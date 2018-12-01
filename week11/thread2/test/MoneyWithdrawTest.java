package thread2.test;

import thread2.utils.withdraw.Account;
import thread2.utils.withdraw.MoneyTaker;

import javax.swing.*;
import java.awt.*;

public class MoneyWithdrawTest {
    public static volatile JTextArea area = new JTextArea(20, 40);
    static boolean flag = true;

    public static void main (String[] args) {
        JFrame frame = new JFrame("MoneyWithdrawTest");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        area.setEditable(false);
        JPanel panel = new JPanel(new FlowLayout());

        Account account = new Account(999999999);

        int i;
        Thread[] threads = new Thread[100];
        String thread_name;
        for(i = 1;i <= 100;i++) {
            thread_name = ("Person " + i);
            threads[i - 1] = new Thread(new MoneyTaker(account), thread_name);  // initialize threads
        }

        for(i = 1;i <= 100;i++) {
            threads[i - 1].start();
        }

        JButton exit = new JButton("Exit");
        exit.addActionListener((listener) -> {
            System.exit(0);
        });


        panel.add(new JScrollPane(area));
        panel.add(exit);
        frame.add(panel);
        frame.setVisible(true);

        while(flag) {
            if(account.getMoney() <= 0) {
                System.exit(0);
            }
            try {
                for (i = 1; i <= 100; i++) {
                    threads[i - 1].sleep(2000);
                }
            } catch (InterruptedException e) {

            }

        }
    }

}
