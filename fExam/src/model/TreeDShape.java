package model;

abstract public class TreeDShape implements Shape {
    protected double length;
    protected double width;
    protected double depth;
    protected int side;

    public TreeDShape(int side) {
        setSide(side);
    }



    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if(length>=0)
            this.length = length;
        else
            throw new ShapePropertyException();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width>=0)
            this.width = width;
        else
            throw new ShapePropertyException();
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        if(depth>=0)
            this.depth = depth;
        else
            throw new ShapePropertyException();

    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        if(side>=0)
            this.side = side;
        else
            throw new ShapePropertyException();

    }
}
