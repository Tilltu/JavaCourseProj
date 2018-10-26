package mystring.pack2;

import  mystring.pack1.DiscardNoneDigit;
import  java.util.*;

public class DiscardNoneDigitTest {

    public static void main (String[] args) {
        Scanner          in  = new Scanner(System.in);
        DiscardNoneDigit cut = new DiscardNoneDigit();
        String           src;

        while (in.hasNext()) {
            src = in.next();
            cut.printResult(src);
        }

        in.close();
    }
}
