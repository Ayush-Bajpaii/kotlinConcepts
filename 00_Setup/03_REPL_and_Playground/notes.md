# REPL and Playground

> Module: Setup

## What is it?

- Sometimes you want to **try one line quickly** without creating a project. Kotlin gives you several ways:
  - **Kotlin Playground**: run Kotlin in your **browser**, no install.
  - **Scratch files**: quick throwaway files **inside IntelliJ** that show results instantly.
  - **Kotlin Notebook**: Jupyter-style cells (code + output + notes) in IntelliJ.
  - **REPL** (Read–Eval–Print Loop): type a line in the **Terminal**, see the result, repeat.
- These are for **experimenting**. Real programs still go in `.kt` files in a project.

## Syntax / Example

### 1. Kotlin Playground (browser)
- Open **play.kotlinlang.org**.
- Write code with a `main` function and press **Run**:
```kotlin
fun main() {
    val nums = listOf(3, 1, 2)
    println(nums.sorted())   // [1, 2, 3]
}
```
- You can choose:
  - **Kotlin version** (to test new or old features)
  - **Target**: JVM, JS, Wasm
- **Share** button gives a link to your code, which is handy for asking questions.
- ⚠️ **No keyboard input**: `readln()` doesn't work here. Use IntelliJ for input programs.

### 2. Scratch files (inside IntelliJ)
1. **File → New → Scratch File** (Cmd + Shift + N / Ctrl + Alt + Shift + Insert).
2. Choose **Kotlin**.
3. Write code **without** `main`:
```kotlin
val a = 10
val b = 3
a / b          // 3
a % b          // 1
"Kotlin".length  // 6
```
4. Click **Run** (▶ at the top of the scratch). Results appear **next to each line**.
- Turn on **Interactive mode** to re-run automatically as you type.
- **Use classpath of module** lets the scratch use code from your project.
- Scratch files are saved outside your project (under **Scratches and Consoles** in the Project view), so they don't clutter the repo.

### 3. Kotlin Notebook (IntelliJ)
- Install the **Kotlin Notebook** plugin: **Settings → Plugins → Marketplace**.
- **File → New → Kotlin Notebook**.
- Code is written in **cells**. Run one cell at a time. Variables stay available in later cells.
- Good for experimenting step by step, charts and data. Not for real app code.

### 4. REPL in the Terminal
```bash
brew install kotlin     # macOS: installs the kotlinc command
kotlinc                 # starts the REPL
```
```
>>> val x = 5
>>> x * 2
res1: kotlin.Int = 10
>>> "hi".uppercase()
res2: kotlin.String = HI
>>> :quit
```
- `res1`, `res2` are names the REPL gives to each result.
- The Terminal REPL is basic and **experimental**. For daily use, Scratch files or the Playground are better.

### 5. Which one should I use?
| Need | Best tool |
|---|---|
| Try something fast, no IDE open | **Playground** |
| Test a line while working in IntelliJ | **Scratch file** |
| Step-by-step experiments with notes | **Kotlin Notebook** |
| Program that reads input (`readln`) | **normal `.kt` file in IntelliJ** |
| Share code with someone | **Playground → Share** |
| Terminal-only environment | **`kotlinc` REPL** |

## Key Points
- Playground = browser, zero setup, but **no input** (`readln()`).
- Scratch files show results next to each line and don't need `main`.
- Kotlin Notebook = cells with code and output, saved as a `.ipynb` file.
- `kotlinc` with no arguments starts a Terminal REPL (needs Kotlin installed via Homebrew or SDKMAN).
- These tools are for **trying things**. Lessons and projects go in `.kt` files.

## Common Mistakes / Gotchas
- Using `readln()` in the Playground → error or no input. Use IntelliJ.
- Forgetting `main` in the Playground → nothing runs. (Scratch files don't need it, the Playground does.)
- Writing your actual lesson code in a scratch file and losing it: scratches are **not part of the repo**. Move code you want to keep into a `.kt` file.
- `kotlinc: command not found`: IntelliJ's built-in compiler isn't on your Terminal path. Install with `brew install kotlin` if you need it.
- Different Kotlin versions in the Playground and your project can behave differently. Check the version selector.

## Practice Done
- [ ] Run a Hello World in the Kotlin Playground
- [ ] Change the Playground's Kotlin version and run again
- [ ] Share a Playground link and open it in another tab
- [ ] Create a Kotlin Scratch file and check `10 / 3`, `10 % 3` and `10.0 / 3` without `main`
- [ ] Turn on **Interactive mode** in the scratch and watch results update
- [ ] Try `readln()` in the Playground and see what happens
- [ ] (Optional) Install the Kotlin Notebook plugin and run 3 cells that use each other's variables
- [ ] (Optional) Install `kotlinc` and try 3 expressions in the REPL

## Doubts / Questions
-
