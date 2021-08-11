package bruno_brabosa.convidados.house_purchases.domain.usecases

import bruno_brabosa.convidados.house_purchases.data.repository.ProductRepository
import javax.inject.Inject

class RemoveProductUseCaseImpl @Inject constructor(
    private val repository: ProductRepository
): RemoveProductUseCase {

    override fun invoke(productName: String, productQuantity: Int, productIdentifier: Int) {
        repository.delete(productName, productQuantity, productIdentifier)
    }
}