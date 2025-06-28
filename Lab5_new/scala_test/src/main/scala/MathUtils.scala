object MathUtils {
  
  def factorial(n: Int): Int = {
    if (n < 0) throw new IllegalArgumentException("Factorial n'est pas défini pour les nombres négatifs")
    if (n == 0 || n == 1) 1
    else n * factorial(n - 1)
  }
  
  def fibonacci(n: Int): Int = {
    if (n < 0) throw new IllegalArgumentException("Fibonacci n'est pas défini pour les nombres négatifs")
    if (n == 0) 0
    else if (n == 1) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }
  
  def isPrime(n: Int): Boolean = {
    if (n < 2) false
    else if (n == 2) true
    else if (n % 2 == 0) false
    else {
      val sqrt = math.sqrt(n).toInt
      !(3 to sqrt by 2).exists(n % _ == 0)
    }
  }
}
