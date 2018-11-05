package myfile.pack1;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import  java.io.*;
import  java.util.ArrayList;
import  java.util.Collections;

public class IntegerIn {


    public void checkFile(String path) throws IOException{
        File file = new File(path);

        if(!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            file.createNewFile();
        }
    }
    public void iWrite(String path, String num) throws IOException {
        File           file  = new File(path);

        FileOutputStream fos = new FileOutputStream(file, true);

        int i;
        byte[] b = num.getBytes();
        fos.write(b);
        fos.flush();


        fos.close();
    }



    public void Print(String path, String option) throws IOException{
        File file = new File(path);

        FileInputStream fis = new FileInputStream(file);
        ArrayList<Integer> list = new ArrayList();
        String str = "";
        int i;

        byte[] b = new byte[fis.available()];
        fis.read(b);
        str = new String(b);
        fis.close();


        String[] intergers = str.split("\n");
        for(i = 0;i < intergers.length;i++) {
            list.add(Integer.valueOf(intergers[i]));
        }
        list.sort(Integer::compareTo);
        if(option.equals("downwards")) {
            Collections.reverse(list);
            System.out.println("After Downwards Sorting : ");
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();

        } else if(option.equals("upwards")) {
            System.out.println("After Upwards Sorting : ");
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        else System.out.println("Wrong Option!");


    }


}
