package model;

public class ShapePropertyException  extends RuntimeException{
    public ShapePropertyException(double num) {
        System.out.printf("Shape can't have %d parameter",num);
        System.out.println();
    }

    public ShapePropertyException() {
    }
}
