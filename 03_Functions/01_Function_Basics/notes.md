# Function Basics

> Module: Functions

## What is it?

- A **function** is a named block of code you can **run again and again** by calling its name.
- You declare one with the `fun` keyword.
- Functions can take **inputs** (parameters) and give back an **output** (return value).
- You've used functions from the start: `main()`, `println()`, `readln()`. Now you write your own.
- Why use them: write once, reuse many times, give a name to an idea, and keep `main` short.

## Syntax / Example

### 1. Declaring and calling a function
```kotlin
fun greet() {
    println("Hello!")
}

fun main() {
    greet()   // Hello!
    greet()   // Hello!
}
```
- `fun` → keyword, `greet` → name, `()` → parameter list (empty here), `{ }` → body.
- **Calling** = writing the name with `()`. Without `()` the code doesn't run.

### 2. Parameters
```kotlin
fun greet(name: String) {
    println("Hello, $name!")
}

greet("Ayush")   // Hello, Ayush!
greet("Riya")    // Hello, Riya!
```
- Every parameter needs a **name and a type**: `name: String`.
- **Parameter** = the variable in the declaration (`name`). **Argument** = the value you pass in the call (`"Ayush"`).

### 3. Multiple parameters
```kotlin
fun introduce(name: String, age: Int) {
    println("$name is $age years old")
}

introduce("Ayush", 25)   // Ayush is 25 years old
```
- Separate parameters with commas.
- Arguments go in the **same order** as the parameters.

### 4. Returning a value
```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}

val total = add(3, 4)
println(total)          // 7
println(add(10, 20))    // 30
```
- `: Int` after `()` is the **return type**.
- `return` sends the value back to the caller and **ends the function** immediately.
- The result can be stored in a variable, printed, or passed to another function.

### 5. `Unit`: functions that return nothing useful
```kotlin
fun log(message: String): Unit {
    println("LOG: $message")
}

// Same thing; `: Unit` is usually left out
fun log2(message: String) {
    println("LOG: $message")
}
```
- `Unit` is Kotlin's version of Java's `void`.
- If you don't write a return type on a block body, it's `Unit`.

### 6. Parameters are read-only
```kotlin
fun increase(x: Int) {
    x = x + 1    // ❌ ERROR: 'val' cannot be reassigned
}
```
- Parameters behave like `val`.
- Need to change it? Copy it into a local `var`:
```kotlin
fun countdown(from: Int) {
    var n = from
    while (n > 0) {
        print("$n ")
        n--
    }
}
```

### 7. Early `return`
```kotlin
fun divide(a: Int, b: Int): Int {
    if (b == 0) {
        println("Can't divide by zero")
        return 0          // stop here
    }
    return a / b
}
```
- Checking bad input first and returning early is called a **guard clause**. It keeps the main logic un-nested.

### 8. `return` with `if` / `when` as expressions (recap: If Expression, When Expression)
```kotlin
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun grade(marks: Int): String {
    return when {
        marks >= 90 -> "A"
        marks >= 75 -> "B"
        marks >= 50 -> "C"
        else -> "F"
    }
}
```

### 9. Every path must return a value
```kotlin
fun sign(n: Int): String {
    if (n > 0) return "positive"
    if (n < 0) return "negative"
    // ❌ ERROR: A 'return' expression required in a function with a block body
}
```
- Fix: add a final `return "zero"`, or use `if`/`when` with an `else`.

### 10. Functions calling functions
```kotlin
fun square(x: Int): Int {
    return x * x
}

fun sumOfSquares(a: Int, b: Int): Int {
    return square(a) + square(b)
}

println(sumOfSquares(3, 4))   // 25
```
- Order doesn't matter for functions at the top of a file: `main` can call a function declared **below** it.

### 11. `main` is just a function
```kotlin
fun main() { }                       // most common
fun main(args: Array<String>) { }    // receives command-line arguments
```

### 12. `TODO()`: placeholder for unfinished functions
```kotlin
fun calculateTax(amount: Double): Double {
    TODO("Write tax logic later")
}
```
- It compiles, but **crashes** with `NotImplementedError` if called. Useful for planning.

## Key Points
- `fun name(param: Type): ReturnType { body }`.
- Parameter types are **always** required.
- Return type is required when you return a value from a block body. Leave it out for `Unit`.
- `return` ends the function immediately.
- Parameters are read-only (like `val`).
- Name functions with **verbs** in camelCase: `calculateTotal`, `printReport`. Use `is`/`has` for `Boolean`: `isEven`, `hasAccess`.
- Prefer **returning** a value over printing inside the function. The caller decides what to do with it.

## Common Mistakes / Gotchas
- Forgetting the return type:
  ```kotlin
  fun add(a: Int, b: Int) {
      return a + b   // ❌ type mismatch: function returns Unit
  }
  ```
- Leaving out parameter types: `fun add(a, b)` → compile error.
- Calling without `()`: `greet` alone does nothing (it refers to the function, it doesn't call it).
- Ignoring the result: `add(2, 3)` on its own line calculates `5` and throws it away.
- Wrong order or number of arguments → type mismatch or "No value passed for parameter".
- Code after `return` in the same block never runs (IntelliJ marks it "Unreachable code").
- Trying to reassign a parameter.

## Practice Done
- [ ] Write `sayHello()` that prints a greeting and call it 3 times
- [ ] Write `greet(name: String)` and call it with 3 names
- [ ] Write `add(a: Int, b: Int): Int` and print the result of `add(15, 27)`
- [ ] Write `isEven(n: Int): Boolean` and test it on 1 to 10 with a `for` loop
- [ ] Write `max(a: Int, b: Int, c: Int): Int` using `if` as an expression
- [ ] Write `grade(marks: Int): String` using `when`
- [ ] Write `areaOfCircle(radius: Double): Double` (use `Math.PI`)
- [ ] Write `factorial(n: Int): Long` using a `for` loop
- [ ] Write `isPrime(n: Int): Boolean` with an early `return false`
- [ ] Read two numbers with `readln()` and pass them to your `add` function
- [ ] Try reassigning a parameter and read the error
- [ ] Remove the last `return` from `sign()` and read the error

## Doubts / Questions
-
