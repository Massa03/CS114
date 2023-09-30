package edu.njit.cs114;
/**
 * The Polynomial Interface represents responsabilities of a polynomial of a
 * single variable with double coefficients.
 * A polynomial is an expression consisting of variables with non-negative
 * integer exponents and real coefficients.
 * The responsibilities (operations) include: addition, subtraction, multiplication, and evaluation.
 *
 * Examples of polynomials with a single variable, x, are:
 *
 * <pre>
 * p3(x) = 2.5x^3 - 5.3x + 3.0
 * p2(x) = x^4 + 2.1x^3 + 0.5x - 8.5
 * p1(x) = 7.2x^5
 * p0(x) = 0.0
 *</pre>
 *
 * @author Junilda Spirollari
 * @date 9/15/2022
 *
 */

public interface PolynomialInterface {

 /**
  * Returns the coefficient of the term with specified power
  * @param power an integer > 0
  * @return the coefficient or 0 if power is larger than the degree of the polynomial
  * @throws Exception if the power is negative
  */
 public double getCoefficient(int power) throws Exception;

 /**
  * Returns the degree of the polynomial
  * Degree of the polynomial is the largest power of a non-zero term
  * @return the degree
  */
public int degree();

/**
 * Evaluates and returns the value of the polynomial at a specified value of x
 * @param x
 * @return the evaluation result at the given x
 */
public double evaluate(double x);
/**
 * Returns the resulting polynomial of the addition between this polynomial
 * and another polynomial q
 * @param q, another polynomial
 * @return a polynomial
 */
public PolynomialInterface add(PolynomialInterface q);

 /**
  * Returns the resulting polynomial of the subtraction between this polynomial
  * and another polynomial q
  * @param q, another polynomial
  * @return a polynomial
  */
 public PolynomialInterface subtract(PolynomialInterface q);

 /**
  * Returns the resulting polynomial of the multiplication between this polynomial
  * and another polynomial q
  * @param q, another polynomial
  * @return a polynomial
  */
 public PolynomialInterface multiply(PolynomialInterface q);


}
