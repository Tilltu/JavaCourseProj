package thread.test;

import  thread.utils.ThreadRandomDigits;

public class ThreadRandomDigitsTest {
    public static void main(String[] args) {

        ThreadRandomDigits trd = new ThreadRandomDigits();
        Thread t = new Thread(trd);

        t.start();

    }
}
