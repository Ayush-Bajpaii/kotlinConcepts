# Infix Functions

> Module: Functions

## What is it?

- An **infix function** can be called **without the dot and parentheses**: `a fn b` instead of `a.fn(b)`.
- It makes some calls read like plain English.
- You've already used built-in ones: `1 to "one"`, `1 until 5`, `10 downTo 1`, `1..10 step 2`.
- You mark a function with the `infix` keyword to allow this.

## Syntax / Example

### 1. Built-in infix functions you already know
```kotlin
val pair = 1 to "one"                 // same as 1.to("one")
for (i in 0 until 5) print(i)         // same as 0.until(5)
for (i in 10 downTo 0 step 2) print(i)

val flags = 0b1010 and 0b0110         // bitwise AND → 0b0010
val shifted = 1 shl 3                 // 8
val both = true and false             // false (no short-circuit, unlike &&)
```
- `to`, `until`, `downTo`, `step`, `and`, `or`, `xor`, `shl`, `shr` are all infix functions.

### 2. Normal call vs infix call
```kotlin
val p1 = 1.to("one")   // normal call
val p2 = 1 to "one"    // infix call → same result
```

### 3. The rules
A function can be `infix` only if it:
1. is a **member function** (inside a class) **or** an **extension function**,
2. has **exactly one** parameter,
3. that parameter is **not** `vararg` and has **no default value**.

```kotlin
infix fun add(a: Int, b: Int) = a + b   // ❌ ERROR: not a member/extension, and 2 parameters
```

### 4. Writing your own (extension function)
```kotlin
infix fun Int.times(text: String) = text.repeat(this)

println(3 times "Hi ")    // Hi Hi Hi
println(3.times("Hi "))   // also works
```
- `Int.` before the name makes this an **extension function** on `Int`: it can be called on any `Int`.
- Inside, `this` is the value on the **left** (`3`), the parameter is the value on the **right** (`"Hi "`).
- Extension functions are covered fully in Functional Programming.

### 5. More examples
```kotlin
infix fun String.repeatTimes(n: Int) = this.repeat(n)
infix fun Int.isMultipleOf(other: Int) = this % other == 0
infix fun String.shouldBe(expected: String) {
    if (this == expected) println("✅ pass") else println("❌ expected $expected but was $this")
}

println("ab" repeatTimes 3)    // ababab
println(15 isMultipleOf 5)     // true
"Kotlin".uppercase() shouldBe "KOTLIN"   // ✅ pass
```
- `shouldBe` style is how many testing libraries read: `result shouldBe 42`.

### 6. Member infix function (preview of classes)
```kotlin
class Point(val x: Int, val y: Int) {
    infix fun plus(other: Point) = Point(x + other.x, y + other.y)
}

val p = Point(1, 2) plus Point(3, 4)
println("${p.x}, ${p.y}")   // 4, 6
```
- Classes are covered in OOP.

### 7. Inside a class, `this` is required
```kotlin
class Bag {
    private val items = mutableListOf<String>()

    infix fun add(item: String) { items.add(item) }

    fun fill() {
        this add "Pen"   // ✅
        add("Book")      // ✅ normal call
        // add "Book"    // ❌ ERROR: infix needs a left side
    }
}
```
- An infix call always needs **both** sides.

### 8. Precedence
```kotlin
println(1 shl 2 + 1)      // 1 shl 3 = 8   (+ runs first)
println(1..10 step 3)     // 1..10 is built first, then step

val ok = 2 isMultipleOf 2 && 4 isMultipleOf 2   // infix runs before &&
```
- Infix calls run **after** arithmetic (`* / + -`) and ranges (`..`), but **before** comparisons (`<`, `==`) and `&&` / `||`.
- When in doubt, add parentheses: `(1 shl 2) + 1`.

### 9. Destructuring a pair made with `to`
```kotlin
val (code, name) = 91 to "India"
println("$code = $name")   // 91 = India

val countryCodes = mapOf(91 to "India", 1 to "USA")
```
- `to` creates a `Pair`. This is why maps are written with `to`.

## Key Points
- `infix fun` lets you call `a fn b` instead of `a.fn(b)`.
- Must be a member or extension function, with exactly one parameter, no vararg, no default.
- Left side = the receiver (`this`), right side = the parameter.
- Built-in infix functions: `to`, `until`, `downTo`, `step`, `and`, `or`, `xor`, `shl`, `shr`.
- Infix calls are lower than arithmetic and higher than comparison and boolean operators.
- Use infix only when it reads naturally. Normal calls are still fine.

## Common Mistakes / Gotchas
- Forgetting `infix`: `3 times "Hi"` on a normal function → error ("'infix' modifier is required").
- Trying to make a top-level function with 2 parameters infix. It needs a receiver instead.
- Infix with a default parameter or vararg → error.
- Precedence surprises: `1 shl 2 + 1` is `8`, not `5`.
- Using `and` / `or` instead of `&&` / `||` for Boolean logic: they always evaluate **both** sides.
- Overusing infix: `user process order` is cute but unclear. Prefer clear names.

## Practice Done
- [ ] Rewrite `1.to("one")`, `0.until(5)` and `10.downTo(1)` as infix calls and back
- [ ] Write `infix fun Int.times(text: String)` and print `3 times "Hi "`
- [ ] Write `infix fun Int.isMultipleOf(other: Int): Boolean` and test it in a `for` loop
- [ ] Write `infix fun String.shouldBe(expected: String)` and use it to check 3 of your earlier functions
- [ ] Write `infix fun Int.pow(exp: Int): Int` using a loop
- [ ] Create a pair with `to` and destructure it into two variables
- [ ] Remove `infix` from one of your functions and read the error
- [ ] Predict `1 shl 2 + 1` before running it, then check

## Doubts / Questions
-
