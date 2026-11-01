# If Expression

> Module: Control Flow

## What is it?

- `if` lets your program **make decisions**: run some code only when a condition is `true`.
- The condition must be a `Boolean` (recap: Basics, Operators). Kotlin does **not** treat `0`, `""` or `null` as `false`.
- In Kotlin, `if` is an **expression**: it can **return a value**, which you can store in a variable.
- Because of this, Kotlin has **no ternary operator** (`a ? b : c`). `if` does that job.

## Syntax / Example

### 1. Simple `if`
```kotlin
val age = 20

if (age >= 18) {
    println("You can vote")
}
```

### 2. `if` / `else`
```kotlin
val temperature = 15

if (temperature > 25) {
    println("Hot")
} else {
    println("Not hot")
}
```

### 3. `else if` chain
```kotlin
val marks = 72

if (marks >= 90) {
    println("Grade A")
} else if (marks >= 75) {
    println("Grade B")
} else if (marks >= 50) {
    println("Grade C")
} else {
    println("Fail")
}
// Grade C
```
- Conditions are checked **top to bottom**. The **first** `true` one runs, and the rest are skipped.

### 4. `if` as an expression (returns a value)
```kotlin
val a = 10
val b = 20

val max = if (a > b) a else b
println(max)   // 20
```
- This replaces Java/JS's `val max = a > b ? a : b`.

**With blocks: the LAST line of the block is the value**
```kotlin
val score = 85

val result = if (score >= 50) {
    println("Checking...")   // runs, but is not the value
    "Pass"                   // ← this is the value
} else {
    "Fail"
}
println(result)   // Checking...  then  Pass
```

**`else` is required when `if` is used as an expression**
```kotlin
val x = if (a > b) a            // ❌ ERROR: 'if' must have both main and 'else' branches
val y = if (a > b) a else b     // ✅
```
- Kotlin needs a value for **every** case, so it needs `else`.

### 5. Both branches can have different types (be careful)
```kotlin
val value = if (true) 10 else "ten"   // type becomes Any. Usually a mistake
```
- Keep both branches the **same type** so the result type is useful.

### 6. Combining conditions (recap: Basics, Operators)
```kotlin
val age = 25
val hasLicense = true

if (age >= 18 && hasLicense) {
    println("Can drive")
}

if (age < 13 || age > 60) {
    println("Discount")
}

if (!hasLicense) {
    println("Get a license first")
}
```

### 7. Nested `if`
```kotlin
val num = 15

if (num > 0) {
    if (num % 2 == 0) {
        println("Positive even")
    } else {
        println("Positive odd")
    }
} else {
    println("Zero or negative")
}
```
- Deep nesting is hard to read. Prefer `&&` or `when` (next lesson).

### 8. Using `if` directly inside other code
```kotlin
println(if (age >= 18) "Adult" else "Minor")
println("Status: ${if (isOnline) "online" else "offline"}")

fun max(a: Int, b: Int) = if (a > b) a else b
```

### 9. Curly braces are optional for one line
```kotlin
if (age >= 18) println("Adult") else println("Minor")
```
- For anything more than one short line, **use braces**. It prevents bugs.

## Key Points
- The condition must be a `Boolean`: `if (count)` is an error; write `if (count > 0)`.
- `if` returns a value: `val x = if (cond) a else b`.
- When used as an expression, `else` is **required**.
- In a block, the **last expression** is the value of that branch.
- No ternary operator in Kotlin. Use `if`/`else`.
- In an `else if` chain, only the **first** true branch runs.

## Common Mistakes / Gotchas
- `if (x = 5)` → error. `=` assigns, `==` compares.
- Writing `if (count)` like in JS/Python/C. Kotlin only accepts `Boolean`.
- Forgetting `else` when storing the result: `val x = if (a > b) a` → compile error.
- Wrong order in an `else if` chain: put the **most specific** condition first.
  ```kotlin
  if (marks >= 50) "C" else if (marks >= 90) "A"   // ❌ 95 gives "C"
  ```
- Putting `println` as the last line of a block you assign: the value becomes `Unit`, not your text.
- Long `else if` chains: use `when` instead. It's cleaner.

## Practice Done
- [ ] Check if a number is positive, negative or zero
- [ ] Check if a number is even or odd using `%`
- [ ] Store the bigger of two numbers in `val max` using `if` as an expression
- [ ] Find the largest of **three** numbers
- [ ] Print a grade (A/B/C/D/Fail) from marks using an `else if` chain
- [ ] Check if a year is a leap year: divisible by 4 and (not by 100, or by 400)
- [ ] Read age with `readln()` and print `"Adult"` or `"Minor"` in one `println` using `if`
- [ ] Write `fun absolute(n: Int) = if (n < 0) -n else n` and test it with `-7` and `7`
- [ ] Try `val x = if (true) 1` without `else` and read the error

## Doubts / Questions
-
