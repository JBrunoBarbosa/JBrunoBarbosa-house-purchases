package bruno_brabosa.convidados.house_purchases.data.repository.local.connection

import android.content.Context
import androidx.room.Room
import bruno_brabosa.convidados.house_purchases.data.model.Constants.PRODUCTS_DATABASE_NAME
import bruno_brabosa.convidados.house_purchases.data.repository.local.database.ProductsDatabase

class RoomConnection(private val context: Context) {

    fun create(): ProductsDatabase =
        Room.databaseBuilder(
            context,
            ProductsDatabase::class.java, PRODUCTS_DATABASE_NAME
        ).build()
}