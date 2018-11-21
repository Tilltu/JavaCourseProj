package thread.utils;

public class Increase extends Thread {

    public static int n = 0;

    @Override
    public void run() {
            try {
                for (int i = 0; i < 10; i++) {

                        System.out.println("ONE:" + n);
                        n++;
                        Thread.sleep(1000);

                }
            } catch (InterruptedException e) {
                return;
            }
        }
}
