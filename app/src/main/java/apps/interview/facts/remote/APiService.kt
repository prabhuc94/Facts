package apps.interview.facts.remote

import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface APiService {

    @GET("s/2iodh4vg0eortkl/facts.json")
    fun facts() : Observable<Response<JsonObject>>
}