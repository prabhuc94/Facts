package apps.training.searcher.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import apps.interview.facts.utils.Extensions.load

object BindingUtils {

    @JvmStatic @BindingAdapter("imageUrl")
    fun loadPic(view : ImageView, imageUrl : Any?){
        view.load(imageUrl)
    }

}