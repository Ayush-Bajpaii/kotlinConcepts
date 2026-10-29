# Input Output

> Module: Basics

## What is it?

- **Output** = showing something to the user. In Kotlin: `print()` and `println()`.
- **Input** = reading what the user types. In Kotlin: `readln()` or `readLine()`.
- Input from the keyboard always comes in as a **String**. To use it as a number, you convert it (recap: Lesson 5).

## Syntax / Example

### 1. Output: `print` vs `println`
```kotlin
print("Hello ")
print("World")
println()            // just moves to a new line
println("Kotlin")
println(42)
println(3.14)
println(true)
```
Output:
```
Hello World
Kotlin
42
3.14
true
```
- `print()` stays on the **same line**.
- `println()` moves to a **new line** after printing.

### 2. Printing values with templates (recap: Lesson 7)
```kotlin
val name = "Ayush"
val score = 95
println("$name scored $score marks")   // Ayush scored 95 marks
```

### 3. Formatting numbers
```kotlin
val price = 99.456
println("%.2f".format(price))            // 99.46  (2 decimal places)
println(String.format("%.1f", price))    // 99.5
println("Total: %.2f".format(price * 2)) // Total: 198.91
println("%5d|".format(42))               // "   42|" (width 5)
println("%-5d|".format(42))              // "42   |" (left aligned)
```
| Code | Means |
|---|---|
| `%d` | whole number |
| `%f` | decimal number (`%.2f` = 2 decimals) |
| `%s` | string |
| `%c` | char |
| `%b` | boolean |

### 4. Input: `readln()`
```kotlin
fun main() {
    print("Enter your name: ")
    val name = readln()
    println("Hello, $name!")
}
```
- `readln()` waits for the user to type and press Enter, then returns a `String`.
- If there's no input at all (input stream ended), `readln()` **crashes**.

### 5. Input: `readLine()` (nullable version)
```kotlin
val input = readLine()        // type is String? (can be null)
val name = readLine() ?: ""   // use "" if nothing came in
```
- `readLine()` returns `null` instead of crashing when there's no input.
- `?:` is the **Elvis operator**. You'll learn it fully in Null Safety.
- For learning, `readln()` is simpler.

### 6. Reading numbers
```kotlin
print("Enter your age: ")
val age = readln().toInt()
println("Next year you'll be ${age + 1}")

print("Enter price: ")
val price = readln().toDouble()
```

**Safe version (doesn't crash on bad input)**
```kotlin
print("Enter a number: ")
val num = readln().toIntOrNull()

if (num == null) {
    println("That's not a number!")
} else {
    println("Double of it: ${num * 2}")
}
```

### 7. Reading many values on one line
```kotlin
print("Enter two numbers: ")        // user types: 10 20
val parts = readln().split(" ")
val a = parts[0].toInt()
val b = parts[1].toInt()
println("Sum = ${a + b}")           // Sum = 30

// shorter
val (x, y) = readln().split(" ").map { it.toInt() }
```

### 8. Running programs that read input
- **IntelliJ**: run the program, then type in the **Run** window at the bottom and press Enter.
- **Kotlin Playground** (play.kotlinlang.org): keyboard input is **not supported**. Use IntelliJ for input programs.

## Key Points
- `print` = same line, `println` = new line.
- `readln()` reads one line of text and always returns a `String`.
- Convert input with `toInt()`, `toDouble()` etc. before doing math.
- Use `toIntOrNull()` if the user might type something wrong.
- Use `"%.2f".format(x)` to show a number with 2 decimals.
- Put a prompt with `print("Enter ...: ")` before reading, so the user knows what to type.

## Common Mistakes / Gotchas
- Doing math on input without converting: `readln() + 5` → error, or text joining instead of adding.
- `readln().toInt()` when the user types `abc` or `12.5` → **crash** (`NumberFormatException`).
- Extra spaces: `" 42".toInt()` crashes. Use `readln().trim().toInt()`.
- Two spaces between numbers: `"10  20".split(" ")` gives an empty piece in the middle. Use `split(" ").filter { it.isNotEmpty() }`, or `trim().split(Regex("\\s+"))`.
- Using `println("Enter name: ")` puts the cursor on the next line. Use `print` for prompts.
- Trying input programs in the online Playground. Use IntelliJ.

## Practice Done
- [ ] Print your name and age on the same line using two `print()` calls
- [ ] Ask the user for their name and greet them
- [ ] Ask for two numbers and print their sum, difference, product and quotient
- [ ] Ask for a temperature in Celsius and print it in Fahrenheit (`c * 9 / 5 + 32`) with 1 decimal
- [ ] Ask for the radius of a circle and print the area with 2 decimals (`Math.PI * r * r`)
- [ ] Read two numbers typed on **one line** and print the bigger one
- [ ] Ask for a number using `toIntOrNull()` and print an error message if it's not valid
- [ ] Type `abc` into a program using `toInt()` and read the crash message

## Doubts / Questions
-
