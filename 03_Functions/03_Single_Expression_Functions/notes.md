# Single Expression Functions

> Module: Functions

## What is it?

- When a function body is **just one expression**, you can drop `{ }` and `return` and write `= expression`.
- This is called an **expression body**. The normal `{ }` style is a **block body**.
- The return type can usually be **inferred** (recap: Type Inference).
- It's very common in Kotlin code for short helpers.

## Syntax / Example

### 1. Block body vs expression body
```kotlin
// Block body
fun double(x: Int): Int {
    return x * 2
}

// Expression body
fun double2(x: Int): Int = x * 2

// Expression body with inferred return type
fun double3(x: Int) = x * 2
```
- All three do the same thing.
- No `return` keyword in an expression body.

### 2. Short helpers
```kotlin
fun square(n: Int) = n * n
fun isEven(n: Int) = n % 2 == 0
fun fullName(first: String, last: String) = "$first $last"
fun celsiusToF(c: Double) = c * 9 / 5 + 32

println(square(6))                    // 36
println(isEven(7))                    // false
println(fullName("Ayush", "Bajpai"))  // Ayush Bajpai
println(celsiusToF(100.0))            // 212.0
```

### 3. With `if` as an expression
```kotlin
fun max(a: Int, b: Int) = if (a > b) a else b
fun abs(n: Int) = if (n < 0) -n else n
```
- Works because `if...else` is an **expression** in Kotlin (recap: If Expression).

### 4. With `when` as an expression
```kotlin
fun dayType(day: String) = when (day) {
    "Saturday", "Sunday" -> "Weekend"
    else -> "Weekday"
}

fun grade(marks: Int) = when {
    marks >= 90 -> "A"
    marks >= 75 -> "B"
    marks >= 50 -> "C"
    else -> "F"
}
```
- An expression can span many lines. It's still "single expression" because it's **one** `when`.

### 5. `Unit` expression bodies
```kotlin
fun greet(name: String) = println("Hello, $name!")
```
- `println` returns `Unit`, so `greet` returns `Unit`.
- This compiles, but many developers prefer a block body for functions that only **do** something and return nothing.

### 6. When to write the return type anyway
```kotlin
fun discount(price: Double): Double = price * 0.9
```
- Write it when:
  - the function is **public** and used by others (the type is a promise),
  - the inferred type isn't obvious from reading,
  - you want the compiler to **check** that you return the right type.

### 7. Inferred type surprises
```kotlin
fun half(n: Int) = n / 2           // Int → half(5) is 2, not 2.5
fun halfD(n: Int) = n / 2.0        // Double → 2.5
```
- The type comes from the expression, so integer division stays `Int` (recap: Operators).

### 8. Calling other functions
```kotlin
fun square(n: Int) = n * n
fun sumOfSquares(a: Int, b: Int) = square(a) + square(b)
```

### 9. Converting block → expression body (IntelliJ)
- Put the cursor on `return` → `Alt + Enter` (Mac: `⌥ + ↩`) → **Convert to expression body**.
- Works the other way too: **Convert to block body**.

## Key Points
- `fun name(params) = expression` is the same as `{ return expression }`.
- Return type is optional when it can be inferred.
- `if`, `when` and `try` are expressions, so they fit in expression bodies.
- Use expression bodies for **short**, one-idea functions. Use block bodies when you need several statements or variables.
- Give an explicit return type to public functions or when the type isn't obvious.

## Common Mistakes / Gotchas
- Using `=` **and** `{ }` together:
  ```kotlin
  fun hello() = { println("Hi") }
  hello()   // prints NOTHING
  ```
  `= { ... }` makes the function **return a lambda** instead of running the code. Lambdas are covered in Functional Programming. Use `fun hello() = println("Hi")` or `fun hello() { println("Hi") }`.
- Writing `return` in an expression body: `fun f(x: Int) = return x * 2` → error.
- `if` without `else` in an expression body → error ("'if' must have both main and 'else' branches if used as an expression").
- Unexpected inferred type (`Int` instead of `Double`) from integer math.
- Squeezing complex logic into one long expression. If it doesn't read easily, use a block body.

## Practice Done
- [ ] Rewrite `add`, `square` and `isEven` as single-expression functions
- [ ] Write `max(a, b)` and `min(a, b)` with `if` expressions
- [ ] Write `grade(marks)` with `when` as an expression body
- [ ] Write `celsiusToFahrenheit(c: Double)` and `fahrenheitToCelsius(f: Double)`
- [ ] Write `isLeapYear(year: Int)` in one expression
- [ ] Write `half(n: Int)` with and without `.0` and compare the results
- [ ] Write `fun hello() = { println("Hi") }`, call it, and explain why nothing prints
- [ ] Use IntelliJ's "Convert to expression body" on one of your Function Basics functions

## Doubts / Questions
-
