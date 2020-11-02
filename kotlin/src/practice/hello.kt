package practice

import java.lang.Integer.parseInt

fun main(args :Array<String>){
    println("Hello world")
    Greeter("SB").greet()
    Greeter("s").vars(1,2,3,4,5)
    println(Greeter("s").getStringLength(1))




    print("循环输出：")
    for (i in 1..4) print(i) // 输出“1234”
    println("\n----------------")
    print("设置步长：")
    for (i in 1..4 step 2) print(i) // 输出“13”
    println("\n----------------")
    print("使用 downTo：")
    for (i in 4 downTo 1 step 2) print(i) // 输出“42”
    println("\n----------------")
    print("使用 until：")
    // 使用 until 函数排除结束元素
    for (i in 1 until 4) {   // i in [1, 4) 排除了 4
        print(i)
    }
    println("\n----------------")
}

class Greeter(val name:String){
    var a : Int=10

    fun greet(){
        println("Hello,$name!")
    }

    fun vars(vararg v:Int){
        for(vt in v){
            println(vt)
        }
    }
    fun getStringLength(obj: Any): Int? {
        // 在 `&&` 运算符的右侧, `obj` 的类型会被自动转换为 `String`
        if (obj is String && obj.length > 0)
            return obj.length
        return null
    }
}