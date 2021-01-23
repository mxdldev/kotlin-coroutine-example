import http.RetrofitManger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import service.WeatherService

/**
 * Description: <`13使用协程使我们的数据同步显示`><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    val service = RetrofitManger.retrofit.create(WeatherService::class.java)
    val coroutineScope = CoroutineScope(Job())
    coroutineScope.launch {
        //1.获取天气
        val deferredWeather = async {
            service.getWeather1()
        }
        //2.获取空气质量指数
        val deferredAir = async {
            service.getAir()
        }
        println(deferredWeather.await())
        println(deferredAir.await())
    }
    Thread.sleep(1000 * 5)
}