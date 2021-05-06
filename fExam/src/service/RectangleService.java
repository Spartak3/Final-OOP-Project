package service;

import model.Cone;
import model.Cube;
import model.Parallelogram;
import model.Rectangle;
import org.w3c.dom.css.Rect;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RectangleService {

    public static List<Rectangle> createRectanglesFromFile(List<String> list){
        list.remove(0);
        String sNums[];
        List<Rectangle> rectangleList=new ArrayList<>();
        for(String nums:list){
            sNums=nums.split(",");
            rectangleList.add(new Rectangle(Integer.parseInt(sNums[0]),Integer.parseInt(sNums[1])));
        }
        return rectangleList;
    }


    public static List<Rectangle> createRectangleManual(int shapeCount){
        Scanner scanner=new Scanner(System.in);
        List<Rectangle> listRectangle=new ArrayList<>();
        int length,width;
        for (int i=0;i<shapeCount;i++){
            System.out.printf("Type length and width for %d Rectangle\n",i+1);
            System.out.printf("Length-");
            length=scanner.nextInt();
            System.out.printf("Width-");
            width=scanner.nextInt();
            listRectangle.add(new Rectangle(length,width));
        }
        return listRectangle;
    }


    public static void writeRectanglesInFile(String path,List<Rectangle> rectangleList) throws IOException {
        StringBuilder stringBuilder=new StringBuilder("");

        for (int i=0;i<rectangleList.size();i++){
            stringBuilder.append(rectangleList.get(i).toString()).append("\n");
        }

        Files.write(Paths.get(path),stringBuilder.toString().getBytes());
    }
}
