package bruno_brabosa.convidados.house_purchases.util.extensions

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout

fun ConstraintLayout.visibilityControl(){
    if(this.visibility == View.VISIBLE)
        this.visibility = View.GONE
    else
        this.visibility = View.VISIBLE
}