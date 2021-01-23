import bean.Weather
import http.RetrofitManger
import http.await
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import service.WeatherService

/**
 * Description: <`11通过协程干掉回调`><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //testThread()
    runBlocking {
        val weather = RetrofitManger.retrofit.create(WeatherService::class.java).getWeather().await()
        println("weather:$weather")
    }
}

private fun testThread() {
    //1.创建一个服务
    val service = RetrofitManger.retrofit.create(WeatherService::class.java)
    //2.创建一个请求命令
    val call = service.getWeather()
    //3.发起一个请求
    call.enqueue(object : Callback<Weather> {
        override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
            println(response.body())
            call.enqueue(object : Callback<Weather> {
                override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                    println(response.body())
                    call.enqueue(object : Callback<Weather> {
                        override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                            println(response.body())
                        }

                        override fun onFailure(call: Call<Weather>, t: Throwable) {
                        }

                    })
                }

                override fun onFailure(call: Call<Weather>, t: Throwable) {
                }

            })
        }

        override fun onFailure(call: Call<Weather>, t: Throwable) {
        }

    })
}