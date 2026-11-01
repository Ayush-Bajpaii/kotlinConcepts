# Varargs

> Module: Functions

## What is it?

- `vararg` lets a function accept **any number of arguments** of the same type: zero, one, or many.
- Inside the function, the vararg parameter is an **array** you can loop over.
- You've already used vararg functions: `listOf(1, 2, 3)`, `arrayOf(...)`, `setOf(...)`, `maxOf(...)`.

## Syntax / Example

### 1. Declaring a vararg
```kotlin
fun sum(vararg numbers: Int): Int {
    var total = 0
    for (n in numbers) {
        total += n
    }
    return total
}

println(sum())                // 0
println(sum(5))               // 5
println(sum(1, 2, 3, 4, 5))   // 15
```
- Write `vararg` before the parameter name.
- Calling with **no** arguments is allowed: the array is just empty.

### 2. It's an array inside the function
```kotlin
fun describe(vararg words: String) {
    println("Count: ${words.size}")
    println("First: ${words[0]}")
    for ((i, w) in words.withIndex()) {
        println("$i → $w")
    }
}

describe("Kotlin", "is", "fun")
```
- `vararg words: String` → `words` is `Array<String>`.
- `vararg numbers: Int` → `numbers` is `IntArray` (a special array for primitive types).
- You get `.size`, indexing `[i]`, `for` loops, and functions like `.sum()`, `.max()`.

### 3. Shorter with array functions
```kotlin
fun sum(vararg numbers: Int) = numbers.sum()
fun average(vararg numbers: Double) = if (numbers.isEmpty()) 0.0 else numbers.average()
```
- Arrays and their functions are covered fully in Collections.

### 4. Vararg with normal parameters
```kotlin
fun printAll(title: String, vararg items: String) {
    println("== $title ==")
    for (item in items) println("- $item")
}

printAll("Fruits", "Apple", "Banana", "Mango")
```
- The first argument goes to `title`, the rest go into `items`.
- Best practice: put the **vararg last**.

### 5. Vararg not last → later parameters must be named
```kotlin
fun joinWith(vararg words: String, separator: String) =
    words.joinToString(separator)

joinWith("a", "b", "c", separator = "-")   // a-b-c
joinWith("a", "b", "c", "-")               // ❌ ERROR: "-" is taken as a word, separator missing
```

### 6. Spread operator `*`: passing an existing array
```kotlin
val nums = intArrayOf(10, 20, 30)

sum(nums)       // ❌ ERROR: type mismatch, expected Int, found IntArray
sum(*nums)      // ✅ 60
```
- `*` **spreads** the array into separate arguments.
- It only exists at the **call site**, and only for vararg parameters.

### 7. Mixing spread and single values
```kotlin
val more = intArrayOf(3, 4)
println(sum(1, 2, *more, 5))   // 15
```

### 8. Passing a List
```kotlin
val list = listOf(1, 2, 3)
sum(*list.toIntArray())        // 6

val names = listOf("A", "B")
describe(*names.toTypedArray())
```
- `*` works on **arrays only**. Convert a `List` first.

### 9. Vararg with defaults and named arguments
```kotlin
fun log(vararg messages: String, level: String = "INFO") {
    for (m in messages) println("[$level] $m")
}

log("Started", "Loading data")                  // [INFO] ...
log("Disk full", level = "ERROR")               // [ERROR] Disk full
```

### 10. Only one vararg per function
```kotlin
fun bad(vararg a: Int, vararg b: Int) { }   // ❌ ERROR: multiple vararg parameters are prohibited
```

## Key Points
- `vararg name: Type` accepts 0 or more arguments.
- Inside: `Array<Type>`, or a primitive array like `IntArray` for `Int`, `Double`, etc.
- Put the vararg **last**. Otherwise the parameters after it must be passed by name.
- Use the spread operator `*array` to pass an existing array. Convert lists with `toIntArray()` / `toTypedArray()` first.
- Only **one** vararg per function.
- Handle the empty case (`size == 0`) when it matters, e.g. average or max.

## Common Mistakes / Gotchas
- Passing an array without `*` → type mismatch.
- Using `*` on a `List` → error. Convert to an array first.
- Accessing `items[0]` when nothing was passed → crash (`ArrayIndexOutOfBoundsException`).
- `numbers.max()` on an empty array → crash (`NoSuchElementException`).
- Expecting `vararg n: Int` to be `Array<Int>`. It's `IntArray`.
- Spreading **copies** the array. Changing the vararg array inside the function doesn't change the caller's array.

## Practice Done
- [ ] Write `sum(vararg numbers: Int): Int` with a `for` loop and test it with 0, 1 and 5 arguments
- [ ] Write `average(vararg numbers: Double): Double` that returns `0.0` when empty
- [ ] Write `maxOfAll(vararg numbers: Int): Int` without using `.max()`
- [ ] Write `printAll(title: String, vararg items: String)`
- [ ] Write `joinWith(vararg words: String, separator: String)` and call it with a named `separator`
- [ ] Pass an existing `intArrayOf(...)` to `sum` with and without `*` and read the error
- [ ] Call `sum(1, 2, *intArrayOf(3, 4), 5)`
- [ ] Pass a `List<Int>` to `sum` using `toIntArray()`
- [ ] Write `countVowels(vararg words: String)` that counts vowels across all words

## Doubts / Questions
-
