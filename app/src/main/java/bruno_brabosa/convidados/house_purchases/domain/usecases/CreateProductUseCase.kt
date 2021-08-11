package bruno_brabosa.convidados.house_purchases.domain.usecases

interface CreateProductUseCase {

    operator fun invoke (productName: String, productQuantity: Int)
}