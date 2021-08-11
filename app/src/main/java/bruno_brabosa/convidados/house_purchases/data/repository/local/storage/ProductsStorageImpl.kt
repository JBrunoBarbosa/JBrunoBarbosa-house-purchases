package bruno_brabosa.convidados.house_purchases.data.repository.local.storage

import bruno_brabosa.convidados.house_purchases.data.model.ProductData
import bruno_brabosa.convidados.house_purchases.data.repository.local.database.ProductsDatabase
import javax.inject.Inject

class ProductsStorageImpl @Inject constructor(
    private val localDatabase: ProductsDatabase
) : ProductsStorage {

    override fun getAll(): List<ProductData> =
        localDatabase.userDao().getAll()


    override fun create(productName: String, productQuantity: Int) {
        localDatabase.userDao().create(
            ProductData(
                name = productName,
                quantity = productQuantity
            )
        )
    }

    override fun delete(productName: String, productQuantity: Int, productIdentifier: Int) {
        localDatabase
            .userDao()
            .delete(
                ProductData(
                    identifier = productIdentifier,
                    name = productName,
                    quantity = productQuantity - 1
                )
            )
    }

    override fun deleteAll(productName: String, productQuantity: Int, productIdentifier: Int) {
        localDatabase
            .userDao()
            .deleteAll(
                ProductData(
                    identifier = productIdentifier,
                    name = productName,
                    quantity = productQuantity
                )
            )
    }

}