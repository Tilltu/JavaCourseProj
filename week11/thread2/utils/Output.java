package thread2.utils;

public class Output implements Runnable{
    StringReverse sr;

    public Output (StringReverse sr) {
        this.sr = sr;
    }

    @Override
    public void run() {
          while (true) {
              sr.output();
          }

    }

}
