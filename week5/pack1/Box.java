package pack1;
import  pack2.Box2;
import  java.util.*;

public class Box {
    public    double length;
    protected double width;
    double           depth;
    private   String color;

    public    Box(){}
    public    Box(double l, double w, double d, String c) {
        length = l;
        width  = w;
        depth  = d;
        color  = c;
    }

    public    double getDepth() {
        return depth;
    }
    protected double area(){
        return length * width * depth;
    }
    public    String getColor() {
        return color;
    }
}

class Box1 extends Box{
    protected String name;

    public Box1(){}
    public Box1(double l, double w, double d, String c, String n) {
        super(l, w, d, c);
        name  = n;
    }

    public String toString() {
        String res;
        res = ("Length = " + length + " Width = " + width +
               " Depth = " + depth  + " Color = " + getColor() +
               " Area = "  + area() + " Name = "  + name);
        return res;
    }

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        //Initialize box1
        double l1   = src.nextDouble();
        double w1   = src.nextDouble();
        double d1   = src.nextDouble();
        String c1   = src.next();
        String name = src.next();
        //Initialize box2
        double l2   = src.nextDouble();
        double w2   = src.nextDouble();
        double d2   = src.nextDouble();
        String c2   = src.next();
        String num  = src.next();

        Box1 box1 = new Box1(l1, w1, d1, c1, name);
        Box2 box2 = new Box2(l2, w2, d2, c2, num );

        System.out.println("Box1 : " + box1.toString());
        System.out.println("Box2 : " + box2.toString());


    }
}
