package thread.test;

import  java.lang.Thread;
import  java.util.Random;

public class ThreadRandomDigitsImplement implements Runnable{

    public void run() {
        try {
            for (int i = 0; i < 50; i++) {
                System.out.println(new Random().nextInt(100));
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {

        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadRandomDigitsImplement());
        t.start();
    }

}
