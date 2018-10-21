package pack2;
import  pack1.MyCircle;
import java.util.ArrayList;
import java.util.Random;

public class MyCircleTest {
    public static void main(String[] args) {
        Random random                 = new Random();
        ArrayList<MyCircle> arrayList = new ArrayList<>();
        int i;

        for(i = 0;i < 10;i++) {
            arrayList.add(new MyCircle(random.nextInt(200), (random.nextInt(10) + 1)));
            System.out.println("OriginalCircle " + (i + 1) + "'s " + arrayList.get(i).toString());
        }

        System.out.println();
        arrayList.sort(MyCircle::compareTo);

        for(i = 0;i < 10;i++) {
            System.out.println("Circle " + (i + 1) + "'s " + arrayList.get(i).toString());
        }
    }
}
