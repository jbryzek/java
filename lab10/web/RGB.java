package lab10_.demo.web;

public class RGB {
    public double[] R = new double[256];
    public double[] G = new double[256];
    public double[] B = new double[256];

    public RGB(){}

    public RGB(double[] lut1, double[] lut2, double[] lut3) {
        R = lut1;
        G = lut2;
        B = lut3;
    }
}