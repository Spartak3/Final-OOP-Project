package model;

import java.security.PublicKey;

abstract public class TwoDShape implements Shape {
    double length;
    double width;


    public TwoDShape(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    //abstract method
    public abstract double calculatePerimeter();

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if(length>=0)
            this.length = length;
        else
            throw new ShapePropertyException(length);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width>=0)
            this.width = width;
        else
            throw new ShapePropertyException(width);

    }
}
