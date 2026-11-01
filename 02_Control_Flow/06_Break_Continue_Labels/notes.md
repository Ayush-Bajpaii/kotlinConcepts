# Break Continue Labels

> Module: Control Flow

## What is it?

- `break` **stops the loop** completely and jumps to the code after it.
- `continue` **skips the rest of the current round** and goes to the next one.
- A **label** (like `outer@`) gives a loop a name, so `break` or `continue` can target an **outer** loop, not just the closest one.
- Kotlin has three **jump** expressions: `break`, `continue` and `return`.

## Syntax / Example

### 1. `break`: stop the loop
```kotlin
for (i in 1..10) {
    if (i == 5) break
    print("$i ")
}
println("Done")
// 1 2 3 4 Done
```

### 2. `continue`: skip this round
```kotlin
for (i in 1..10) {
    if (i % 2 == 0) continue   // skip even numbers
    print("$i ")
}
// 1 3 5 7 9
```

### 3. `break` vs `continue`
| | `break` | `continue` |
|---|---|---|
| What it does | exits the loop | skips to the next round |
| Rest of the current round | skipped | skipped |
| Remaining rounds | **none** run | **still** run |

### 4. Works in `while` and `do-while` too
```kotlin
var i = 0
while (true) {
    i++
    if (i == 3) continue
    if (i > 5) break
    print("$i ")
}
// 1 2 4 5
```
- With `while`, update the counter **before** `continue`. Otherwise you can create an infinite loop.

### 5. Real use: search and stop early
```kotlin
val nums = listOf(4, 9, 15, 22, 31)
var firstEven: Int? = null

for (n in nums) {
    if (n % 2 == 0) {
        firstEven = n
        break          // found it, no need to check the rest
    }
}
println(firstEven)   // 4
```

### 6. The problem: `break` only exits the **inner** loop
```kotlin
for (i in 1..3) {
    for (j in 1..3) {
        if (j == 2) break     // exits only the inner loop
        println("$i, $j")
    }
}
// 1, 1
// 2, 1
// 3, 1
```

### 7. Labels: `break@label`
```kotlin
outer@ for (i in 1..3) {
    for (j in 1..3) {
        if (i == 2 && j == 2) break@outer   // exits BOTH loops
        println("$i, $j")
    }
}
// 1, 1
// 1, 2
// 1, 3
// 2, 1
```
- A label is a name followed by `@`, placed **before** the loop: `outer@ for (...)`.
- `break@outer` jumps **out of the loop named `outer`**.
- Any name works: `rows@`, `search@`, `loop@`.

### 8. Labels: `continue@label`
```kotlin
outer@ for (i in 1..3) {
    for (j in 1..3) {
        if (j == 2) continue@outer   // skip to the next i
        println("$i, $j")
    }
}
// 1, 1
// 2, 1
// 3, 1
```
- `continue@outer` stops the inner loop **and** moves the outer loop to its next round.

### 9. `break` and `continue` inside `when`
```kotlin
for (i in 1..10) {
    when {
        i == 3 -> continue
        i == 6 -> break
        else -> print("$i ")
    }
}
// 1 2 4 5
```
- Since Kotlin 1.4, `break` and `continue` inside a `when` apply to the **surrounding loop**, with no label needed.

### 10. `forEach` and `return@` (preview of lambdas)
```kotlin
listOf(1, 2, 3, 4).forEach {
    if (it == 2) return@forEach   // like `continue`: skips only this item
    print("$it ")
}
// 1 3 4
```
- `break` and `continue` **can't** be used directly inside `forEach { }`.
- `return@forEach` returns from the lambda for **this item only**, which works like `continue`.
- A plain `return` inside `forEach` exits the **whole function** (`main`), not just the loop. This surprises many people.
- If you need `break`, use a normal `for` loop.

### 11. `return` in a loop
```kotlin
fun findIndex(names: List<String>, target: String): Int {
    for (i in names.indices) {
        if (names[i] == target) return i   // exits the loop AND the function
    }
    return -1
}
```

## Key Points
- `break` = exit the loop. `continue` = skip to the next round.
- Without a label, both affect only the **closest** loop.
- Label a loop with `name@ for (...)`, and target it with `break@name` / `continue@name`.
- Labels are mostly useful with **nested loops**.
- `break`/`continue` inside `when` inside a loop work on the loop (Kotlin 1.4+).
- Inside `forEach`, use `return@forEach` to skip an item. Plain `return` exits the whole function.
- `return` inside a loop exits the whole function, not just the loop.

## Common Mistakes / Gotchas
- Expecting `break` in an inner loop to stop the outer loop too. It doesn't; use a label.
- Space in the wrong place: write `break@outer`, **no space** before `@`. Define the label as `outer@ for`.
- `continue` in a `while` loop before updating the counter → infinite loop.
  ```kotlin
  var i = 0
  while (i < 5) {
      if (i == 2) continue   // ❌ i stays 2 forever
      i++
  }
  ```
- Using `break` inside `forEach { }` → compile error.
- Using plain `return` inside `forEach` and expecting it to skip one item. It exits the function.
- Too many labels and jumps make code hard to follow. Often a small function with `return` is cleaner.

## Practice Done
- [ ] Print 1 to 100 but stop at the first number divisible by both 7 and 5
- [ ] Print 1 to 20, skipping multiples of 3, using `continue`
- [ ] Read numbers with `readln()` in `while (true)` and add them up until the user types `0`, then print the total
- [ ] Find the first number above 100 that's divisible by 17
- [ ] Check if a number is prime: loop from 2 and `break` as soon as you find a divisor
- [ ] Print all prime numbers from 2 to 50 using `continue@outer`
- [ ] Search a 3x3 grid (nested loops over `1..3`) for `i * j == 6` and stop **both** loops with `break@outer`
- [ ] Use `when` inside a `for` loop with both `continue` and `break`
- [ ] Use `return@forEach` to skip even numbers in `listOf(1, 2, 3, 4, 5)`
- [ ] Put a plain `return` inside `forEach` in `main`, add a `println` after the loop, and explain why it never prints

## Doubts / Questions
-
