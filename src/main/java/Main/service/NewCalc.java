package Main.service;

public class NewCalc implements InterfCalc{
    InterfCalc interfCalc;
    protected double[] a = new double[2];
    protected double[] b = new double[2];

    public double[] getA() {
        return a;
    }

    public double[] getB() {
        return b;
    }

    public void setA(double[] a) {
        this.a = a;
    }

    public void setB(double[] b) {
        this.b = b;
    }

    @Override
    public double[] result(double[] a, double[] b) {
        return new double[0];
    }
}
