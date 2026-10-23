# Type Inference

> Module: Basics

## What is it?

- **Type inference** means Kotlin **figures out the type by itself** from the value you give.
- So you don't always need to write the type.
- The type is still fixed. Kotlin just writes it for you.

```kotlin
val age = 25          // Kotlin sees 25 → type is Int
val age: Int = 25     // same thing, type written by you
```

## Syntax / Example

### How Kotlin decides the type
```kotlin
val a = 10            // Int     (whole number)
val b = 10L           // Long    (ends with L)
val c = 3000000000    // Long    (too big for Int, so Kotlin picks Long)
val d = 10.5          // Double  (decimal)
val e = 10.5f         // Float   (ends with f)
val f = true          // Boolean
val g = 'A'           // Char    (single quotes)
val h = "Hello"       // String  (double quotes)
```

### Recap: the type never changes (from Lesson 2 and 3)
```kotlin
var count = 10        // Int
count = 20            // ✅ still Int
count = "twenty"      // ❌ ERROR: Type mismatch (count is Int)
count = 5.5           // ❌ ERROR: Type mismatch (5.5 is Double)
```

### When you MUST write the type

**1. No value yet**
```kotlin
val total: Int        // no value → Kotlin can't guess, so type is required
total = 100
```

**2. You want a different type than Kotlin's default**
```kotlin
val small: Byte = 10       // without ": Byte", Kotlin would pick Int
val big: Long = 10         // without ": Long", Kotlin would pick Int
```

### When writing the type is helpful (optional)
- When the value doesn't make the type obvious to someone reading the code.
- When you want to be sure you get the type you expect.

### See the type Kotlin picked (IntelliJ)
- Click on the variable name and press **Ctrl + Shift + P**: IntelliJ shows its type.
- Or hover the mouse over the variable name.

## Key Points
- Kotlin guesses the type from the value. This is type inference.
- Whole number → `Int`. Too big for Int → `Long`. Ends with `L` → `Long`.
- Decimal → `Double`. Ends with `f` → `Float`.
- `'A'` → `Char`. `"A"` → `String`. `true`/`false` → `Boolean`.
- Type is decided **once**, when the variable is created, and never changes.
- Write the type yourself when there's no value yet, or when you want a non-default type.
- Kotlin is **statically typed**: types are checked before the program runs, so type mistakes show up as errors in IntelliJ right away.

## Common Mistakes / Gotchas
- Thinking "no type written" means "any type". It doesn't: `var x = 5` is `Int` forever.
- Declaring without type and without value: `val total` → error "This variable must either have a type annotation or be initialized".
- Whole number into Double: `val d: Double = 5` → error "Type mismatch". Write `5.0`.
- Decimal into Float without `f`: `val w: Float = 2.5` → error. Write `2.5f`.
- Expecting a decimal to become Int: `val n: Int = 5.0` → error. `5.0` is Double.

## Practice Done
- [ ] Create 8 variables without writing types (one for each type in the example) and check each type with Ctrl + Shift + P
- [ ] Create `val c = 3000000000` and check: is it Int or Long?
- [ ] Try `val d: Double = 5` and read the error, then fix it
- [ ] Try `val total` (no type, no value) and read the error
- [ ] Create `var x = 10`, then try `x = 2.5`. Why the error?

## Doubts / Questions
-
