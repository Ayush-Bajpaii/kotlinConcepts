# Top Level vs Member Functions

> Module: Functions

## What is it?

- A **top-level function** is declared directly in a file, **outside any class**. Everything you've written so far (`main`, `add`, `greet`) is top-level.
- A **member function** is declared **inside a class** and is called **on an object** of that class: `user.greet()`.
- Java needs every function inside a class. Kotlin doesn't, so you choose based on whether the function **belongs to an object** or not.
- Kotlin has four places for functions: **top-level**, **member**, **local** (recap: Local Functions), and **extension** (covered in Functional Programming).

## Syntax / Example

### 1. Top-level function
```kotlin
// File: MathUtils.kt
fun square(n: Int) = n * n

fun main() {
    println(square(5))   // 25 → called directly, no object needed
}
```

### 2. Member function (preview of classes)
```kotlin
class User(val name: String, var age: Int) {

    fun greet() {
        println("Hi, I'm $name")
    }

    fun haveBirthday() {
        age++                // member functions can read/change the object's properties
    }
}

fun main() {
    val user = User("Ayush", 25)
    user.greet()             // Hi, I'm Ayush
    user.haveBirthday()
    println(user.age)        // 26
}
```
- Called with a **dot** on an object: `user.greet()`.
- Inside, `name` and `age` mean **this object's** values.
- Classes, constructors and properties are covered fully in OOP.

### 3. `this` inside a member function
```kotlin
class Counter(var count: Int) {
    fun add(count: Int) {
        this.count += count   // this.count = property, count = parameter
    }
}
```
- `this` = the object the function was called on.
- Needed only when a parameter has the **same name** as a property.

### 4. Same name, different places
```kotlin
fun describe() = "top-level describe"

class Car(val model: String) {
    fun describe() = "Car: $model"
}

fun main() {
    println(describe())               // top-level describe
    println(Car("Swift").describe())  // Car: Swift
}
```
- No clash: one is called alone, the other on an object.

### 5. Top-level functions in other files
```kotlin
// File: utils/StringUtils.kt
package utils

fun capitalizeWords(text: String) =
    text.split(" ").joinToString(" ") { word -> word.replaceFirstChar { it.uppercaseChar() } }
```
```kotlin
// File: Main.kt
import utils.capitalizeWords

fun main() {
    println(capitalizeWords("kotlin is fun"))   // Kotlin Is Fun
}
```
- Same package → no import needed. Different package → `import package.functionName`.

### 6. `private` top-level functions
```kotlin
// File: Report.kt
private fun formatLine(text: String) = "| $text |"

fun printReport() {
    println(formatLine("Sales"))
}
```
- `private` at top level = visible **only in this file**. Good for file-specific helpers.
- Visibility modifiers are covered in OOP.

### 7. How the JVM sees top-level functions
- The JVM only understands classes. Kotlin puts top-level functions in a hidden class named after the file:
  - `MathUtils.kt` → class `MathUtilsKt` with a `static` method `square`.
- From Java: `MathUtilsKt.square(5)`.
- Rename that class with this line at the very top of the file:
  ```kotlin
  @file:JvmName("MathUtils")
  ```

### 8. Which one to use?
| Use a **top-level** function when... | Use a **member** function when... |
|---|---|
| it doesn't need any object's data | it reads or changes an object's properties |
| it's a general helper (`square`, `formatDate`) | it describes what the object **does** (`user.login()`) |
| Java would put it in a `Utils` class with `static` methods | it's part of the object's behavior |

- Kotlin style: **don't** create `object Utils { fun ... }` classes just to hold functions. Use top-level functions.

### 9. All four kinds together (preview)
```kotlin
fun topLevel() = "top-level"                     // top-level

class Shop {
    fun member() = "member"                      // member
}

fun String.shout() = this.uppercase() + "!"      // extension (Functional Programming)

fun main() {
    fun local() = "local"                        // local

    println(topLevel())
    println(Shop().member())
    println("hello".shout())
    println(local())
}
```

## Key Points
- Top-level = in a file, outside classes. Call directly: `square(5)`.
- Member = inside a class. Call on an object: `user.greet()`.
- Member functions can use the object's properties and `this`.
- Top-level functions in another package need an `import`.
- `private` top-level functions are visible only in their file.
- On the JVM, top-level functions become `static` methods in a `FileNameKt` class.
- Prefer top-level functions over Java-style `Utils` classes.

## Common Mistakes / Gotchas
- Calling a member function without an object: `greet()` outside the class → "Unresolved reference".
- Calling a top-level function on an object: `user.square(5)` → error (unless it's an extension function).
- Two top-level functions with the **same name and parameters** in the **same package** (even in different files) → "Conflicting overloads".
- Forgetting the `import` for a function in another package.
- Putting unrelated helpers into a class just to "organize" them, Java-style.
- From Java, calling `square(5)` directly instead of `MathUtilsKt.square(5)`.

## Practice Done
- [ ] Write top-level `square`, `cube` and `isEven` in a file `MathUtils.kt` and call them from `main` in another file
- [ ] Move them into a package `utils` and import them
- [ ] Write a `class BankAccount(var balance: Double)` with member functions `deposit(amount)` and `withdraw(amount)`
- [ ] Add a member `fun describe()` and a top-level `fun describe()` and call both
- [ ] Use `this.balance` in a member function whose parameter is also named `balance`
- [ ] Make a top-level helper `private` and try calling it from another file
- [ ] Declare the same top-level function in two files of the same package and read the error
- [ ] Write one function of each kind (top-level, member, local, extension) in one file

## Doubts / Questions
-
