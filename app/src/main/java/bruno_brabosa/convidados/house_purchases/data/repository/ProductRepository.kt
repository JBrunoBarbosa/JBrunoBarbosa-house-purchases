package bruno_brabosa.convidados.house_purchases.data.repository

import bruno_brabosa.convidados.house_purchases.domain.model.ProductDomain


interface ProductRepository {

     fun getAll(): List<ProductDomain>
     fun create(productName: String, productQuantity: Int)
     fun delete(productName: String, productQuantity: Int, productIdentifier: Int)
     fun deleteAll(productName: String, productQuantity: Int, productIdentifier: Int)

}