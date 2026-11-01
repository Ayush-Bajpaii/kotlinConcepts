# While DoWhile

> Module: Control Flow

## What is it?

- `while` repeats code **as long as** a condition is `true`.
- `do-while` does the same, but runs the body **at least once** and checks the condition **after**.
- Use them when you **don't know in advance** how many times to loop, for example "keep asking until the user types a valid number".
- `while` and `do-while` are **statements**, not expressions. They don't return a value (unlike `if` and `when`).

## Syntax / Example

### 1. `while` loop
```kotlin
var count = 1

while (count <= 5) {
    println("Count: $count")
    count++          // without this, the loop never ends
}
```
How it runs:
1. Check the condition. If `false`, skip the loop entirely.
2. Run the body.
3. Go back to step 1.

### 2. `while` may run zero times
```kotlin
var x = 10
while (x < 5) {
    println("Never printed")
}
```
- The condition is checked **first**, so if it's `false` at the start, the body never runs.

### 3. `do-while` loop
```kotlin
var count = 1

do {
    println("Count: $count")
    count++
} while (count <= 5)
```
How it runs:
1. Run the body.
2. Check the condition. If `true`, go back to step 1.

### 4. `do-while` always runs at least once
```kotlin
var x = 10
do {
    println("Printed once: $x")   // runs even though x < 5 is false
} while (x < 5)
```

### 5. `while` vs `do-while` side by side
| | `while` | `do-while` |
|---|---|---|
| Checks condition | **before** the body | **after** the body |
| Minimum runs | 0 | 1 |
| Best for | "loop only if needed" | "do it once, repeat if needed" |

### 6. Real use: keep asking until input is valid
```kotlin
var age: Int?

do {
    print("Enter your age: ")
    age = readln().toIntOrNull()
} while (age == null || age < 0)

println("Your age is $age")
```
- You must ask **at least once**, so `do-while` fits perfectly.

**Variables declared inside `do { }` are visible in the `while (...)` condition**
```kotlin
do {
    val input = readln()
} while (input != "quit")   // ✅ `input` is visible here
```
- This is special to `do-while`. They are **not** visible after the loop ends.

### 7. Real use: digits of a number
```kotlin
var n = 4527
var sum = 0

while (n > 0) {
    sum += n % 10    // take the last digit
    n /= 10          // remove the last digit
}
println(sum)   // 18 (4 + 5 + 2 + 7)
```
- You don't know how many digits there are in advance, so `while` is the right choice.

### 8. Infinite loops
```kotlin
while (true) {
    val input = readln()
    if (input == "exit") break    // the only way out
    println("You typed: $input")
}
```
- `while (true)` runs forever until `break` (next lesson) is hit.
- An **accidental** infinite loop freezes your program. In IntelliJ, press the red **Stop** button.

### 9. `for` vs `while`: which to choose?
```kotlin
// Known count → for
for (i in 1..10) println(i)

// Unknown count, depends on a condition → while
var balance = 1000
var months = 0
while (balance < 2000) {
    balance += balance * 10 / 100
    months++
}
println("Doubled in $months months")
```

## Key Points
- `while (condition) { }` checks **first**, so it may run 0 times.
- `do { } while (condition)` checks **last**, so it always runs at least once.
- Something inside the loop **must change** the condition, or it never ends.
- Loop variables (`var count`) are declared **before** the loop and must be `var`.
- Variables declared in `do { }` can be used in its `while (...)` condition.
- `for` = known number of items. `while` = repeat until a condition changes.
- `while` and `do-while` don't return a value.

## Common Mistakes / Gotchas
- Forgetting to update the variable (`count++`) → **infinite loop**.
- Updating in the wrong direction: `while (i <= 10) { i-- }` → never ends.
- Off-by-one: `while (i < 5)` vs `while (i <= 5)` run a different number of times.
- Missing the condition at the end of `do-while`: `do { } while` needs `(condition)`.
- Using `while` when the body must run once (like asking for input): you end up repeating code before the loop. Use `do-while`.
- Using `val` for the loop counter → `count++` fails. It must be `var`.

## Practice Done
- [ ] Print 1 to 10 using `while`
- [ ] Print 10 down to 1 using `do-while`
- [ ] Find the sum of the digits of `98765` using `while`
- [ ] Reverse a number: `1234` → `4321` (hint: `rev = rev * 10 + n % 10`)
- [ ] Count how many digits a number has
- [ ] Keep asking for a password until the user types `"kotlin123"` using `do-while`
- [ ] Number guessing game: pick `val secret = (1..100).random()`, keep reading guesses and print `"Too high"` / `"Too low"` until correct, then print the number of tries
- [ ] Find how many years it takes ₹10,000 at 8% yearly interest to reach ₹20,000
- [ ] Write a `while` loop that runs 0 times and a `do-while` that runs once with the same condition
- [ ] Write a simple menu with `while (true)` that exits when the user types `0`

## Doubts / Questions
-
