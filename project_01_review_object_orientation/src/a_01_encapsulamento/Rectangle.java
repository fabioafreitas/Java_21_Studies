package a_01_encapsulamento;

public class Rectangle {
    private double length;
    private double width;
    private double area;
    private double perimeter;
    private boolean isSquare;

    // overloading methods, in this case, the constructor

    public Rectangle(double length, double width) throws IllegalArgumentException{
        if(length <= 0 || width <= 0) {
            throw new IllegalArgumentException("length and width should be greatar than zero");
        }
        this.length = length;
        this.width = width;
        this.evalParams();
    }

    public Rectangle(double side) {
        if(side <= 0) {
            throw new IllegalArgumentException("side should be greatar than zero");
        }
        this.length = side;
        this.width = side;
        this.evalParams();
    }

    // encapsulated methods

    private void evalParams() {
        this.area = this.width*this.length;
        this.perimeter = 2*(this.width+this.length);
        this.isSquare = this.width == this.length ? true : false;
    }

    // getters

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    public double getArea() {
        return this.area;
    }

    public double getPerimeter() {
        return this.perimeter;
    }

    public boolean isSquare() {
        return this.isSquare;
    }

    public void setLength(double length) throws IllegalArgumentException{
        if(length <= 0) {
            throw new IllegalArgumentException("length should be greatar than zero");
        }
        this.length = length;
        this.evalParams();
    }

    public void setWidth(double width) throws IllegalArgumentException{
        if(width <= 0) {
            throw new IllegalArgumentException("width should be greatar than zero");
        }
        this.width = width;
        this.evalParams();
    }
}
