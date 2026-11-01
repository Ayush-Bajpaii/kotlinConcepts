# Ranges

> Module: Control Flow

## What is it?

- A **range** is a sequence of values from a start to an end, like `1..5` → 1, 2, 3, 4, 5.
- Ranges are used for **checking** (`x in 1..10`) and for **looping** (`for (i in 1..10)`).
- Works with `Int`, `Long` and `Char` for looping. Other comparable types (like `Double`, `String`) support `in` checks only.
- A range is a real object: `1..5` has the type `IntRange`.

## Syntax / Example

### 1. Range operators
| Code | Values | Meaning |
|---|---|---|
| `1..5` | 1, 2, 3, 4, 5 | start to end, **end included** |
| `1..<5` | 1, 2, 3, 4 | **end excluded** (Kotlin 1.9+) |
| `1 until 5` | 1, 2, 3, 4 | same as `1..<5` (older style) |
| `5 downTo 1` | 5, 4, 3, 2, 1 | counting **down** |
| `1..10 step 2` | 1, 3, 5, 7, 9 | skip by 2 |
| `10 downTo 1 step 3` | 10, 7, 4, 1 | down, skipping by 3 |

```kotlin
for (i in 1..5) print("$i ")        // 1 2 3 4 5
println()
for (i in 1..<5) print("$i ")       // 1 2 3 4
println()
for (i in 5 downTo 1) print("$i ")  // 5 4 3 2 1
println()
for (i in 0..10 step 5) print("$i ") // 0 5 10
```

### 2. Checking with `in` and `!in`
```kotlin
val age = 25

println(age in 18..60)    // true
println(age !in 0..17)    // true

if (age in 13..19) println("Teenager")
```
- `x in a..b` means the same as `x >= a && x <= b`, but is easier to read.

### 3. Char ranges
```kotlin
for (c in 'a'..'e') print(c)    // abcde
println()

val ch = 'k'
println(ch in 'a'..'z')         // true → lowercase letter
println(ch in 'A'..'Z')         // false
println('5' in '0'..'9')        // true → digit
```

### 4. Double and String ranges (check only, no loop)
```kotlin
val temp = 36.6
println(temp in 36.1..37.2)     // true

println("kiwi" in "apple".."mango")   // true (alphabetical order)

for (x in 1.0..2.0) { }         // ❌ ERROR: can't loop over a Double range
```
- There's no "next" value after `1.0`, so Kotlin can't loop over it.

### 5. Empty ranges
```kotlin
for (i in 5..1) println(i)      // prints NOTHING
println((5..1).isEmpty())       // true
```
- `..` only counts **up**. For counting down, use `downTo`.

### 6. Useful range properties and functions
```kotlin
val r = 1..10

println(r.first)          // 1
println(r.last)           // 10
println(r.count())        // 10
println(r.sum())          // 55
println(r.reversed())     // 10 downTo 1 step 1
println(r.toList())       // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
println(r.contains(7))    // true (same as 7 in r)

println((1..10 step 4).toList())  // [1, 5, 9]
println((1..10 step 4).last)      // 9 → the last value actually reached
```

### 7. Storing ranges in variables
```kotlin
val validMarks = 0..100
val passMarks = 40..100

val marks = 55
if (marks in passMarks) println("Pass")
```

### 8. Keeping a value inside limits: `coerceIn`
```kotlin
println(150.coerceIn(0, 100))   // 100
println((-5).coerceIn(0, 100))  // 0
println(42.coerceIn(0..100))    // 42
```

### 9. Ranges in `when` (recap: When Expression)
```kotlin
val speed = 72
val label = when (speed) {
    in 0..40 -> "Slow"
    in 41..80 -> "Normal"
    else -> "Too fast"
}
```

## Key Points
- `..` includes the end. `..<` and `until` exclude it.
- `downTo` counts down. `..` alone never counts down.
- `step` changes the gap. It must be **positive**, even with `downTo`.
- `in` checks membership, `!in` checks it's outside.
- You can loop over `Int`, `Long` and `Char` ranges, but not `Double`.
- `5..1` is an **empty** range, not an error.
- With `step`, `last` is the last value **actually reached**, not always the end you wrote.

## Common Mistakes / Gotchas
- Writing `10..1` to count down → loop runs **0 times**. Use `10 downTo 1`.
- `step 0` or `step -2` → **crash** (`IllegalArgumentException`). Use `downTo` for going backwards.
- Using `..` when you meant to exclude the end: looping `0..list.size` goes **one past** the last index → crash. Use `0..<list.size` or `list.indices`.
- Off-by-one with `until`: `1 until 5` does **not** include `5`.
- Trying to loop over `1.0..5.0` → compile error.
- `(1..10 step 3).last` is `10` but `(1..10 step 4).last` is `9`. Don't assume the end is reached.

## Practice Done
- [ ] Print 1 to 10 using `..`
- [ ] Print 1 to 9 using `..<` and again using `until`
- [ ] Print 10 down to 1 using `downTo`
- [ ] Print all even numbers from 2 to 20 using `step`
- [ ] Print the alphabet `a` to `z` using a `Char` range
- [ ] Check if an age is in `13..19` and print `"Teenager"`
- [ ] Check if a `Char` is a digit, a lowercase letter or an uppercase letter
- [ ] Print the sum of 1 to 100 using `(1..100).sum()`
- [ ] Print `(1..20 step 3).toList()` and its `last`, and explain the result
- [ ] Try `for (i in 5..1)` and `step -1`, and explain what happens

## Doubts / Questions
-
