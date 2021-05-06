package main;

import model.*;
import service.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
    static List<String> listForCubeFile;
    static List<Cube> cubesList;
    static List<String> listForConeFile;
    static List<Cone> coneList;
    static List<String> listForRectangleFile;
    static List<Rectangle> rectangleList;
    static List<String> listForParallelogramFile;
    static List<Parallelogram> parallelogramList;
    static List<Shape> allShapes=new ArrayList<>();
    static List<TwoDShape> twoDShapes=new ArrayList<>();
    static List<TreeDShape> treeDShapes=new ArrayList<>();
    public static void main(String[] args) {


        /*
        File file=new File("fExam/objFilesWrite/allObjWrite");
        if(!file.exists()){
            file.mkdirs();
        }
        File file1=new File("fExam/objFilesWrite/allObjWrite/allW.rtf");
        file1.createNewFile();
         */
        boolean isActive=true;
        System.out.println("Hello, this is Shape world");
        int chooseNumber=0,choosenum2=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("-------------------------------------------");
        System.out.println("Do you want to create shape manual or create it from file??");
        System.out.println("-------------------------------------------");
        System.out.println("Chose one of this");
        System.out.println("-------------------------------------------");
        System.out.printf("1-create manual\n");
        System.out.println("-------------------------------------------");
        System.out.printf("2-create from file\n type...");

        chooseNumber=scanner.nextInt();
        if(chooseNumber==2){
            System.out.println("We have created your shapes");

            try {
                createShapesFromFile();
            } catch (IOException e) {
                System.out.println("some problem found, file error");
                e.printStackTrace();
                System.exit(0);
            }
        }
        else {
            System.out.println("Okay, how many shapes do you want for each type?");
            chooseNumber=scanner.nextInt();
            createShapesManual(chooseNumber);
        }

        if(coneList.isEmpty()||cubesList.isEmpty()||rectangleList.isEmpty()||parallelogramList.isEmpty()){
            System.out.println("Your list is empty, we can't continue: exit");
            System.exit(0);
        }

        while (isActive) {
            System.out.println("-------------------------------------------");
            System.out.println("Everything is done, please type what do you want to do with shapes");
            System.out.println("0-End all ");
            System.out.println("1-Save this shapes in file (write in file)");
            System.out.println("2-Print the shape with max area");
            System.out.println("3-Print the TwoDShape with max perimeter");
            System.out.println("4-Find shapes which have more than x area (x= any number you wish)");
            System.out.println("5-Print the shape type which have more types in Shapes List,if equal than last ");
            System.out.println("6-Find the Rectangle which have max area from Shapes List");
            System.out.println("7-Sort x shape by area (x= any type you want)");
            System.out.println("8-Sort Rectangle shapes comparing perimeters (by default it compares areas)");
            System.out.println("9-Find if there any equal twoDShapes (with perimeter), if yes, print first equals");
            System.out.println("10-Find the Shape type which have the max area sum in shapes list, then find the shape which has max area in that type");
            System.out.println("-----------------type number--------------------------");
            chooseNumber=scanner.nextInt();
            switch (chooseNumber){
                case 0:{
                    isActive=false;
                    System.out.println("Bye");
                    break;
                }
                case 1:{
                    System.out.println("Please type which shape do you want to save");
                    System.out.println("==1-Cone");
                    System.out.println("==2-Cube");
                    System.out.println("==3-Rectangle");
                    System.out.println("==4-Parallelogram");
                    System.out.println("==5-All");
                    choosenum2=scanner.nextInt();
                    try {
                        switch (choosenum2) {
                            case 1: {
                                ConeService.writeConesInFile("fExam/objFilesWrite/coneObjWrite/coneW.rtf", coneList);
                                break;
                            }
                            case 2: {
                                CubeService.writeCubesInFile("fExam/objFilesWrite/cubeObjWrite/cubeW.rtf", cubesList);
                                break;
                            }
                            case 3: {
                                RectangleService.writeRectanglesInFile("fExam/objFilesWrite/rectangleObjWrite/rectW.rtf", rectangleList);
                                break;
                            }
                            case 4: {
                                ParallelogramService.writeParallelogramsInFile("fExam/objFilesWrite/parallelogramObjWrite/parallW.rtf", parallelogramList);
                                break;
                            }
                            case 5: {
                                ShapeService.writeAllShapesInFile("fExam/objFilesWrite/allObjWrite/allW.rtf", allShapes);
                                break;
                            }


                        }
                    }catch (IOException e){
                        System.out.println("some problem found");
                        e.printStackTrace();
                    }
                    System.out.println("<<------------------------------------------->>");
                    System.out.println("Shapes are saved:= Please check fExam/objFilesWrite file");
                    System.out.println("<<------------------------------------------->>");

                    break;
                }
                case 2:{
                    ShapeService.printTheShapeWithMaxArea(allShapes);
                    break;
                }
                case 3:{
                    ShapeService.printTheTwoDShapeWithMaxPerimeter(twoDShapes);
                    break;
                }
                case 4:{
                    System.out.println("Please type your number");
                    choosenum2=scanner.nextInt();
                    List<Shape> mShapes=ShapeService.findShapesWithAreaMoreThanCurrNumber(allShapes,choosenum2);
                    System.out.println("<<------------------------------------------->>");
                    System.out.printf("This shapes have area more than %d \n" ,choosenum2);
                    System.out.println(mShapes);
                    System.out.println("<<------------------------------------------>>");
                    break;
                }
                case 5:{
                    ShapeService.printTheShapeTypeWhichHaveMoreShapesInList(allShapes);
                    break;
                }
                case 6:{
                    Rectangle rectangle=ShapeService.findTheRectangleWithMaxAreaFromShapes(twoDShapes);
                    System.out.println("<<----------------max Rectangle--------------------------->>");
                    System.out.println(rectangle);
                    System.out.println("<<------------------------------------------->>");
                    break;
                }
                case 7:{
                    System.out.println("Which shape do you want to sort by area");
                    System.out.println("==1-Cube");
                    System.out.println("==2-Cone");
                    System.out.println("==3-Rectangle");
                    System.out.println("==4-Parallelogram");
                    choosenum2=scanner.nextInt();
                    switch (choosenum2){
                        case 1:{
                            Collections.sort(cubesList);
                            System.out.println("<<------------------------------------------->>");
                            System.out.println("The Cubes sorted (by area):");
                            System.out.println(cubesList);
                            System.out.println("<<------------------------------------------->>");
                            break;
                        }
                        case 2:{
                            Collections.sort(coneList);
                            System.out.println("<<------------------------------------------->>");
                            System.out.println("The Cones sorted (by area):");
                            System.out.println(coneList);
                            System.out.println("<<------------------------------------------->>");
                            break;
                        }
                        case 3:{
                            Collections.sort(rectangleList);
                            System.out.println("<<------------------------------------------->>");
                            System.out.println("The Rectangle sorted (by area):");
                            System.out.println(rectangleList);
                            System.out.println("<<------------------------------------------->>");
                            break;
                        }
                        case 4:{
                            Collections.sort(parallelogramList);
                            System.out.println("<<------------------------------------------->>");
                            System.out.println("The Parallelogram sorted (by area):");
                            System.out.println(parallelogramList);
                            System.out.println("<<------------------------------------------->>");
                            break;
                        }
                        default:{
                            System.out.println("<<------------------------------------------->>");
                            System.out.println("No such number");
                        }
                    }
                    break;
                }
                case 8:{
                    List<Rectangle> list=ShapeService.sortRectangleByPerimeter(rectangleList);
                    System.out.println("<<------------------------------------------->>");
                    System.out.println("The Rectangles sorted by perimeter:");
                    System.out.println(list);
                    System.out.println("<<------------------------------------------->>");
                    break;
                }
                case 9:{
                    ShapeService.findIfThereAnyEqualTwoDShapesWithPerimeter(twoDShapes);
                    break;
                }
                case 10:{
                    Shape shape2=ShapeService.findShapesMaxAreaAndMaxShape(allShapes);
                    System.out.println("<<------------------------------------------->>");
                    System.out.println("Max area have , from maxes: ");
                    System.out.println(shape2);
                    System.out.println("<<------------------------------------------->>");
                    break;
                }
            }
        }
    }

    public static void createShapesFromFile() throws IOException{
        try {
            FileService.createFile("fExam/objFiles/cubeObjFile","cube.rtf");
            FileService.createFile("fExam/objFiles/coneObjFile","cone.rtf");
            FileService.createFile("fExam/objFiles/rectangleObjFile","rectangle.rtf");
            FileService.createFile("fExam/objFiles/parallelogramObjFile","parallelogram.rtf");
        } catch (IOException e) {
            System.out.println("something went wrong: exit");
            e.printStackTrace();
            System.exit(0);
        }

        listForCubeFile=FileService.readFromFile("fExam/objFiles/cubeObjFile/cube.rtf");
        cubesList=CubeService.createCubesFromFile(listForCubeFile);
        listForConeFile=FileService.readFromFile("fExam/objFiles/coneObjFile/cone.rtf");
        coneList= ConeService.createConesFromFile(listForConeFile);
        listForRectangleFile=FileService.readFromFile("fExam/objFiles/rectangleObjFile/rectangle.rtf");
        rectangleList= RectangleService.createRectanglesFromFile(listForRectangleFile);
        listForParallelogramFile=FileService.readFromFile("fExam/objFiles/parallelogramObjFile/parallelogram.rtf");
        parallelogramList= ParallelogramService.createParallelogramsFromFile(listForParallelogramFile);
        System.out.println("Your shapes are:-");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(cubesList);
        System.out.println(coneList);
        System.out.println(rectangleList);
        System.out.println(parallelogramList);
        System.out.println("----------------------------------------------------------------------");

        allShapes.addAll(coneList);
        allShapes.addAll(rectangleList);
        allShapes.addAll(cubesList);
        allShapes.addAll(parallelogramList);
        twoDShapes.addAll(parallelogramList);
        twoDShapes.addAll(rectangleList);
        treeDShapes.addAll(coneList);
        treeDShapes.addAll(cubesList);

    }

    public static void createShapesManual(int shapeCount){
        coneList=ConeService.createConeManual(shapeCount);
        cubesList=CubeService.createCubeManual(shapeCount);
        parallelogramList=ParallelogramService.createParallelogramManual(shapeCount);
        rectangleList=RectangleService.createRectangleManual(shapeCount);
        System.out.println("Your shapes are:-");
        allShapes.addAll(coneList);
        allShapes.addAll(rectangleList);
        allShapes.addAll(cubesList);
        allShapes.addAll(parallelogramList);
        twoDShapes.addAll(parallelogramList);
        twoDShapes.addAll(rectangleList);
        treeDShapes.addAll(coneList);
        treeDShapes.addAll(cubesList);
        System.out.println("----------------------------------------------------------------------");
        System.out.println(cubesList);
        System.out.println(coneList);
        System.out.println(rectangleList);
        System.out.println(parallelogramList);
        System.out.println("----------------------------------------------------------------------");

    }
}
