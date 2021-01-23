import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Description: <`04创建多个协程提升并发编程效率`><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //testThread()
    testCoroutine()
}

private fun testCoroutine() {
    val start = System.currentTimeMillis()
    runBlocking {
        repeat(10) {
            launch {
                println(".")
                //println(Thread.currentThread().name)
            }
        }
    }
    val end = System.currentTimeMillis()
    println("time:" + (end - start))
}

private fun testThread() {
    //创建十万个线程
    val start = System.currentTimeMillis()
    runBlocking {
        repeat(10) {
            Thread({
                println(".")
            }).start()
        }
    }
    val end = System.currentTimeMillis()
    println("time:" + (end - start))
}