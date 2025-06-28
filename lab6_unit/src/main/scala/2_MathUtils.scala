object MathUtils:

  def factorial(n: Int): Int =
    if n < 0 then throw new IllegalArgumentException("Negative numbers not allowed")
    else if n == 0 then 1
    else n * factorial(n - 1)

  def fibonacci(n: Int): Int =
    if n <= 0 then 0
    else if n == 1 then 1
    else fibonacci(n - 1) + fibonacci(n - 2)

  def isPrime(n: Int): Boolean =
    if n <= 1 then false
    else !(2 until n).exists(n % _ == 0)
