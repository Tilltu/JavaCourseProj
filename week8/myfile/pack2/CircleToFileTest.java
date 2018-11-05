package myfile.pack2;

import  pack1.Circle;

import  java.io.*;
import  java.util.*;

public class CircleToFileTest {

    public static void checkFile(String path) throws IOException{
        File file = new File(path);
        if(file.exists()) {
            file.delete();
            file.createNewFile();
        } else {
            file.createNewFile();
        }
    }

    public static void objWrite(String path, LinkedList<Circle> list) throws IOException {
        File file = new File(path);
        int i;
        FileOutputStream fos   = new FileOutputStream(file, true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for(i = 0;i < list.size();i++) {
            oos.writeObject(list.get(i));
            oos.flush();
        }
        oos.close();
        fos.close();
    }

    public static void objRead(String path) throws IOException {
        File file = new File(path);

        FileInputStream   fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            for(int i = 0;i < 10;i++) {
                Circle circle = (Circle) ois.readObject();
                System.out.println(circle);
            }

        }catch (ClassNotFoundException e) {
            e.getException();
        }finally {
            System.out.println("Success!");
        }

        fis.close();
        ois.close();

    }

    public static void main(String[] args) throws IOException{
        LinkedList<Circle> list = new LinkedList<>();
        String path   = "/Users/xc5/Desktop/Text/fileOfAccount.dat";
        Random random = new Random();
        int i;

        checkFile(path);
        for(i = 0;i < 10;i++) {
            list.add(new Circle(random.nextInt(100)));
        }

        objWrite(path, list);
        objRead(path);

    }
}
