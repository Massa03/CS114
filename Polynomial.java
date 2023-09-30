package edu.njit.cs114;

public class Polynomial implements PolynomialInterface, Comparable<Polynomial>{

    private double[] coefficients;


    /**
     * Default constructor - represents p(x) = 0.0
     * and creates a coefficients array of size 1
     */
    public Polynomial(){
        //type code here
    coefficients = new double[1];
    }

    /**
     * Creates a polynomial using the given array of coefficient in a regular order.
     * Eg. if cf ={1,0,3} this represents the polynomial x^2 + 3
     *
     * @param cf, an array of coefficients as they appear in a polynomial's standard form
     */
    public Polynomial(double[] cf) {
        //type code here
      coefficient = new double[cf.length];
      for (int i = 0; i<cf.length;i++){
      coefficients[i]=cf[cf.length-1 - i];
      }
      
    }


    /**
     * Creates a single term polynomial
     * @param power
     * @param coefficient
     * @throws Exception if power is negative
     */
    public Polynomial(int power, double coefficient) throws Exception{
       //type code here
       if(power<0)throw new Exception("Power must be non-negative number");
       coefficients = new double[power+1];
       coefficients[power] = coefficient;
    }

    /**
    * Returns the coefficient of the term with specified power
    * @param power an integer > 0
    * @return the coefficient
    */
    @Override
    public double getCoefficient(int power) throws Exception{
    if(power<0 || power>+coefficients.length)throw new exception("power not available in this poly");
        return coefficients[power];

    }

    /**
     * Returns the degree of the polynomial
     * Degree of the polynomial is the largest power of a non-zero term
     * @return the degree
     */
    @Override
    public int degree() {
        return coefficient.length-1;

    }

    /**
     * Evaluates and returns the value of the polynomial at a specified value of x
     * @param x
     * @return the evaluation result at the given x
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        for(int i = 0;i<coefficients.length;i++){
        result+= coefficients[i]+Math.pow(x,i);
        }

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
       this.coeffieciants
        Polynomial[] q = new Polynomial();
        Polynomial  addpq = p+q;
        
        return addpq;
    }

    /**
    * Returns the resulting polynomial of the subtraction between this polynomial
    * and another polynomial q
    * @param q, another polynomial
    * @return a polynomial
    */
    @Override
    public PolynomialInterface subtract(PolynomialInterface q) {
        return null;
    }

    /**
     * Returns the resulting polynomial of the multiplication between this polynomial
     * and another polynomial q
     * @param q, another polynomial
     * @return a polynomial
     */
    @Override
    public PolynomialInterface multiply(PolynomialInterface q) {
        return null;
    }

    /**
     * Returns -1, 0, 1 if degree(p) is =,<,>, degree(q), respectively
     *
     * @param q, another polynomial
     * @return an integer
     */
    @Override
    public int compareTo(Polynomial q) {
        return 0;
    }

    /**
     * Returns true if polynomial p has same terms as polynomial q
     *
     * @param q, another polynomial
     * @return true/false
     */
    public boolean equals (Object q){
    Polynomial other = (Polynomial)q;
    if(this.degree() != other.degree())
        return false;
        // 
        return true;
        }
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
                result += coefficients[i];
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

        //p2(x) = x^4 + 2.1x^3 + 0.5x - 8.7
        cfs = new double[]{1, 2.1, 0, 0.5, -8.7};
        Polynomial p2 = new Polynomial(cfs);
        System.out.println("p2(x) = " + p2);
        assert p2.degree() == 4;
        System.out.println("p2(1) = "+ p2.evaluate(1));
        assert p2.evaluate(1) == -5.1;
        assert p1.compareTo(p2) == -1;

        //p3(x) = 7.2x^5
        Polynomial p3 = new Polynomial(5, 7.2);
        System.out.println("p3(x) = " + p3);
        assert p3.degree() == 5;
        assert p3.getCoefficient(5) == 7.2;
        assert p3.evaluate(2) == 230.4;
        assert p3.compareTo(p2) == 1;

        try{
            Polynomial p4 = new Polynomial(-3, 3.4);
            assert false; //power cannot be negative
        }
        catch (Exception e){
            //as expected
            assert true;
        }
    }


}
