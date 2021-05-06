package model;

import java.text.DecimalFormat;

public class Parallelogram extends TwoDShape implements Comparable<Parallelogram>{
    private int height;


    public Parallelogram(double length, double width,int height) {
        super(length, width);
        setHeight(height);
    }


    @Override
    public double calculateArea() {
        return length*height;

    }

    @Override
    public double calculatePerimeter() {
        return (2*length)+(2*width);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height>=0)
            this.height = height;
        else
            throw new ShapePropertyException(height);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder("Parallelogram:");
        stringBuilder.append(" length=").append(length).append(", width=").append(width).append(", height=").append(height)
        .append(", area= ").append(new DecimalFormat("#0").format(calculateArea()))
                .append(", perimeter= ").append(calculatePerimeter()).append(": ");
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Parallelogram o) {
        return (int)(this.calculateArea()-o.calculateArea());
    }
}
