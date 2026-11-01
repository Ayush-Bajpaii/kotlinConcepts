# For Loops

> Module: Control Flow

## What is it?

- A `for` loop **repeats code** once for **each item** in something you can go through: a range, a string, an array, a list.
- Kotlin's `for` is a **for-each** loop: `for (item in things)`.
- There is **no C-style loop** `for (int i = 0; i < n; i++)` in Kotlin. Ranges do that job (recap: Ranges).
- Use `for` when you **know** what you're looping over. Use `while` when you loop **until** something happens (next lesson).

## Syntax / Example

### 1. Looping over a range
```kotlin
for (i in 1..5) {
    println("Count: $i")
}
```
- `i` is the **loop variable**. It takes the next value on each round.
- The C-style `for (int i = 0; i < 5; i++)` is written as `for (i in 0..<5)`.

### 2. Different ranges (recap: Ranges)
```kotlin
for (i in 0..<5) print("$i ")        // 0 1 2 3 4
for (i in 10 downTo 0 step 2) print("$i ")  // 10 8 6 4 2 0
for (c in 'a'..'e') print(c)         // abcde
```

### 3. Looping over a String
```kotlin
for (ch in "Kotlin") {
    print("$ch-")
}
// K-o-t-l-i-n-
```
- Each item is a `Char`.

### 4. Looping over an array or list
```kotlin
val fruits = listOf("Apple", "Banana", "Mango")

for (fruit in fruits) {
    println(fruit)
}
```
- `listOf` and arrays are covered fully in Collections. For now, read it as "a group of values".

### 5. Getting the index too
```kotlin
val fruits = listOf("Apple", "Banana", "Mango")

// Option A: indices
for (i in fruits.indices) {        // 0..2
    println("$i: ${fruits[i]}")
}

// Option B: withIndex() (cleaner)
for ((index, fruit) in fruits.withIndex()) {
    println("$index: $fruit")
}
// 0: Apple
// 1: Banana
// 2: Mango
```
- `fruits.indices` is the range of valid indexes, `0..(size - 1)`.
- `(index, fruit)` unpacks two values at once. This is called **destructuring**.

### 6. Looping over a map
```kotlin
val ages = mapOf("Ayush" to 25, "Riya" to 22)

for ((name, age) in ages) {
    println("$name is $age")
}
```

### 7. The loop variable is read-only
```kotlin
for (i in 1..5) {
    i = 10     // ❌ ERROR: 'val' cannot be reassigned
}
```
- `i` behaves like a `val`. You can't change it inside the loop.
- `i` only exists **inside** the loop.

### 8. Doing work with a loop
```kotlin
// Sum of 1 to 100
var sum = 0
for (i in 1..100) {
    sum += i
}
println(sum)   // 5050

// Multiplication table
val n = 7
for (i in 1..10) {
    println("$n x $i = ${n * i}")
}
```
- The variable you update (`sum`) must be a `var` declared **outside** the loop.

### 9. Nested loops
```kotlin
for (row in 1..3) {
    for (col in 1..row) {
        print("* ")
    }
    println()
}
// *
// * *
// * * *
```
- The inner loop runs **fully** for each round of the outer loop.
- The total number of runs is outer × inner, so nested loops get slow quickly.

### 10. `repeat` (when you don't need the value)
```kotlin
repeat(3) {
    println("Hello")
}

repeat(3) { index ->
    println("Round $index")   // 0, 1, 2 (starts at 0!)
}
```

### 11. `forEach` (a function, not a real loop)
```kotlin
val nums = listOf(1, 2, 3)

nums.forEach { n ->
    println(n * 10)
}
nums.forEach { println(it) }   // `it` = the current item
```
- `forEach` takes a **lambda** (a block of code passed as a value). Lambdas are covered in Functions.
- `break` and `continue` **don't work** directly inside `forEach`. Use a normal `for` loop if you need them (see Break, Continue, Labels).

## Key Points
- `for (x in something)`. Kotlin's `for` always goes through items.
- No C-style `for (i = 0; i < n; i++)`. Use `0..<n` or `indices`.
- Works with ranges, strings, arrays, lists, maps, and anything that has an `iterator()`.
- The loop variable is read-only and local to the loop.
- `withIndex()` gives index and value together.
- `repeat(n)` runs a block `n` times, with index starting at `0`.
- Declare result variables (`var sum = 0`) **before** the loop.

## Common Mistakes / Gotchas
- `for (i in 0..list.size)` → goes one too far → **crash** (`IndexOutOfBoundsException`). Use `list.indices` or `0..<list.size`.
- Declaring `var sum = 0` **inside** the loop: it resets every round.
- Counting down with `10..1` → runs 0 times. Use `downTo`.
- Expecting `repeat`'s index to start at `1`. It starts at `0`.
- Trying `break` inside `forEach { }` → compile error.
- Changing a list while looping over it → crash (`ConcurrentModificationException`). Covered in Collections.

## Practice Done
- [ ] Print numbers 1 to 20
- [ ] Print the multiplication table of a number read with `readln()`
- [ ] Find the sum of all even numbers from 1 to 100
- [ ] Calculate the factorial of 5 (`1 * 2 * 3 * 4 * 5 = 120`)
- [ ] Print each character of your name on a new line
- [ ] Count the vowels in `"Kotlin Programming"` using a `for` loop and `when`
- [ ] Reverse a string manually using `for (i in text.indices.reversed())`
- [ ] Print a list of 3 fruits with their positions using `withIndex()`
- [ ] Print a right-angle triangle of `*` with 5 rows using nested loops
- [ ] FizzBuzz: 1 to 30, print `Fizz` for multiples of 3, `Buzz` for 5, `FizzBuzz` for both
- [ ] Try changing `i` inside a `for` loop and read the error

## Doubts / Questions
-
