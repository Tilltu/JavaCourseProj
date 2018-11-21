package thread.test;

import  thread.utils.IsPrime;
import  thread.utils.RandomNumGenerator;

import  javax.swing.*;


public class IsPrimeGUITest {

    public static  int num;
    public static  JTextArea area;
    public static boolean flag = true;

    public static void main (String[] args) {
        JFrame frame = new JFrame("IsPrime Test");
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

        RandomNumGenerator generator = new RandomNumGenerator();
        IsPrime            isPrime   = new IsPrime();

        Thread t1 = new Thread(generator);
        Thread t2 = new Thread(isPrime);

        t1.start();
        t2.start();
        while(flag) {
            Thread t = Thread.currentThread();
            synchronized (t) {
                try {
                    t1.sleep(1000);

                    t2.sleep(1000);
                    if (num > 90) {
                        area.append("Main thread says : " + num + " is bigger than 90\nOver.");
                        flag = false;
                    }
                } catch (Exception e) {

                }
            }
        }
    }
}
