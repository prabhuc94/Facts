package apps.interview.facts.utils

import android.view.View
import android.widget.ImageView
import apps.interview.facts.R

object Extensions {
    // Try to make ternary operator in Kotlin
    fun <T> T?.or(default: T): T = this ?: default

    fun <T> T?.or(compute: () -> T): T = this ?: compute()

    fun View.show(){
        this.visibility = View.VISIBLE
    }

    fun View.hide(){
        this.visibility = View.GONE
    }


    fun ImageView.load(imagePath : Any?){
        GlideApp.with(this)
            .load(imagePath)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(this)
    }
}