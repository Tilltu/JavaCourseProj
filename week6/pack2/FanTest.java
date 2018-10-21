package pack2;

import  pack1.Fan;

import  java.text.DecimalFormat;
import  java.util.Comparator;
import  java.util.Random;
import  java.util.Set;
import  java.util.TreeMap;

public class FanTest {

    public static void main(String[] args) {
        TreeMap<Fan, String> tm_r         = new TreeMap<>((Fan fan1, Fan fan2) -> {

                if(fan1.getRadius() > fan2.getRadius()) {
                    return 1;
                }
                else if(fan1.getRadius() == fan2.getRadius() && fan1.getPrice() == fan2.getPrice()) {
                    return 0;
                }
                return -1;


        });

        TreeMap<Fan, String> tm_p         = new TreeMap<>((Fan fan1, Fan fan2) -> {

                if(fan1.getPrice() > fan2.getPrice()) {
                    return 1;
                }
                else if(fan1.getPrice() == fan2.getPrice() && fan1.getRadius() == fan2.getRadius()) {
                    return 0;
                }
                return -1;

        });

        Random  random       = new Random();
        DecimalFormat format = new DecimalFormat("#.##");
        int r;
        double p;
        int i;


        for(i = 0;i < 10;i++) {
            r = random.nextInt(30) + 1;
            p = Double.valueOf(format.format(random.nextDouble() * 1000));
            Fan fan = new Fan(r, p);

            tm_r.put(fan, String.valueOf(r));
            tm_p.put(fan, String.valueOf(p));
        }

        System.out.println("After being sorted by Radius : ");
        Set<Fan> set_r = tm_r.keySet();
        for (Fan fan : set_r
             ) {
            System.out.println(fan);
        }

        System.out.println();

        System.out.println("After being sorted by Price : ");
        Set<Fan> set_p = tm_p.keySet();
        for (Fan fan : set_p
        ) {
            System.out.println(fan);
        }
    }
}
