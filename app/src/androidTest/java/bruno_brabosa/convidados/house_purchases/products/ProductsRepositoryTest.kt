package bruno_brabosa.convidados.house_purchases.products

import android.content.Context
import android.util.Log
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import bruno_brabosa.convidados.house_purchases.data.repository.ProductRepository
import bruno_brabosa.convidados.house_purchases.data.repository.ProductRepositoryImpl
import bruno_brabosa.convidados.house_purchases.data.repository.local.database.ProductsDatabase
import bruno_brabosa.convidados.house_purchases.data.repository.local.storage.ProductsStorage
import bruno_brabosa.convidados.house_purchases.data.repository.local.storage.ProductsStorageImpl
import org.junit.Assert.fail
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Exception


@RunWith(AndroidJUnit4::class)
class ProductsRepositoryTest {

    private val context: Context = ApplicationProvider.getApplicationContext()
    private val localDatabase: ProductsDatabase = ProductsDatabase.create(context)
    private val storage: ProductsStorage = ProductsStorageImpl(localDatabase)
    private val repository: ProductRepository = ProductRepositoryImpl(storage)

    @Test
    fun should_create_product_in_database () {

        try {
            repository.create("Biscoito de Polvilho", 4)
        } catch (error: Exception) {
            fail()
        }

    }

    @Test
    fun should_return_all_product_in_database () {

        try {
            val productsList = repository.getAll()
            Log.d("DATABASE-LOG", "$productsList")
        } catch (error: Exception) {
            fail()
        }

    }

    @Test
    fun should_delete_product_in_database () {

        try {
            repository.delete("Biscoito de Polvilho", 4, 7)
        } catch (error: Exception) {
            fail()
        }

    }


    @Test
    fun should_return_all_product_in_database2 () {

        try {
            val productsList = repository.getAll()
            Log.d("DATABASE-LOG", "$productsList")
        } catch (error: Exception) {
            fail()
        }

    }

    @Test
    fun should_delete_all_products_in_database () {

        try {
            repository.deleteAll("Biscoito de Polvilho", 3, 1)
        } catch (error: Exception) {
            fail()
        }

    }

    @Test
    fun should_return_all_product_in_database3 () {

        try {
            val productsList = repository.getAll()
            Log.d("DATABASE-LOG", "$productsList")
        } catch (error: Exception) {
            fail()
        }

    }

}