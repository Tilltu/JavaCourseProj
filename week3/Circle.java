//package week3;

import java.util.*;

public class Circle {
    public static final double PI = 3.1415926;
    private double radius;
    private double circumference;
    private double area;

    Circle(){
      radius = 0;
      circumference = 0;
      area = 0;
    }
    void setRadius(double r){
        this.radius = r;
    }
    void setCircumference(){
        this.circumference = 2 * PI * radius;
    }
    void setArea(){
        this.area = PI * radius * radius;
    }
    double getRadius(){
        return this.radius;
    }
    double getCircumference(){
        return this.circumference;
    }
    double getArea(){
        return this.area;
    }
    public boolean compareRadius(Circle circle){
        return (this.radius < circle.getRadius());
    }


    public static void main(String[] args){
        Scanner in       = new Scanner(System.in);
        Circle[] circles = new Circle[10];
        int i;
        double radius;
        for (i = 0; i < 10; i++) {
            circles[i] = new Circle();
            radius = in.nextDouble();
            circles[i].setRadius(radius);
            circles[i].setCircumference();
            circles[i].setArea();
        }
        Test test = new Test();

        test.print(circles);

    }

}

class Test{
    void print(Circle[] circles) {
        Circle temp;// = new Circle(); //TODO:why initialization is unnecessary
        int i, k, j;

        for (i = 0; i < 9; i++) {
            k = i;

            for (j = i + 1; j < 10; j++) {
                if (!circles[k].compareRadius(circles[j])) {
                    k = j;
                }
            }
            if(k!=i) {
                temp       = circles[i];
                circles[i] = circles[k];
                circles[k] = temp;
            }

        }

        for (i = 0;i < 10;i++){
            System.out.println("Radius: "        + circles[i].getRadius() + "\n" +
                               "Circumference: " + circles[i].getCircumference() + "\n" +
                                "Area: "         + circles[i].getArea());
        }
    }
}

