package bruno_brabosa.convidados.house_purchases.domain.usecases

import bruno_brabosa.convidados.house_purchases.presentation.model.ProductPresentation

interface GetAllProductsUseCase {

    operator fun invoke (): List<ProductPresentation>
}