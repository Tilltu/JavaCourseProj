//package week3;
import java.math.*;
import java.util.*;
class StopWatch {
    private long startTime;
    private long endTime;

    StopWatch(){
        startTime = System.currentTimeMillis();
    }

    void start(){
        startTime = System.currentTimeMillis();
    }
    void stop(){
        endTime   = System.currentTimeMillis();
    }
    long getElapsedTime(){
        return endTime - startTime;
    }

}

public class TimeTest{
    public static void main(String[] parms){
        double[] test_array = new double[100000];
        int i, j, k;
        double temp = 0d;

        for(i = 0;i < 100000;i++){
            test_array[i] = Math.random();
        }

        StopWatch watch = new StopWatch();
        long counter = 0;
        for(i = 0;i < 99999;i++){
            k = i;
            watch.start();
            for(j = i + 1;j < 100000;j++){
                if(test_array[k] < test_array[j]){
                    k = j;
                }
            }
            if(k != i){
                temp          = test_array[i];
                test_array[i] = test_array[k];
                test_array[k] = temp;
            }
            watch.stop();
            counter += watch.getElapsedTime();
        }



        System.out.println("The Time Elapsed Is " + counter + "ms");
        /*for(i = 0;i < 20;i++){
            System.out.println(test_array[i]);
        }*/
    }
}

