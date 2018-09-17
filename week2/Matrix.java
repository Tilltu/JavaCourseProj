//package java.matrix;
import java.math.*;
import java.util.*;

class GetGreatestNum{

    double big[];
    int location[][];

    protected GetGreatestNum(){
        big = new double[5]; // store greatest numbers
        location = new int[5][];
        for(int i = 0;i < 5;i++){
            location[i] = new int[2]; //store the location of the numbers above
        }
    }

    public GetGreatestNum getNum(Matrix m){
       GetGreatestNum output = new GetGreatestNum();
       int i, j;
       for(i = 0;i < 5;i++){
           output.big[i] = 0;
           output.location[i][0] = -1;
           output.location[i][1] = -1;
       }
        for (i = 0; i < m.size; i++) {
            for (j = 0; j < m.size; j++){
               if(output.big[0] <= m.matrix[i][j]){
                   output.big[0] = m.matrix[i][j];
                   output.location[0][0] = i;
                   output.location[0][1] = j;
               }
            }
        }
       int flag = 1;
       while(flag < 5) {
           for (i = 0; i < m.size; i++) {
               for (j = 0; j < m.size; j++) {
                   if ((output.big[flag] <= m.matrix[i][j]) &&
                       (m.matrix[i][j] <= output.big[flag-1]) &&
                       (i != output.location[flag-1][0]) &&
                       (j != output.location[flag-1][1])) {

                       output.big[flag] = m.matrix[i][j];
                       output.location[flag][0] = i;
                       output.location[flag][1] = j;
                   }
               }
           }
           flag++;
       }
       return output;
    }

    public void print(Matrix m){
        int i;
        for(i = 0; i < 5; i++){
            System.out.print("No." + (i + 1)  + " digit is " + getNum(m).big[i] +
                             "   Location is (" + getNum(m).location[i][0]
                             + "," + getNum(m).location[i][1] + ")\n");
        }
    }
}

class FindSaddlePoint{
    double value;
    int location[];

    public FindSaddlePoint(){
        value       = 0;
        location    = new int[2];
    }

    protected int[] getMaxInRow(int row, Matrix m){
        int j;
        double max = m.matrix[row][0];
        int loca[];
        loca    = new int[2];

        for(j = 0;j < m.size;j++){
            if(max <= m.matrix[row][j]){
                max     = m.matrix[row][j];
                loca[0] = row;
                loca[1] = j;
            }
        }
        return loca;
    }
    protected int[] getMinInCol(int col, Matrix m){
        int i;
        double min = m.matrix[0][col];
        int loca[];
        loca    = new int[2];
        for(i = 0;i < m.size;i++){
            if(min >= m.matrix[i][col]){
                min     = m.matrix[i][col];
                loca[0] = i;
                loca[1] = col;
            }
        }
        return loca;
    }

    public void getSaddlePoint(Matrix m) {
        int i;
        double val = 0;
        int if_max[] = new int[2];
        int if_min[] = new int[2];
        boolean flag = false;

        for (i = 0; i < m.size; i++) {
            if_max[0] = getMaxInRow(i, m)[0];
            if_max[1] = getMaxInRow(i, m)[1];
            if_min[0] = getMinInCol(if_max[1], m)[0];
            if_min[1] = getMinInCol(if_max[1], m)[1];
            System.out.println("max :" + if_max[0] + "," + if_max[1] + ":::" +
                               "min :" + if_min[0] + "," + if_min[1]);
            if (if_max[0] == if_min[0] && if_max[1] == if_min[1]) {
                val = m.matrix[if_max[0]][if_max[1]];
                flag = true;
                break;
            }
        }

        location[0] = if_max[0];
        location[1] = if_max[1];
        if(flag){
            System.out.println("The Saddle Point is " + val +
                               "\nLocation is (" + location[0] + "," + location[1] + ")");
        }
        else {
            System.out.println("No Saddle Point Found!");
        }

    }


}

public class Matrix {
    int size;
    double matrix[][];
    
    
    
    public int getSize() {
        return size;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    private void print(Matrix m){
        int i, j;
        for(i = 0;i < m.size; i++){
            for(j = 0;j < m.size;j++){
                System.out.print(m.matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    private void initMatrix(int size){
        int i, j;
        this.size = size;
        double s = this.size;
        this.matrix = new double[this.size][];
        for(i = 0;i < s;i++){
            this.matrix[i] = new double[size];
        }
        for(i = 0;i < s;i++){
            for(j = 0;j < s;j++){
                this.matrix[i][j] = Math.random();
            }
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            Matrix m = new Matrix();
            int gate = in.nextInt();
            if(gate<=5){
                System.out.println("Iuput Error! Try Again!");
                continue;
            }
            m.initMatrix(gate);
            int opration = in.nextInt();
            switch (opration){
                case 1:{
                    System.out.println("*********Finding Top 5 Digits*********");
                    GetGreatestNum res = new GetGreatestNum();
                    //m.print(m);
                    res.getNum(m);
                    res.print(m);
                    break;
                }
                case 2:{
                    System.out.println("*********Finding Saddle Point*********");
                    FindSaddlePoint res = new FindSaddlePoint();
                    res.getSaddlePoint(m);
                    break;
                }
                default:{
                    System.out.println("No Such Operation!");
                    break;
                }
            }

        }
    }
}

