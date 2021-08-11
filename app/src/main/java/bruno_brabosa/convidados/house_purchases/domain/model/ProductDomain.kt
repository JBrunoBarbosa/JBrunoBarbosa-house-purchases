package bruno_brabosa.convidados.house_purchases.domain.model

import bruno_brabosa.convidados.house_purchases.presentation.model.ProductPresentation

data class ProductDomain(

    val identifier: Int = 0,
    val name: String,
    val quantity: Int
)

fun ProductDomain.asProductPresentation () =
    ProductPresentation(
        identifier = identifier,
        name = name,
        quantity = quantity
    )
