package pack2;
import  pack1.*;

public class Box2 extends Box{
    String number;

    public Box2(){}
    public Box2(double l, double w, double d, String c, String num) {
        super(l, w, d, c);
        number  = num;
    }

    public String toString() {
        String res;
        res = ("Length = " + length     + " Width = "   + width +
               " Depth = " + getDepth() + " Color = "   + getColor() +
               " Area = "  + area()     + " Number = "  + number);
        return res;
    }

}
