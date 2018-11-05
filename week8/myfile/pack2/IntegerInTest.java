package myfile.pack2;

import  java.io.*;
import  java.util.Scanner;
import  myfile.pack1.IntegerIn;

public class IntegerInTest {

    public static void main(String[] args) throws IOException {
        IntegerIn integerIn = new IntegerIn();
        Scanner in = new Scanner(System.in);
        int num;
        int i;
        String path = "/Users/xc5/Desktop/Text/IntIn.txt";

        integerIn.checkFile(path);
        for(i = 0;i < 10;i++) {
            num = in.nextInt();

            integerIn.iWrite(path, String.valueOf(num) + "\n");
        }

        integerIn.Print(path, "upwards");
        System.out.println();
        integerIn.Print(path, "downwards");


        in.close();
    }
}
