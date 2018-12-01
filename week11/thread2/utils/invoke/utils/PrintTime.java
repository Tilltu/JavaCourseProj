package thread2.utils.invoke.utils;

import  thread2.utils.invoke.test.InvokeTest;

public class PrintTime implements Runnable{
    InvokeWrapper invokeWrapper;

    public PrintTime(InvokeWrapper invokeWrapper) {
        this.invokeWrapper = invokeWrapper;
    }

    @Override
    public void run() {
        for(int i = 0;i < 10;i++) {
            if(i == 9) {
                InvokeWrapper.EOF = true;
            }
            InvokeTest.area.append("No." + (i + 1) + " \n");
            invokeWrapper.printTime();
        }
    }

}
