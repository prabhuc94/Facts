package apps.interview.facts.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import apps.interview.facts.R
import apps.interview.facts.data.Row
import apps.interview.facts.databinding.LayoutFactsDataItemBinding
import apps.interview.facts.ui.fragments.FactsRowDetails


class FactsAdapter() : RecyclerView.Adapter<FactsAdapter.FactsHolder>() {

    class FactsHolder(val binding : LayoutFactsDataItemBinding) : RecyclerView.ViewHolder(binding.root)

    private var factsData : MutableList<Row> = mutableListOf()

    fun loadFacts(data : List<Row>){
        this.factsData = data as MutableList<Row>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactsHolder {
        return FactsHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.layout_facts_data_item, parent, false))
    }

    override fun getItemCount(): Int {
        return factsData.size
    }

    override fun onBindViewHolder(holder: FactsHolder, position: Int) {
        holder.binding.facts = factsData[position]
        holder.binding.factsRowCard.setOnClickListener {
            val activity: AppCompatActivity = it.context as AppCompatActivity
            FactsRowDetails(rowData = factsData[position]).show(activity.supportFragmentManager, null)
        }
    }
}