package thread2.utils;

import thread2.test.StringReverseTest;

import  static java.lang.System.out;
import  static thread2.test.StringReverseTest.area;


import  java.io.IOException;
import  java.util.Scanner;
import  java.util.LinkedList;
import  java.lang.StringBuffer;
import  java.util.Queue;

public class StringReverse {
    public static LinkedList<String> in_src = new LinkedList<>();
    public static LinkedList<String> out_src = new LinkedList<>();
    public static String temp = "";
    private static Scanner in = new Scanner(System.in);

    public static boolean gen_flag = true;
    public static boolean rev_flag = false;


    public synchronized void input() {
        while (!gen_flag) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        out.println("Input \"EXIT\" to exit");

        try {

            String str = in.nextLine();
            if (str == null) {
                out.println("Input Null!");
                in.close();
                System.exit(0);
            }
            if (str.equals("EXIT")) {
                out.println("EXITING!");
                in.close();
                System.exit(0);
            }
            in_src.add(str);
            out.println(Thread.currentThread().getName() + " : " + "Input  String is : " +
                    in_src.get(in_src.size() - 1));


            gen_flag = false;
            rev_flag = true;
        } catch (Exception e) {

        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        notifyAll();

    }




    public synchronized void output() {
        while (!rev_flag) {
            try {
                wait();
            } catch (InterruptedException e) {

            }

        }
        temp = in_src.get(in_src.size() - 1);
        temp = new StringBuilder(temp).reverse().toString();
        out_src.add(temp);

        out.println(Thread.currentThread().getName() + " : " + "Output String is : " + temp);

        rev_flag = false;
        gen_flag = true;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        notifyAll();
    }
}