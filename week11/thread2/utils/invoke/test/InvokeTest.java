package thread2.utils.invoke.test;

import  thread2.utils.invoke.utils.InvokeWrapper;
import  thread2.utils.invoke.utils.PrintTime;
import  thread2.utils.invoke.utils.Supervisor;
import  javax.swing.*;
import  java.awt.*;

public class InvokeTest {

    public static volatile JTextArea area;

    public static void main (String[] args) {

        JFrame frame = new JFrame("Invoker");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        area = new JTextArea(30, 30);
        area.setEditable(false);

        JButton exit = new JButton("EXIT");
        exit.addActionListener((listener) -> {
            System.exit(0);
        });

        panel.add(new JScrollPane(area));
        panel.add(exit);

        frame.add(panel);
        frame.setVisible(true);

        InvokeWrapper invokeWrapper = new InvokeWrapper();

        Thread t1 = new Thread(new PrintTime(invokeWrapper));
        Thread t2 = new Thread(new Supervisor(invokeWrapper, t1));

        t1.start();
        t2.start();


    }
}
