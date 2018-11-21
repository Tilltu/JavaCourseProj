package thread.utils;

import  thread.test.PrinterGUITest;

public class DigitPrinter implements Runnable{
    Printer printer;


    public DigitPrinter(Printer p) {
        this.printer = p;
    }

    @Override
    public void run() {
        int i;
        for(i = 0;i < 26;i++) {
            printer.printDigit();
        }
    }

}
