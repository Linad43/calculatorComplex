package Main;

import Main.controller.Controller;
import Main.service.NewCalc;
//import Main.service.Sum;
import Main.view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Принцип подстановки Барбары Листков
        //  При подставлении вместо родительского класс ребенок, ничего не сломаеться
        Controller controller = new Controller(new View(), new NewCalc()/*new Sum()*/);
        controller.StartProgram();
    }

}