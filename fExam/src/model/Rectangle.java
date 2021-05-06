package model;

import java.text.DecimalFormat;

public class Rectangle extends TwoDShape implements Comparable<Rectangle>{

    public Rectangle(double length, double width) {
        super(length, width);

    }

    @Override
    public double calculateArea() {
        return length*width;
    }

    @Override
    public double calculatePerimeter() {
        return (2*length)+(2*width);
    }

    @Override
    public int compareTo(Rectangle o) {
        return (int)((this.length+this.length)-(o.length+o.width));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder("Rectangle:");
        stringBuilder.append(" length=").append(length).append(", width=").append(width).append(", area=")
        .append(new DecimalFormat("#0").format(calculateArea())).append(", perimeter= ").
                append(calculatePerimeter()).append(": ");
        return stringBuilder.toString();
    }
}
