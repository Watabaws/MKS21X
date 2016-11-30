public class HomeworkTest {

       public static double celsiusToFarenheit(double temp){
           return (((temp * 9.0) / 5) + 32);
       }

       public static double farenheitToCelsius(double temp){
           return (((temp - 32) * 5.0) / 9);
       }

       public static void main(String[]aaaaargs){
           System.out.println(celsiusToFarenheit(23));
           System.out.println(celsiusToFarenheit(10.2));
           System.out.println(farenheitToCelsius(70));
           System.out.println(farenheitToCelsius(32.4));
       }
 }
