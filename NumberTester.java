import java.util.Iterator;

public class NumberTester
{
    public static void main(String[] args)
    {
        System.out.println("testNumber() = " + testNumber());
        System.out.println("testIsZero() = " + testIsZero());
        System.out.println("testBitIterator() = " + testBitIterator());
        System.out.println("testIncrement() = " + testIncrement());
        System.out.println("testIsLegal() = " + testIsLegal());
        System.out.println("testEquals() = " + testEquals());
        System.out.println("testToString() = " + testToString());
        System.out.println("testLessEq() = " + testLessEq());
        System.out.println("testLessThan() = " + testLessThan());
        System.out.println("testCompareTo() = " + testCompareTo());
        System.out.println("testAdd() = " + testAdd());
        System.out.println("testMultiply() = " + testMultiply());
    }


    public static boolean testNumber(){


        Number num1=new Number();return true;
    }


    public static boolean testIsZero(){
        Number num1=new Number(10);

        Number num2=new Number("0");
        Number num3=new Number(0);
        return(!num1.isZero()&num2.isZero()&num3.isZero());

    }

    public static boolean testBitIterator(){
            Number num1=new Number(10);
            String s="0101",s1="";
            boolean output=false;
        Iterator<Bit> Built=num1.bitIterator();
            while(Built.hasNext()) {
                if (Built.next().getValue())
                    s1=s1+ "1";
                else
                    s1=s1+ "0";
            }
            return (s.equals(s1));


            }



    public static boolean testIncrement(){
        Number num = new Number();
        String S="10";

        for(int i=0;i<3;i=i+1)
            num.increment();

        return S.equals(num.toString());
    }


    public static boolean testIsLegal(){
        String a="6",B="%",C="000",D="123^#";
        Number NUM1=new Number();
        return (NUM1.isLegal(a)&!NUM1.isLegal(B)&!NUM1.isLegal(C)&!NUM1.isLegal(D));
    }


    public static boolean testEquals(){
        Number num1= new Number(100);
        Number num2= new Number("101");
        Number num3=new Number(10);
        num1.increment();
        String s="100";
        return (num2.equals(num1)&!num1.equals(s)&!num2.equals(num3));

    }

    public static boolean testToString(){
       Number A = new Number(29);
       Number B = new Number();
       Number C= new Number("11131");
       String s=A.toString(),S1=B.toString(),S2= C.toString();
       return (s.equals("11101")&S2.equals("10101101111011")&!S1.equals("10"));
    }


    public static boolean testLessEq(){
        Number N1=new Number(29);
        Number N2=new Number("29");
        Number N3=new Number(28);
        return(N1.lessEq(N1,N2)&N2.lessEq(N2,N1)&N2.lessEq(N3,N2)&!N2.lessEq(N2,N3));
    }


    public static boolean testLessThan(){
        Number N1=new Number(29);
        Number N2=new Number("29");
        Number N3=new Number(10);
        return(N2.lessThan(N3,N2)&!N1.lessThan(N1,N2)&!N2.lessThan(N2,N1)&N1.lessThan(N2,N3));
        //
    }


    public static boolean testCompareTo(){
        return true;

    }


    public static boolean testAdd(){
        Number N1= new Number(13);
        Number N2= new Number(5);
        Number N3= new Number();
       return( N3.add(N1,N2).toString().equals("10010"));



    }

    public static boolean testMultiply() {
        return true;
    }
}
