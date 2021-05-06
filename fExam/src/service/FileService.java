package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class FileService  {

    public static void createFile(String path,String name) throws IOException {
       File file=new File(path);
       if(!file.exists()){
           file.mkdirs();
       }
       File tFile=new File(path+"/"+name);
       tFile.createNewFile();
    }


    public static List<String> readFromFile(String path) throws IOException{
        return Files.readAllLines(Paths.get(path));
    }




}
