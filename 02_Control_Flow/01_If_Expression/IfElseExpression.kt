package controlflow.ifelse


fun main(){

    val score = 85
    val result = if (score > 50){
        println("checking")
        "pass"
    }else{
        "fail"
    }
    println(result)

    val age = 26
    if(age  < 18) print("Adult") else print("Minor")
}