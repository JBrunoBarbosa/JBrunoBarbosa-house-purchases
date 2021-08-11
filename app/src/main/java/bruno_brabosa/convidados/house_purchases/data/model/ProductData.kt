package bruno_brabosa.convidados.house_purchases.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import bruno_brabosa.convidados.house_purchases.data.model.Constants.COLUMN_PRODUCT_NAME
import bruno_brabosa.convidados.house_purchases.data.model.Constants.COLUMN_PRODUCT_QUANTITY
import bruno_brabosa.convidados.house_purchases.domain.model.ProductDomain

@Entity
data class ProductData(

    @PrimaryKey(autoGenerate = true)
    val identifier: Int = 0,

    @ColumnInfo(name = COLUMN_PRODUCT_NAME)
    val name: String,

    @ColumnInfo(name = COLUMN_PRODUCT_QUANTITY)
    val quantity: Int
)

fun ProductData.asProductDataDomain() =
    ProductDomain(
        identifier = identifier,
        name = name,
        quantity = quantity
    )
