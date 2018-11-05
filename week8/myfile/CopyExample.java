package myfile;

import java.io.*;

public class CopyExample {
    /*public static void main(String[] args) throws IOException {
        /*File fs = new File("/Users/xc5/Desktop/Hello.txt");    //源文件，必须存在
        File fd = new File("/Users/xc5/Desktop/Hello.cpy");   //目标文件，可以不存在
        FileInputStream  fis = new FileInputStream(fs);      //建立连接文件fs的输入流
        FileOutputStream fos = new FileOutputStream(fd);   //建立连接文件fd的输出流
        byte[] b = new byte[1024];    //创建大小为1024的字节数组
        while(fis.read(b) != -1){
            fos.write(b);                   //将字节数组b的内容写入目标文件
        }



        fos.close();         //fos关闭；
        fis.close();         //fis关闭；

        int x = 3, y;
        y=(x++)+(x++)+(x++);
        System.out.println(y);
    }*/

    public void changeInt(int x){
        x+=12;
        System.out.print(x+" ");}
    public static void main(String[] args){
        int intVar=10;
        System.out.print(intVar+" ");
        CopyExample Obj=new CopyExample();
        Obj.changeInt(intVar);
        System.out.println(intVar);
    }




}
