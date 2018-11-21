package thread.test;

import  thread.utils.Increase;
import  thread.utils.Decrease;


public class MeetTest extends Thread{

    public static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException{

        Increase in = new Increase();
        Decrease de = new Decrease();
        de.setDaemon(true);
        in.setDaemon(true);

        in.start();
        de.start();

        while (flag) {
            try {

                in.sleep(600);
                de.sleep(600);
                if (in.n == de.n) {
                    flag = false;
                    System.out.println("They Meet!");
                    System.out.println("Present increase is :" + in.n + " decrease is :" + de.n);
                    System.exit(0);
                }

            }catch (Exception e) {

            }


        }

    }

}


