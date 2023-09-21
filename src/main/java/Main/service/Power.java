package Main.service;
//Принцип единственной ответственности
//  каждый класс отвечает за свою операцию
public class Power extends NewCalc implements InterfCalc{
    @Override
    public double[] result(double[] a, double[] b) {
        int n = (int) b[0];
        double[] result = a;
        while (n>=2)
        {
            interfCalc = new Prod();
            result = interfCalc.result(a,result);
            n--;
        }
        return result;
    }
}
