package bruno_brabosa.convidados.house_purchases.domain.usecases

interface RemoveProductUseCase {

    operator fun invoke (productName: String, productQuantity: Int, productIdentifier: Int)
}