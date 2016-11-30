public class Square extends Rectangle{
    double width, length;

    public Square(){
        super();
    }

    public Square(double side){
        width = side;
        length = side;
    }

    public void setWidth(double side){
        super.setWidth(side);
        super.setLength(side);
    }

    public void setLength(double side){
        super.setWidth(side);
        super.setLength(side);
    }

    public String toString(){
        return "A Square with side= " + length + ", which is a subclass of " + super.toString();
    }
}
