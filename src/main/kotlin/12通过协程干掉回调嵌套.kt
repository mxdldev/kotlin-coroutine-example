import http.RetrofitManger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import service.WeatherService

/**
 * Description: <`12通过协程干掉回调嵌套`><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    val weatherService = RetrofitManger.retrofit.create(WeatherService::class.java)
    val coroutineScope = CoroutineScope(Job())
    coroutineScope.launch {
        //获取天气
        val weather = async {
            weatherService.getWeather1()
        }.await()
        println(weather)
        //获取空气指数
        val air = async {
            weatherService.getAir()
        }.await()
        println(air)
    }
    Thread.sleep(1000 * 5)
}