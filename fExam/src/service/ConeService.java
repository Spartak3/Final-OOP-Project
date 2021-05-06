package service;

import model.Cone;
import model.Cube;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConeService {



    public static List<Cone> createConesFromFile(List<String> list){
        list.remove(0);
        String sNums[];
        List<Cone> coneList=new ArrayList<>();
        for(String nums:list){
            sNums=nums.split(",");
            coneList.add(new Cone(Integer.parseInt(sNums[0]),Integer.parseInt(sNums[1])));
        }
        return coneList;
    }

    public static List<Cone> createConeManual(int shapeCount){
        Scanner scanner=new Scanner(System.in);
        List<Cone> listCone=new ArrayList<>();
        int side,radius;
        for (int i=0;i<shapeCount;i++){
            System.out.printf("Type side and radius for %d Cone\n",i+1);
            System.out.printf("Side-");
            side=scanner.nextInt();
            System.out.printf("Radius-");
            radius=scanner.nextInt();
            listCone.add(new Cone(side,radius));
        }
        return listCone;
    }



    public static void writeConesInFile(String path,List<Cone> cones) throws IOException {
         StringBuilder stringBuilder=new StringBuilder("");

         for (int i=0;i<cones.size();i++){
             stringBuilder.append(cones.get(i).toString()).append("\n");
         }
         Files.write(Paths.get(path),stringBuilder.toString().getBytes());
    }










}
