package thread.utils;

import  thread.test.IsPrimeGUITest;
import  java.math.*;

public class IsPrime extends Thread{

    public  boolean isPrime() {
        int n = IsPrimeGUITest.num;

        if(n <= 2) {
            return (n==2);
        }
        else if(n % 2 == 0){
            return false;
        } else {
            int i;
            for(i = 3;i <= Math.sqrt(n);i+=2) {
                if(n % 3 == 0) {
                    return false;
                }
            }
        }
        return true;

    }

    @Override
    public synchronized void run() {
        Thread t = currentThread();
        synchronized (t) {
            try {
                while (IsPrimeGUITest.flag) {
                    if (IsPrimeGUITest.num != 0) {
                        if (isPrime()) {
                            IsPrimeGUITest.area.append("Thread2 says : " + IsPrimeGUITest.num +
                                    " is a prime\n");
                        } else {
                            IsPrimeGUITest.area.append("Thread2 says : " + IsPrimeGUITest.num +
                                    " is not a prime\n");
                        }
                    }
                    Thread.sleep(1200);
                }
            } catch (InterruptedException e) {

            }
        }
    }

}
