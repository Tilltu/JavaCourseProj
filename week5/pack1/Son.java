package pack1;


class Father{
    public double fa;
    public double sa;
    public double gsa;

    Father(){}
    Father(double a) {
        this.fa = a;
    }
    void printHouseArea() {
        System.out.println("The Area Of Father's House Is " + this.fa);
    }

}

public class Son extends Father {
    public Son(){}
    public Son(double fa, double sa) {
        super(fa);
        this.sa  = sa;
    }


    public void printHouseArea() {
        super.printHouseArea();
        System.out.println("The Area Of Son's House Is " + this.sa);
    }

}
