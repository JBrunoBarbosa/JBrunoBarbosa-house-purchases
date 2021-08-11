package bruno_brabosa.convidados.house_purchases.domain.usecases

interface RemoveAllProductsUseCase {

    operator fun invoke (productName: String, productQuantity: Int, productIdentifier: Int)
}