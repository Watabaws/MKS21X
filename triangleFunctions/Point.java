public class Point {
    public double x = 0;
    public double y = 0;

    public Point(){
    }

    public Point(double x, double y) {
        setX(x);
        setY(y);
    }

    // accessor methods
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public double distance(Point other){
        return Math.sqrt(Math.pow(x - other.x, 2) +
                         Math.pow(y - other.y, 2));
    }
    public String toString(){
        return "(" + getX() + "," + getY() + ")";
    }

    public static void main(String[]args){
        Point a = new Point(0,7);
        Point b = new Point(0,0);
        System.out.println(a.distance(b));

        Point c = new Point(0,0);
        Point d = new Point(1,1);
        System.out.println(c.distance(d));
        //Just checkin :)
        //System.out.println(Math.sqrt(2));

        Point e = new Point(4,3);
        Point f = new Point(0,0);
        System.out.println(e.distance(f));

        System.out.println(e);
    }
}
