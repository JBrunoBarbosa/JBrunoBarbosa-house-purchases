package bruno_brabosa.convidados.house_purchases.util.extensions

import android.app.Activity
import android.widget.Button
import androidx.core.content.ContextCompat
import bruno_brabosa.convidados.house_purchases.R

fun Button.colorControl(activity: Activity?){
    if (activity != null) {
        if (this.backgroundTintList == ContextCompat.getColorStateList(
                activity,
                R.color.secondary_color
            )
        )
            this.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.white)
        else
            this.backgroundTintList =
                ContextCompat.getColorStateList(activity, R.color.secondary_color)
    }
}

fun Button.onPressedControl(btnValue2: Button, btnValue3: Button, btnValue4: Button, btnValue5: Button, activity: Activity?){

    this.colorControl(activity)

    if (activity != null) {
        btnValue2.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.white)
        btnValue3.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.white)
        btnValue4.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.white)
        btnValue5.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.white)
    }
}
