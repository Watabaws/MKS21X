public class Tester{

    public static String testMethods(String phrase){
        String results;

        results = "String: " + phrase + "\n\n";

        results += "The length of this string is: ";
        results += phrase.length() + "\n\n";

        results += "This statement contains the letter H: ";
        results += Boolean.valueOf(phrase.contains("H")) + "\n";

        results += "^ used valueOf to print a Boolean! \n\n";

        results += "This statement as a lowercase: ";
        results += phrase.toLowerCase() + "\n\n";

        results += "The substring of this string beginning at the fifth index is: ";
        results += phrase.substring(5) + "\n";



        results += "========================================================================";

        return results;
    }

    public static void main(String[]args){
        String testString1 = "Hello how are you?";
        String testString2 = "                   ";
        String testString3 = "HiHello";
        String testString4 = "C@$H M0N3Y";

        System.out.println(testMethods(testString1));
        System.out.println(testMethods(testString2));
        System.out.println(testMethods(testString3));
        System.out.println(testMethods(testString4));

    }
}
