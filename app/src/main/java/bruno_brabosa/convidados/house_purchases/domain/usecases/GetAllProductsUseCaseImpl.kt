package bruno_brabosa.convidados.house_purchases.domain.usecases

import bruno_brabosa.convidados.house_purchases.data.repository.ProductRepository
import bruno_brabosa.convidados.house_purchases.domain.model.asProductPresentation
import bruno_brabosa.convidados.house_purchases.presentation.model.ProductPresentation
import javax.inject.Inject

class GetAllProductsUseCaseImpl @Inject constructor(
    private val repository: ProductRepository
) : GetAllProductsUseCase {

    override fun invoke(): List<ProductPresentation> =
        repository.getAll().map { it.asProductPresentation() }
}