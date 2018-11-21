package thread.test;

import  javax.swing.*;
import  thread.utils.AlphaPrinter;
import  thread.utils.DigitPrinter;
import thread.utils.Printer;

public class PrinterGUITest {
    public static volatile JTextArea area;
    public static volatile int  digit = 1;
    public static volatile char alpha = 'A';
    public static volatile boolean  flag = true;

    public static void main (String[] args) {
        JFrame frame = new JFrame("Printer Test");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel    = new JPanel();
        BoxLayout bl    = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(bl);

        area = new JTextArea(20, 20);
        area.setEditable(false);


        panel.add(new JScrollPane(area));


        frame.add(panel);
        frame.setVisible(true);

        Printer printer = new Printer();

        AlphaPrinter ap = new AlphaPrinter(printer);
        DigitPrinter dp = new DigitPrinter(printer);

        Thread t1 = new Thread(ap, "t1");
        Thread t2 = new Thread(dp, "t2");

        t1.start();
        t2.start();

        while (flag) {
            Thread t = Thread.currentThread();
                try {
                    t1.sleep(1000);
                    t2.sleep(1000);

                    if(digit == 53) {
                        area.append("DONE!\n");
                        flag = false;
                    }

                } catch (InterruptedException e) {

                }
        }




    }

}
