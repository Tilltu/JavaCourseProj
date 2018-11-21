package thread.utils;

import  thread.test.PrinterGUITest;

public class AlphaPrinter implements Runnable{
    Printer printer;

    public AlphaPrinter(Printer p) {
        this.printer = p;
    }

    @Override
    public void run() {
        int i;
        for(i = 0;i < 26;i++) {
            printer.printAlpha();
        }
    }
}
