package thread2.utils;

public class Input implements Runnable {
    StringReverse sr;

    public Input (StringReverse sr) {
        this.sr = sr;
    }
    @Override
    public void run() {
          while (true) {
              sr.input();
          }

    }

}
