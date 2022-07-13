package RecursiveFormulaCompiler;


import java.util.Scanner;

public class RecurCompfTest {
    public static void main(String[] args) throws Exception {
        RecurCompf c = new RecurCompf();

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Введите формулу -> ");
            c.compile(in.next().toCharArray());
        }
    }
}
