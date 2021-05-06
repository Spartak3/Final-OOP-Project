package model;

import java.text.DecimalFormat;

public class Cone extends TreeDShape implements Comparable<Cone>{
    private int radius;


    public Cone(int side, int radius) {
        super(side);
        setRadius(radius);
    }



    @Override
    public double calculateArea() {
        return Math.PI*radius*side;
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if(radius>=0&&radius<90)
            this.radius = radius;
        else
            throw new ShapePropertyException();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder("Cone:");
        stringBuilder.append(" side=").append(side).append(", radius=").append(radius).append(", area= ")
                .append((int)calculateArea()).append(": ");
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Cone o) {
        return (int)(this.calculateArea()-o.calculateArea());
    }
}
