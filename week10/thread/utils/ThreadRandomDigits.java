package thread.utils;


import java.util.Random;

public class ThreadRandomDigits extends Thread{
    @Override
    public void run() {
        int i;
        try {
            for (i = 0; i < 50; i++) {
                System.out.println(new Random().nextInt(100));
                Thread.sleep(200);
            }
        }catch (InterruptedException e) {

        }
    }
}
