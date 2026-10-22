# Variables: val and var

> Module: Basics

## What is it?

- A **variable** is a name that stores a value, so you can use it later.
- Think of it as a **labeled box**: the label is the name, the thing inside is the value.
- Kotlin has two kinds:
  - **`val`**: value **cannot change** after you set it (read-only).
  - **`var`**: value **can change** later.

## Syntax / Example

### Creating a variable
```kotlin
val name = "Ayush"
var age = 25
```
| Part | Meaning |
|---|---|
| `val` / `var` | the kind of variable |
| `name` / `age` | the variable's name |
| `=` | puts the value into the variable |
| `"Ayush"` / `25` | the value |

### Using a variable
```kotlin
fun main() {
    val name = "Ayush"
    var age = 25

    println(name)    // Ayush
    println(age)     // 25
}
```

### `var` can change
```kotlin
fun main() {
    var score = 10
    println(score)   // 10

    score = 20       // change the value (no var/val again)
    println(score)   // 20

    score = score + 5
    println(score)   // 25
}
```

### `val` cannot change
```kotlin
fun main() {
    val city = "Delhi"
    city = "Mumbai"  // ❌ ERROR: Val cannot be reassigned
}
```

### Giving the type yourself (optional)
```kotlin
val name: String = "Ayush"
var age: Int = 25
```
- `: String` and `: Int` tell Kotlin the **type** (what kind of value).
- Usually you can skip it. Kotlin figures out the type from the value. (More in Lesson 4.)

### Declare now, set value later
```kotlin
fun main() {
    val total: Int   // type is required here, because there's no value yet
    total = 100      // set once
    println(total)   // 100
}
```

### `const val`: a fixed value known before the program runs
```kotlin
const val MAX_USERS = 100      // written OUTSIDE main (at the top of the file)

fun main() {
    println(MAX_USERS)         // 100
}
```
- Use for fixed values that never change, like limits or names.
- Must be written **outside** any function.
- Only for simple values: numbers, `true`/`false`, a single character, or text.
- Name style: ALL CAPS with `_`: `MAX_USERS`.

| | `val` | `const val` |
|---|---|---|
| Can change? | No | No |
| Where | anywhere | only outside functions |
| Value | can be decided while the program runs | must be fixed in the code itself |

## Key Points
- `val` = cannot change. `var` = can change.
- **Use `val` by default.** Use `var` only when the value really needs to change.
- To change a `var`, write just `name = newValue` (no `var` again).
- A variable's type cannot change: if `age` holds a number, you can't later put text in it.
- A variable must have a value before you use it.
- Naming style: **camelCase**: start small, each next word starts capital: `userName`, `totalPrice`.
- `const val` = fixed value, written outside functions, name in ALL CAPS.

## Common Mistakes / Gotchas
- Changing a `val` → error "Val cannot be reassigned". Make it `var` if it must change.
- Writing `var` again when changing: `var score = 20` a second time → error "Conflicting declarations". Just write `score = 20`.
- Wrong type: `var age = 25` then `age = "twenty"` → error "Type mismatch".
- Using a variable before giving it a value → error "Variable must be initialized".
- Bad names:
  - can't start with a number: `1name` ❌
  - no spaces or dashes: `user name` ❌, `user-name` ❌
  - can't use keywords: `val val = 5` ❌
- Names are case-sensitive: `age` and `Age` are two different variables.
- `const val` inside `main` → error "Modifier 'const' is not applicable to 'local variable'". Move it above `main`.

## Practice Done
- [ ] Create `val` variables for your name and city, and print them
- [ ] Create a `var` for your age, print it, add 1, print again
- [ ] Try changing a `val`. Read the error.
- [ ] Try putting text into a number `var`. Read the error.
- [ ] Make `var count = 0`, add 1 to it three times, print it after each change
- [ ] Create `const val APP_NAME = "KotlinLearner"` above `main` and print it

## Doubts / Questions
-
