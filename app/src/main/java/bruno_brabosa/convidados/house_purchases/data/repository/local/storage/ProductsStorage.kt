package bruno_brabosa.convidados.house_purchases.data.repository.local.storage

import bruno_brabosa.convidados.house_purchases.data.model.ProductData

interface ProductsStorage {

    fun getAll(): List<ProductData>
    fun create(productName: String, productQuantity: Int)
    fun delete(productName: String, productQuantity: Int, productIdentifier: Int)
    fun deleteAll(productName: String, productQuantity: Int, productIdentifier: Int)
}