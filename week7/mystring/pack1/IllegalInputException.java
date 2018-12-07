package mystring.pack1;

public class IllegalInputException extends Exception{
    String msg;

    public IllegalInputException(String statement) {
        msg = "[IllegalInputException]: " + statement + "\nInput Error! Please Retry!\n";
    }
    public void printMessage() {
        System.out.println(msg);
    }
}
