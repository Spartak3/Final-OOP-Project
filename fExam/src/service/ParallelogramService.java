package service;

import model.Cone;
import model.Cube;
import model.Parallelogram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParallelogramService {

    public static List<Parallelogram> createParallelogramsFromFile(List<String> list){
        //first line is nut number
        list.remove(0);
        String sNums[];
        List<Parallelogram> paralList=new ArrayList<>();
        for(String nums:list){
            sNums=nums.split(",");
            paralList.add(new Parallelogram(Integer.parseInt(sNums[0]),Integer.parseInt(sNums[1]),Integer.parseInt(sNums[2])));
        }
        return paralList;
    }


    public static List<Parallelogram> createParallelogramManual(int shapeCount){
        Scanner scanner=new Scanner(System.in);
        List<Parallelogram> listParallelogram=new ArrayList<>();
        int length,width,height;
        for (int i=0;i<shapeCount;i++){
            System.out.printf("Type length, width and height for %d Parallelogram\n",i+1);
            System.out.printf("Length-");
            length=scanner.nextInt();
            System.out.printf("Width-");
            width=scanner.nextInt();
            System.out.printf("Height-");
            height=scanner.nextInt();
            listParallelogram.add(new Parallelogram(length,width,height));
        }
        return listParallelogram;
    }


    public static void writeParallelogramsInFile(String path,List<Parallelogram> parallelograms) throws IOException {
        StringBuilder stringBuilder=new StringBuilder("");

        for (int i=0;i<parallelograms.size();i++){
            stringBuilder.append(parallelograms.get(i).toString()).append("\n");
        }

        Files.write(Paths.get(path),stringBuilder.toString().getBytes());
    }
}
