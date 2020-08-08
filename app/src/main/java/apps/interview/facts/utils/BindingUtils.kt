package apps.training.searcher.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import apps.interview.facts.adapter.FactsAdapter
import apps.interview.facts.data.Row
import apps.interview.facts.utils.Extensions.load

object BindingUtils {

    @JvmStatic @BindingAdapter("imageUrl")
    fun loadPic(view : ImageView, imageUrl : Any?){
        view.load(imageUrl)
    }

    @JvmStatic @BindingAdapter("loadFacts")
    fun loadFacts(view : RecyclerView, factsData : List<Row>?){
        val factsAdapter  = FactsAdapter()
        view.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = factsAdapter
        }
        factsData?.let { factsAdapter.loadFacts(it) }
    }

}