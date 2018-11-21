package thread.utils;


public class Decrease extends Thread {

    public static int n = 10;

    @Override
    public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                        System.out.println("TWO:" + n);
                        n--;
                        Thread.sleep(1000);


                }
            } catch (InterruptedException e) {
                return;
            }
        }
}
