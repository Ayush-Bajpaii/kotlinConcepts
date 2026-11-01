# Install JDK and IntelliJ

> Module: Setup

## What is it?

- To write and run Kotlin on your computer you need two things:
  - **JDK** (Java Development Kit): runs the compiled Kotlin code on the **JVM** (Java Virtual Machine).
  - **IntelliJ IDEA**: the editor (IDE) where you write, run and debug code. It's made by **JetBrains**, the company that created Kotlin.
- The **Kotlin compiler comes bundled** with IntelliJ. You don't install Kotlin separately.
- Android Studio is built on IntelliJ, so everything here also applies there.

## Syntax / Example

### 1. JDK vs JRE vs JVM
| Name | What it is | Do you need it? |
|---|---|---|
| **JVM** | the engine that runs bytecode (`.class` files) | yes (comes inside the JDK) |
| **JRE** | JVM + standard libraries, only for **running** programs | not separately |
| **JDK** | JRE + tools for **developing** (`javac`, `javap`, `jar`, ...) | ✅ **install this** |

### 2. Which JDK version?
- Use an **LTS** (Long-Term Support) version: **17**, **21** or **25**.
- Any of them works for learning Kotlin. This repo currently uses **JDK 17**.

### 3. Install the JDK

**Option A: from IntelliJ (easiest)**
1. Open IntelliJ → **File → Project Structure → SDKs**.
2. Click **+** → **Download JDK**.
3. Pick a version (e.g. 17 or 21) and a vendor (e.g. *Eclipse Temurin* or *Amazon Corretto*) → **Download**.

**Option B: Homebrew (macOS)**
```bash
brew install openjdk@17
```

**Option C: Windows / Linux**
- Download an installer from **adoptium.net** (Eclipse Temurin) and run it.

### 4. Check the installation (Terminal)
```bash
java -version
# openjdk version "17.0.x" ...

javac -version
# javac 17.0.x
```
- If `java -version` works but `javac` doesn't, you installed only a JRE, not a JDK.
- If you installed the JDK only through IntelliJ, these commands may not work in the Terminal. That's fine: IntelliJ knows where it is.

### 5. Install IntelliJ IDEA
1. Download from **jetbrains.com/idea**. The free version is enough for everything in this repo.
2. Install and open it.
3. The **Kotlin plugin is already included**. Check under **Settings → Plugins → Installed → Kotlin**.
- Tip: **JetBrains Toolbox** (a small app from JetBrains) installs and updates IntelliJ and Android Studio for you.

### 6. Useful first settings
| Setting | Where |
|---|---|
| Theme / font size | **Settings → Appearance & Behavior → Appearance** and **Editor → Font** |
| Show line numbers | **Settings → Editor → General → Appearance → Show line numbers** |
| Auto-import | **Settings → Editor → General → Auto Import** |
| Check the project's JDK | **File → Project Structure → Project → SDK** |

> On macOS, **Settings** is under **IntelliJ IDEA → Settings** (Cmd + ,).

### 7. Shortcuts worth learning now (macOS / Windows)
| Action | macOS | Windows / Linux |
|---|---|---|
| Run | Ctrl + R | Shift + F10 |
| Run the current file | Ctrl + Shift + R | Ctrl + Shift + F10 |
| Search everything | Shift Shift | Shift Shift |
| Find any action | Cmd + Shift + A | Ctrl + Shift + A |
| Format code | Cmd + Option + L | Ctrl + Alt + L |
| Comment line | Cmd + / | Ctrl + / |
| Show quick fix | Option + Enter | Alt + Enter |

- **Option + Enter / Alt + Enter** is the most useful shortcut: it suggests a fix for whatever is underlined in red.

## Key Points
- Install a **JDK** (not just a JRE). An LTS version (17, 21 or 25) is the safest choice.
- IntelliJ already includes the Kotlin plugin and compiler.
- The easiest way to get a JDK is **Project Structure → SDKs → Download JDK** inside IntelliJ.
- `java -version` and `javac -version` confirm a working JDK in the Terminal.
- Each project points to one JDK, set in **Project Structure → Project → SDK**.

## Common Mistakes / Gotchas
- **"Project JDK is not defined"** banner: set a JDK in **Project Structure → Project → SDK**.
- Installing a JRE instead of a JDK → `javac` missing.
- Several JDKs installed and the Terminal uses a different one from IntelliJ. That's normal. Check each one separately.
- `JAVA_HOME` not set when running Gradle from the Terminal → set it, e.g. on macOS add `export JAVA_HOME=$(/usr/libexec/java_home -v 17)` to `~/.zshrc`.
- Installing the "Kotlin plugin" from somewhere else: not needed, it's built in.

## Practice Done
- [ ] Install a JDK (17 or 21) and run `java -version` and `javac -version`
- [ ] Install IntelliJ IDEA and open it
- [ ] Confirm the Kotlin plugin is installed under **Settings → Plugins**
- [ ] Turn on line numbers and set a comfortable font size
- [ ] Open **Project Structure** and see which JDK this repo uses
- [ ] Try **Shift Shift** and search for a file in this repo
- [ ] Write a line with an error and fix it with **Option + Enter**

## Doubts / Questions
-
