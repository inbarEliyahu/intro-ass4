

import com.sun.javafx.image.BytePixelSetter;

import java.util.Iterator;



public class Number implements Comparable<Number> {
    private static final int BASE = 2;
    private static final Bit FALSE=new Bit(false);
    private static final Bit TRUE=new Bit(true);
    private static final Number ONE = new Number(1);
    private static final Number ZERO = new Number();
    private List<Bit> list;

    /**
     * Constructs a new Number defaulted to the value zero.
     */

    public Number(){
        list = new LinkedList<Bit>();
        list.add(FALSE);
    }
    /**
     * Constructs a new Number from an int.
     * @param number an int representing a decimal number
     */
    public Number(int number){  // assignment #2
       if(number<0)
           throw new IllegalArgumentException("only natural numbers are Interchangeable ");
       boolean one_time_0=false;
       list = new LinkedList<Bit>();
       if (number==0)
           this.list.add(FALSE);
       int counter=0;
       while(number>0&!one_time_0) {
           if (number == 0)
               one_time_0 = true;
           if (number % BASE == 1) {
               this.list.add(counter,TRUE);
               counter=counter+1;
           }
           else{
               this.list.add(counter,FALSE);
               counter=counter+1;
           }
            number = number / BASE;
       }

    }


        /**
     * Constructs a new Number from a String.
     * @param s a String (possibly) representing a decimal number.
     */
    public Number(String s) {// assignment #2
        if (!isLegal(s))
            throw new IllegalArgumentException("only natural numbers are Interchangeable ");
        list = new LinkedList<Bit>();
        int value, location = 1, number = 0;
        for (int i = s.length() - 1; i >=0; i = i - 1, location = location * 10) {
            value = s.charAt(i) - '0';
            number = number + (value * location);
        }
        if (number==0)
            list.add(FALSE);
        else {
            boolean one_time_0=false;
            int counter=0;
            while (number > 0 & !one_time_0) {
                if (number == 0)
                    one_time_0 = true;
                if (number % BASE == 1) {
                    this.list.add(counter,TRUE);
                    counter=counter+1;
                } else {
                    this.list.add(FALSE);
                    counter=counter+1;
                }
                number = number / BASE;
            }
        }
    }
    /**
     * Constructs a new Number which is a deep copy of the provided Number.
     * @param number a Number to be copied
     *               **/
    public Number(Number number){ // assignment #3
        Number new_num=new Number(number);
            }

    /**
     * Checks if this Number is zero.
     * @return true if and only if this object representing the number zero.
     */
    public boolean isZero(){ // assignment #4
       boolean output;
        if (this.list.isEmpty()|this.list.size()>1)
           output=false;
        else
            if (!this.list.get(0).getValue())
                output=true;
            else
                output=false;

return output;
    }
        /**
     * Returns an iterator over the Bit objects in the representation of this number,
     * which iterates over the Bit objects from LSB (first) to MSB (last).
     * @return a LSB-first iterator over the Bit objects in the representation of this number.
     */
    public Iterator<Bit> bitIterator(){ // assignment #5
        Iterator<Bit> bitIterator = list.iterator();
        return bitIterator;

    }

    /**
     * Adds 1 to the number
     */
    public void increment(){ // assignment #6
    boolean out=false;
    int counter=0;
    Iterator<Bit> Search=this.bitIterator();
        while(Search.hasNext()&!out) {
            if (!Search.next().getValue()) {
                this.list.set(counter, TRUE);
                counter = counter + 1;
                out = true;

            } else {
                this.list.set(counter, FALSE);
                counter=counter+1;
            if(!Search.hasNext())
                this.list.add(counter,TRUE);
        }}
    }
    /**
     * Checks if a provided String represent a legal decimal number.
     * @param s a String that possibly represents a decimal number, whose legality to be checked.
     * @return true if and only if the provided String is a legal decimal number
     */
    public static boolean isLegal(String s){ // assignment #7
            boolean output;
        if (s.isEmpty())
            output = false;
        else
            if (s.length() >1 & (s.charAt(0) <'1'|s.charAt(0)>'9'))
            output = false;
            else {
                output = true;
                for (int i = 0; i < s.length() & output; i = i + 1) {
                    if ('0' > s.charAt(i)|s.charAt(i) > '9')
                        output = false;
                }
            }
        return output;


    }
    /**
     * Compares the specified object with this Number for equality.
     * Returns true if and only if the specified object is also a
     * Number (object) which represents the same number.
     * @param obj he object to be compared for equality with this Number
     * @return true if and only if the specified object is equal to this object
     */
    public boolean equals(Object obj){ // assignment #8
        boolean output= true;
        if(obj instanceof Number){
            Number number = (Number) obj;
            Iterator<Bit> surch= this.bitIterator();
            Iterator<Bit> surch1= number.bitIterator();
            if(number.list.size()!=this.list.size())
                output=false;
            else{
                while(output&surch.hasNext()){
                    if(surch.next()!=surch1.next())
                        output=false;

                }
            }
        }
        else
            output=false;
        return output;
    }
    /**
     * Returns a string representation of this Number
     * as a binary number.
     * @return a string representation of this Number
     */
    public String toString(){ // assignment #9
         if(this==null)
             throw new IllegalArgumentException("invalid input ");
    String output = "";
    int size=0;
    Iterator<Bit> count=this.bitIterator();
    while (count.hasNext()){size=size+1;count.next();}
    for (int i = size- 1; 0 <= i; i = i - 1) {
        if (!this.list.get(i).getValue())
            output = output + "0";
        else
            output = output + "1";

    }
    return output;
    }
    /**
     * Compares the two provided numbers, and returns true if
     * the first parameter is less than or equal to the second
     * parameter, as numbers.
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if and only if the first number is less than
     * or equal to the second parameter, as numbers.
     */
    public static boolean lessEq(Number num1, Number num2){ // assignment #10
        if(num1==null|num2==null)
            throw new IllegalArgumentException("invalid input ");
        boolean output=true;
        Iterator<Bit> search1 = num1.bitIterator();
        Iterator<Bit> search2 = num2.bitIterator();
        while(search1.hasNext()&search2.hasNext()&output){
            if(!search1.next().lessEq(search2.next()))
                output= false;
            }
       return output;
    }

