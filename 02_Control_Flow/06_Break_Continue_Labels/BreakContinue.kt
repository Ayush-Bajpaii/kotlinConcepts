package controlflow.breakcontinue


fun main(){
//    for(i in 1..10){
////        if(i ==5)break
//        if(i %2 == 0) continue
//        print("$i ")
//    }
//    print("done")

//    val num = listOf(1,3,4,5)
//    var firstEven : Int?= null
//    for (i in num){
//        if(i % 2 == 0){
//            firstEven = i
//            break
//        }
//    }
//    println(firstEven)

//   outer@ for (i in 1..3){
//        for (j in 1..3){
//            if(i==2 && j==2 )continue@outer
//            println("$i,$j")
//        }
//
//    }


//    listOf(1,2,3,4,5).forEach{
//        if(it==2)return@forEach
//        print("$it ")
//    }
    val names = listOf("Ayush","Yash", "Piyush","priyanshu")
    println(findIndex(names,"Ayush"))
    println(findIndex(names,"Yash"))
}

    fun findIndex(names : List<String>, target : String) : Int{
        for(i in names.indices){
            if (names[i] ==target) return i
        }
        return -1
}