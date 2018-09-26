package pack2;

import pack1.Fan;
import java.util.*;

public class TestFan {
   public static void main(String[] args){
       ArrayList<Fan> fan = new ArrayList<Fan>(10);
       Scanner         in = new Scanner(System.in);
       while(in.hasNext()){
           int speed = in.nextInt();



           if(speed < 0 || speed > 3){
               System.out.println("Input Error! Try Again!");
               continue;
           }
           if(speed == 0){
               Fan fan1 = new Fan();
               fan.add(fan1);
               System.out.println(fan1.toString());
           }
           else {
               Fan fan1 = new Fan();
               fan1.setSpeed(speed);
               fan1.setOn(true);
               Random random = new Random();
               int r = random.nextInt(8) + 3;
               while(r == 5){
                   r = random.nextInt(8) + 3;
               }
               fan1.setRadius(r);
               fan1.setColor(random.nextInt(7));
               System.out.println(fan1.toString());
           }
       }
   }
}
