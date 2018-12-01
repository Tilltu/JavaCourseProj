package thread2.test;

import thread2.utils.Input;
import thread2.utils.Output;
import thread2.utils.StringReverse;
import javax.swing.*;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Scanner;

public class StringReverseTest {

    public static volatile JTextArea area   = new JTextArea(20, 20);
    public static  JTextField input = new JTextField(10);


    public static void main (String[] args) {



        StringReverse sr = new StringReverse();


        Thread t1 = new Thread(new Input(sr), "Generator");
        Thread t2 = new Thread(new Output(sr), "Reverser1");
        Thread t3 = new Thread(new Output(sr), "Reverser2");
        Thread t4 = new Thread(new Output(sr), "Reverser3");

        t1.start();
        t2.start();
        t3.start();
        t4.start();



    }

}
