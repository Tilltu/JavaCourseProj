package gui.utils;

import  java.text.DecimalFormat;

public class CalculateArea {
    double upper_edge, lower_edge, height;
    double area;

    public CalculateArea(String ue, String le, String h) {

        double due = Double.valueOf(ue);
        double dle = Double.valueOf(le);
        double dh = Double.valueOf(h);

        upper_edge = due;
        lower_edge = dle;
        height     = dh;

        this.getArea();
    }

    public double getArea() {
        DecimalFormat format = new DecimalFormat("##.#");
        area = Double.valueOf(format.format((upper_edge + lower_edge) * height / 2));

        return area;
    }

    @Override
    public String toString() {
        return String.valueOf(area);
    }
}
