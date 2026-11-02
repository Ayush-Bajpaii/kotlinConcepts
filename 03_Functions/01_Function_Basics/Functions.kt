package functions.functions

import javax.annotation.processing.Messager


fun main(){
    greet("Ayush",25)
   println(add(2,3))
    log("hello there")
   println(max(23,34))


    println(grade(20))
    println(grade(50))
    println(grade(75))
    println(grade(76))
    println(grade(100))

    print(sumOfSquare(2,3))



}

fun greet(name : String, age : Int) {
    println("HELLO $name,age is $age")
}

fun log(message: String ) : Unit{
    println("Log : $message")
}


fun max(a:Int,b:Int):Int{
    return if(a>b) a else b
}

fun grade(marks: Int): String{
    return when{
        marks >=90 -> "A"
        marks >=75 -> "B"
        marks >=50 -> "C"
        else -> "F"

    }
}


fun add(a:Int, b :Int) :Int{
    return a+b
}

fun sumOfSquare(x : Int, y :Int) : Int{
    return square(x) + square(y)
}


fun square(x : Int) :Int{
    return x * x
}
