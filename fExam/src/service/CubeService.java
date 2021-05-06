package service;

import model.Cone;
import model.Cube;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CubeService {

    public static List<Cube> createCubesFromFile(List<String> list){
        list.remove(0);
        String[] sepNumbers=list.get(0).split(",");
        List<Cube> cubeList=new ArrayList<>();
        for (String num:sepNumbers){
            cubeList.add(new Cube(Integer.parseInt(num)));
        }
        return cubeList;
    }


    public static List<Cube> createCubeManual(int shapeCount){
        Scanner scanner=new Scanner(System.in);
        List<Cube> listCube=new ArrayList<>();
        int side;
        for (int i=0;i<shapeCount;i++){
            System.out.printf("Type side for %d Cube\n",i+1);
            System.out.printf("Side-");
            side=scanner.nextInt();
            listCube.add(new Cube(side));
        }
        return listCube;
    }

    public static void writeCubesInFile(String path,List<Cube> cubes) throws IOException {
        StringBuilder stringBuilder=new StringBuilder("");

        for (int i=0;i<cubes.size();i++){
            stringBuilder.append(cubes.get(i).toString()).append("\n");
        }

        Files.write(Paths.get(path),stringBuilder.toString().getBytes());
    }
}
