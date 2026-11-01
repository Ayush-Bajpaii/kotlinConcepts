# Default and Named Arguments

> Module: Functions

## What is it?

- A **default argument** is a value a parameter uses **when the caller doesn't pass one**.
- A **named argument** is when the caller writes the **parameter name** in the call: `greet(name = "Ayush")`.
- Together they make calls shorter, clearer, and remove the need to write many versions (overloads) of the same function, which Java needs.

## Syntax / Example

### 1. Default values
```kotlin
fun greet(name: String, greeting: String = "Hello") {
    println("$greeting, $name!")
}

greet("Ayush")              // Hello, Ayush!
greet("Ayush", "Welcome")   // Welcome, Ayush!
```
- Write `= value` after the type.
- The caller can **skip** parameters that have defaults.

### 2. Several defaults
```kotlin
fun createUser(name: String, age: Int = 18, country: String = "India") {
    println("$name, $age, $country")
}

createUser("Ayush")              // Ayush, 18, India
createUser("Ayush", 25)          // Ayush, 25, India
createUser("Ayush", 25, "UK")    // Ayush, 25, UK
```

### 3. Named arguments
```kotlin
createUser(name = "Riya", age = 22, country = "USA")
```
- Each argument says which parameter it's for. Readers don't need to remember the order.

### 4. Named arguments in any order
```kotlin
createUser(country = "Japan", name = "Ken", age = 30)
// Ken, 30, Japan
```

### 5. Skipping a middle parameter
```kotlin
createUser("Ayush", country = "Canada")
// Ayush, 18, Canada   → age uses its default
```
- Without named arguments you can't skip `age` and set `country`.
- This is the **most common use** of named arguments.

### 6. Mixing positional and named
```kotlin
createUser("Ayush", age = 25)              // ✅ positional first, then named
createUser(name = "Ayush", 25, "UK")       // ✅ allowed when every argument is in its own position (Kotlin 1.4+)
createUser(age = 25, "Ayush")              // ❌ ERROR: named argument out of position, then positional
```
- Safest rule: put **positional arguments first**, then named ones.

### 7. Named arguments make unclear calls readable
```kotlin
fun formatPrice(amount: Double, showSymbol: Boolean, roundOff: Boolean): String {
    val value = if (roundOff) Math.round(amount).toString() else amount.toString()
    return if (showSymbol) "₹$value" else value
}

formatPrice(99.5, true, false)                                // what do true/false mean?
formatPrice(99.5, showSymbol = true, roundOff = false)        // clear
```
- Use named arguments especially for `Boolean`s, numbers and `null`s, where the value alone means nothing.

### 8. A default can use an earlier parameter
```kotlin
fun rectangle(width: Int, height: Int = width) {
    println("${width} x ${height} = ${width * height}")
}

rectangle(5)      // 5 x 5 = 25   (a square)
rectangle(5, 3)   // 5 x 3 = 15
```
- Defaults are evaluated **at call time**, and can use parameters declared **before** them.

### 9. Default parameter before a required one
```kotlin
fun sendEmail(subject: String = "No subject", body: String) {
    println("[$subject] $body")
}

sendEmail(body = "Hi there")   // ✅ must name `body`
sendEmail("Hi there")          // ❌ ERROR: "Hi there" goes to `subject`, `body` is missing
```
- Put parameters **with defaults at the end** so callers don't have to use names.

### 10. Defaults replace overloading
```kotlin
// Java style: 3 functions
fun connect(host: String) { connect(host, 80, false) }
fun connect(host: String, port: Int) { connect(host, port, false) }
fun connect(host: String, port: Int, secure: Boolean) { println("$host:$port secure=$secure") }

// Kotlin style: 1 function
fun connect(host: String, port: Int = 80, secure: Boolean = false) {
    println("$host:$port secure=$secure")
}
```
- (Both styles can't exist in the same file; this is just a comparison.)
- Java code can't use Kotlin defaults directly. Adding `@JvmOverloads` before `fun` generates the overloads for Java callers.

### 11. Trailing comma
```kotlin
createUser(
    name = "Ayush",
    age = 25,
    country = "India",   // trailing comma is allowed
)
```
- One argument per line plus a trailing comma makes long calls easy to read and edit.

## Key Points
- Default: `param: Type = value`. The caller may skip it.
- Named: `function(param = value)`. Order no longer matters.
- Use named arguments to skip middle defaults and to make `Boolean`/number arguments clear.
- Put parameters with defaults **last**.
- Defaults are evaluated each time the function is called, and can refer to earlier parameters.
- One function with defaults replaces several overloaded functions.

## Common Mistakes / Gotchas
- Putting a positional argument after a named one that isn't in its position → compile error.
- Default parameter **before** a required one forces callers to use names.
- Renaming a parameter **breaks** every call that used the old name with a named argument.
- Named arguments **don't work** when calling Java functions (Java doesn't keep parameter names).
- Passing the same parameter twice: `greet("Ayush", name = "Riya")` → error.
- Overusing defaults: if a function has 8 optional parameters, it's probably doing too much.

## Practice Done
- [ ] Write `greet(name: String, greeting: String = "Hello")` and call it with and without `greeting`
- [ ] Write `power(base: Int, exponent: Int = 2): Int` and test `power(5)` and `power(2, 10)`
- [ ] Write `createUser(name, age = 18, country = "India")` and skip `age` while setting `country`
- [ ] Call `createUser` with all arguments named in a different order
- [ ] Write `rectangleArea(width: Int, height: Int = width)` and test with 1 and 2 arguments
- [ ] Write `formatPrice(amount, showSymbol = true, decimals = 2)` and call it with named Booleans
- [ ] Write `printLine(char: Char = '-', length: Int = 20)` and call it 4 different ways
- [ ] Put a default parameter first, call the function without names, and read the error
- [ ] Rewrite 3 overloaded functions as 1 function with defaults

## Doubts / Questions
-
