package Task_63;

import java.util.Scanner;

public class RecursCompfTest {
    public static void main(String[] args) throws Exception{
        RecursCompf c = new RecursCompf();

        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("Введите формулу -> ");
            c.compile(in.next().toCharArray());
        }
    }
}
