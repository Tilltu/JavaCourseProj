package thread2.test;


import  javax.swing.*;
import  java.awt.*;
import  thread2.utils.matrix.Matrix;
import  thread2.utils.matrix.ParaMatrixMutiThread;

public class MatrixTest {

    public static volatile JTextArea area;               // TextArea to be appended

    public static final int threads_num = 2000;             // global threads number,
                                                         // you can alter it to change
                                                         // the threads you want to run parallel


    /**
     *
     * @param threads
     * @return
     *
     * function to test if all threads are dead
     */
    private static boolean areAllThreadsDead (Thread[] threads) {
        int i;

        for (i = 0;i < threads_num;i++) {
            if (threads[i].isAlive()) {
                return false;
            }
        }

        return true;
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame("TimeComparator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        JPanel panel = new JPanel(new FlowLayout());

        area = new JTextArea(30,30);
        area.setEditable(false);

        JButton exit = new JButton("EXIT");
        exit.addActionListener((listener) -> {
            System.exit(0);
        });

        panel.add(area);
        panel.add(exit);
        frame.add(panel);
        frame.setVisible(true);                             // GUI initializer






        int n = 2000;                                       // n is the size of the matrix
        Matrix m = new Matrix(n);
        area.append("Sequence Multiplying...\n");
        m.sequenceMatrixMultiplication();                   // processing sequence matrix
                                                            // multiplication

        Thread[] threads = new Thread[threads_num];         // declare threads

        int i;
        for(i = 0;i < threads_num;i++) {
            String name = String.valueOf(i);
            threads[i] = new Thread(new ParaMatrixMutiThread(m), name);
            //threads[i].start();
        }
                                                            // initialize threads and start
        for(i = 0;i < threads_num;i++) {
            threads[i].start();
        }

        area.append("Parallel Multiplying...\n");    // print time consumed if all threads dead
        while (true) {
            if (areAllThreadsDead(threads)) {
                m.printPres();
                break;
            }
        }

    }
}
