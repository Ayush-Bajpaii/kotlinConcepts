# Strings and Templates

> Module: Basics

## What is it?

- A **String** is text: a sequence of characters inside double quotes, like `"Hello"`.
- A single character uses single quotes and is a `Char`: `'H'`. `"H"` is a String, `'H'` is a Char.
- Strings are **immutable**: once made, they can't be changed. Functions like `uppercase()` give you a **new** String.
- A **string template** lets you put a variable or expression directly inside text using `$`.

## Syntax / Example

### 1. Creating strings
```kotlin
val name = "Ayush"
val empty = ""
val greeting: String = "Hello, Kotlin"
```

### 2. String templates: `$` and `${ }`
```kotlin
val name = "Ayush"
val age = 25

println("My name is $name")              // My name is Ayush
println("Next year I'll be ${age + 1}")  // Next year I'll be 26
println("Name has ${name.length} letters") // Name has 5 letters
```
- `$name` puts in the value of a **simple variable**.
- `${ ... }` runs an **expression** (math, a function call, a property) and puts in the result.

**Template vs `+`**
```kotlin
println("Age: " + age)   // works, but harder to read
println("Age: $age")     // ✅ preferred in Kotlin
```

### 3. Escape characters (special characters inside `" "`)
```kotlin
println("Line 1\nLine 2")       // \n  new line
println("Name:\tAyush")         // \t  tab
println("He said \"Hi\"")       // \"  double quote inside text
println("C:\\Users\\ayush")     // \\  a backslash
println("Price: \$10")          // \$  a real dollar sign
```

### 4. Raw strings: `""" """`
```kotlin
val poem = """
    Roses are red,
    Kotlin is neat,
    No \n needed here.
""".trimIndent()

println(poem)
```
- Text between `"""` is printed **as written**, including new lines.
- Escapes like `\n` do **not** work inside raw strings. Templates (`$name`) still work.
- `trimIndent()` removes the common spaces at the start of each line.

### 5. Common properties and functions
```kotlin
val text = "Hello Kotlin"

println(text.length)              // 12
println(text.uppercase())         // HELLO KOTLIN
println(text.lowercase())         // hello kotlin
println(text[0])                  // H  (index starts at 0, gives a Char)
println(text.first())             // H
println(text.last())              // n
println(text.contains("Kot"))     // true
println(text.startsWith("Hello")) // true
println(text.endsWith("lin"))     // true
println(text.indexOf("K"))        // 6
println(text.substring(0, 5))     // Hello  (from 0 up to, NOT including, 5)
println(text.replace("Hello", "Hi")) // Hi Kotlin
println(text.split(" "))          // [Hello, Kotlin]
println("  spaces  ".trim())      // spaces
println(text.reversed())          // niltoK olleH
println("ha".repeat(3))           // hahaha
println("".isEmpty())             // true
println("   ".isBlank())          // true (only spaces counts as blank)
```

### 6. Comparing strings
```kotlin
println("kotlin" == "kotlin")                        // true
println("Kotlin" == "kotlin")                        // false
println("Kotlin".equals("kotlin", ignoreCase = true)) // true
```
- Use `==` to compare text (recap: Lesson 6).

### 7. Strings and numbers (recap: Lesson 5)
```kotlin
val num = "42".toInt()          // String → Int
val bad = "abc".toIntOrNull()   // null (doesn't crash)
val text = 42.toString()        // Int → String
```

### 8. Building a string piece by piece
```kotlin
val sb = StringBuilder()
sb.append("Hello")
sb.append(", ")
sb.append("World")
println(sb.toString())          // Hello, World

val result = buildString {
    append("Kotlin ")
    append("is fun")
}
println(result)                 // Kotlin is fun
```
- Use these when joining **many** pieces (for example, inside a loop). Each `+` on a String makes a new String.

## Key Points
- Strings use `" "`, Chars use `' '`.
- `$variable` for simple values, `${expression}` for anything more.
- Strings can't be changed. Functions return a **new** String; save it if you need it.
- `text[i]` gives a `Char`, and index starts at `0`.
- `substring(start, end)`: `end` is **not** included.
- `"""raw strings"""` keep new lines; use `trimIndent()` to clean the indentation.
- Use `\$` for a real dollar sign in a normal string.

## Common Mistakes / Gotchas
- `"$name.length"` prints `Ayush.length`. Only the variable is picked up. Write `"${name.length}"`.
- Calling `text.uppercase()` and expecting `text` to change. It doesn't; use `val upper = text.uppercase()`.
- `text[20]` on a short string → **crash** (`StringIndexOutOfBoundsException`).
- Mixing up `'A'` (Char) and `"A"` (String): `'A' == "A"` → error.
- `"abc".toInt()` → **crash** (`NumberFormatException`). Use `toIntOrNull()` when unsure.
- `\n` inside `""" """` prints as `\n`, not a new line.
- `isEmpty()` vs `isBlank()`: `"  "` is **not** empty but **is** blank.

## Practice Done
- [ ] Make `val name` and `val city`, then print `"I am <name> from <city>"` using a template
- [ ] Print `"5 + 3 = 8"` where `8` is calculated inside `${ }`
- [ ] Print your name's length, its first letter and its last letter
- [ ] Print `"Kotlin"` in uppercase, lowercase and reversed
- [ ] Use `substring` to get `"World"` from `"Hello World"`
- [ ] Print a message with a quote inside it: `She said "Kotlin is great"`
- [ ] Write a 3-line address using a raw string with `trimIndent()`
- [ ] Check if `"racecar"` is a palindrome: compare it with `reversed()`
- [ ] Count how many times `'a'` appears in `"banana"` (hint: `count { it == 'a' }`)
- [ ] Try `"$name.length"` and `"${name.length}"` and explain the difference

## Doubts / Questions
-
