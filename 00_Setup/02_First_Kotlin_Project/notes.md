# First Kotlin Project

> Module: Setup

## What is it?

- A **project** is a folder that IntelliJ manages: your source files, settings, the JDK it uses, and where compiled output goes.
- When you create a project, you choose a **build system**. It decides how your code is compiled and how libraries are added.
- Every runnable Kotlin program needs a `main` function (recap: Basics, Hello World and Main).

## Syntax / Example

### 1. Create the project
1. **File → New → Project** (or **New Project** on the welcome screen).
2. Choose **Kotlin** on the left.
3. Fill in:
   - **Name**: e.g. `kotlinConcepts`
   - **Location**: where the folder is created
   - **Build system**: see the table below
   - **JDK**: pick the one you installed (recap: Install JDK and IntelliJ)
4. Click **Create**.

### 2. Which build system?
| Build system | Good for | Notes |
|---|---|---|
| **IntelliJ** | learning, small practice files | simplest; no build file. **This repo uses this.** |
| **Gradle** (Kotlin DSL) | real apps, Android, using libraries | the standard for professional Kotlin; covered in Build Tools |
| **Maven** | some Java/backend teams | XML config; less common for Kotlin |

### 3. Project structure (IntelliJ build system)
```
kotlinConcepts/
├── .idea/                 ← IntelliJ settings (mostly don't touch)
├── out/                   ← compiled .class files (generated, git-ignored)
├── 01_Basics/
│   └── 01_Hello_World_and_Main/
│       └── HelloWorld.kt  ← your code
└── kotlinConcepts.iml     ← module file (may sit inside .idea/)
```

### 3b. Project structure (Gradle)
```
myApp/
├── build.gradle.kts       ← dependencies and build settings
├── settings.gradle.kts
├── gradlew / gradlew.bat  ← Gradle wrapper scripts
└── src/
    ├── main/kotlin/       ← your code goes here
    └── test/kotlin/       ← tests go here
```

### 4. Create your first file
1. Right-click a folder → **New → Kotlin Class/File** → choose **File** → name it `Hello`.
2. IntelliJ creates `Hello.kt`. Type:
```kotlin
package basics.hello

fun main() {
    println("Hello, Kotlin!")
}
```

### 5. Run it
- Click the **green ▶ arrow** next to `fun main()` (in the gutter) → **Run 'HelloKt'**.
- Or press **Ctrl + Shift + R** (macOS) / **Ctrl + Shift + F10** (Windows).
- Output appears in the **Run** window at the bottom:
```
Hello, Kotlin!

Process finished with exit code 0
```
- **Exit code 0** = the program finished without errors. A crash gives a non-zero code (usually `1`).

### 6. Why does it say `HelloKt`?
- Kotlin lets you write functions outside a class (**top-level functions**).
- The JVM only runs code inside classes, so Kotlin puts them into a class named after the file: `Hello.kt` → `HelloKt`.
- More in How Kotlin Compiles.

### 7. `package`
```kotlin
package basics.operators   // first line of the file
```
- A **package** groups related code and avoids name clashes. Two files can both have `main` if they are in different packages.
- Convention: all lowercase, dot-separated, usually matching the folder.
- Every lesson in this repo has its own package (`basics.helloworld`, `basics.operators`, ...). That's why each lesson can have its own `main`.

### 8. Run configurations
- Each time you run a file, IntelliJ creates a **run configuration** (top-right dropdown).
- You can re-run the last one with **Ctrl + R** (macOS) / **Shift + F10** (Windows).
- **Edit Configurations...** lets you add program arguments or change the JDK.

### 9. Naming files
| Thing | Convention | Example |
|---|---|---|
| File with one class | same as the class | `Student.kt` |
| File with functions only | `PascalCase`, describes contents | `Operators.kt`, `StringUtils.kt` |
| Package | lowercase | `basics.operators` |

## Key Points
- **New Project → Kotlin**, pick a build system and a JDK.
- **IntelliJ** build system for learning, **Gradle** for real projects.
- Files end in `.kt`, and each runnable file needs `fun main()`.
- Run with the green ▶ in the gutter. Output shows in the **Run** window.
- `Hello.kt` becomes the JVM class `HelloKt`.
- Use a **different package** per lesson so many `main` functions don't clash.
- `out/` (or `build/` in Gradle) is generated. Don't edit it and don't commit it.

## Common Mistakes / Gotchas
- **No green ▶ arrow**: the file isn't inside a source folder. Right-click the folder → **Mark Directory as → Sources Root**.
- **"Conflicting overloads: fun main()"**: two files in the **same package** both have `main`. Give each file its own `package`.
- Package name doesn't match the folder: it still compiles, but IntelliJ shows a warning. Keep them matching.
- Committing `out/` or `build/` to git: they're generated. Add them to `.gitignore` (this repo already ignores `out/`).
- Choosing Gradle for your first project and waiting ages for the first sync: normal the first time, since it downloads Gradle and dependencies.
- Wrong or missing JDK in the project → red code everywhere. Check **Project Structure → Project → SDK**.

## Practice Done
- [ ] Create a new Kotlin project with the **IntelliJ** build system
- [ ] Add a file `Hello.kt` with a `package` and `main`, and run it
- [ ] Find the **Run** window output and the exit code
- [ ] Make the program crash (e.g. `println(10 / 0)`) and see the non-zero exit code
- [ ] Create a second file in the **same** package with its own `main` and read the error, then fix it with a different package
- [ ] Open the `out/` folder and find the `HelloKt.class` file
- [ ] Create a second project with **Gradle** and compare the folder structure
- [ ] Re-run the last program with the keyboard shortcut

## Doubts / Questions
-
