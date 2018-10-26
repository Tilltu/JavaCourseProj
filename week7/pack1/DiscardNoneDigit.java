package mystring.pack1;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import  java.util.StringTokenizer;


public class DiscardNoneDigit {
    String regex = "\\D\\s*";
    String[] res;

    public String[] discardNoneDigit(String src) {
        return src.split(regex);
    }

    public void printResult(String src) {
        res = src.split(regex);
        StringBuffer stringBuffer = new StringBuffer();

        int i;

        for(i = 0;i < res.length;i++) {
            if(!res[i].isEmpty()) {
                System.out.print(res[i] + " ");
            }
        }
        System.out.println();


    }

}
