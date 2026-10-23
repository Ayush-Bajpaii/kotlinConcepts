# Type Conversion

> Module: Basics

## What is it?

- **Type conversion** means changing a value from one type to another, like `Int` to `Double`, or `String` to `Int`.
- Kotlin **never converts types by itself**. You must convert using functions like `toInt()`, `toDouble()`, `toString()`.
- Conversion gives a **new value**. The original variable stays the same.

## Syntax / Example

### Recap: no automatic conversion (from Lesson 4)
```kotlin
val a: Int = 10
val b: Long = a          // ❌ ERROR: Type mismatch
val b: Long = a.toLong() // ✅ convert first
```

### Number to number
```kotlin
val num: Int = 10

val l: Long = num.toLong()       // 10
val d: Double = num.toDouble()   // 10.0
val f: Float = num.toFloat()     // 10.0
val s: Short = num.toShort()     // 10
val by: Byte = num.toByte()      // 10
```

### Decimal to whole number: cuts, doesn't round
```kotlin
val price = 9.99
println(price.toInt())    // 9   (decimal part is removed, NOT rounded to 10)

val neg = -9.99
println(neg.toInt())      // -9
```

### Number to String
```kotlin
val age = 25
val text: String = age.toString()   // "25"
println(text + "5")                 // 255 (joins text)
```

### String to number
```kotlin
val input = "25"
val n: Int = input.toInt()          // 25
println(n + 5)                      // 30 (math)

val p: Double = "99.5".toDouble()   // 99.5
val big: Long = "9000000000".toLong()
```

### String to Boolean
```kotlin
println("true".toBoolean())    // true
println("TRUE".toBoolean())    // true  (capital letters are fine)
println("yes".toBoolean())     // false (anything other than "true" is false)
```

### Char and numbers
```kotlin
val letter = 'A'
println(letter.code)            // 65   (every character has a number code)
println(Char(66))               // B    (number code → character)

val digit = '7'
println(digit.digitToInt())     // 7    (the digit's value)
println(digit.code)             // 55   (the character's code, NOT 7)
```

### Mixing types in math
```kotlin
val x = 5          // Int
val y = 2.5        // Double
val result = x + y // Double → 7.5
```
- When you add an `Int` and a `Double`, the result is `Double`. Kotlin picks the type that doesn't lose the decimal.
- This only works inside math. Storing an `Int` into a `Double` variable still needs `toDouble()`.

## Key Points
- Kotlin does not convert types automatically. Use `toInt()`, `toLong()`, `toDouble()`, `toFloat()`, `toString()`, etc.
- Conversion returns a new value; the original doesn't change.
- `Double` → `Int` **cuts off** the decimal: `9.99.toInt()` is `9`.
- Any value can become text with `toString()`.
- Text becomes a number only if it really is a number: `"25".toInt()` works, `"abc".toInt()` crashes.
- `'A'.code` gives the character's number (65). `'7'.digitToInt()` gives the digit's value (7).
- `Int + Double` in math gives a `Double`.

## Common Mistakes / Gotchas
- Assigning without converting: `val d: Double = num` → error "Type mismatch". Use `num.toDouble()`.
- Expecting rounding: `2.9.toInt()` is `2`, not `3`.
- Converting text that isn't a number: `"abc".toInt()` → the program **crashes** with `NumberFormatException`. Same for `"12.5".toInt()` (it's a decimal) and `" 25"` (has a space).
- Big number into a small type: `3000000000L.toInt()` gives a wrong negative number (overflow), with no error.
- Mixing up `'7'.code` (55) and `'7'.digitToInt()` (7).
- Thinking conversion changes the variable: after `num.toDouble()`, `num` is still `Int`.

## Practice Done
- [ ] Convert an `Int` to `Long`, `Double`, `Float`, and `String`, and print each
- [ ] Print `9.99.toInt()` and `-9.99.toInt()`. Notice it cuts, not rounds.
- [ ] Convert `"150"` to `Int` and add `50` to it
- [ ] Try `"abc".toInt()` and read the crash message
- [ ] Print `'A'.code`, `Char(97)`, and `'5'.digitToInt()`
- [ ] Add an `Int` and a `Double` and check the result's type with Ctrl + Shift + P

## Doubts / Questions
-
