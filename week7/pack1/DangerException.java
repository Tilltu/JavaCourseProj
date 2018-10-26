package mystring.pack1;

import java.util.Date;

public class DangerException extends Exception {
    String msg;

    public DangerException() {
        msg = "Dangerous Goods Detected!";
    }

    public void toShow() {
        System.out.println(msg);
    }

}
