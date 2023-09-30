package edu.njit.cs114;

public class Polynomial implements PolynomialInterface, Comparable<Polynomial>{

    private double[] coefficients;

    /**
     * Creates a polynomial using the given array of coefficients in a regular order.
     * Eg. if cf ={1,0,3} this represents the polynomial x^2 + 3
     *
     * @param cf, an array of coefficients as they appear in a polynomial's standard form
     */
    public Polynomial(double[] cf) {
        //may find it helpful to call constructor below (constructor chaining)

    }

    
    public Polynomial(double[] cf, boolean standardOrder){
  
  
    }

    /**
     * Default constructor - represents p(x) = 0.0
     * and creates a coefficients array of size 1
     */
    public Polynomial(){
        coefficients =  new double[1];
    }

      /**
     * Creates a single term polynomial
     * @param power
     * @param coefficient
     * @throws Exception if power is negative
     */
    public Polynomial(int power, double coefficient) throws Exception{
        
    }

    /**
     * Returns the coefficient of the term with specified power
     * @param power an integer > 0
     * @return the coefficient or 0 if power is larger than the degree of the polynomial
     * @throws Exception if the power is negative
     */
    @Override
    public double getCoefficient(int power) throws Exception {
        return 0;
            }

    /**
     * Returns the degree of the polynomial
     * Degree of the polynomial is the largest power of a non-zero term
     * @return the degree
     */
    @Override
    public int degree() {
        return 0;
        
    }

    /**
     * Evaluates and returns the value of the polynomial at a specified value of x
     * @param x
     * @return the evaluation result at the given x
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
                return result;
    }

    /**
     * Returns the resulting polynomial of the addition between this polynomial
     * and another polynomial q
     * @param q, another polynomial
     * @return a polynomial
     */
    @Override
    public PolynomialInterface add(PolynomialInterface q) {

        //deg(p+q) = max(deg(p),deg(q))
        return null;
    }

    /**
     * Returns the resulting polynomial of the subtraction between this polynomial
     * and another polynomial q
     * @param q, another polynomial
     * @return a polynomial
     */
    @Override
    public PolynomialInterface subtract(PolynomialInterface q) {
        Polynomial other = (Polynomial) q;
        return null;
    }

    @Override
    /**
     * Returns the resulting polynomial of the multiplication between this polynomial
     * and another polynomial q
     * @param q, another polynomial
     * @return a polynomial
     */
    public PolynomialInterface multiply(PolynomialInterface q) {
        Polynomial other = (Polynomial)q;
        return null;
    }
    @Override
    /**
     * Compares two polynomials based on their degree
     */
    public int compareTo(Polynomial q) {
        return 0;
     }

    /**
     * Compares two polynomial for equality, i.e. they have same terms
     * @param q
     * @return
     */
    public boolean equals (Object q){
        return true;
    }

    /**
     * toString method
     * @return String representation of the polynomial
     */
    public String toString(){
        int degree = degree();
        String result = "";
        if (degree == 0) {
            return "" + coefficients[0];
        }
        for (int i = degree; i >= 0; i--) {
            if (coefficients[i] == 0)
                continue;
            if (i == degree) {
                if (Math.abs(coefficients[i])>1 ){
                    result += coefficients[i];
                }
                else{
                    result += coefficients[i] < 0 ? "-" : "" ;
                }
            } else{
                if (coefficients[i] > 0) {
                    result += " + ";
                }
                else
                    result+= " - ";
                result+= Math.abs(coefficients[i]);
            }

            if (i > 0) {
                result += "x";
                if (i > 1) {
                    result += "^" + i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        //type code here
        //p0(x) = 0.0

        Polynomial p0 = new Polynomial();
        System.out.println("p0(x) = " + p0);
        assert p0.degree() == 0;
        assert p0.getCoefficient(0) == 0;
        assert p0.getCoefficient(5) == 0;
        assert p0.equals(new Polynomial());
        System.out.println("Tests Passed: 4");

        //p1(x) = 2.5x^3 - 5.3x + 3.0
        double[] cfs = {2.5, 0, -5.3, 3.0};
        Polynomial p1 = new Polynomial(cfs);
        System.out.println("p1(x) = " + p1);
        assert p1.toString().equals("2.5x^3 - 5.3x + 3.0");
        System.out.println("p1(0) = "+ p1.evaluate(0));
        assert p1.degree() == 3;
        assert p1.getCoefficient(0) == 3.0;
        assert p1.getCoefficient(2) == 0.0;
        assert p1.evaluate(0) == 3.0;
        System.out.println("Tests passed: 9");

        //p2(x) = x^4 + 2.1x^3 + 0.5x - 8.7
        cfs = new double[]{1, 2.1, 0, 0.5, -8.7};
        Polynomial p2 = new Polynomial(cfs);
        System.out.println("p2(x) = " + p2);
        assert p2.degree() == 4;
        System.out.println("p2(1) = "+ p2.evaluate(1));
        assert p2.evaluate(1) == -5.1;
        assert p1.compareTo(p2) == -1;
        System.out.println("Tests passed: 12");

        //p3(x) = 7.2x^5
        Polynomial p3 = new Polynomial(5, 7.2);
        System.out.println("p3(x) = " + p3);
        assert p3.degree() == 5;
        assert p3.getCoefficient(5) == 7.2;
        assert p3.evaluate(2) == 230.4;
        assert p3.compareTo(p2) == 1;
        System.out.println("Tests passed: 16");

        Polynomial addResult =(Polynomial) p1.add(p2);
        System.out.println("p1(x) + p2(x) = "+addResult);
        assert addResult.degree() == 4;
        assert Math.abs(addResult.getCoefficient(0) - -5.7) <= 0.0001;

        try{
            Polynomial p4 = new Polynomial(-3, 3.4);
            System.out.println(p2.getCoefficient(-3));
            assert false; //power cannot be negative
        }
        catch (Exception e){
            //as expected
            assert true;
        }
        System.out.println("Tests passed: 20");

        Polynomial subtractResult = (Polynomial) p2.subtract(p1);
        System.out.println("p2(x) - p1(x) = " +p2.subtract(p1));
        assert subtractResult.degree() == 4;
        assert Math.abs(subtractResult.getCoefficient(1) - 5.8) <= 0.0001;
        assert Math.abs(subtractResult.getCoefficient(3) - -0.4) <= 0.0001;
        System.out.println("Tests passed: 23");

        Polynomial p4 = new Polynomial(new double[]{1, 0, 2, 0});
        Polynomial multResult = (Polynomial) p1.multiply(p4);
        System.out.println("p1(x) * p4(x) = " +multResult);
        assert multResult.degree() == 6;
        assert Math.abs(multResult.getCoefficient(2) - -10.6) <= 0.0001;
        assert Math.abs(multResult.getCoefficient(0) ) <= 0.0001;
        assert Math.abs(multResult.getCoefficient(6) - 2.5) <= 0.0001;
        assert Math.abs(p1.evaluate(2) * p4.evaluate(2) - multResult.evaluate(2)) <= 0.0001;
        assert p1.equals(new Polynomial(new double[]{2.5, 0, -5.3, 3.0}));
        System.out.println("Tests passed: 29");
    }


}
