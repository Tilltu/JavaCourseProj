package pack1;
import  java.util.Comparator;

public class Fan {
    private int radius;
    private double price;

    public Fan(){}
    public Fan(int r, double p) {
        radius = r;
        price  = p;
    }

    public int getRadius() {
        return radius;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return ("Fan (radius = " + radius + ", price = " + price + ")" );
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Fan)) {
            return false;
        }
        Fan fan = (Fan) obj;

        return (this.price == fan.price && this.radius == fan.radius);
    }


}
