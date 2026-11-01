package controlflow.whenexpressions

fun main() {
//    val day = 4
//
//    val type = when (day){
//        1 -> "Monday"
//        2 -> "Tuesday"
//        3 ->"Wednesday"
//        else ->"Friday"
//    }
//    println("today is $type")

//    val num = 60
//
//    val grade = when (num){
//        in 50..60 -> println("not in range")
//        in 60..100 -> println("in range")
//        else -> println("Stop messing around")
//    }
//


//    fun describe(x: Any): String = when (x) {
//        is Int -> "it is int${x * 2}"
//        is String -> "it is String${x.length}"
//        is Boolean -> "it is Boolean${x}"
//        else -> "unknown"
//    }
//    println(describe(20))
//    print(describe("Ayush"))


    when (val input = readln()) {
      "YES","Yes", "yes", "y", "Y" -> println("Confirmed")
        "no", "n", "No", "YES" -> println("Rejected")
        else -> println("Unknown")
    }



}
