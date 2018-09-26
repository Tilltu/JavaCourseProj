package pack1;

import java.math.*;
import java.util.*;

public class Point2D {
   public double x, y;

   public Point2D(){
       x = 0;
       y = 0;
   }
   public Point2D(double x, double y){
       this.x = x;
       this.y = y;
   }
   public double getDistance(Point2D target_point1, Point2D target_point2){

       return Math.sqrt(Math.pow((target_point2.x - target_point1.x), 2) +
                        Math.pow((target_point2.y - target_point1.y), 2));
   }
   public double areaOfTriangle(Point2D a, Point2D b, Point2D c){
       double[] edge = new double[3];
       edge[0]       = getDistance(a, b);
       edge[1]       = getDistance(a, c);
       edge[2]       = getDistance(b, c);

       double      p = (edge[0] + edge[1] + edge[2]) / 2;

       if(edge[0] + edge[1] > edge[2] &&
          edge[0] + edge[2] > edge[1] &&
          edge[1] + edge[2] > edge[0]){

           return Math.sqrt(p * (p - edge[0]) + (p - edge[1])
                            + (p - edge[2]));
       }

       else {
           return 0;
       }

   }
   public void test(){
       Random random = new Random();
       double      x = random.nextDouble();
       double      y = random.nextDouble();
       Point2D     a = new Point2D(x,y);
       Point2D     b = new Point2D(x,y);
       Point2D     c = new Point2D(x,y);
       double   dist = getDistance(a, b) + getDistance(a, c) +
                       getDistance(b, c);
       double   area = areaOfTriangle(a, b, c);


   }


}
