# Local Functions

> Module: Functions

## What is it?

- A **local function** is a function declared **inside another function**.
- It can only be used inside that outer function. Nobody else can see it.
- It can read (and change) the outer function's **parameters and variables**.
- Use it for a small helper that only makes sense in one place, to avoid repeating code without cluttering the file.

## Syntax / Example

### 1. Declaring a local function
```kotlin
fun printReport() {
    fun line() {
        println("-".repeat(20))
    }

    line()
    println("Monthly Report")
    line()
}
```
- `line()` exists only inside `printReport()`.

### 2. Not visible outside
```kotlin
fun main() {
    printReport()
    line()        // ❌ ERROR: Unresolved reference: line
}
```

### 3. Using the outer function's parameters
```kotlin
fun printBox(title: String, width: Int) {
    fun border() = println("+" + "-".repeat(width) + "+")

    border()
    println("|" + title.padEnd(width) + "|")
    border()
}

printBox("Kotlin", 10)
// +----------+
// |Kotlin    |
// +----------+
```
- `border()` uses `width` **without** receiving it as a parameter.
- A function that uses variables from around it is called a **closure**. Covered more in Functional Programming.

### 4. Removing repeated validation
```kotlin
fun registerUser(name: String, email: String, city: String) {
    fun requireNotBlank(value: String, field: String) {
        if (value.isBlank()) {
            throw IllegalArgumentException("$field can't be empty")
        }
    }

    requireNotBlank(name, "Name")
    requireNotBlank(email, "Email")
    requireNotBlank(city, "City")

    println("Registered $name")
}
```
- Same check, written once, used 3 times. Exceptions (`throw`) are covered later.

### 5. Changing an outer variable
```kotlin
fun countWords(text: String): Int {
    var count = 0

    fun add() {
        count++          // changes the outer `count`
    }

    for (word in text.split(" ")) {
        if (word.isNotBlank()) add()
    }
    return count
}

println(countWords("Kotlin is  fun"))   // 3
```

### 6. Must be declared before use
```kotlin
fun main() {
    sayHi()          // ❌ ERROR: Unresolved reference: sayHi
    fun sayHi() = println("Hi")
}
```
- Top-level functions can be called before their declaration. **Local functions can't**. Local code runs top to bottom.

### 7. Local functions can return values
```kotlin
fun bmiReport(weightKg: Double, heightM: Double): String {
    fun bmi() = weightKg / (heightM * heightM)

    fun category(value: Double) = when {
        value < 18.5 -> "Underweight"
        value < 25 -> "Normal"
        value < 30 -> "Overweight"
        else -> "Obese"
    }

    val value = bmi()
    return "BMI %.1f → %s".format(value, category(value))
}

println(bmiReport(70.0, 1.75))   // BMI 22.9 → Normal
```

### 8. Recursive local function
```kotlin
fun sumDigits(n: Int): Int {
    fun helper(x: Int): Int = if (x == 0) 0 else x % 10 + helper(x / 10)
    return helper(n)
}

println(sumDigits(1234))   // 10
```
- Local functions can call themselves (see Recursion and Tailrec). When the return type isn't inferable from a recursive call, write it explicitly.

## Key Points
- Declared inside another function with the normal `fun` syntax.
- Visible **only** inside the outer function.
- Can use and change the outer function's parameters and local variables.
- Must be declared **before** it's called.
- Good for small helpers used several times inside one function.
- If a helper is useful in other places too, make it a normal top-level (or `private`) function instead.

## Common Mistakes / Gotchas
- Calling a local function before declaring it → "Unresolved reference".
- Trying to call it from outside the outer function.
- Adding visibility modifiers: `private fun` inside a function → error. Local functions are already private to the function.
- Nesting local functions inside local functions inside... → hard to read. Keep it to one level.
- Making the outer function very long by stuffing many local functions in it. Split it into separate functions instead.
- A recursive local function without an explicit return type → error ("Type checking has run into a recursive problem").

## Practice Done
- [ ] Write `printReport()` with a local `line()` function used 3 times
- [ ] Write `printBox(title, width)` where a local `border()` uses `width` from the outer function
- [ ] Write `validateForm(name, email, password)` with a local `check(value, field)` helper
- [ ] Write `countWords(text)` where a local function updates an outer `var count`
- [ ] Call a local function before declaring it and read the error
- [ ] Try calling a local function from `main` and read the error
- [ ] Write `sumDigits(n)` with a recursive local helper
- [ ] Write a temperature report function with local `toFahrenheit()` and `label()` helpers

## Doubts / Questions
-
