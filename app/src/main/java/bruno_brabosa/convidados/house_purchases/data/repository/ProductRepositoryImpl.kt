package bruno_brabosa.convidados.house_purchases.data.repository

import bruno_brabosa.convidados.house_purchases.data.model.asProductDataDomain
import bruno_brabosa.convidados.house_purchases.data.repository.local.storage.ProductsStorage
import bruno_brabosa.convidados.house_purchases.domain.model.ProductDomain
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val storage: ProductsStorage
): ProductRepository {

    override fun getAll(): List<ProductDomain> =
        storage.getAll().map { it.asProductDataDomain() }


    override fun create(productName: String, productQuantity: Int) {
        storage
            .create(
                productName = productName,
                productQuantity = productQuantity
            )
    }

    override fun delete(productName: String, productQuantity: Int, productIdentifier: Int) {
        storage.delete(
            productIdentifier = productIdentifier,
            productName = productName,
            productQuantity = productQuantity
        )
    }

    override fun deleteAll(productName: String, productQuantity: Int, productIdentifier: Int) {
        storage.deleteAll(
            productIdentifier = productIdentifier,
            productName = productName,
            productQuantity = productQuantity
        )
    }
}