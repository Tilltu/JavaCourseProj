package myfile.pack2;

import myfile.pack1.JarInfo;

import java.io.IOException;

public class JarInfoTest {
    public static void main(String[] args) {
        String path = "/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/lib";
        JarInfo test = new JarInfo();
        try {
            test.getInfo(path);
        }catch (IOException e) {

        }
    }

}
