package co.com.empresa.certificacion.producto.utils;

import java.io.File;
import java.util.Scanner;

public class ReadFile {
    private ReadFile(){}
    public static String returnFile(String route) {
        String line ="";
        Scanner input;
        try{
            input = new Scanner(new File(route));
            while (input.hasNextLine()){
                line = line + input.nextLine();
            }
            input.close();
        }catch (Exception e){
            e.getMessage();
        }
        return line;
    }
}
