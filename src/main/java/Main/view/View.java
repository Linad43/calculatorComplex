package Main.view;

import Main.service.*;

import java.util.Arrays;
import java.util.Scanner;

public class View{
    NewCalc newCalc;

    public double[] Start() {
        Scanner sc = new Scanner(System.in);
        double[] A = new double[4];
        System.out.println("Калькулятор комплексных чисел в виде (A+Bi)");
        System.out.println("Введите первое число");
        System.out.println("А = ");
        A[0] = sc.nextDouble();
        System.out.println("В = ");
        A[1] = sc.nextDouble();
        System.out.println("Введите второе число");
        System.out.println("А = ");
        A[2] = sc.nextDouble();
        System.out.println("В = ");
        A[3] = sc.nextDouble();
        return A;
    }
    public void ErrorStepen() {
        System.out.println("Степень должна быть целым числом без мнимой части");
        //System.out.println("Ответ неверный");
    }

    public void ErrorChastnoe() {
        System.out.println("Делимое не может быть нулевым");
        //System.out.println("Ответ неверный");
    }
    public String Print(double[] a)
    {
        String text;
        text = "( " + a[0];
        if (a[1]>=0)
        {
            text = text + " + ";
        }
        else
        {
            text = text + " - ";
        }
        text = text + Math.abs(a[1]) + "i )";
        return text;
    }
    public void PrintAll(NewCalc newCalc, String op)
    {
        InterfCalc interfCalc = null;
        switch (op){
            case " + ": {
                interfCalc = new Sum();
                break;
            }
            case " - ": {
                interfCalc = new Remain();
                break;
            }
            case " * ": {
                interfCalc = new Prod();
                break;
            }
            case " / ": {
                interfCalc = new Quot();
                break;
            }
            case " ^ ": {
                interfCalc = new Power();
                break;
            }
        }
        System.out.println(Print(newCalc.getA()) + op + Print(newCalc.getB()) + " = " + Print(interfCalc.result(newCalc.getA(), newCalc.getB())));
    }
    public void ResultAll(NewCalc newCalc)
    {

        System.out.println("Результаты:");
        PrintAll(newCalc, " + ");
        PrintAll(newCalc," - ");
        PrintAll(newCalc," * ");
        if (!Arrays.equals(newCalc.getB(), new double[]{0, 0}))
        {
            PrintAll(newCalc, " / ");
        }
        else
        {
            ErrorChastnoe();
        }
        if (newCalc.getB()[1]==0 && Math.abs(newCalc.getB()[0])==newCalc.getB()[0])
        {
            PrintAll(newCalc, " ^ ");
        }
        else
        {
            ErrorStepen();
        }
    }
    public void Case(NewCalc newCalc) {
        System.out.println("Вы ввели:");
        System.out.println(Print(newCalc.getA()));
        System.out.println(Print(newCalc.getB()));
        System.out.println("\nВыберите необходимую операцию:");
        System.out.println("  1. \" + \"");
        System.out.println("  2. \" - \"");
        System.out.println("  3. \" * \"");
        System.out.println("  4. \" / \"");
        System.out.println("  5. \" ^ \"");
        System.out.println("0. Выход");
        Scanner sc = new Scanner(System.in);
        int choise = sc.nextInt();
        String op = " ";
        switch (choise)
        {
            case 1:
                op = " + ";
                break;
            case 2:
                op = " - ";
                break;
            case 3:
                op = " * ";
                break;
            case 4:
                op = " / ";
                break;
            case 5:
                op = " ^ ";
                break;
        }
        if (!op.equals(" "))
        {
            PrintAll(newCalc, op);
        }
    }
}
