package pack1;

import java.text.DecimalFormat;

public class Circle implements Comparable<Circle> {
    int radius;
    public final double PI = 3.14159;

    public Circle(){}
    public Circle(int r) {
        radius = r;
    }

    public int compareTo(Circle c){
        if(c.radius < this.radius) {
            return -1;
        }
        else if (c.radius == this.radius) {
            return 0;
        }
        else return 1;
    }

    public int getRadius() {
        return radius;
    }

    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return ("Radius = " + format.format(radius) + " Area = " + format.format((PI * Math.pow(radius, 2))));
    }


}
