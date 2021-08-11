package bruno_brabosa.convidados.house_purchases.domain.usecases

import bruno_brabosa.convidados.house_purchases.data.repository.ProductRepository
import javax.inject.Inject

class CreateProductUseCaseImpl @Inject constructor(
    private val repository: ProductRepository
): CreateProductUseCase {

    override fun invoke(productName: String, productQuantity: Int) {
        repository.create(productName, productQuantity)
    }
}