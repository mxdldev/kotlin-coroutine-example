import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Description: <`08获取协程的执行结果-串行执行`><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    val start = System.currentTimeMillis()
    runBlocking {
        //启动一个子协程
        val result1 = async {
            delay(1000 * 3)
            1 + 1
        }.await()
        println("result1:$result1")
        //启动一个子协程
        val result2 = async {
            delay(1000 * 2)
            2  + 2
        }.await()
        println("result2:$result2")
    }
    val end = System.currentTimeMillis()
    println("time:"+(end - start))
}