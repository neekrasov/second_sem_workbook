package Task_52;

import java.util.Scanner;

public class Main {
    /*
1.Множество натуральных чисел, без незначащих нулей.
2.Множество действительных чисел, без незначащих нулей.
3.Корректные адреса электронной почты.
     */

    public static void isSetNaturalNumbers() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.nextLine();
            if (input.equals("q")){
                break;
            }else{
                System.out.println(input.matches("((1|2|3|4|5|6|7|8|9)+0*)+"));
            }
        }
    }
    public static void isSetRealNumbers() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.nextLine();
            if (input.equals("q")){
                break;
            }else{
                System.out.println(input.matches("-?((((1|2|3|4|5|6|7|8|9)+0*)+)|0)\\.?((0|1|2|3|4|5|6|7|8|9)*)|0"));
            }
        }
    }
    public static void isMail() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.nextLine();
            if (input.equals("q")){
                break;
            }else{
                System.out.println(input.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]+"));
            }
        }
    }
    public static void main(String[] args){
        isSetRealNumbers();
    }
}
