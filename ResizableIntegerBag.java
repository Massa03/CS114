//package edu.njit.cs114;

/*Implementing a Resizable Integer Bag
 */

import java.util.Arrays;

public class ResizableIntegerBag {

    private Integer[] bag;
    private int numElements;

    private static final int DEFAULT_CAPACITY = 1;

    public ResizableIntegerBag(int desiredCapacity) {
        bag = new Integer[desiredCapacity];
    }

    public ResizableIntegerBag() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * add number to the end of the bag
     * if bag is full double the size of bag(array)
     *
     * @param number
     */
    public void add(int number) {
    }

   
    /**
     * Add a number at specified index position
     * shift to right numbers at positions higher than or equal to index
     * if bag is full, double its size
     *
     * @param index
     * @param number
     * @throws IndexOutOfBoundsException if index < 0 or index >= size()
     */
    public void add(int index, int number) {
        if (index < 0 || index > numElements) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

     }

   
    /**
     * Returns the number of integers in the bag (array)
     *
     * @return size of the bag
     */
    public int size() {
        
    }

    /**
     * Set the number at a specified index (replace old value)
     *
     * @param index
     * @param number
     * @return previous value in the index position
     * @throws IndexOutOfBoundsException if index < 0 or index >= numElements
     */
    public int set(int index, int number) throws IndexOutOfBoundsException {
        if (index < 0 || index >= numElements){
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
    }

    /**
     * Get the number at the specified index position
     *
     * @param index
     * @return number at the specified index
     * @throws IndexOutOfBoundsException if index < 0 or index >= size()
     */
    public int get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= numElements){
            throw new IndexOutOfBoundsException("Invalid index");
        }

     }

    /**
     * Remove and return the number at the specified index position.
     * shift left the numbers at positions higher than index
     *
     * @param index
     * @return the number at specified index
     * @throws IndexOutOfBoundsException if index < 0 or index >= size()
     */
    public int remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        
    }



    /**
     * Remove and return the number at the end of the bag(array)
     * multiple removes may leave the bag almost empty
     * if a remove causes numElements < bag.length/4 shrink bag in half
     *
     * @return
     * @throws Exception if numElements == 0
     */
    public int remove() throws Exception {
        if (numElements == 0) {
            throw new Exception("Nothing to remove. Bag is empty");
        }

    }

    
    public String toString() {
        String result = "";

        result += "[";
        for (int i = 0; i < numElements; i++) {
            if (i > 0) result += ", ";
            result += (bag[i] == null ? "" : bag[i]);
        }
        result += "]";
        return result;
    }

    public static void main(String[] args) throws Exception {
        ResizableIntegerBag integerBag = new ResizableIntegerBag();

        //testing add methods
        integerBag.add(5);
        integerBag.add(23);
        integerBag.add(15);
        System.out.println("Bag of " + integerBag.size() + " numbers:  " + integerBag);


        assert integerBag.size() == 3;
        integerBag.add(2, 14);
        integerBag.add(1, 20);
        System.out.println("Bag of " + integerBag.size() + " numbers:  " + integerBag);
        assert integerBag.size() == 5;

        //testing get method
        System.out.println("Number at position 0 = "+ integerBag.get(0));
        assert integerBag.get(0) == 5;
        assert integerBag.size() == 5;

        //testing set method
        int oldVal = integerBag.set(0, 17);
        System.out.println("Old value at index 0 after replacing it with 17 = " +
                            oldVal);
        assert oldVal == 5;
        System.out.println("Bag of " + integerBag.size() + " numbers:  " + integerBag);
        System.out.println("Number of tests passed: 5");

        //testing remove(index) method
        int removedVal = integerBag.remove(0);
        System.out.println("Removed number at position 0 = " + removedVal);
        System.out.println("Bag of " + integerBag.size() + " numbers:  " + integerBag);
        assert removedVal == 17;
        assert integerBag.size() == 4;

        removedVal = integerBag.remove(2);
        System.out.println("Removed number at position 2 = " + removedVal);
        System.out.println("Bag of " + integerBag.size() + " numbers:  " + integerBag);
        assert removedVal == 14;
        assert integerBag.size() == 3;


        removedVal = integerBag.remove(2);
        System.out.println("Removed number at position 2 = " + removedVal);
        System.out.println("Bag of " + integerBag.size() + " numbers:  " + integerBag);
        assert removedVal == 15;
        assert integerBag.size() == 2;
        assert integerBag.bag.length == 8;

        //testing remove() method
        removedVal = integerBag.remove();
        System.out.println("Removed number at end = " + removedVal);
        System.out.println("Bag of " + integerBag.size() + " numbers:  " + integerBag);
        assert removedVal == 23;
        assert integerBag.size() == 1;
        System.out.println(Arrays.toString(integerBag.bag));
        assert integerBag.bag.length == 4;
        removedVal = integerBag.remove();
        System.out.println("Removed numbere at end = " + removedVal);
        System.out.println("Bag of " + integerBag.size() + " numbers:  " + integerBag);
        assert removedVal == 20;
        assert integerBag.size() == 0;
        assert integerBag.bag.length == 2;
        System.out.println("Number of tests passed: 18");
        try{
            integerBag.remove();
            assert false;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            assert true;
        }
        integerBag.add(-37);
        integerBag.add(29);
        integerBag.add(-3);
        System.out.println("Bag of " + integerBag.size() + " numbers:  " + integerBag);
        assert integerBag.size() == 3;

        assert integerBag.bag.length == 4;
        System.out.println("Number of tests passed 21");
    }
}
/*ouput
Bag of 3 numbers:  [5, 23, 15]
Bag of 5 numbers:  [5, 20, 23, 14, 15]
Number at position 0 = 5
Old value at index 0 after replacing it with 17 = 5
Bag of 5 numbers:  [17, 20, 23, 14, 15]
Number of tests passed: 5
Removed number at position 0 = 17
Bag of 4 numbers:  [20, 23, 14, 15]
Removed number at position 2 = 14
Bag of 3 numbers:  [20, 23, 15]
Removed number at position 2 = 15
Bag of 2 numbers:  [20, 23]
Removed number at end = 23
Bag of 1 numbers:  [20]
[20, null, null, null]
Removed numbere at end = 20
Bag of 0 numbers:  []
Number of tests passed: 18
Nothing to remove. Bag is empty
Bag of 3 numbers:  [-37, 29, -3]
Number of tests passed 21

 */