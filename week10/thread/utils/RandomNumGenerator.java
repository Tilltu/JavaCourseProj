package thread.utils;

import  thread.test.IsPrimeGUITest;
import  java.util.Random;

public class RandomNumGenerator extends Thread{

    @Override
    public void run() {
        Thread t = currentThread();
        synchronized (t) {
            try {
                while (IsPrimeGUITest.flag) {
                    Random random = new Random();
                    //synchronized (this) {
                    IsPrimeGUITest.num = random.nextInt(100) + 1;
                    IsPrimeGUITest.area.append("Thread1 says : I create a number : " + IsPrimeGUITest.num + "\n");
                    //}
                    Thread.sleep(1300);
                }
            } catch (InterruptedException e) {

            }
        }

    }

}
