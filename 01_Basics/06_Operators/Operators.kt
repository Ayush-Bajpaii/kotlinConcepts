package basics.operators

fun main(){
    val a : Int = 111;
    println(a.toDouble()/3)


    val b : Int = 20
    val isRight  = true

    println(b > 15 && isRight )

    var c : Int = 20
    println(c--)
    println(c)

    println("Kotlin" == "Kotlin")
    println("kotlin" == "Koltin")


    println(!isRight)


    // can divide the int with the 0
    //println(10/0)

    //text must be on  the left
    //println(25 + "Years")

    println("Years" + 25)
    //gives the error exception arithmetic
    //println(10/0)

    println( "Abc-> "+10.0/0)

    println(17+5)
    println(17-5)
    println(17*5)
    println(17/5)
    println(17%5)

    var abc = 5;
    var bca = 5;
    println(abc++)
    println(bca--)





}


