package apps.interview.facts.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import apps.interview.facts.data.Facts
import apps.interview.facts.database.FactsDatabase.Companion.instance
import apps.interview.facts.remote.APiClient
import apps.interview.facts.utils.Extensions.or
import apps.interview.facts.utils.Logger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class FactsViewModel : ViewModel() {
    fun getFacts(context: Context) : LiveData<Facts>? {
        loadFacts(context)
        return context.instance()?.facts()?.getFacts()
    }

    private fun loadFacts(context: Context) {
        APiClient.apiService.facts()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( object : DisposableSingleObserver<Response<Facts>>(){
                override fun onSuccess(t: Response<Facts>) {
                    if (t.isSuccessful) {
                        t.body()?.let { context.instance()?.facts()?.insert(it)}
                    }
                }

                override fun onError(e: Throwable) {
                    Logger.error(tag = "FactsModel",msg = e.localizedMessage.or(e.message))
                }

            })
    }
}