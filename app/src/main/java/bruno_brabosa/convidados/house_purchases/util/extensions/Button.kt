package bruno_brabosa.convidados.house_purchases.util.extensions

import android.app.Activity
import android.widget.Button
import androidx.core.content.ContextCompat
import bruno_brabosa.convidados.house_purchases.R

fun Button.colorControl(activity: Activity?) {
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

fun Button.onPressedControl(
    btnValue2: Button,
    btnValue3: Button,
    btnValue4: Button,
    btnValue5: Button,
    activity: Activity?
) {

    this.colorControl(activity)

    if (activity != null) {
        btnValue2.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.white)
        btnValue3.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.white)
        btnValue4.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.white)
        btnValue5.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.white)
    }
}

fun Button.getSelected(
    btnValue2: Button,
    btnValue3: Button,
    btnValue4: Button,
    btnValue5: Button,
    activity: Activity?
): Int {

    if (activity != null) {
        when (ContextCompat.getColorStateList(activity, R.color.secondary_color)) {
            this.backgroundTintList -> return this.text.toString().toInt()
            btnValue2.backgroundTintList -> return btnValue2.text.toString().toInt()
            btnValue3.backgroundTintList -> return btnValue3.text.toString().toInt()
            btnValue4.backgroundTintList -> return btnValue4.text.toString().toInt()
            btnValue5.backgroundTintList -> return btnValue5.text.toString().toInt()
        }
    }

    return 0
}

fun Button.cleanColor(
    btnValue2: Button,
    btnValue3: Button,
    btnValue4: Button,
    btnValue5: Button,
    activity: Activity?
) {

    if (activity != null) {
        this.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.white)
        btnValue2.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.white)
        btnValue3.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.white)
        btnValue4.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.white)
        btnValue5.backgroundTintList = ContextCompat.getColorStateList(activity, R.color.white)
    }
}
