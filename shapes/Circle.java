public class Circle extends Shape{
    double radius;

    public Circle(){
        radius = 1.0;
    }

    public Circle(double rad){
        radius = rad;
    }

    public void setRadius(double rad){
        if(rad>= 0){
            radius = rad;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double getPerimeter(){
        return Math.PI * (radius*2);
    }

    public String toString(){
        return "A Circle with radius= " + radius + ", which is a subclass of " + super.toString();
    }
}
