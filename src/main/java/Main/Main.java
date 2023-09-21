package Main;

import Main.controller.Controller;
import Main.service.NewCalc;
import Main.service.Sum;
import Main.view.View;

public class Main {
    public static void main(String[] args) {
        //Принцип подстановки Барбары Листков
        //  При подставлении вместо родительского класс ребенок, ничего не сломаеться
        Controller controller = new Controller(new View(), new NewCalc()/*new Sum()*/);
        controller.StartProgram();
    }

}