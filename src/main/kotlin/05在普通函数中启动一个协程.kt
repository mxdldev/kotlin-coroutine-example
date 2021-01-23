import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Description: <`05在普通函数中启动一个协程`><br>
 * Author:      mxdl<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
fun main(args: Array<String>) {
    runBlocking {
        request()
    }
}
//1.首先该函数必须是一个挂起函数
//2.需要在挂起函数内部调用我们得内置协程api创建协程的作用域
suspend fun request(){
    coroutineScope {
        launch{
            println("hello world")
        }
    }
}