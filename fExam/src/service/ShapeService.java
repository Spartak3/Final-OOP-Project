package service;

import model.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShapeService {









    //2 method Print the shape with max area
    public static void printTheShapeWithMaxArea(List<Shape> shapes) {
        Shape maxAreaShape = shapes.get(0);
        double area = maxAreaShape.calculateArea();
        for (int i = 1; i < shapes.size(); i++) {
            if (shapes.get(i).calculateArea() > area) {
                maxAreaShape = shapes.get(i);
                area=maxAreaShape.calculateArea();
            }
        }
        System.out.println("<<------------------------------------->>");
        System.out.printf("Max area have the %s: , area= %d \n", shapeName(maxAreaShape),(int)maxAreaShape.calculateArea());
        System.out.println("<<------------------------------------->>");
        System.out.println(maxAreaShape);
        System.out.println("<<------------------------------------->>");
    }


    public static String shapeName(Shape shape) {
        if (shape instanceof Cube) {
            return "Cube";
        } else if (shape instanceof Cone) {
            return "Cone";
        } else if (shape instanceof Rectangle) {
            return "Rectangle";
        } else {
            return "Parallelogram";
        }
    }

    //3 method Print the TwoDShape with max perimeter
    public static void printTheTwoDShapeWithMaxPerimeter(List<TwoDShape> twoDShapes) {
        TwoDShape maxShape = twoDShapes.get(0);
        double maxPerimeter = maxShape.calculatePerimeter();
        for (int i = 1; i < twoDShapes.size(); i++) {
            if (twoDShapes.get(i).calculatePerimeter() > maxPerimeter) {
                maxShape = twoDShapes.get(i);
            }
        }
        System.out.println("<<------------------------------------->>");
        System.out.printf("The max perimeter with %d \n",(int)maxShape.calculatePerimeter());
        System.out.println(maxShape);
        System.out.println("<<------------------------------------->>");

    }


    //4 method Find shapes which have more than x area (x= any number you wish)
    public static List<Shape> findShapesWithAreaMoreThanCurrNumber(List<Shape> currShapes, int currNamber) {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < currShapes.size(); i++) {
            if (currShapes.get(i).calculateArea() >= currNamber) {
                shapes.add(currShapes.get(i));
            }
        }

        return shapes;
    }


    //5 method Print the shape type which have more types in Shapes List,if equal than last
    public static void printTheShapeTypeWhichHaveMoreShapesInList(List<Shape> shapes) {
        int coneC = 0, cubeC = 0, rectC = 0, parallC = 0;
        //find shape with max number
        for (Shape shape : shapes) {
            switch (shapeName(shape)) {
                case "Cube": {
                    cubeC++;
                    break;
                }
                case "Cone": {
                    coneC++;
                    break;
                }
                case "Parallelogram": {
                    parallC++;
                    break;
                }
                case "Rectangle": {
                    rectC++;
                    break;
                }
            }
        }
        //add numbers in list to sort and find maximum
        List<Integer> numsList = new ArrayList<>();
        numsList.add(cubeC);
        numsList.add(parallC);
        numsList.add(coneC);
        numsList.add(rectC);
        //Collections.sort(numsList);

        //find which shape is it
        int max = Collections.max(numsList);
        String shapeName = "";
        if (max == coneC) {
            shapeName = "Cone";
        } else if (max == cubeC) {
            shapeName = "Cube";
        } else if (max == rectC) {
            shapeName = "Rectangle";
        } else {
            shapeName = "Parallelogram";
        }
        System.out.println("<<------------------------------------->>");
        System.out.printf("The max count of shapes have %s with %d shapes\n", shapeName, max);
        System.out.println("<<------------------------------------->>");


    }


    //6 method Find the Rectangle which have max area from Shapes List
    public static Rectangle findTheRectangleWithMaxAreaFromShapes(List<TwoDShape> shapes) {
        List<Rectangle> rectangleList = new ArrayList<>();
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) instanceof Rectangle) {
                //Rectangle rectangle=(Rectangle)shapes.get(i);//
                rectangleList.add((Rectangle)shapes.get(i));
            }
        }

        //rectangle have compareTo method(compare areas)
        Collections.sort(rectangleList);
        return rectangleList.get(rectangleList.size() - 1);
    }

    //8 method Sort Rectangle shapes comparing perimeters (by default it compares areas)
    public static List<Rectangle> sortRectangleByPerimeter(List<Rectangle> twoDShapes){
        Comparator<TwoDShape> comparator=new Comparator<TwoDShape>() {
            @Override
            public int compare(TwoDShape o1, TwoDShape o2) {
                return (int)(o1.calculatePerimeter()-o2.calculatePerimeter());
            }
        };
        Collections.sort(twoDShapes,comparator);
        return twoDShapes;

    }

    //9 method Find if there any equal twoDShapes (with perimeter), if yes, print first equals
    public static void findIfThereAnyEqualTwoDShapesWithPerimeter(List<TwoDShape> twoDShapes){
        boolean b=false;
        for (int i = 0; i < twoDShapes.size(); i++) {
            for (int j = i+1; j < twoDShapes.size(); j++) {
                if(twoDShapes.get(i).calculatePerimeter()==twoDShapes.get(j).calculatePerimeter()){
                    System.out.println("<<------------------------------------->>");
                    System.out.printf("Yes! this shapes have equal perimeters:- %d\n",(int)twoDShapes.get(i).calculatePerimeter());
                    System.out.println("1- "+twoDShapes.get(i));
                    System.out.println("2- "+twoDShapes.get(j));
                    System.out.println("<<------------------------------------->>");
                    b=true;
                    break;
                }
            }
            if(b)
                break;
        }
        if(!b){
            System.out.println("<<------------------------------------->>");
            System.out.println("No any equal ones");
            System.out.println("<<------------------------------------->>");
        }

    }


    //10 method Find the Shape type which have the max area sum in shapes list, then find the shape which has max area in that type
    public static Shape findShapesMaxAreaAndMaxShape(List<Shape> shapes) {
        int areaSumOfCone = 0, areaSumCube = 0, areaSumOfRectangle = 0, areaSumOfParallelogram = 0;
        List<Integer> areasList = new ArrayList<>(4);
        //find each shape type sum
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) instanceof Cone) {
                areaSumOfCone += shapes.get(i).calculateArea();
            } else if (shapes.get(i) instanceof Cube) {
                areaSumCube += shapes.get(i).calculateArea();
            } else if (shapes.get(i) instanceof Rectangle) {
                areaSumOfRectangle += shapes.get(i).calculateArea();
            } else {
                areaSumOfParallelogram += shapes.get(i).calculateArea();
            }
        }
        //to sort
        areasList.add(areaSumCube);
        areasList.add(areaSumOfCone);
        areasList.add(areaSumOfRectangle);
        areasList.add(areaSumOfParallelogram);
        Collections.sort(areasList);
        int max = areasList.get(areasList.size() - 1);
        Shape maxShape;

        //find type
        if (max == areaSumCube) {
            maxShape = new Cube(0);
        } else if (max == areaSumOfCone) {
            maxShape = new Cone(0, 0);
        } else if (max == areaSumOfParallelogram) {
            maxShape = new Parallelogram(0, 0, 0);
        } else {
            maxShape = new Rectangle(0, 0);
        }


        //find that shapes in list and add it here to maxShapes
        List maxShapes = new ArrayList();
        Shape sh;
        for (int i = 0; i < shapes.size(); i++) {
            sh = shapes.get(i);
            if (maxShape instanceof Cube) {
                if (sh instanceof Cube) {
                    maxShapes.add(sh);
                } else if (maxShape instanceof Cone) {
                    maxShapes.add(sh);
                } else if (maxShape instanceof Rectangle) {
                    maxShapes.add(sh);
                } else if (maxShape instanceof Parallelogram) {
                    maxShapes.add(sh);
                }
            }

        }
        Collections.sort(maxShapes);
        System.out.println("<<------------------------------------->>");
        System.out.printf("Maximum area sum has %s: with %d sum of areas:\n",maxShape.getClass(),max);
        return (Shape) maxShapes.get(maxShapes.size() - 1);
    }



    public static void writeAllShapesInFile(String path,List<Shape> list) throws IOException {
        StringBuilder stringBuilder=new StringBuilder("");

        for (int i=0;i<list.size();i++){
            stringBuilder.append(list.get(i).toString()).append("\n");
        }

        Files.write(Paths.get(path),stringBuilder.toString().getBytes());
    }



}
