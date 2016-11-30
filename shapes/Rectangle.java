public class Rectangle extends Shape{
    double width,length;

    public Rectangle(){
        width = 1.0;
        length = 1.0;
    }

    public Rectangle(double wid, double len){
        width = wid;
        len = length;
    }

    public void setLength(double len){
        if(len>= 0){
            length = len;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public void setWidth(double wid){
        if(wid>= 0){
            width = wid;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public double getLength(){
        return length;
    }

    public double getWidth(){
        return width;
    }

    public double getArea(){
        return length * width;
    }

    public double getPerimeter(){
        return length * 2 + width * 2;
    }

    public String toString(){
        return "A rectangle with width= " + width + " and length= " + length + ", which is a subclass of " + super.toString();
    }

}
