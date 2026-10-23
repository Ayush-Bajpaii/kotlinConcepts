package basics.typeConversion


fun main(){
    val num : Int = 10;

    val l : Long = num.toLong();
    println(l);
    val m : Float = num.toFloat()
    println(m)

    val n : String = num.toString()
    println(n + 5)

    val o = "true".toBoolean()
    println(o)


    //Kotlin allows concatenation when a String is on the left side of +.
    val p = "150"
    println(p.toInt() + 15)


    val q = 10.5
    println(q.toInt())

    val r = 'A'

    println(r.code)

    println(Char(97))

    println('5'.digitToInt())

    println(5 + 1.3)


    //    gives error due to the letter in the string trying to convert in the int
    //    val s : String = "ABCD"
    //    print(s.toInt())

}

