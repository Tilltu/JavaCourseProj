package thread2.utils.matrix;

import  java.text.DecimalFormat;
import  java.util.Random;
import  thread2.test.MatrixTest;

public class Matrix {
    public static double[][] matrix1;
    public static double[][] matrix2;
    public static double[][] pres;
    public static double[][] res;
    public static int        size;


    public static volatile long time = 0;


    public long getTime() {
        return time;
    }


    /**
     *
     * @param n is the size of the matrix
     *
     *   Constructor use Random to generate random number to fill the source matrix
     *   and the destination matrix.  Also it initializes the result matrix of sequence matrix
     *   multiplication denoted as res and the result matrix of parallel matrix multiplication
     *   denoted as pres.
     */
    public Matrix(int n) {
        int i, j;
        Random seed = new Random();

        size = n;

        matrix1 = new double[size][];
        matrix2 = new double[size][];

        res  = new double[size][];
        pres = new double[size][];

        for (i = 0;i < size;i++) {
            res [i] = new double[size];
            pres[i] = new double[size];
        }

        for (i = 0;i < size;i++) {
            for (j = 0;j < size;j++) {
                pres[i][j] = 0;
                res [i][j]  = 0;
            }
        }

        for (i = 0;i < size;i++) {
            matrix1[i] = new double[size];
            matrix2[i] = new double[size];
        }

        for (i = 0;i < size;i++) {
            for (j = 0;j < size;j++) {
                matrix1[i][j] = seed.nextDouble() * 10;
                matrix2[i][j] = seed.nextDouble() * 10;
            }
        }
    }

    /**
     *      function applies mathematics rule to multiply matrices sequentially
     */
    public void sequenceMatrixMultiplication() {


        DecimalFormat format = new DecimalFormat("\f.00");

        int i, j, k;

        long time = 0;

        for (i = 0;i < size;i++) {
            long start_time = System.currentTimeMillis();
            for (j = 0;j < size;j++) {
                for (k = 0;k < size;k++) {
                    res[i][j] += matrix2[k][j] * matrix1[i][k];
                }
            }
            long end_time = System.currentTimeMillis();
            time += (end_time - start_time);
        }
        MatrixTest.area.append("Sequence Time Used : " + time + " ms\n\n");

        /*for (i = 0;i < size;i++) {
            for (j = 0;j < size;j++) {
                if (j == size - 1) {
                    System.out.print(format.format(res[i][j]) + "\n");
                } else {
                    System.out.print(format.format(res[i][j]) + " ");      // if you want to see
                                                                          // the sequential matrix result
                                                                         // just uncomment this.
                }
            }
        }*/

    }



    /**
     *  Each thread do a part of the multiplication.
     *  For example, if threads number is 4, matrix size is 2000,
     *  then each thread do 2000 / 4 = 500 row multiplication, and row is
     *  set in each thread's name.
     * @param row
     */
    public synchronized void parallelMatrixMultiplication(int row) {

        int i, j, k;
        int start_pos = (size / MatrixTest.threads_num) * row;
        int end_pos   = (size / MatrixTest.threads_num) * (row + 1);


        long start_time = System.currentTimeMillis();
        for(i = start_pos;i < end_pos;i++) {
            for (j = 0; j < size; j++) {
                for (k = 0; k < size; k++) {
                    pres[i][j] += matrix2[k][j] * matrix1[i][k];
                }
            }
        }
        long end_time = System.currentTimeMillis();
        time += (end_time - start_time);

    }





    /**
     *  function use to print the time used by parallel multiplication.
     */
    public void printPres () {
        int i, j;

        /*DecimalFormat format = new DecimalFormat("\f.00");

        for (i = 0;i < size;i++) {
            for (j = 0; j < size; j++) {
                if (j == size - 1) {
                    System.out.print(format.format(pres[i][j]) + "\n");        // if you want to see
                                                                              // the parallel matrix result
                                                                             // just uncomment this.
                } else {
                    System.out.print(format.format(pres[i][j]) + " ");
                }
            }
        }*/

        MatrixTest.area.append("Parallel Time Used : " + time + " ms");
    }
}
