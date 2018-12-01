package thread2.utils.invoke.utils;

public class Supervisor implements Runnable{
    InvokeWrapper invokeWrapper;
    Thread thread;

    public Supervisor(InvokeWrapper invokeWrapper, Thread t) {
        this.invokeWrapper = invokeWrapper;
        thread = t;
    }

    @Override
    public void run() {
        while (!InvokeWrapper.EOF) {
            invokeWrapper.supervisor(thread);
        }
    }

}
