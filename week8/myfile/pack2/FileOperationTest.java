package myfile.pack2;

import  java.io.*;
import  myfile.pack1.FileOperation;
import  java.util.*;

public class FileOperationTest {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        String  str;
        FileOperation fileOperation = new FileOperation();
        int i;

        for(i = 0;i < 12;i++) {
            str = in.next();
            fileOperation.fwrite((i + 1) + "." + str + "\n");
        }

        fileOperation.fread("/Users/xc5/Desktop/Text/input.txt");
        in.close();
    }
}
