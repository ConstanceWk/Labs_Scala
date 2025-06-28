package calcobject

object Calculator:
  def add(a: Int, b: Int): Int = a + b
  def subtract(a: Int, b: Int): Int = a - b
  def multiply(a: Int, b: Int): Int = a * b
  def divide(a: Int, b: Int): Int =
    if b == 0 then throw new ArithmeticException("Cannot divide by zero")
    else a / b
