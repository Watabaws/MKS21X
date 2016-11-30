public abstract class Shape{
    public abstract double getArea();
    public abstract double getPerimeter();

    public double getSemiPerimeter(){
        return getPerimeter()/2;
    }

    public String toString(){
        return "Shape";
    }
}
