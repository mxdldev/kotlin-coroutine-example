package http

import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.coroutines.resumeWithException

/**
 * Description: <RetrofitManger><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class RetrofitManger {
    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://v0.yiketianqi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
suspend fun <T> Call<T>.await():T{
    return suspendCoroutine {
        enqueue(object :Callback<T>{
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if(response.isSuccessful){
                    if(response.body() != null){
                        it.resume(response.body()!!)
                    }else{
                        it.resumeWithException(Exception("body is null"))
                    }
                }else{
                    it.resumeWithException(HttpException(response))
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                it.resumeWithException(t)
            }

        })
    }
}