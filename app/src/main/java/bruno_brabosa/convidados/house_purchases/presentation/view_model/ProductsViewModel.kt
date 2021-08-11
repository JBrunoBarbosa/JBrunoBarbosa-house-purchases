package bruno_brabosa.convidados.house_purchases.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bruno_brabosa.convidados.house_purchases.domain.usecases.CreateProductUseCase
import bruno_brabosa.convidados.house_purchases.domain.usecases.GetAllProductsUseCase
import bruno_brabosa.convidados.house_purchases.domain.usecases.RemoveAllProductsUseCase
import bruno_brabosa.convidados.house_purchases.domain.usecases.RemoveProductUseCase
import bruno_brabosa.convidados.house_purchases.presentation.model.ProductPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val createProductUseCase: CreateProductUseCase,
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val removeAllProductsUseCase: RemoveAllProductsUseCase,
    private val removeProductUseCase: RemoveProductUseCase
) : ViewModel() {

    private val _productsList = MutableLiveData<List<ProductPresentation>>()
    val productsList : LiveData<List<ProductPresentation>> = _productsList

    private val _onError = MutableLiveData<Boolean>()
    val onError : LiveData<Boolean> = _onError

    private val _onLoading = MutableLiveData<Boolean>()
    val onLoading: LiveData<Boolean> = _onLoading

    fun createProduct(productName: String, productQuantity: Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            _onLoading.postValue(true)
            createProductUseCase(productName, productQuantity)
        } catch (error: Exception) {
            _onError.postValue(true)
        }

        _onLoading.postValue(false)
    }

    fun getAllProducts() = viewModelScope.launch(Dispatchers.IO) {
        try {
            _onLoading.postValue(true)
            _productsList.postValue(getAllProductsUseCase())
        } catch (error: Exception) {
            _onError.postValue(true)
        }

        _onLoading.postValue(false)
    }

    fun removeProduct(productName: String, productQuantity: Int, productIdentifier: Int) = viewModelScope.launch (Dispatchers.IO){
        try {
            _onLoading.postValue(true)
            removeProductUseCase(productName, productQuantity, productIdentifier)
        } catch (error: Exception) {
            _onError.postValue(true)
        }

        _onLoading.postValue(false)
    }
    fun removeAllProducts(productName: String, productQuantity: Int, productIdentifier: Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            _onLoading.postValue(true)
            removeAllProductsUseCase(productName, productQuantity, productIdentifier)
        } catch (error: Exception) {
            _onError.postValue(true)
        }

        _onLoading.postValue(false)
    }

}