# When Expression

> Module: Control Flow

## What is it?

- `when` checks a value against **many options** and runs the matching branch.
- It's Kotlin's much more powerful version of `switch` (Java, C, JS).
- Like `if`, `when` is an **expression**: it can return a value.
- There's **no fall-through** and **no `break` needed**. Only the first matching branch runs.

## Syntax / Example

### 1. Basic `when` with a subject
```kotlin
val day = 3

when (day) {
    1 -> println("Monday")
    2 -> println("Tuesday")
    3 -> println("Wednesday")
    else -> println("Another day")
}
// Wednesday
```
- `day` is the **subject**. Each branch is `value -> code`.
- Branches are checked **top to bottom**, and the **first** match wins.
- `else` runs if nothing else matches.

### 2. `when` as an expression
```kotlin
val day = 6

val type = when (day) {
    1, 2, 3, 4, 5 -> "Weekday"
    6, 7 -> "Weekend"
    else -> "Invalid"
}
println(type)   // Weekend
```
- `1, 2, 3` = **many values** for one branch (comma means "or").

### 3. Branch with a block
```kotlin
val result = when (marks / 10) {
    10, 9 -> "A"
    8 -> {
        println("Very good!")
        "B"            // last line is the value
    }
    else -> "C"
}
```

### 4. Checking ranges with `in` (next lesson: Ranges)
```kotlin
val marks = 78

val grade = when (marks) {
    in 90..100 -> "A"
    in 75..89 -> "B"
    in 50..74 -> "C"
    in 0..49 -> "Fail"
    else -> "Invalid marks"
}
println(grade)   // B
```
- `!in` means **not in** the range: `!in 0..100 -> "Invalid"`.

### 5. Checking types with `is` (smart cast)
```kotlin
fun describe(x: Any): String = when (x) {
    is Int -> "Int, doubled is ${x * 2}"      // x is treated as Int here
    is String -> "String of length ${x.length}" // x is treated as String here
    is Boolean -> "Boolean: $x"
    else -> "Unknown type"
}

println(describe(21))       // Int, doubled is 42
println(describe("Kotlin")) // String of length 6
```
- After `is Int ->`, Kotlin **automatically** treats `x` as `Int` in that branch. This is a **smart cast**.

### 6. `when` without a subject (replaces `if-else if`)
```kotlin
val temp = 32
val isRaining = false

when {
    temp > 35 -> println("Very hot")
    temp > 25 && !isRaining -> println("Nice and warm")
    isRaining -> println("Take an umbrella")
    else -> println("Cool")
}
// Nice and warm
```
- With no subject, each branch is a **Boolean condition**.
- This is the cleanest way to write long `if / else if` chains.

### 7. Expressions as branch conditions
```kotlin
val x = 10
val target = 5

when (x) {
    target * 2 -> println("Exactly double")   // 10 == 5 * 2
    else -> println("Not double")
}
```
- Branch conditions don't have to be constants. Any expression works.

### 8. Declaring a variable in the subject
```kotlin
when (val input = readln()) {
    "yes", "y" -> println("Confirmed")
    "no", "n" -> println("Cancelled")
    else -> println("Unknown: $input")
}
```
- `input` exists **only inside** this `when`.

### 9. When is `else` required?
```kotlin
val x = 5

val a = when (x) {        // ❌ ERROR: 'when' expression must be exhaustive
    1 -> "one"
    2 -> "two"
}

when (x) {                // ✅ OK: used as a statement, nothing returned
    1 -> println("one")
    2 -> println("two")
}

val flag = true
val b = when (flag) {     // ✅ OK: Boolean has only 2 values, all covered
    true -> "yes"
    false -> "no"
}
```
- **Expression** (`val a = when ...`): must be **exhaustive** (cover every case), usually with `else`.
- **Statement** with an `Int`/`String` subject: `else` is optional.
- With `Boolean`, `enum` or `sealed` subjects, `when` must cover all cases **even as a statement** (since Kotlin 1.7). You'll see enums and sealed classes in OOP.

### 10. Function returning `when`
```kotlin
fun dayName(day: Int) = when (day) {
    1 -> "Mon"
    2 -> "Tue"
    else -> "?"
}
```

## Key Points
- `when` = a smarter `switch`. No `break`, no fall-through.
- Only the **first** matching branch runs.
- Combine values with commas: `1, 2, 3 ->`.
- `in range`, `!in range`, `is Type`, `!is Type` all work as conditions.
- `is` gives a **smart cast** inside that branch.
- `when { }` without a subject replaces `if / else if` chains.
- As an expression, it must be **exhaustive**, so add `else`.
- Last line of a branch block is that branch's value.

## Common Mistakes / Gotchas
- Expecting fall-through like C/Java `switch`. Kotlin never falls through.
- Using `||` between values: `1 || 2 ->` → error. Use commas: `1, 2 ->`.
- Overlapping ranges: the **first** match wins, so order matters.
  ```kotlin
  when (marks) {
      in 0..100 -> "Valid"   // always matches first
      in 90..100 -> "A"      // never reached
  }
  ```
- Forgetting `else` when assigning the result → "must be exhaustive" error.
- Putting a condition like `x > 5 ->` in a `when (x)` with a subject. That compares `x` with a `Boolean` → error. Use `when { x > 5 -> ... }` with no subject.

## Practice Done
- [ ] Print the day name for numbers 1–7, with `else` for invalid input
- [ ] Return `"Weekday"` or `"Weekend"` using comma-separated values
- [ ] Print a grade from marks using `in` ranges
- [ ] Write a simple calculator: read two numbers and an operator (`+ - * /`) and use `when` on the operator
- [ ] Write `describe(x: Any)` using `is Int`, `is String`, `is Double` and test with 3 types
- [ ] Rewrite your grade `else if` chain from the If lesson using `when` with no subject
- [ ] Check if a `Char` is a vowel: `'a', 'e', 'i', 'o', 'u' -> true`
- [ ] Use `when (val input = readln())` to handle `"yes"`/`"no"` answers
- [ ] Remove `else` from a `when` used as an expression and read the error

## Doubts / Questions
-
