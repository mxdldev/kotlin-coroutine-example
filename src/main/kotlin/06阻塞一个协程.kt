import kotlinx.coroutines.*

/**
 * Description: <`06阻塞一个协程`><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //runBlocking会阻塞我们的线程
    //coroutineScope会阻塞我们的协程
    runBlocking {
        launch {
            delay(200)
            println("launcher end")
        }
        coroutineScope {
            launch {
                delay(500)
                println("launch1 end")
            }
            delay(100)
            println("coroutineScope end")
        }
        println("runBlocking end")
    }
}