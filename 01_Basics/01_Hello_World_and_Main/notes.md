# Hello World and Main

> Module: Basics

## What is it?

- **Hello World** is a program that just prints a message. It is the first program people write.
- **`main`** is the function where every Kotlin program **starts**.
- When you click Run, Kotlin runs the code inside `main` from **top to bottom**.
- When `main` ends, the program ends.

## Syntax / Example

### Smallest program
```kotlin
fun main() {
    println("Hello, World!")
}
```
Output:
```
Hello, World!
```

### What each part means
| Part | Meaning |
|---|---|
| `fun` | creates a function |
| `main` | the function's name; Kotlin starts the program here |
| `()` | inputs to the function (none here) |
| `{ }` | the code that runs goes inside |
| `println(...)` | prints something and moves to a new line |
| `"Hello, World!"` | text; text goes inside double quotes |

### `println` vs `print`
```kotlin
fun main() {
    println("One")      // prints, then new line
    println("Two")

    print("A")          // prints, stays on same line
    print("B")
    println()           // only moves to a new line

    println(10 + 5)     // math → prints 15
    println("10 + 5")   // text → prints 10 + 5
}
```
Output:
```
One
Two
AB
15
10 + 5
```

### Old style of `main`
```kotlin
fun main(args: Array<String>) {
    println("Hello, World!")
}
```
This also works. You will see it in older code. Today, `fun main()` is enough.

## Key Points
- Every program starts from `fun main()`.
- Code runs top to bottom, one line at a time.
- `println` prints and goes to a new line. `print` stays on the same line.
- Text must be inside double quotes: `"Hello"`.
- No semicolon `;` needed at the end of a line.
- `main` does not need to be inside a class.
- `//` is a comment. Kotlin ignores it.
- Kotlin is case-sensitive: `main` and `Main` are different.

## Common Mistakes / Gotchas
- Writing `Main` or `Println` → error. Use small letters: `main`, `println`.
- Single quotes for text: `'Hello'` → error. Use `"Hello"`.
- Missing `}` or `)` → error. Every opening bracket needs a closing one.
- Writing code outside `main` (like `println("Hi")` on its own) → error.
- Two files with `main` and no `package` line → "Conflicting overloads" error. Fix: add a different `package` line at the top of each file, like `package basics.helloworld`.

## Practice Done
- [ ] Create `HelloWorld.kt` in this folder and print "Hello, World!"
- [ ] Print your name, city, and age on 3 separate lines
- [ ] Print `Kotlin is fun` using 3 `print` calls
- [ ] Print `25 * 4` and `"25 * 4"`. See the difference.
- [ ] Delete one `}`, read the error, fix it

## Doubts / Questions
-
