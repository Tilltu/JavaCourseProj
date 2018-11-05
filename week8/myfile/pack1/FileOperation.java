package myfile.pack1;

import java.io.*;

public class FileOperation {
    public void fwrite(String text) throws IOException{
        File file             = new File("/Users/xc5/Desktop/Text");
        FileOutputStream fos  = new FileOutputStream(file.getPath() + "/input.txt", true);

        byte[] b = text.getBytes();
        fos.write(b);
        fos.close();
    }

    public void fread (String file_name) throws IOException{
        File file         = new File(file_name);
        FileInputStream fis = new FileInputStream(file);

        int size   = fis.available();
        byte[] b   = new byte[size];
        fis.read(b);
        String res = new String(b);

        System.out.println(res);
        fis.close();
    }

}