    /**
     * Compares the two provided numbers, and returns true if
     * the first parameter is strictly less than the second
     * parameter, as numbers.
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if and only if the first number is strictly
     * less than the second parameter, as numbers.
     */
    public static boolean lessThan(Number num1, Number num2){ // assignment #11
        if(num1==null|num2==null)
            throw new IllegalArgumentException("invalid input ");
        Iterator<Bit> search1 = num1.bitIterator();
        Iterator<Bit> search2 = num2.bitIterator();
        while(search1.hasNext()&search2.hasNext()){
            if(search1.next().lessThan(search2.next()))
                return true;
            }
        boolean output=false;
        return output;
    }
    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Number o){ // assignment #12
        int output=0;
        if(lessEq(this,o)&!lessThan(this,o))
            output= 0;
        else {
            if (lessThan(this, o))
                output = -1;
            else if (!lessThan(this, o))
                output = 1;
        }

        return output;
    }
    /**
     * Adds the specified Number objects, and returns their sum.
     * @param num1 the first addend
     * @param num2 the second addend
     * @return the sum of the specified Number objects.
     */
    public static Number add(Number num1, Number num2) {// assignment #13
        if(num1==null|num2==null)
            throw new IllegalArgumentException("invalid input ");
        Number output=new Number();
        Iterator<Bit> index1=num1.bitIterator();
        Iterator<Bit> index2=num2.bitIterator();
        Bit B,A,Cin = FALSE;
int counter=0;
        while(index1.hasNext()|index2.hasNext()|Cin.equals(TRUE)) {
            if(index1.hasNext()){
                A = index1.next();
            }
            else
                A=FALSE;
            if(index2.hasNext()){

                B = index2.next();}
            else
                B=FALSE;
            if (TRUE.fullAdderSum(A, B, Cin).equals(TRUE))
                output.list.set(counter,TRUE);
            else
                output.list.set(counter,FALSE);
            if(B!=FALSE&A!=FALSE&Cin.equals(TRUE))
                Cin=FALSE;

            if (TRUE.fullAdderCarry(A, B, Cin).equals(TRUE))
                Cin=TRUE;
            counter=counter+1;
            if(index1.hasNext()|index2.hasNext())
                output.list.add(counter,FALSE);
            else
                if(Cin.equals(TRUE)){
                    output.list.add(counter,TRUE);
                    Cin=FALSE;}
        }

            return output;

    }

    /**
     * Multiply the specified Number objects, and returns their product.
     * @param num1 the first factor
     * @param num2 the second factor
     * @return the product of the specified Number objects.
     */
    public static Number multiply(Number num1, Number num2){ // assignment #14
        if(num1==null|num2==null)
            throw new IllegalArgumentException("invalid input ");
        Number output=new Number();
        Number sum1;
        Iterator<Bit> index2=num2.bitIterator();
        while(index2.hasNext()) {
            sum1 = PartOfMultiply(num1, index2.next());
            output = add(output, sum1);
        }
        return output;

    }
    private static Number PartOfMultiply(Number num1, Bit num2){
    Number output=new Number();
    int temp1,temp2=num2.toInt(),sum;
    Iterator<Bit> index1=num1.bitIterator();
        while(index1.hasNext()) {
        if (index1.next().getValue())
            temp1 = 1;
        else
            temp1 = 0;
        sum = temp1 * temp2 ;
        if (sum == 1)
            output.list.add(TRUE);
        else
            output.list.add(FALSE);

    }
    return output;
}
}