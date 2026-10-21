# Kotlin Learning Plan: Basics to Advanced

This folder is for learning **Kotlin as a programming language**, from the basics to advanced topics.
Android development comes later, in a **separate folder** (see [Phase 2](#phase-2--android-development-separate-folder-later)).

---

## How to Use This Folder

- Each module is a numbered folder (`01_...`, `02_...`). Work through them **in order**.
- Each topic inside a module has its own folder with a `notes.md`. Put your notes there, and put your practice `.kt` files next to it.
- Tick the checkboxes in this file (`- [ ]` → `- [x]`) as you finish each topic.
- After each module, do the **Practice** tasks before moving on.
- Suggested pace: **1 module per week**, about 1 to 2 hours a day. Coroutines and Advanced Kotlin may take 2 weeks each.

### Folder Layout

```
kotlin_Concepts/
├── LEARNING_PLAN.md          ← this file
├── 00_Setup/
├── 01_Basics/
│   ├── 01_Hello_World_and_Main/
│   │   └── notes.md          ← your notes + .kt practice files here
│   └── ...
├── ...
└── 17_Projects/
```

### Routine for Each Topic

1. Read the topic in the official docs: https://kotlinlang.org/docs/home.html
2. Write small examples in a `.kt` file inside the topic folder.
3. Write the key points **in your own words** in `notes.md`.
4. Solve 2 or 3 small problems on the topic (Kotlin Koans, Exercism, LeetCode Easy).

---

## Phase 1: Kotlin Language

### 00 · Setup
- [x] Install JDK 17+ and IntelliJ IDEA (Community is fine)
- [x] Create a Kotlin project in IntelliJ
- [ ] Run your first program; learn to use the REPL and Kotlin Playground (https://play.kotlinlang.org)
- [ ] Learn how Kotlin compiles: JVM bytecode, Kotlin/JS, Kotlin/Native

### 01 · Basics
- [ ] Hello World and the `main` function
- [ ] Variables: `val` vs `var`
- [ ] Basic data types: Int, Long, Double, Float, Boolean, Char, String
- [ ] Type inference and explicit types
- [ ] Type conversion (`toInt()`, `toDouble()`, ...)
- [ ] Operators: arithmetic, comparison, logical, assignment, `==` vs `===`
- [ ] Strings: templates, raw strings, common string functions
- [ ] Input and output: `println`, `readln()`
- [ ] Comments and code style conventions

**Practice:** temperature converter, simple calculator, string reverse / palindrome check.

### 02 · Control Flow
- [ ] `if` as an expression
- [ ] `when` expression (replacement for switch)
- [ ] Ranges: `..`, `until`, `downTo`, `step`
- [ ] `for` loops
- [ ] `while` and `do-while`
- [ ] `break`, `continue`, and labels (`outer@`)

**Practice:** FizzBuzz, multiplication table, prime numbers in a range, number-guessing game.

### 03 · Functions
- [ ] Declaring functions, parameters, return types, `Unit`
- [ ] Default and named arguments
- [ ] Single-expression functions
- [ ] `vararg`
- [ ] Local (nested) functions
- [ ] Infix functions
- [ ] Recursion and `tailrec`
- [ ] Top-level functions vs member functions

**Practice:** factorial (recursive + tailrec), Fibonacci, GCD/LCM, power function.

### 04 · Null Safety
- [ ] Nullable vs non-nullable types (`String?`)
- [ ] Safe call `?.`
- [ ] Elvis operator `?:`
- [ ] Not-null assertion `!!` (and why to avoid it)
- [ ] Safe casts `as?` and smart casts with `is`
- [ ] `let` with nullables
- [ ] `lateinit` and `lazy`

**Practice:** safely parse user input, find a user in a nullable list.

### 05 · Collections
- [ ] Arrays (`arrayOf`, `IntArray`, ...)
- [ ] Lists: `listOf` vs `mutableListOf`
- [ ] Sets
- [ ] Maps
- [ ] Mutable vs read-only collections
- [ ] Collection operations: `map`, `filter`, `forEach`, `reduce`, `fold`, `groupBy`, `associate`, `partition`, `zip`, `flatMap`, `sortedBy`, `any`/`all`/`none`, `first`/`find`
- [ ] Sequences (lazy evaluation) vs collections

**Practice:** word frequency counter, student grade report, remove duplicates, group items by category.

### 06 · Object-Oriented Programming
- [ ] Classes and objects
- [ ] Primary and secondary constructors, `init` blocks
- [ ] Properties: getters, setters, backing fields
- [ ] Visibility modifiers: `public`, `private`, `protected`, `internal`
- [ ] Inheritance: `open`, `override`, `super`
- [ ] Abstract classes
- [ ] Interfaces (with default methods)
- [ ] Polymorphism
- [ ] `Any`, `equals`, `hashCode`, `toString`

**Practice:** bank account system, shape hierarchy (area/perimeter), library management model.

### 07 · Special Classes
- [ ] Data classes (`copy`, `componentN`, `equals`)
- [ ] Enum classes (with properties and functions)
- [ ] Sealed classes and sealed interfaces
- [ ] `object` declarations (singleton)
- [ ] Companion objects
- [ ] Nested vs inner classes
- [ ] Anonymous objects (object expressions)
- [ ] Value (inline) classes

**Practice:** model API states with a sealed class (`Loading`, `Success`, `Error`), traffic light with enum.

### 08 · Functional Programming
- [ ] Lambdas and their syntax (`it`, trailing lambdas)
- [ ] Function types (`(Int) -> String`)
- [ ] Higher-order functions
- [ ] Function references (`::functionName`)
- [ ] Closures
- [ ] Extension functions and extension properties
- [ ] Scope functions: `let`, `run`, `with`, `apply`, `also`
- [ ] Inline functions, `noinline`, `crossinline`

**Practice:** write your own `myFilter`/`myMap`, String extension functions, builder with `apply`.

### 09 · Generics
- [ ] Generic classes and functions
- [ ] Type constraints (`<T : Comparable<T>>`, `where`)
- [ ] Variance: `out` (covariance), `in` (contravariance)
- [ ] Use-site variance and star projection `<*>`
- [ ] Type erasure and `reified` type parameters

**Practice:** generic `Stack<T>`, generic `Box<T>`, a `Result`-like wrapper class.

### 10 · Error Handling
- [ ] Exceptions: `try`/`catch`/`finally`
- [ ] `try` as an expression
- [ ] `throw` and the `Nothing` type
- [ ] Custom exceptions
- [ ] `require`, `check`, `error`
- [ ] `runCatching` and the `Result` type

**Practice:** input validator with custom exceptions, safe division function returning `Result`.

### 11 · Advanced Kotlin
- [ ] Class delegation (`by`)
- [ ] Property delegation: `lazy`, `observable`, `vetoable`, map delegation, custom delegates
- [ ] Operator overloading
- [ ] Destructuring declarations
- [ ] Type aliases
- [ ] Annotations
- [ ] Reflection basics (`::class`, `KClass`)
- [ ] Type-safe builders and DSLs
- [ ] Context receivers / context parameters (newer feature, read the latest docs)
- [ ] Kotlin and Java interoperability (`@JvmStatic`, `@JvmOverloads`, platform types)

**Practice:** build a small HTML DSL, a `Vector` class with `+` and `*` operators.

### 12 · Coroutines and Flow ⭐ (very important for Android)
- [ ] Threads vs coroutines: why coroutines
- [ ] `suspend` functions
- [ ] Coroutine builders: `runBlocking`, `launch`, `async`/`await`
- [ ] `CoroutineScope` and structured concurrency
- [ ] Dispatchers: `Default`, `IO`, `Main`, `Unconfined`; `withContext`
- [ ] `Job`, cancellation, timeouts
- [ ] Exception handling in coroutines, `SupervisorJob`, `CoroutineExceptionHandler`
- [ ] Channels
- [ ] Flow basics (cold streams), operators (`map`, `filter`, `collect`, `combine`, `flatMapLatest`, ...)
- [ ] `StateFlow` and `SharedFlow` (hot streams)
- [ ] Shared mutable state: `Mutex`, atomics

**Practice:** download simulator with parallel `async`, countdown timer with Flow, producer/consumer with Channel.

### 13 · Standard Library and I/O
- [ ] Working with files (`File`, `readText`, `useLines`, `use`)
- [ ] Regular expressions
- [ ] Date and time (`java.time`, `kotlinx-datetime`)
- [ ] Math and random utilities
- [ ] JSON with `kotlinx.serialization`

**Practice:** read a CSV file and print a summary; save and load data as JSON.

### 14 · Testing
- [ ] Unit testing with JUnit 5 / `kotlin.test`
- [ ] Assertions and test structure (Arrange, Act, Assert)
- [ ] Mocking with MockK
- [ ] Testing coroutines (`runTest`)

**Practice:** write tests for your earlier calculator and bank account projects.

### 15 · Build Tools and Project Structure
- [ ] Packages and imports
- [ ] Gradle basics with Kotlin DSL (`build.gradle.kts`)
- [ ] Adding dependencies; version catalogs (`libs.versions.toml`)
- [ ] Multi-module projects

### 16 · Design Patterns and Clean Code in Kotlin
- [ ] SOLID principles
- [ ] Singleton, Factory, Builder, Observer, Strategy, Adapter (the Kotlin way)
- [ ] Dependency injection (the concept; manual DI)
- [ ] Kotlin idioms and best practices

### 17 · Projects (put everything together)
- [ ] **Console To-Do App**: CRUD, data classes, collections, saved to a file
- [ ] **Library Management System**: OOP, sealed classes, error handling
- [ ] **Expense Tracker**: collections ops, file/JSON storage, tests
- [ ] **Weather CLI**: coroutines + HTTP call (Ktor client) + JSON parsing
- [ ] **Quiz Game**: enums, `when`, user input, scoring

---

## Phase 2: Android Development (separate folder, later)

Create a new folder (for example `android_Concepts`) when Phase 1 is done, at least through Module 12 (Coroutines).

1. **Android Basics:** Android Studio, project structure, Gradle, Manifest, Activity lifecycle, Intents
2. **Jetpack Compose (modern UI):** composables, layouts (Row/Column/Box), modifiers, state, recomposition, lists (`LazyColumn`), theming with Material 3
3. **Navigation:** Navigation Compose, passing arguments, back stack
4. **Architecture:** MVVM, `ViewModel`, `StateFlow` in UI, unidirectional data flow, Clean Architecture layers
5. **Data and Storage:** Room database, DataStore, repository pattern
6. **Networking:** Retrofit / Ktor, `kotlinx.serialization`, error handling, offline-first
7. **Dependency Injection:** Hilt (or Koin)
8. **Background Work:** WorkManager, Services, Notifications
9. **Permissions and Device Features:** runtime permissions, camera, location
10. **Testing:** unit tests, UI tests with Compose testing, Espresso basics
11. **Advanced:** performance, Paging 3, modularization, animations in Compose
12. **Publishing:** app signing, release builds, Play Store
13. **Older view system (optional, useful for existing code):** XML layouts, RecyclerView, Fragments

---

## Resources

| Resource | Link |
|---|---|
| Official Kotlin Docs | https://kotlinlang.org/docs/home.html |
| Kotlin Koans (exercises) | https://play.kotlinlang.org/koans |
| Kotlin Playground | https://play.kotlinlang.org |
| Coroutines Guide | https://kotlinlang.org/docs/coroutines-guide.html |
| Exercism Kotlin Track | https://exercism.org/tracks/kotlin |
| Android Basics with Compose | https://developer.android.com/courses/android-basics-compose/course |
| Book: *Kotlin in Action* (2nd ed.) | Manning |
| Book: *Atomic Kotlin* | Bruce Eckel & Svetlana Isakova |

---

## Progress Log

| Date | Module / Topic | Notes |
|---|---|---|
|  |  |  |
