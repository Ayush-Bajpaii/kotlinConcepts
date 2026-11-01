# How Kotlin Compiles

> Module: Setup

## What is it?

- Computers can't run `.kt` files directly. Your code must be **compiled** (translated) into something a machine can run.
- On the JVM (the most common target), the steps are:
  1. You write **source code** in `.kt` files.
  2. The **Kotlin compiler** (`kotlinc`) turns it into **bytecode** in `.class` files.
  3. The **JVM** runs the bytecode on any OS: macOS, Windows, Linux.
- Java compiles to the **same bytecode**. That's why Kotlin and Java can use each other's code in the same project.
- Kotlin is **statically typed**: types are checked at **compile time**, so many errors are caught before the program ever runs.

## Syntax / Example

### 1. The pipeline (Kotlin/JVM)
```
HelloWorld.kt ──(kotlinc)──▶ HelloWorldKt.class ──(JVM)──▶ output
 source code                    bytecode                 running program
```
- **Compile time**: when `kotlinc` checks and translates your code. Type errors appear here (red underline in IntelliJ).
- **Runtime**: when the JVM runs the program. Crashes like `10 / 0` happen here.

### 2. Top-level functions → a class named `<File>Kt`
Your [HelloWorld.kt](../../01_Basics/01_Hello_World_and_Main/HelloWorld.kt):
```kotlin
package basics.helloworld

fun main() {
    println("Hello world")
}
```
After compiling, IntelliJ puts it in `out/production/.../basics/helloworld/HelloWorldKt.class`.

Inspect it with `javap` (comes with the JDK):
```bash
javap out/production/kotlin_Concepts/basics/helloworld/HelloWorldKt.class
```
```
Compiled from "HelloWorld.kt"
public final class basics.helloworld.HelloWorldKt {
  public static final void main();
  public static void main(java.lang.String[]);
}
```
- The JVM only runs code inside classes, so Kotlin creates the class `HelloWorldKt`.
- Kotlin also generates `main(String[])`, the entry point the JVM looks for, which calls your `main()`.

### 3. Looking at the bytecode
```bash
javap -c out/production/kotlin_Concepts/basics/helloworld/HelloWorldKt.class
```
```
0: ldc           #8   // String Hello world
2: getstatic     #14  // Field java/lang/System.out:Ljava/io/PrintStream;
5: swap
6: invokevirtual #20  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
```
- Kotlin's `println("...")` becomes Java's `System.out.println(...)` in bytecode.

**Easier way in IntelliJ:** open a `.kt` file → **Tools → Kotlin → Show Kotlin Bytecode** → click **Decompile** to see the equivalent Java code.

### 4. Compiling by hand (Terminal)
```bash
kotlinc HelloWorld.kt -include-runtime -d hello.jar   # compile
java -jar hello.jar                                   # run
```
- `-include-runtime` packs the **Kotlin standard library** into the jar. Without it, `println`, `listOf` etc. can't be found at runtime.
- `-d hello.jar` = destination. This jar is about **5–6 MB**, mostly the standard library.
- IntelliJ (or Gradle) does all of this for you when you press Run.

### 5. What happens inside the JVM
1. **Class loading**: the JVM loads `HelloWorldKt.class`.
2. **Bytecode verification**: checks the bytecode is safe.
3. **Interpreting + JIT**: the JVM starts by interpreting bytecode, then the **JIT (Just-In-Time) compiler** turns frequently used code into fast native machine code while the program runs.
- That's why JVM programs get faster after "warming up".

### 6. Kotlin can target more than the JVM
| Target | Compiles to | Used for |
|---|---|---|
| **Kotlin/JVM** | `.class` bytecode | Android, backend servers, desktop |
| **Kotlin/JS** | JavaScript | web frontends |
| **Kotlin/Wasm** | WebAssembly | fast web apps |
| **Kotlin/Native** | native machine code (via LLVM), no JVM | iOS, macOS, Linux, embedded |
| **Kotlin Multiplatform** | several of the above from shared code | sharing logic across Android, iOS, web |

- The same Kotlin language, different **backends**. This repo uses **Kotlin/JVM**.

### 7. The K2 compiler
- Since **Kotlin 2.0**, Kotlin uses a new compiler frontend called **K2**: faster compilation and smarter type checking (e.g. better smart casts).
- You don't need to do anything. It's the default.

### 8. Java interop in practice
```kotlin
import java.time.LocalDate     // a Java class

fun main() {
    println(LocalDate.now())   // used directly from Kotlin
}
```
- Kotlin can use **any Java library**, and Java can call Kotlin code, because both become JVM bytecode.

## Key Points
- `.kt` → **kotlinc** → `.class` bytecode → **JVM** runs it.
- Errors are found at **compile time** (type errors) or **runtime** (crashes).
- Top-level functions in `Name.kt` live in a JVM class called `NameKt`.
- Kotlin generates a `main(String[])` for the JVM automatically.
- The **Kotlin standard library** is needed at runtime (`-include-runtime` when building a jar by hand).
- **Tools → Kotlin → Show Kotlin Bytecode → Decompile** shows what your code really becomes.
- Kotlin also compiles to JS, Wasm and native code. Same language, different targets.
- Kotlin and Java share bytecode, so they work together in one project.

## Common Mistakes / Gotchas
- Thinking Kotlin is interpreted like Python: it's **compiled** before it runs.
- `java -jar hello.jar` fails with `NoClassDefFoundError: kotlin/...`: you forgot `-include-runtime`.
- Running the class with the wrong name: it's `HelloWorldKt`, not `HelloWorld` (`java -cp out/... basics.helloworld.HelloWorldKt`).
- Editing files in `out/`: they're regenerated on every build. Edit the `.kt` source.
- Expecting compile-time checks to catch everything: `10 / 0` and `"abc".toInt()` compile fine and only crash at runtime.
- Assuming Kotlin/Native code can use Java libraries: only Kotlin/JVM can.

## Practice Done
- [ ] Run a program in IntelliJ, then find its `...Kt.class` file under `out/production/`
- [ ] Run `javap` on that class and find the generated `main(String[])`
- [ ] Run `javap -c` and find where `println` becomes `System.out.println`
- [ ] Use **Show Kotlin Bytecode → Decompile** on `Operators.kt` and read the Java version
- [ ] Write a line with a type error (`val x: Int = "hi"`) and note it's a **compile-time** error
- [ ] Write `println(10 / 0)` and note it compiles but fails at **runtime**
- [ ] Use a Java class (`java.time.LocalDate.now()`) from Kotlin
- [ ] (Optional) Compile a file with `kotlinc ... -include-runtime -d hello.jar` and run it with `java -jar`

## Doubts / Questions
-
