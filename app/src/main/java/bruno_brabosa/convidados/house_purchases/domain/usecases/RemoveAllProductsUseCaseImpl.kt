package bruno_brabosa.convidados.house_purchases.domain.usecases

import bruno_brabosa.convidados.house_purchases.data.repository.ProductRepository
import javax.inject.Inject

class RemoveAllProductsUseCaseImpl @Inject constructor(
    private val repository: ProductRepository
) : RemoveAllProductsUseCase {

    override fun invoke(productName: String, productQuantity: Int, productIdentifier: Int) {
        repository.deleteAll(productName, productQuantity, productIdentifier)
    }
}