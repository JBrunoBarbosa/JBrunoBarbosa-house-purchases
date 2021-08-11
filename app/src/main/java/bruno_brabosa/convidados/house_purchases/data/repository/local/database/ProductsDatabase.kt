package bruno_brabosa.convidados.house_purchases.data.repository.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import bruno_brabosa.convidados.house_purchases.data.model.ProductData
import bruno_brabosa.convidados.house_purchases.data.repository.local.connection.RoomConnection
import bruno_brabosa.convidados.house_purchases.data.repository.local.dao.ProductDao

@Database(entities = [ProductData::class], exportSchema = false, version = 1)
abstract class ProductsDatabase : RoomDatabase() {
    abstract fun userDao(): ProductDao

    companion object {
        fun create(context: Context): ProductsDatabase =
            RoomConnection(context).create()
    }
}
