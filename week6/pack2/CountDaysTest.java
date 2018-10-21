package pack2;

import  java.text.ParseException;
import  java.util.Scanner;
import  pack1.CountDays;

public class CountDaysTest {
    public static void main(String [] args) throws ParseException {
        Scanner in    = new Scanner(System.in);

        String src_date_str;
        String dis_date_str;

        System.out.println("Please input in the form of 'xxxx年xx月xx日'. For example : " +
                "2017年02月04日");
        while(in.hasNext()) {

            src_date_str = in.next();
            dis_date_str = in.next();

            CountDays src_date = new CountDays();
            CountDays dis_date = new CountDays();
            src_date.setDate(src_date_str);
            dis_date.setDate(dis_date_str);

            //System.out.println("src_date:" + src_date_str);
            //System.out.println("dis_date:" + dis_date_str);
            System.out.println(src_date.getDays(dis_date));

        }
    }
}
