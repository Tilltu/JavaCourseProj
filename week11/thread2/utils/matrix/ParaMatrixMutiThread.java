package thread2.utils.matrix;

public class ParaMatrixMutiThread implements Runnable{
    Matrix matrix;

    public ParaMatrixMutiThread(Matrix m) {
        this.matrix = m;
    }

    @Override
    public void run() {
        String thread_name = Thread.currentThread().getName();

        int row = Integer.valueOf(thread_name);
        matrix.parallelMatrixMultiplication(row);
    }
}
