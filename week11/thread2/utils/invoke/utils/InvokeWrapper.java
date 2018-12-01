package thread2.utils.invoke.utils;

import  static java.lang.System.out;

import  thread2.utils.invoke.test.InvokeTest;
import  java.util.Date;

public class InvokeWrapper {

    public  static boolean EOF = false;    // flag to end the program

    private static boolean flag = true;    // flag to printTime

    public synchronized void printTime() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }

        InvokeTest.area.append("Current Time Is : " + new Date(System.currentTimeMillis()) + "\n");
        flag = false;


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            InvokeTest.area.append("PrintTime Is Invoked!" + "\n");
            flag = true;
            notifyAll();
        }
    }

    public  void supervisor(Thread t) {

        try {
            Thread.sleep(400);
            t.interrupt();
        } catch (InterruptedException e) {

        }
        InvokeTest.area.append("Supervisor Interrupts PrintTime!" + "\n");

    }
}
