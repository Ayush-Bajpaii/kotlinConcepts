package controlflow.forloop



fun main(){
//    for (i in 1..5){
//        print(i)
//    }

//    for (i in 10 downTo 1 step 2){
//        print("$i " )
//    }
//
//    for (c in 'a'..'e') print(c)

//     val fruits = listOf("Apple","Banana","Mango")
//    for ( items in fruits.withIndex()){
//        val index  = items.index
//        val fruit = items.value
//        println("$index : $fruit ")
//
//    }
//
//    val ages = mapOf("ayush" to 25, "riya" to 18)
//    for((name,age) in ages){
//        println("$name is $age ")
//    }

//    var sum = 0
//    for(i in 1..100){
//        sum += i
//    }
//    println(sum)

//    for (row in 1..3){
//        for( col in 1..row){
//            print("* ")
//        }
//        println()
//    }

//    repeat(3){
//        index -> println("Round $index")
//    }


  //  val nums = listOf(1,2,3)

    val  nums = mapOf(1 to "one", 2 to "Two", 3 to "Three")

    nums.forEach{
        (n,m) -> println("$n,$m")
    }
    nums.forEach{ println("${it.key},${it.value}") }


}