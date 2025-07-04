class Calculator {
  def add(a: Int, b: Int): Int = a + b 
  def subtract(a: Int, b: Int): Int = a - b
  def multiply(a: Int, b: Int): Int = a * b
  def divide(a: Int, b: Int): Double = {
    if (b == 0) throw new IllegalArgumentException("Division par zéro")
    a.toDouble / b.toDouble
  }
}