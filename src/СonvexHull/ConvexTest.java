package СonvexHull;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Тест для выпуклой оболочки.
class ConvexTest {
    static void whileTest(FileWriter fw) throws IOException {
        Convex convex = new Convex();
        ConvexFrame frame = new ConvexFrame();
        Scanner in = new Scanner(System.in);

        int count = 0;
        System.out.println("Для выхода из программы используйте значение 'q' в одной из переменных.");
        System.out.println("Для начала введите радиус круга.");

        System.out.print("r -> ");
        String r = in.nextLine();

        frame.drawCircle(new Circle(((int) Double.parseDouble(r))*2));

        System.out.println("Теперь вводите координаты точек.");

        while (true) {
            System.out.print("x -> ");
            String x = in.nextLine();
            System.out.print("y -> ");
            String y = in.nextLine();
            if (x.equals("q")||y.equals("q")) break;
            try {
                convex.add(new R2Point(Double.parseDouble(x), Double.parseDouble(y)));
                fw.write("Point:" + ++count + "\n x:" + x + "\n y:" + y+"\n");
                frame.repaint(convex);
                System.out.println("S = " + convex.area() + ", P = " + convex.perimeter());
            }catch (NumberFormatException e) {
                System.out.println("Введите корректные данные.");
            }

        }
    }

    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("files/hh.txt");
        whileTest(fw);
        fw.close();
        System.exit(0);
    }
}