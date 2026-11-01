package controlflow.ranges

fun main(){

//    for (i in 1..5) print("$i ")        // 1 2 3 4 5
//    println()
//    for (i in 1..<5) print("$i ")       // 1 2 3 4
//    println()
//    for (i in 5 downTo 1) print("$i ")  // 5 4 3 2 1
//    println()
//    for (i in 0..10 step 5) print("$i ") // 0 5 10
//
//
//    println("Kiwi" in "apple".."mango")   // true (alphabetical order)

//    for (c in 'a'..'z') print("$c ")

//    for ( i in 5 downTo 1)print("$i ")


//    val r = 1..10
//
//    println(r.first)
//    println(r.last)
//    println((1..10).toList())
//

    val validMarks  =  0..100
    val passMarks = 40..100


    print("Enter the marks : ")
    val marks = readln().toIntOrNull()

    if(marks == null || marks  !in validMarks){
        println("Marks must be between 0 and 100")
    }
    else if (marks in passMarks)print("pass")

    else print("fail")

}