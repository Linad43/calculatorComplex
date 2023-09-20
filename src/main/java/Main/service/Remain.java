package Main.service;

public class Remain extends NewCalc implements InterfCalc{
    @Override
    public double[] result(double[] a, double[] b) {
        double[] result = new double[2];
        for (int i = 0; i < a.length; i++)
        {
            result[i] = a[i] - b[i];
        }
        return result;
    }
}
