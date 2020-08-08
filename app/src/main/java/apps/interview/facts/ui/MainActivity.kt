package apps.interview.facts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import apps.interview.facts.R
import apps.interview.facts.databinding.ActivityMainBinding
import apps.interview.facts.viewmodel.FactsViewModel

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy { DataBindingUtil.setContentView(this,R.layout.activity_main) as ActivityMainBinding }
    private val factsViewModel : FactsViewModel by lazy { ViewModelProvider(this)[FactsViewModel::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        factsViewModel.getFacts(this)?.observeForever {
            binding.fact = it
        }
    }
}