package StackCalculator;
import java.util.Stack;
//Стековый компилятор формул.
public class Compf extends Stack<Character>{
    //Типы символов (скобки, знаки операций, иное).
    protected final static int SYM_LEFT = 0,
            SYM_RIGHT = 1,
            SYM_OPER = 2,
            SYM_OTHER = 3;

    protected int symType(char c){
        return switch (c) {
            case '(' -> SYM_LEFT;
            case ')' -> SYM_RIGHT;
            case '+', '-', '*', '/' -> SYM_OPER;
            default -> symOther(c);
        };
    }

    private void processSymbol(char c){
        switch (symType(c)) {
            case SYM_LEFT -> push(c);
            case SYM_RIGHT -> {
                processSuspendedSymbols(c);
                pop();
            }
            case SYM_OPER -> {
                processSuspendedSymbols(c);
                push(c);
            }
            case SYM_OTHER -> nextOther(c);
        }
    }

    private void processSuspendedSymbols(char c){
        while(precedes(peek(), c))
            nextOper(pop());
    }

    protected int priority(char c){
        return c == '+' || c == '-' ? 1 : 2;
    }

    protected boolean precedes(char a, char b){
        if(symType(a) == SYM_LEFT) return false;
        if(symType(b) == SYM_RIGHT) return true;

        return priority(a) >= priority(b);
    }

    protected int symOther(char c){
        if (c < 'a' || c > 'z'){
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }

        return SYM_OTHER;
    }

    protected void nextOper(char c){
        System.out.print("" + c + " ");
    }

    protected void nextOther(char c){
        nextOper(c);
    }

    public Integer compile(char[] str){
        processSymbol('(');

        for (char c : str) processSymbol(c);

        processSymbol(')');

        System.out.print("\n");
        return null;
    }
}
