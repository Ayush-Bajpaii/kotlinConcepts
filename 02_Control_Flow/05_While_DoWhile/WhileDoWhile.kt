package controlflow.whiledowhile

fun main(){
    var count = 1

    while(count <= 5){
        println("count : $count")
        count++
    }
//
//    var x = 10
//    while(x < 5){
//        println("never Printed")
//    }

//    do{
//        println("count :$count")
//        count++
//    }while (count <= 5)

//    var age : Int?
//    do{
//        print("Enter you age : ")
//        age = readln().toIntOrNull()
//    }while(age==null || age <=0)
//    println("your age is $age")



//    var num = 456789
//    var sum = 0
//
//    while (num > 0){
//        sum = sum + num % 10
//        num = num/10
//        print("$num ")
//
//    }
//    println(sum)
//
//    while (true) {
//        val input = readln()
//        if (input == "exit") break    // the only way out
//        println("You typed: $input")
//    }

    var balance = 1000
    var months = 0
    while (balance < 2000) {
        balance += balance * 10 / 100
        months++
    }
    println("Doubled in $months months")

}



