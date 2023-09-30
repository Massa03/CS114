import java.util.Iterator;

/**
   A class of polynomials in x. Each polynomial has
   integer coefficients and non-negative exponents.

   @author Frank M. Carrano
   @version 5.0
 */
public class Polynomial implements PolynomialInterface
{
	private SortedListInterface<Term> myTerms;  // Terms of polynomial in ascending
												// order by exponents of x
	private int myDegree; // Polynomial's degree (highest exponent among terms)

	public Polynomial() {
		//CODE TO BE COMPLETED IN LAB
		myDegree = 0;
		myTerms = new LinkedSortedList<>();
	}  // end default constructor

	public int getDegree() 	{
		//CODE TO BE COMPLETED IN LAB
		return myDegree;
	}  // end getDegree

	public double getCoefficient(int power) throws IllegalArgumentException
	{
		if (power < 0) throw new IllegalArgumentException("Exponent cannot be negative");
		Iterator<Term> iterator = myTerms.getIterator();
		while (iterator.hasNext()){
			Term term = iterator.next();
			if (term.getExponent() == power){
				return term.getCoefficient();
			}
		}
		//CODE TO BE COMPLETED IN LAB
		return 0;
	}  // end getCoefficient

	public void addTerm(double newCoefficient, int power) throws IllegalArgumentException	{
		//CODE TO BE COMPLETED IN LAB
		if (power < 0) throw new IllegalArgumentException("Exponent cannot be negative");
		Term term = new Term(newCoefficient, power);
		myTerms.add(term);
		if (myDegree < power)
			myDegree = power;
		
	} // end addTerm


	public Polynomial add(Polynomial polyTwo) {
		//CODE TO BE COMPLETED FOR HOMEWORK
		//Re-do solution provided during lab to use iterators
		Polynomial sum = new Polynomial();
		Iterator<Term> iter1 = myTerms.getIterator();
		Iterator<Term> iter2 = polyTwo.myTerms.getIterator();


		return sum;
	}  // end add 

	/** negates current polynomial, ie. all coefficients in current polynomial
	 * are negated
	 * @return a new polynomial containing negated terms of the current one
 	 */

	private Polynomial negate(){
		Polynomial temp = new Polynomial();
		Iterator<Term> iter = myTerms.getIterator();

		//CODE TO BE COMPLETED FOR HOMEWORK
		return temp;
	}
	public Polynomial subtract(Polynomial polyTwo)
	{    
		//CODE TO BE COMPLETED FOR HOMEWORK
		return null;
	}  // end subtract

	@Override
	public double evaluate(double value) {
		double result = 0;
		Iterator<Term> iter = myTerms.getIterator();
		//CODE TO BE COMPLETED FOR HOMEWORK
		return result;

		//return 0;
	}

	public void clear()
	{
		myTerms.clear();  
		myDegree = 0;
	}  // end clear

	public String toString()
	{
		String polyString = "";
		int degree = getDegree();
		int listLength = myTerms.getLength();
		for (int position = 1; position <= listLength; position++)
		{
			Term nextTerm = myTerms.getEntry(position);
			if (position == 1)
				polyString += nextTerm.toString().startsWith(" +") ? nextTerm.toString().substring(3): nextTerm.toString();
			else
				polyString = polyString + nextTerm.toString();
		}  // end for

		return polyString;

	}  // end toString
}  // end Polynomial
