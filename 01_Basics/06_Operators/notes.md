# Operators

> Module: Basics

## What is it?

- An **operator** is a symbol that does something with values: `+` adds, `>` compares, `&&` combines true/false.
- The values an operator works on are called **operands**. In `5 + 3`, `5` and `3` are operands.
- Main groups:
  - **Arithmetic**: math (`+ - * / %`)
  - **Assignment**: store or update a value (`= += -=` ...)
  - **Increment / Decrement**: add or subtract 1 (`++ --`)
  - **Comparison**: compare values, result is `Boolean` (`== != > < >= <=`)
  - **Logical**: combine `Boolean`s (`&& || !`)

## Syntax / Example

### 1. Arithmetic operators
```kotlin
val a = 10
val b = 3

println(a + b)   // 13  add
println(a - b)   // 7   subtract
println(a * b)   // 30  multiply
println(a / b)   // 3   divide (Int / Int → whole number only!)
println(a % b)   // 1   remainder (10 ÷ 3 = 3, remainder 1)
```

### Division: Int vs Double
```kotlin
println(10 / 3)       // 3        both Int → decimal part is dropped
println(10.0 / 3)     // 3.3333333333333335  one is Double → Double result
println(10 / 3.0)     // 3.3333333333333335
println(10.toDouble() / 3)  // 3.3333333333333335 (recap: Lesson 5)
```
- If **both** sides are `Int`, the result is `Int`, and the decimal part is cut off.
- If **either** side is `Double`, the result is `Double`.

### Remainder `%` uses
```kotlin
println(10 % 2)   // 0 → 10 is even
println(7 % 2)    // 1 → 7 is odd
println(25 % 10)  // 5 → last digit of 25
```

### 2. Assignment operators
```kotlin
var x = 10      // =  store a value

x += 5          // x = x + 5  → 15
x -= 3          // x = x - 3  → 12
x *= 2          // x = x * 2  → 24
x /= 4          // x = x / 4  → 6
x %= 4          // x = x % 4  → 2
```
- These only work on `var` (they change the value).

### 3. Increment and decrement
```kotlin
var count = 5
count++         // add 1 → 6
count--         // subtract 1 → 5
```

**Before or after: `++x` vs `x++`**
```kotlin
var a = 5
println(a++)    // 5  → prints FIRST, then adds 1
println(a)      // 6

var b = 5
println(++b)    // 6  → adds 1 FIRST, then prints
println(b)      // 6
```
- `x++` (postfix): use the old value, then add 1.
- `++x` (prefix): add 1, then use the new value.
- On its own line (`count++`), both do the same thing.

### 4. Comparison operators (result is always `Boolean`)
```kotlin
val a = 10
val b = 20

println(a == b)   // false  equal to
println(a != b)   // true   not equal to
println(a > b)    // false  greater than
println(a < b)    // true   less than
println(a >= 10)  // true   greater than or equal to
println(a <= 5)   // false  less than or equal to

val isEqual: Boolean = a == b   // store the result
```

**Comparing text**
```kotlin
println("kotlin" == "kotlin")   // true
println("Kotlin" == "kotlin")   // false (capital K is different)
```

### 5. Logical operators (work on `Boolean`)
```kotlin
val age = 25
val hasTicket = true

println(age >= 18 && hasTicket)   // true  AND: both must be true
println(age < 18 || hasTicket)    // true  OR: at least one must be true
println(!hasTicket)               // false NOT: flips true ↔ false
```

| A | B | `A && B` | `A \|\| B` |
|---|---|---|---|
| true | true | true | true |
| true | false | false | true |
| false | true | false | true |
| false | false | false | false |

**Short-circuit: Kotlin stops early**
- `&&`: if the left side is `false`, the right side is **not checked** (result is already `false`).
- `||`: if the left side is `true`, the right side is **not checked** (result is already `true`).

### `==` vs `===`
```kotlin
val a = "hello"
val b = "hello"
println(a == b)    // true → same VALUE
```
- `==` checks if two values are **equal**. **Use this almost always.**
- `===` checks if two variables point to the **exact same object** in memory. You'll need it rarely; it makes more sense after Classes and Objects.

### `+` with text (recap from Lesson 3)
```kotlin
println("Age: " + 25)    // Age: 25 → text on the LEFT, number becomes text
println(25 + " years")   // ❌ ERROR → number on the left can't add text
println(25.toString() + " years")  // ✅ 25 years
```

### Order of operations (precedence)
```kotlin
println(2 + 3 * 4)     // 14  → * before +
println((2 + 3) * 4)   // 20  → brackets first
println(10 - 4 - 3)    // 3   → same level: left to right
```
Order, highest first:
1. `( )` brackets
2. `++` `--` `!` (on one value)
3. `*` `/` `%`
4. `+` `-`
5. `>` `<` `>=` `<=`
6. `==` `!=`
7. `&&`
8. `||`
9. `=` `+=` `-=` ... (assignment, last)

**Tip:** when unsure, use brackets. They also make code easier to read.

## Key Points
- `/` with two `Int`s gives a whole number: `10 / 3` is `3`. Make one side `Double` for decimals.
- `%` gives the remainder. `x % 2 == 0` means `x` is even.
- `+=`, `-=`, `*=`, `/=`, `%=` are short forms of `x = x + ...`. They need `var`.
- `x++` uses the old value then adds 1; `++x` adds 1 first.
- Comparison operators always give `true` or `false`.
- `&&` = both true. `||` = at least one true. `!` = flip.
- Use `==` to compare values (numbers and text).
- `*` `/` `%` happen before `+` `-`. Use brackets to be clear.

## Common Mistakes / Gotchas
- Expecting a decimal from `Int / Int`: `5 / 2` is `2`, not `2.5`. Write `5.0 / 2`.
- Dividing an `Int` by zero: `10 / 0` → program **crashes** with `ArithmeticException`.
- Dividing a `Double` by zero doesn't crash: `10.0 / 0` gives `Infinity`.
- Using `=` instead of `==` to compare: `=` stores a value, `==` compares.
- `%` with negative numbers keeps the left side's sign: `-7 % 3` is `-1`, not `2`.
- `++`, `--`, `+=` on a `val` → error. They change the value, so use `var`.
- Comparing different number types: `10 == 10L` → error. Convert first (`10.toLong() == 10L`).
- `25 + " years"` → error. The text must be on the left, or convert the number with `toString()`.

## Practice Done
- [ ] Print the result of all 5 arithmetic operators on `17` and `5`
- [ ] Print `7 / 2` and `7.0 / 2`. Explain the difference.
- [ ] Use `%` to check if `42` and `37` are even (print `true`/`false`)
- [ ] Start with `var score = 100` and use `+=`, `-=`, `*=`, `/=`, printing after each
- [ ] Print `a++` and `++b` (both starting at 5) and explain the outputs
- [ ] With `val age = 20` and `val hasId = false`, print `age >= 18 && hasId` and `age >= 18 || hasId`
- [ ] Print `2 + 3 * 4` and `(2 + 3) * 4`
- [ ] Try `10 / 0` and read the crash, then try `10.0 / 0`

## Doubts / Questions
-
