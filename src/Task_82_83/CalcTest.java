package Task_82_83;

import java.util.Scanner;

//Тест для калькулятора формул.
public class CalcTest{
    public static void main(String[] args) throws Exception{
        Calc c = new Calc();

        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("Введите формулу -> ");
            c.compile(in.next().toCharArray());
            System.out.print("\n");
        }
    }
}
