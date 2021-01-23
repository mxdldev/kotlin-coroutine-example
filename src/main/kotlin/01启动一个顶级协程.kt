import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Description: <`01启动一个顶级协程`><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //启动一个顶级协程
    GlobalScope.launch {
        println("hello world")
        println(Thread.currentThread().name)
    }
    println("main game over")
    println(Thread.currentThread().name)
    Thread.sleep(1000 * 5)
}