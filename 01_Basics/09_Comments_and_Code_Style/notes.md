# Comments and Code Style

> Module: Basics

## What is it?

- A **comment** is a note in your code for humans. Kotlin **ignores** it when running.
- **Code style** is a set of rules for naming and formatting, so code is easy to read for you and others.
- Kotlin has an official style guide (kotlinlang.org/docs/coding-conventions.html), and IntelliJ follows it by default.

## Syntax / Example

### 1. Single-line comments: `//`
```kotlin
// This is a comment
val age = 25   // comment at the end of a line
```

### 2. Multi-line comments: `/* */`
```kotlin
/*
  This comment
  spans many lines
*/
val x = 10

/* Kotlin allows nesting: /* inner */ still a comment */
```

### 3. Doc comments (KDoc): `/** */`
```kotlin
/**
 * Adds two numbers.
 *
 * @param a the first number
 * @param b the second number
 * @return the sum of [a] and [b]
 */
fun add(a: Int, b: Int): Int {
    return a + b
}
```
- KDoc is used to **document** functions and classes.
- IntelliJ shows it when you hover over the function name.

### 4. Commenting out code (to disable it for now)
```kotlin
println("This runs")
// println(10 / 0)   // disabled, would crash
```
- Shortcut in IntelliJ: **Cmd + /** (Mac) or **Ctrl + /** (Windows) toggles `//` on selected lines.

### 5. Good vs bad comments
```kotlin
// ❌ Bad: says what the code already says
var count = 0   // set count to 0

// ✅ Good: explains WHY
var retries = 3   // the server sometimes fails on the first try
```
- Good code with clear names needs **few** comments. Comment the **why**, not the **what**.

### 6. Naming rules
| What | Style | Example |
|---|---|---|
| Variables, functions | `camelCase` | `userName`, `totalPrice`, `calculateTax()` |
| Classes, objects | `PascalCase` | `Student`, `BankAccount` |
| Constants | `UPPER_SNAKE_CASE` | `const val MAX_SCORE = 100` |
| Packages | all lowercase | `basics.operators` |
| Booleans | sound like yes/no | `isLoggedIn`, `hasTicket`, `canEdit` |

```kotlin
// ❌ Bad names
val a = 25
val x1 = "Ayush"
val Price = 99.5

// ✅ Good names
val age = 25
val userName = "Ayush"
val price = 99.5
```

### 7. Formatting rules
```kotlin
// ✅ Good
fun main() {
    val total = 10 + 20
    if (total > 25) {
        println("Big")
    }
}

// ❌ Bad
fun main(){
val total=10+20
  if(total>25){println("Big")}
}
```
- Indent with **4 spaces**.
- Spaces around operators: `a + b`, not `a+b`.
- Space after `if`, `for`, `while`: `if (x > 0)`.
- Space before `{`: `fun main() {`.
- Colon in types: `val age: Int` (no space before `:`, one space after).
- **No semicolons** `;` at the end of lines. Kotlin doesn't need them.
- Keep lines reasonably short (official limit: 100 characters).
- Auto-format in IntelliJ: **Cmd + Option + L** (Mac) or **Ctrl + Alt + L** (Windows).

### 8. Prefer `val` and type inference
```kotlin
val name = "Ayush"          // ✅ type is clear, so no need to write it
val name: String = "Ayush"  // fine, but extra
var count = 0               // use var only if it changes
```

## Key Points
- `//` one line, `/* */` many lines, `/** */` documentation.
- Comments are ignored by Kotlin; they're only for people.
- Comment **why**, not **what**. Clear names reduce the need for comments.
- `camelCase` for variables and functions, `PascalCase` for classes, `UPPER_SNAKE_CASE` for constants.
- 4-space indent, spaces around operators, no semicolons.
- Use IntelliJ's auto-format and comment shortcuts.

## Common Mistakes / Gotchas
- Leaving a `/*` without a closing `*/`: the rest of the file becomes a comment, causing confusing errors.
- Comments that become wrong after you change the code. Update or remove them.
- Writing `;` at the end of every line. It works, but isn't Kotlin style.
- Names like `a`, `temp`, `data2` that don't tell what the value is.
- Starting variable names with a capital letter (`val Name`). That style is for classes.
- Leaving lots of old commented-out code. Git already keeps the history, so delete it when done.

## Practice Done
- [ ] Add a single-line comment above each line of one of your old programs, explaining it
- [ ] Write a multi-line comment at the top of a file describing what the program does
- [ ] Write a KDoc for a function `fun square(n: Int): Int` and hover over it in IntelliJ
- [ ] Rename these to proper style: `val Username`, `val x = 18 // minimum age`, `val max_marks = 100`
- [ ] Open [Operators.kt](../06_Operators/Operators.kt), remove the semicolons, and press Cmd + Option + L
- [ ] Select 3 lines and use Cmd + / to comment and uncomment them
- [ ] Find one comment in your code that says **what** and rewrite it to say **why** (or delete it)

## Doubts / Questions
-
