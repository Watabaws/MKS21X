public class trngl{
    private Point v1, v2, v3;
    private double dis1, dis2, dis3;

    /**
    *Define the unit triangle, with points (0,0), (0,1), and (1,1).
    */
    public trngl(){
        v1 = new Point(0,0);
        v2 = new Point(0,1);
        v3 = new Point(1,1);
        //For the purposes of this code, the "default" "triangle" will be a triangle on the unit circle. Any incorrect values inputted will lead to the default triangle being created.

        dis1 = v1.distance(v2);
        dis2 = v2.distance(v3);
        dis3 = v3.distance(v1);
    }

    /**
    *Define a new triangle given three points (stored in v1, v2 and v3).
    *Also assign the distance between the points (aka the sides) to three instance variables.
    *If the triangle is not a valid triangle, automatically transform it into the unit triangle (the default triangle).
    *@param a is the first point
    *@param b is the second point
    *@param c is the third point
    */

    public Triangle(Point a, Point b, Point c){
        //We don't want to just set the new value equal to the old - this won't be making a "copy" of the value, it would be having several names for the same address. To work around this issue, we simply create a new class that bases itself off the value of the old.
        v1 = new Point(a.getX(), a.getY());
        v2 = new Point(b.getX(), b.getY());
        v3 = new Point(c.getX(), c.getY());

        //QOL Variables <3
        dis1 = v1.distance(v2);
        dis2 = v2.distance(v3);
        dis3 = v3.distance(v1);



        if (dis1 == 0.0 || dis2 == 0.0 || dis3 == 0.0){
            v1 = new Point(0,0);
            v2 = new Point(0,1);
            v3 = new Point(1,1);
            System.out.println("Invalid Triangle");
            dis1 = v1.distance(v2);
            dis2 = v2.distance(v3);
            dis3 = v3.distance(v1);
        }
    }

    /**
    *Define a new triangle given the x and y coordinates seperately (stored in v1, v2 and v3)
    *Also assign the distance between the points (aka the sides) to three instance variables.
    *If the triangle is not a valid triangle, automatically transform it into the unit triangle (the default triangle).
    *@param x1 is the x coordinate of the first point
    *@param y1 is the y coordinate of the first point
    *@param x2 is the x coordinate of the second point
    *@param y2 is the y coordinate of the second point
    *@param x3 is the x coordinate of the third point
    *@param y3 is the y coordinate of the third point
    */

    public Triangle(double x1,double y1,double x2,double y2,double x3,double y3){
        v1 = new Point(x1, y1);
        v2 = new Point(x2, y2);
        v3 = new Point(x3, y3);

        dis1 = v1.distance(v2);
        dis2 = v2.distance(v3);
        dis3 = v3.distance(v1);

        if (dis1 == 0.0 || dis2 == 0.0 || dis3 == 0.0){
            v1 = new Point(0,0);
            v2 = new Point(0,1);
            v3 = new Point(1,1);
            System.out.println("Invalid Triangle");
            dis1 = v1.distance(v2);
            dis2 = v2.distance(v3);
            dis3 = v3.distance(v1);
        }
    }

    //format: "Triangle @ (1,1) (3,2) (5,6)"
    /**
    *Print out the triangle and the location of its points.
    */
    public String toString(){
        return ("Triangle @ (" + v1.getX() + "," + v1.getY() + ")" + " (" +
                                            v2.getX() + "," + v2.getY() + ")" + " (" +
                                            v3.getX() + "," + v3.getY() + ")");
    }

    /**
    *A useful function that automatically squares an input
    *@param b (base) is the number that is being squared
    */

    public double square(double b){
        return Math.pow(b, 2);
    }

    /**
    *getPerimeter works on a Triangle class and returns the sum of its sides -- it's perimeter.
    */

    public double getPerimeter(){
        return (dis1 + dis2 + dis3);
    }

    /**
    *getArea works on a triangle and returns the area of the triangle based on its sides -- using Heron's Formula.
    */
    public double getArea(){
        //Heron's Formula says that the area of a triange can be found by *insert explanation*. We can already acquire the perimeter of the triangle, divide that by two and you have the semi perimeter. The distances between each side are already recorded in each variable, so it's just a matter of doing the math!
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - dis1) * (s - dis2) * (s - dis3));
    }

    //do not use == to check if doubles are the same, because of rounding errors + irrational numbers.
    //Instead write a function to check if values are very close together.

    /**
    *isCloseEnough is essentially an '==' for floats. Due to errors in binary calculation, it is necessary to have a function that detects if two floats are extremely close to each other.
    */
    public boolean isCloseEnough(double a,double b){
        //The percent difference is equal to the difference of the two values divided by the average of the two. The smaller the percentage, the closer the values are together. In this function, I assign the percent difference to a variable after calculating it. Then I check if the percent difference is less than .000001 (.0001 percent). For reference, 100000000 and 100000001 are .000000999999995% apart and 1 and 2 are .666666666666667 apart.
        double percDif;
        percDif = Math.abs((a - b)) / ((a + b) / 2);
        return percDif < .000001;
    }

    //helper function for isRight, assume that ab is the longest side
    /**
    *pycheck takes in 3 sides and then determines if it is a pythagorean (right) triangle, using the Pythagorean Theorem. In this function, the largest side is assumed to be the first one.
    *@param a is the longest side
    *@param b and c are the other sides of the triangle.
    */
    private boolean pycheck(double a, double b, double c){
        return isCloseEnough(square(a), (square(b) + square(c)));
    }

    /**
    *pycheck not given any inputs will automatically work upon the triangle its referencing and use it's instances of distance/sides.
    */
    private boolean pycheck(){
        //System.out.println((square(dis2) + square(dis1)));
        //System.out.println(square(dis3));
        return isCloseEnough(square(dis1), ((square(dis2) + square(dis3))));
    }

    //It is suggested that you use pycheck
    //Return true when the triangle is a right triangle, false otherwise.

    /**
    *isRight is a more in depth version of pycheck, checking if any combinations of sides works - using pycheck but switching the order of the parameters.
    */
    public boolean isRight(){
        return (pycheck(dis1, dis2, dis3) || pycheck(dis2, dis1, dis3) || pycheck(dis3, dis1, dis2));
    }
    /*
    public static String testTri(Triangle test){
        return test + "\n" + "Perimeter: " + test.getPerimeter() +"\n Area: " + test.getArea() + "\n isRight? " + test.isRight();
    }

    public static void main(String[]args){
        Point p1, p2, p3;
        p1 = new Point(0,0);
        p2 = new Point(0,3);
        p3 = new Point(4,3);

        //System.out.println(p1);
        //System.out.println(p2);
        //System.out.println(p3);

        Triangle juan = new Triangle(p1, p2, p3);

        System.out.println(testTri(juan));

        /////////////////////////////////////////////

        System.out.println("\n");

        Triangle dos = new Triangle(0,0, 5,4, 3,1);

        System.out.println(testTri(dos));

        /////////////////////////////////////////////

        System.out.println("\n");

        Triangle bad = new Triangle(0,0, 0,0, 0,0);

        System.out.println(testTri(bad));

        System.out.println("\n");

        //Should be the same as:

        Triangle unit = new Triangle();

        System.out.println(testTri(unit));

    }
    */
}
