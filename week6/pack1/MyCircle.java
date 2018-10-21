package pack1;

public class MyCircle extends Circle{
    String color;
    String[] colors = {"Red", "Orange", "Yellow", "Green", "Cyan", "Blue", "Purple", "White", "Black", "Pink"};

    int getColorIndex(String color) {
        int i;
        for(i = 0;i < 10;i++) {
            if(color == colors[i]) {
                return i;
            }
        }
        return -1;
    }


    public int compareTo(MyCircle src) {
        if(src.getColorIndex(src.color) < this.getColorIndex(this.color)) {
            return -1;
        }
        else if (src.getColorIndex(src.color) == this.getColorIndex(this.color)) {
            return 0;
        }
        else return 1;
    }

    public String howToPrint(int num) {
        return colors[num - 1];
    }
    public MyCircle(){}
    public MyCircle(int r, int num) {
        super(r);
        this.color = howToPrint(num);
    }

    @Override
    public String toString() {
        return (super.toString() + " Color = " + color);
    }
}
