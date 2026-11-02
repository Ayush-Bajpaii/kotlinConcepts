package functions.defaultnamedArg

fun main (){
    createUser(
        "Yash",
        28,
        "UK")
    rectangle(height = 5)
//    rectangle(5,3)

}

fun createUser(name : String = "Ayush", age : Int = 25, country : String = "Inida") :Unit{
    println("my name is  $name, age is $age, country is $country")
}

fun rectangle(width : Int = 10, height : Int){
    println("width is $width x $height = ${width * height}")
}

