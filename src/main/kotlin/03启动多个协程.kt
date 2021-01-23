import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Description: <`03启动多个协程`><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    runBlocking {
        //启动一个子协程1
        launch {
            println("launcher1")
        }
        //启动一个子协程2
        launch {
            println("launcher2")
        }
    }
}