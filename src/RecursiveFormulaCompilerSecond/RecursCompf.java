package RecursiveFormulaCompilerSecond;

public class RecursCompf {
    private static final int DEFSIZE = 256;
    private char[] str;
    private boolean isBefore = false;
    private int index; //Число обработанных символов.

    public RecursCompf() {
        str = new char[DEFSIZE];
    }

    private void compileF() {
        compileT();
        while (true) {
            if (index >= str.length)
                return;
            if (str[index] == '+') {
                index++;
                compileT();
                System.out.print("+ ");
            } else if (str[index] == '-') {
                index++;
                compileT();
                System.out.print("- ");
            } else {
                return;
            }
        }


    }

    private void compileT() {
        compileM();
        while (true) {
            if (index >= str.length)
                return;
            if (str[index] == '*') {
                index++;
                compileM();
                System.out.print("* ");
            } else if (str[index] == '/') {
                index++;
                compileM();
                System.out.print("/ ");
            } else {
                return;
            }
        }
    }

    private void compileM() {
        if (str[index] == '{' ||
            str[index] == '[' ||
            str[index] == '(')
        {
            index++;
            compileF();
            index++;
        } else
            compileV();
        isBefore = false;
    }

    private void compileV() {
        while (
                (index < str.length) &&
                (str[index] != '+' || !isBefore) &&
                (str[index] != '-' || !isBefore) &&
                (str[index] != '*')  &&
                (str[index] != '/')  &&
                (str[index] != '(')  &&
                (str[index] != ')')
        ) {
            System.out.print("" + str[index++] + "");
            isBefore = true; //заглушка для единоразового вывода
        }
        System.out.print(" ");
    }

    public void compile(char[] str) {
        this.str = str;
        index = 0;
        compileF();
        System.out.print("\n");
    }
}
