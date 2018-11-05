package myfile.pack1;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import  java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JarInfo {

    public  void getInfo(String path) throws IOException{

        File file = new File(path);

        int i;

        Date date;

        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for(i = 0;i < files.length;i++) {
                if (files[i].getName().endsWith(".jar")) {
                    date = new Date(files[i].lastModified());
                    System.out.printf("File Name : %90s | Total Space : %9s | Last Modified : %15s\n",
                            files[i].getName(), files[i].length(), date);
                    //System.out.printf("File Name : " + files[i].getName() +
                    //                   " Total Space : " + files[i].length() + "B" +
                    //                   " Last Modified : " + date);
                }
                if(files[i].isDirectory()) {
                    getInfo(files[i].getPath());
                }
            }
        }
    }
}
