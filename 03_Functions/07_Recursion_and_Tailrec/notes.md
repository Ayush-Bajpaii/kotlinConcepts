# Recursion and Tailrec

> Module: Functions

## What is it?

- **Recursion** is when a function **calls itself** to solve a smaller version of the same problem.
- Every recursive function needs:
  1. a **base case**: when to stop, and
  2. a **recursive case**: call itself with a **smaller** input that moves toward the base case.
- `tailrec` is a Kotlin keyword that turns a certain kind of recursion (**tail recursion**) into a fast loop, so it can't overflow the stack.

## Syntax / Example

### 1. First example: countdown
```kotlin
fun countdown(n: Int) {
    if (n == 0) {              // base case
        println("Go!")
        return
    }
    print("$n ")
    countdown(n - 1)           // recursive case, smaller input
}

countdown(3)   // 3 2 1 Go!
```

### 2. Factorial
```kotlin
fun factorial(n: Int): Long {
    if (n <= 1) return 1                // base case
    return n * factorial(n - 1)         // recursive case
}

println(factorial(5))    // 120
println(factorial(20))   // 2432902008176640000
```
- `5! = 5 × 4! = 5 × 4 × 3! = ... = 5 × 4 × 3 × 2 × 1`.
- Use `Long`: `13!` is already too big for `Int`.

### 3. How it runs (the call stack)
```
factorial(4)
= 4 * factorial(3)
= 4 * (3 * factorial(2))
= 4 * (3 * (2 * factorial(1)))
= 4 * (3 * (2 * 1))      ← base case reached, now results come back
= 24
```
- Each call **waits** for the next one. Each waiting call takes space on the **call stack**.
- The stack is limited (a few thousand calls deep, depending on the JVM settings).

### 4. Too deep → `StackOverflowError`
```kotlin
fun sumTo(n: Long): Long = if (n == 0L) 0 else n + sumTo(n - 1)

println(sumTo(1_000))       // 500500
println(sumTo(1_000_000))   // 💥 StackOverflowError
```

### 5. Missing base case → infinite recursion
```kotlin
fun forever(n: Int): Int {
    return forever(n - 1)    // no base case → StackOverflowError
}
```
- It still compiles. IntelliJ only shows a recursion icon in the gutter, so the bug shows up at runtime.

### 6. Fibonacci: correct but slow
```kotlin
fun fib(n: Int): Long = if (n <= 1) n.toLong() else fib(n - 1) + fib(n - 2)

println(fib(10))   // 55
println(fib(45))   // takes several seconds!
```
- Every call makes **two** more calls, so the work roughly doubles with each `n` (exponential time).
- The same values (`fib(3)`, `fib(2)`, ...) get calculated again and again.

### 7. Tail recursion
A call is a **tail call** when it is the **very last thing** the function does, with nothing left to do after it returns.
```kotlin
// NOT tail recursive: after factorial(n - 1) returns, we still multiply by n
return n * factorial(n - 1)

// Tail recursive: the call's result is returned directly
return factorial(n - 1, acc * n)
```
- The trick: carry the partial result in an extra parameter, usually called an **accumulator** (`acc`).

### 8. `tailrec`
```kotlin
tailrec fun factorial(n: Int, acc: Long = 1): Long {
    if (n <= 1) return acc
    return factorial(n - 1, acc * n)
}

println(factorial(5))   // 120
```
```kotlin
tailrec fun sumTo(n: Long, acc: Long = 0): Long =
    if (n == 0L) acc else sumTo(n - 1, acc + n)

println(sumTo(1_000_000))   // 500000500000 ✅ no StackOverflowError
```
- With `tailrec`, the compiler rewrites the function as a **loop**: no stack growth, and fast.
- The default value `acc = 1` hides the accumulator from callers (recap: Default and Named Arguments).

### 9. Fast Fibonacci with `tailrec`
```kotlin
tailrec fun fib(n: Int, a: Long = 0, b: Long = 1): Long =
    if (n == 0) a else fib(n - 1, b, a + b)

println(fib(45))   // 1134903170, instantly
println(fib(90))   // 2880067194370816120
```

### 10. `tailrec` rules
- The recursive call must be the **last** operation.
- It can't be inside `try` / `catch` / `finally`.
- It can't be an `open` function (classes, covered in OOP).
- If the call isn't really a tail call, you get a **warning** ("A function is marked as tail-recursive but no tail calls are found"), and **no optimization** happens.

### 11. More recursion examples
```kotlin
fun power(base: Int, exp: Int): Long =
    if (exp == 0) 1 else base * power(base, exp - 1)

fun reverse(s: String): String =
    if (s.length <= 1) s else reverse(s.substring(1)) + s[0]

fun sumDigits(n: Int): Int =
    if (n < 10) n else n % 10 + sumDigits(n / 10)

tailrec fun gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

println(power(2, 10))        // 1024
println(reverse("Kotlin"))   // niltoK
println(sumDigits(9875))     // 29
println(gcd(48, 18))         // 6
```
- `gcd` is naturally tail recursive, so `tailrec` works without an accumulator.

### 12. Recursion vs loops
| | Recursion | Loop |
|---|---|---|
| Good for | problems that split into smaller copies (trees, folders, divide-and-conquer, backtracking) | simple repeating steps |
| Stack | grows each call (unless `tailrec`) | constant |
| Speed | usually slower | usually faster |
| Readability | often shorter for tree-like problems | often clearer for counting |

- Many DSA problems (tree traversal, permutations, backtracking, merge sort) are written recursively.

## Key Points
- Recursion = a function calling itself with a smaller input.
- Always have a **base case**, and make sure every call moves toward it.
- Each call uses stack space. Too deep → `StackOverflowError`.
- Tail call = the recursive call is the last operation. Use an **accumulator** to make it so.
- `tailrec` turns tail recursion into a loop. It's only applied if the call is truly a tail call.
- Watch number sizes: use `Long` for factorials and Fibonacci.
- If a loop is simpler, use a loop.

## Common Mistakes / Gotchas
- No base case, or a base case that's never reached (`n - 1` when starting from a negative `n`) → `StackOverflowError`.
- Not making the input smaller: `factorial(n)` calling `factorial(n)`.
- `Int` overflow: `factorial(13)` with `Int` gives a **wrong number** (`1932053504` instead of `6227020800`), not an error. Even `Long` overflows after `20!`.
- Thinking `tailrec` fixes `n * factorial(n - 1)`. It doesn't: that's not a tail call (you'll see a warning).
- Using naive recursive Fibonacci for big `n` → extremely slow.
- Forgetting the return type on a recursive expression-body function → error. Recursive functions need an explicit return type.

## Practice Done
- [ ] Write `countdown(n)` recursively
- [ ] Write `factorial(n: Int): Long` recursively and test 0, 1, 5, 20
- [ ] Write `factorial` with `Int` and check `factorial(13)` to see overflow
- [ ] Write `sumTo(n)` without `tailrec`, find the size where it overflows the stack
- [ ] Rewrite `sumTo` with `tailrec` and an accumulator, and run it with `1_000_000`
- [ ] Write naive `fib(n)` and time `fib(40)`; then write the `tailrec` version and compare
- [ ] Write `power(base, exp)` recursively
- [ ] Write `reverse(s: String)` recursively
- [ ] Write `isPalindrome(s: String)` recursively
- [ ] Write `sumDigits(n)` recursively
- [ ] Write `tailrec fun gcd(a, b)`
- [ ] Add `tailrec` to the non-tail `factorial` and read the warning

## Doubts / Questions
-
