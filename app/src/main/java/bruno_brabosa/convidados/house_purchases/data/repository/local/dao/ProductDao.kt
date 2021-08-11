package bruno_brabosa.convidados.house_purchases.data.repository.local.dao

import androidx.room.*
import bruno_brabosa.convidados.house_purchases.data.model.ProductData

@Dao
interface ProductDao {

    @Query("SELECT * FROM productData")
    fun getAll(): List<ProductData>

    @Insert
    fun create(vararg product: ProductData)

    @Update
    fun delete(product: ProductData)

    @Delete
    fun deleteAll(product: ProductData)

}