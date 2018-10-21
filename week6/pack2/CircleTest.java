package pack2;

import pack1.Circle;

import java.util.ArrayList;
import java.util.Random;

public class CircleTest {
    public static void main(String[] args) {
        ArrayList<Circle> arrayList = new ArrayList<Circle>();
        Random random               = new Random();
        int i;

        for (i = 0;i < 10;i++) {
            arrayList.add(new Circle(random.nextInt(200) + 1));
            System.out.println("OriginalCircle " + (i + 1) + "'s Radius : " + arrayList.get(i).getRadius());
        }
        System.out.println();
        arrayList.sort(Circle::compareTo);

        for (i = 0;i < 10;i++) {
            System.out.println("Circle " + (i + 1) + "'s " + arrayList.get(i).toString());
        }

    }

}
