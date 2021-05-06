package model;

import java.text.DecimalFormat;

public class Cube extends TreeDShape implements Comparable<Cube>{
    private final int faces=6;

    public Cube(int side) {
        super(side);
    }

    @Override
    public double calculateArea() {
        return faces*(side*side);
    }

    public int getFaces() {
        return faces;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder("Cube:");
        stringBuilder.append(" faces=").append(faces).append(", side=").append(side).append(", area= ")
                .append((int)calculateArea()).append(": ");
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Cube o) {
        return (int)(this.calculateArea()-o.calculateArea());
    }
}
