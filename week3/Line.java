//package week3;
import java.awt.geom.*;
import java.util.Scanner;


class LineEquation {
    double k;
    double b;
    LineEquation(double [][] normal_line){
        k = (normal_line[0][1] - normal_line[1][1]) /
            (normal_line[0][0] - normal_line[1][0]);

        b = ((normal_line[0][0] * normal_line[1][1]) -
             (normal_line[1][0] * normal_line[0][1])) /
             (normal_line[0][0] - normal_line[1][0]);
    }
    double[] getIntersectPoint(LineEquation counter_line){
        double[] intersect_point = new double[2];
        intersect_point[0] = (counter_line.b - this.b) /
                             (this.k - counter_line.k);
        intersect_point[1] = this.k * intersect_point[0] +
                             this.b;
        return intersect_point;
    }

}


class LinearFunc {
    boolean isCrossed(Line line) {
        Line2D line1 = new Line2D.Double(line.getPoint1()[0][0],
                                         line.getPoint1()[0][1],
                                         line.getPoint1()[1][0],
                                         line.getPoint1()[1][1]);
        Line2D line2 = new Line2D.Double(line.getPoint2()[0][0],
                                         line.getPoint2()[0][1],
                                         line.getPoint2()[1][0],
                                         line.getPoint2()[1][1]);
        return line1.intersectsLine(line2);
    }
    void getIntersectPoint(Line line){
        if(!isCrossed(line)){
            System.out.println("These Two Lines Are NOT Intersected!");
            return;
        }
        LineEquation line1 = new LineEquation(line.getPoint1());
        LineEquation line2 = new LineEquation(line.getPoint2());
        double[] p         = line1.getIntersectPoint(line2);
        System.out.println("The Intersected Point Is (" +
                            p[0] + "," +
                            p[1] + ")");
    }


}

public class Line {
    private double[][] point1;
    private double[][] point2;

    Line(){
        point1 = new double[2][];
        point2 = new double[2][];
        for(int i = 0;i < 2;i++){
            point1[i] = new double[2];
            point2[i] = new double[2];
        }
    }

    void lineInit(double[] coordinate){
        int flag = 0;
        for(int i = 0;i < 2;i++){
            for(int j = 0;j < 2;j++){

                point1[i][j] = coordinate[flag++];
            }
        }
        for(int i = 0;i < 2;i++){
            for(int j = 0;j < 2;j++){

                point2[i][j] = coordinate[flag++];
            }
        }
    }

    double[][] getPoint1(){
        return point1;
    }
    double[][] getPoint2(){
        return point2;
    }

    public static void main(String [] args){
        double[] coordinate = new double[8];
        Scanner in = new Scanner(System.in);
        //while(in.hasNext()){
            int i;
            System.out.println("Please Input The First Line\n" +
                    "The Sequence Is X1, Y1, X2, Y2");
            for(i = 0;i < 4;i++){
                coordinate[i] = in.nextDouble();
            }
            System.out.println("Please Input The Second Line\n" +
                    "The Sequence Is X3, Y3, X4, Y4");
            for(i = 4;i < 8;i++){
                coordinate[i] = in.nextDouble();
            }
            Line line = new Line();
            line.lineInit(coordinate);
            LinearFunc test = new LinearFunc();
            test.getIntersectPoint(line);
       // }
    }
}

