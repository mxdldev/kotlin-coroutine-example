import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Description: <`07取消一个协程`><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    val job = Job()
    val coroutineScope = CoroutineScope(job)
    coroutineScope.launch {
        delay(1000 * 3)
        println("hello world")
    }
    job.cancel()
    Thread.sleep(1000 * 5)
}