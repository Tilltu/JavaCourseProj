package mystring.pack2;

import java.text.DecimalFormat;
import  java.util.*;
import  mystring.pack1.*;
import  mystring.pack1.DangerException;

public class MachineTest {

    public static void checkBag(Goods goods) throws DangerException{
        if (goods.isDanger()) {
            DangerException dangerException = new DangerException();
            throw(dangerException);
        }
    }



    public static void main(String[] args){
        Random random        = new Random();
        DecimalFormat format = new DecimalFormat("#.##");
        ArrayList<Goods> goods = new ArrayList<>();
        double weight;
        int num;
        int i;

        try {
            for (i = 0; i < 20; i++) {
                weight = Double.valueOf(format.format(random.nextDouble())) * 15;
                num    = random.nextInt(10);
                goods.add(new Goods(weight, num));
                goods.get(i).printInfo();
                checkBag(goods.get(i));
            }

        }catch (DangerException de) {
            de.toShow();
        }

    }



}
