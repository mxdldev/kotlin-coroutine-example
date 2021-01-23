import kotlinx.coroutines.*

/**
 * Description: <`14通过协程干掉try-catch`><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    val coroutineExceptionHandler = CoroutineExceptionHandler{
        coroutineContext, throwable ->
        println(throwable)
    }
    val coroutineScope = CoroutineScope(Job() + coroutineExceptionHandler)
    coroutineScope.launch {
        supervisorScope {
            launch(coroutineExceptionHandler) {
                delay(500)
                println("luncher1")
                throw Exception()
            }

            launch(coroutineExceptionHandler)  {
                delay(200)
                println("luncher2")
                throw Exception()
            }
        }

    }
    Thread.sleep(1000 * 5)
}