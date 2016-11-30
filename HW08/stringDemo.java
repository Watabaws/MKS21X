public class stringDemo{
    public static void main(String[]args){
        System.out.println("Hello".charAt(3));
        //System.out.println("Hello".charAt(7));
        //Runtime Error: Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 7

        System.out.println("Hello".length());
        //Compile Error: stringDemo.java:5: error: method length in class String cannot be applied to given types;
        //An error obtained when you give .length() a parameter. It's an easy to find mistake, as you know it's an error with length. If this error is ever encountered, look to make sure all instances of .length() have empty parenthses.

        System.out.println("Jello".equals("jello"));
        System.out.println("Jello".equals("Jello"));
        String a = new String("Jello");
        System.out.println("Jello".equals(a));
        //System.out.println(5.equals("Jello"));
        //stringDemo.java:14: error: malformed floating point literal
        //An error when a String method is applied to an integer/float. Generally, if there isn't a pair of quotes before a method, that's where the error is. The fix is simply to either make the integer a string or use a valid string.

        System.out.println("Hello".compareTo("hello"));
        System.out.println("Hello".compareTo("Hello"));
        System.out.println("Hello".compareTo(" Hello"));
        //System.out.println(true.compareTo("Hello"));
        //stringDemo.java:22: error: boolean cannot be dereferenced
        //An error that occurs when a string method is applied to a boolean. Similar issue to what happens when applied to an int- however the data type is a boolean. Make sure to either use quotes or a valid String in place of it

        System.out.println("Hello".indexOf('e'));
        System.out.println("H3llo".indexOf(3));

        System.out.println("The other day I went to the store".substring(14,23));
        //System.out.println("The other day I went to the store".substring(14,10));
        /*Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: -4
        at java.lang.String.substring(String.java:1911)*/
        //Error that occurs when either: The first index in substring is greater than the second, or the second is less than the first.


        System.out.println("Hello my name is Jim".substring(6));

    }
}
