package apps.interview.facts.remote

import apps.interview.facts.data.Facts
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface APiService {

    @GET("s/2iodh4vg0eortkl/facts.json")
    fun facts() : Single<Response<Facts>>
}