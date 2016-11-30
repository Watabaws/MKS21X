public class Driver{

    public static String testTri(Triangle test){
        return test + "\n" + "Perimeter: " + test.getPerimeter() +"\n Area: " + test.getArea() + "\n isRight? " + test.isRight();
    }

    public static void main(String[]args){
        Point p1, p3, p4;
        Triangle p2;
        p1 = new Point(0,0);
        p2 = new Triangle(0,3);
        p3 = new Point(4,3);
        p4 = p1;

        System.out.println(p1 == p2);
        System.out.println(p4 == p1);
/*
        //System.out.println(p1);
        //System.out.println(p2);
        //System.out.println(p3);

        Triangle juan = new Triangle(p1, p2, p3);

        System.out.println(testTri(juan));

        System.out.println("\n");


        Triangle dos = new Triangle(0,0, 5,4, 3,1);

        System.out.println(testTri(dos));

        System.out.println("\n");


        Triangle bad = new Triangle(0,0, 0,0, 0,0);

        System.out.println(testTri(bad));

        System.out.println("\n");


        Triangle unit = new Triangle();

        System.out.println(testTri(unit));

        System.out.println("\n");


        Triangle negative = new Triangle(-1,-2, 8,7, -10,8);

        System.out.println(testTri(negative));

        System.out.println("\n");
*/
    }
}
