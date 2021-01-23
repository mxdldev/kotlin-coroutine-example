import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Description: <`10给协程指定一个线程`><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    runBlocking {
        //withContext和async的效果是一样的，他是一个简化版的async
        //Dispatchers.IO任务多执行时间短
        //Dispatchers.default任务少执行时间长
        //Dispatchers.main UI主线程，它是android开始中使用
        val result = withContext(Dispatchers.IO){
            delay(1000 * 2)
            println(Thread.currentThread().name)
            1 + 1
        }
        println("$result")
    }
}