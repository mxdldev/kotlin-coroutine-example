import kotlinx.coroutines.runBlocking

/**
 * Description: <`02启动一个阻塞的协程`><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    //1.runblocking创建了一个阻塞的协程，他是用来阻塞我们的主线程的
    //2.当runBlocking里面的代码和所有的自协程没有执行完毕的时候他会一直阻塞我们主线程
    //3.一般我们在测试的时候回用到它，正式项目不要用
    runBlocking {
        println("hello world")
    }
    println("main game over")
}