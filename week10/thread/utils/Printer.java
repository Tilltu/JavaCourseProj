package thread.utils;

import  thread.test.PrinterGUITest;

import  javax.swing.*;

public class Printer extends Thread{
    public  boolean dflag = true;

    public synchronized void printDigit() {
        while (!dflag) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }

        PrinterGUITest.area.append("Thread 1 : " + PrinterGUITest.digit++ + PrinterGUITest.digit++ + "\n");
        dflag = false;

        try {
            sleep(1000);
        } catch (InterruptedException e) {

        }
        notify();

    }

    public synchronized void printAlpha() {
        while (dflag) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }

        PrinterGUITest.area.append("Thread 2 : " + (char) PrinterGUITest.alpha + "\n");
        PrinterGUITest.alpha += 1;
        dflag = true;

        try {
            sleep(1000);
        } catch (InterruptedException e) {

        }
        notify();
    }


}
