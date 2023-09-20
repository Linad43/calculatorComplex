package Main;

import Main.controller.Controller;
import Main.service.NewCalc;
import Main.view.View;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new View(), new NewCalc());
        controller.StartProgram();
    }

}