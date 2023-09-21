package Main.service;
//Принцип единственной ответственности
//  каждый класс отвечает за свою операцию
public class Prod extends NewCalc implements InterfCalc{
    @Override
    public double[] result(double[] a, double[] b) {
        double a1=a[0];
        double b1=a[1];
        double a2=b[0];
        double b2=b[1];

        double[] result = new double[] {0,0};
        result[0] = a1*a2-b1*b2;
        result[1] = a1*b2+a2*b1;
        return result;
    }
}
