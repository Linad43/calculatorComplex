package Main.service;
//Принцип открытости/закрытости
//  наследующие классы дополняют родительский класс
//Принцип разделения интерфейса
//	В программе не переопределенно пустых или бессмысленных методов
//Принцип инверсии зависимостей
//	Класы наследуются от данного интерфейса, и метод резутьтат есть у всех наследников
public interface InterfCalc {
    double[] result(double[] a, double[] b);

}
