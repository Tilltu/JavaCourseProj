package mystring.pack1;

public class Goods {
    private double  weight;
    private int     level;
    private boolean danger;

    public Goods(){}
    public Goods(double weight, int i) {
        this.weight = weight;
        this.level  = i;
        if(i >= 8) {
            this.danger = true;
        }else {
            this.danger = false;
        }
    }

    public double getWeight() {
        return weight;
    }

    public boolean isDanger() {
        return danger;
    }

    public void printInfo() {
        System.out.printf("Weight = %f, Level = %d, IsDangerous : %s\n", weight, level, danger);
    }
}
