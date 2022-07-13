package StackCalculator;

import java.util.ArrayList;
import java.util.Stack;

//Калькулятор арифметических формул.
public class Calc extends Compf {
    private final Stack<Integer> s;
    private final ArrayList<Integer> preS = new ArrayList<>();

    public Calc() {
        s = new Stack<>();
    }

    protected static int char2int(char c) {
        return (int) c - (int) '0';
    }

    private void buildNum() {
        if (preS.isEmpty())
            return;

        int number = 0;
        int degree = 0;

        while (!preS.isEmpty()) {
            number += preS.get(preS.size() - 1) * (Math.pow(10, degree++));
            preS.remove(preS.size() - 1);
        }
        s.push(number);
    }

    @Override
    protected int symType(char c) {
        switch (c) {
            case '(', '[', '{' -> {
                buildNum();
                return SYM_LEFT;
            }
            case ')', ']', '}' -> {
                buildNum();
                return SYM_RIGHT;
            }
            case '+', '-', '*', '/' -> {
                buildNum();
                return SYM_OPER;
            }
            default -> {
                return symOther(c);
            }
        }
    }


    @Override
    protected int symOther(char c) {
        if (c < '0' || c > '9') {
            System.out.println("Недопустимый символ: " + c);

            System.exit(0);
        }

        return SYM_OTHER;
    }

    @Override
    protected void nextOper(char c) {
        int second = s.pop();
        int first = s.pop();

        switch (c) {
            case '+' -> s.push(first + second);
            case '-' -> s.push(first - second);
            case '*' -> s.push(first * second);
            case '/' -> s.push(first / second);
        }
    }

    @Override
    protected void nextOther(char c) {
        preS.add(char2int(c));
    }

    @Override
    protected int priority(char c) {
        return c == '*' || c == '/' ? 1 : 2;
    }

    @Override
    public final Integer compile(char[] str) {
        super.compile(str);

        System.out.println("" + s.peek());
        return s.peek();

    }
}
