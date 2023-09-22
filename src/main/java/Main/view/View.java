package Main.view;

import Main.service.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class View{
    NewCalc newCalc;

    public double[] Start() throws IOException {
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
    public void ErrorStepen() throws IOException {
        Println("Степень должна быть целым числом без мнимой части");
        //Println("Ответ неверный");
    }

    public void ErrorChastnoe() throws IOException {
        Println("Делимое не может быть нулевым");
        //Println("Ответ неверный");
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
    public void PrintAll(NewCalc newCalc, String op) throws IOException {
        InterfCalc interfCalc = null;
        switch (op){
            case " + ": {
                interfCalc = new Sum();
                Println(Print(newCalc.getA()) + op + Print(newCalc.getB()) + " = " + Print(interfCalc.result(newCalc.getA(), newCalc.getB())));
                break;
            }
            case " - ": {
                interfCalc = new Remain();
                Println(Print(newCalc.getA()) + op + Print(newCalc.getB()) + " = " + Print(interfCalc.result(newCalc.getA(), newCalc.getB())));
                break;
            }
            case " * ": {
                interfCalc = new Prod();
                Println(Print(newCalc.getA()) + op + Print(newCalc.getB()) + " = " + Print(interfCalc.result(newCalc.getA(), newCalc.getB())));
                break;
            }
            case " / ": {
                if (!Arrays.equals(newCalc.getB(), new double[]{0, 0}))
                {
                    interfCalc = new Quot();
                    Println(Print(newCalc.getA()) + op + Print(newCalc.getB()) + " = " + Print(interfCalc.result(newCalc.getA(), newCalc.getB())));
                }
                else
                {
                    ErrorChastnoe();
                }
                break;
            }
            case " ^ ": {
                if (newCalc.getB()[1]==0 && Math.abs(newCalc.getB()[0])==newCalc.getB()[0])
                {
                    interfCalc = new Power();
                    Println(Print(newCalc.getA()) + op + Print(newCalc.getB()) + " = " + Print(interfCalc.result(newCalc.getA(), newCalc.getB())));
                }
                else
                {
                    ErrorStepen();
                }
                break;
            }
        }
        //Println(Print(newCalc.getA()) + op + Print(newCalc.getB()) + " = " + Print(interfCalc.result(newCalc.getA(), newCalc.getB())));
    }
    public void ResultAll(NewCalc newCalc) throws IOException {

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
    public void Case(NewCalc newCalc) throws IOException {
        Println("Вы ввели:");
        Println(Print(newCalc.getA()));
        Println(Print(newCalc.getB()));
        System.out.println("\nВыберите необходимую операцию:");
        System.out.println("  1. \" + \"");
        System.out.println("  2. \" - \"");
        System.out.println("  3. \" * \"");
        System.out.println("  4. \" / \"");
        System.out.println("  5. \" ^ \"");
        System.out.println("    6. Печатать все");
        System.out.println("0. Выход");
        Scanner sc = new Scanner(System.in);
        int choise = sc.nextInt();
        String op = "";
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
            case 6:
                op = " ";
                break;
        }
        if (op.equals(" "))
        {
            ResultAll(newCalc);
        }
        else {
            PrintAll(newCalc,op);
        }
    }
    private void Println(String text) throws IOException {
        System.out.println(text);
        FileWriter File = new FileWriter("log.txt", true);
        File.write(text + "\n");
        File.close();
    }
}
