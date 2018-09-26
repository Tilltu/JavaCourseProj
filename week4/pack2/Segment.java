package pack2;

import pack1.Point2D;

import java.awt.geom.Line2D;
import java.util.*;


public class Segment {
    private Point2D a;
    private Point2D b;

    private double k, t;

    Segment(Point2D p1){
        a = new Point2D();
        b = p1;

        k = (b.y - a.y) / (b.x - a.x);
        t = 0;
    }
    Segment(Point2D p1, Point2D p2){
        a = p1;
        b = p2;

        k = (b.y - a.y) / (b.x - a.x);
        t = ((b.x * a.y) - (a.x * b.y)) / (b.x - a.x);
    }

    boolean onLine(Point2D p){
       return (p.x * this.k + t == p.y);
    }

    boolean isParallel(Segment line){
        return (line.k == this.k && line.t != this.t);
    }

    boolean isIntersect(Segment line){
        Line2D line1 = new Line2D.Double(this.a.x, this.a.y,
                                         this.b.x, this.b.y);
        Line2D line2 = new Line2D.Double(line.a.x, line.a.y,
                                         line.b.x, line.b.y);

        return line1.intersectsLine(line2);
    }

    String getLine(){
        //StringBuilder res = new StringBuilder();
        String res = ("y = " + this.k +
                   "x + " + this.t + "(Begins at (" +
                   this.a.x + "," + this.a.y + ") " +
                   "(Ends at (" +
                   this.b.x + "," + this.b.y + "))");
        return res;
    }

    public static void main(String[] args){
        Random random = new Random();
        Scanner in    = new Scanner(System.in);
        double      x = (double) random.nextInt(100) + 1;
        double      y = (double) random.nextInt(100) + 1;

        Point2D  zero = new Point2D();

        Segment[] segment = new Segment[5];

        int i, j;
        for(i = 0;i < 5;i++){
                x      = (double) random.nextInt(100) + 1;
                y      = (double) random.nextInt(100) + 1;
            Point2D a1 = new Point2D(x, y);
                x      = (double) random.nextInt(100) + 1;
                y      = (double) random.nextInt(100) + 1;
            Point2D b1 = new Point2D(x, y);
            segment[i] = new Segment(a1, b1);
        }

        for(i = 0;i < 4;i++){
            for(j = i + 1;j < 5;j++){
                if(segment[i].isParallel(segment[j])){
                    System.out.println("Line " + i + ": " +
                                       segment[i].getLine() +
                                       " is parallel with " +
                                       "Line " + j + ": " +
                                       segment[j].getLine());
                }
                else if(segment[i].isIntersect(segment[j])){
                    System.out.println("Line " + i + ": " +
                            segment[i].getLine() +
                            " is intersected with " +
                            "Line " + j + ": " +
                            segment[j].getLine());
                }
                else {
                    System.out.println("Line " + i + ": " +
                            segment[i].getLine() +
                            " has no relation with " +
                            "Line " + j + ": " +
                            segment[j].getLine());
                }
            }
        }
    }

}
