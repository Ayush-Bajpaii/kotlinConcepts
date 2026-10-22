# Data Types

> Module: Basics

## What is it?

- A **data type** tells Kotlin **what kind of value** a variable holds: a number, text, true/false, etc.
- The type decides **what you can do** with the value. You can do math with numbers, but not with text.
- Every variable in Kotlin has a type, and it **never changes**.

## Syntax / Example

### The main types
| Type | Holds | Example |
|---|---|---|
| `Int` | whole numbers | `val age: Int = 25` |
| `Long` | very big whole numbers | `val population: Long = 8_000_000_000L` |
| `Double` | decimal numbers | `val price: Double = 99.5` |
| `Float` | decimal numbers (less precise) | `val weight: Float = 60.5f` |
| `Boolean` | `true` or `false` | `val isLoggedIn: Boolean = true` |
| `Char` | one single character | `val grade: Char = 'A'` |
| `String` | text (many characters) | `val name: String = "Ayush"` |

### Whole numbers
```kotlin
val small: Byte = 100             // -128 to 127
val medium: Short = 30000         // about -32 thousand to 32 thousand
val normal: Int = 2_000_000       // about -2.1 billion to 2.1 billion (most used)
val big: Long = 9_000_000_000L    // much bigger; ends with L
```
- Use **`Int`** for normal whole numbers.
- Use **`Long`** when the number may be bigger than about 2.1 billion.
- `Byte` and `Short` are rarely used.
- `_` in numbers is only for easy reading: `1_000_000` is the same as `1000000`.

### Decimal numbers
```kotlin
val pi: Double = 3.14159       // default for decimals
val height: Float = 5.9f       // ends with f
```
- Use **`Double`** for decimals. It is the default and more precise.
- `Float` must end with `f`.

### Boolean
```kotlin
val isAdult: Boolean = true
val hasPaid: Boolean = false
println(10 > 5)                // true
```
- Only two values: `true` or `false`.
- Used for yes/no decisions (more in Control Flow).

### Char vs String
```kotlin
val letter: Char = 'K'           // single quotes, exactly ONE character
val word: String = "Kotlin"      // double quotes, any length
val empty: String = ""           // empty text is fine
```

### Kotlin picks the type for you
```kotlin
val a = 10           // Int
val b = 10L          // Long
val c = 10.0         // Double
val d = 10.0f        // Float
val e = true         // Boolean
val f = 'X'          // Char
val g = "Hi"         // String
```

### Same-looking values, different types
```kotlin
val x = 25       // Int    → 25 + 5 = 30 (math)
val y = "25"     // String → "25" + "5" = "255" (joins text)
```

### Check limits
```kotlin
println(Int.MAX_VALUE)    // 2147483647
println(Int.MIN_VALUE)    // -2147483648
println(Long.MAX_VALUE)   // 9223372036854775807
```

## Key Points
- Most used: `Int`, `Double`, `Boolean`, `String`.
- Whole numbers → `Int`. Decimals → `Double`.
- `Long` ends with `L`. `Float` ends with `f`.
- `Char` uses single quotes `'A'`. `String` uses double quotes `"A"`.
- Kotlin guesses the type from the value, so writing the type is optional.
- A number in quotes (`"25"`) is text, not a number.
- In Kotlin, all types start with a capital letter: `Int`, not `int`.

## Common Mistakes / Gotchas
- Text in a number variable: `val age: Int = "25"` → error "Type mismatch".
- Two characters in a Char: `val c: Char = 'AB'` → error. Use a String.
- Double quotes for Char: `val c: Char = "A"` → error. Use `'A'`.
- Missing `f`: `val w: Float = 60.5` → error. Write `60.5f`.
- Number too big for Int: `val n: Int = 3000000000` → error. Use `Long`: `3000000000L`.
- Going past the limit: `Int.MAX_VALUE + 1` gives a **negative number** (`-2147483648`), with no error. This is called **overflow**.
- Decimal math is not always exact: `0.1 + 0.2` prints `0.30000000000000004`.
- Lowercase types like `int` or `string` don't exist in Kotlin.

## Practice Done
- [ ] Make one variable of each type (`Int`, `Long`, `Double`, `Float`, `Boolean`, `Char`, `String`) and print them all
- [ ] Write the type yourself for each one (like `val age: Int = 25`)
- [ ] Print `25 + 5` and `"25" + "5"`. Explain the difference.
- [ ] Print `Int.MAX_VALUE` and then `Int.MAX_VALUE + 1`. What happened?
- [ ] Print `0.1 + 0.2`. Is it exactly `0.3`?
- [ ] Try `val c: Char = 'AB'` and read the error

## Doubts / Questions
-
