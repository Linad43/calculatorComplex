package Main.controller;

import Main.service.NewCalc;
import Main.view.View;

public class Controller{
    View view;
    NewCalc calc;

    static double[] resultX = new double[2];

    public Controller(View view, NewCalc calc) {
        this.view = view;
        this.calc = calc;
    }
    public void StartProgram(){
        double[] buf = view.Start();
        double[] a = {buf[0], buf[1]};
        double[] b = {buf[2], buf[3]};
        calc.setA(a);
        calc.setB(b);
        view.Case(calc);
    }
}
