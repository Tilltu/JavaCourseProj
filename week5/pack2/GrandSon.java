package pack2;
import  pack1.Son;
import  java.util.*;

public class GrandSon extends Son{

    GrandSon(){}
    GrandSon(double fa, double sa, double gsa) {
        super(fa, sa);
        this.gsa = gsa;
    }

    public void printHouseArea() {
        super.printHouseArea();
        System.out.println("The Area Of Grandson's House Is " + this.gsa);
    }
    public static void main(String[] args) {

        double fa         = 200d;
        double sa         = 80d;
        double gsa        = 160d;
        GrandSon grandSon = new GrandSon(fa, sa, gsa);

        grandSon.printHouseArea();


    }
}
