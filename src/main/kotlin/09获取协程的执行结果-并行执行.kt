import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Description: <`09获取协程的执行结果-并行执行`><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    val start = System.currentTimeMillis()
    runBlocking {
        //1.async可以启动一个子协程
        //2.async函数一旦调用，它里面的代码就会立即执行
        //3.通过await函数获取它的执行结果，如果async里面的代码和所有的子协程没有执行完毕那么他会一直阻塞在这里
        //直到结果返回
        val deferred1 = async {
            delay(1000 * 2)
            1 + 1
        }

        val deferred2 = async {
            delay(1000 * 3)
            2 + 2
        }

        println(deferred1.await())
        println(deferred2.await())
    }
    val end = System.currentTimeMillis()
    println("time:"+(end - start))
}