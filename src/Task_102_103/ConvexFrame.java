package Task_102_103;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

class ConvexFrame extends JFrame {
    static final int width = 500;
    static final int height = 500;
    private ArrayList<R2Point> points = new ArrayList<>();

    private Circle circle;

    ConvexFrame() {
        start();
    }

    void start() {
        this.setSize(width, height);
        this.setTitle("Task 10.2");
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void drawCircle(Circle circle) {
        this.circle = circle;
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g2 = bufferedImage.createGraphics();

        g2.clearRect(0, 0, width, height);
        g2.translate(width / 2, height / 2);
//        g2.drawOval(-5, -5, 10, 10);

        g2.drawLine(-width / 2, 0, width / 2, 0);
        g2.drawLine(0, height / 2, 0, -height / 2);

        if (circle != null) {
            circle.draw(g2);
        }

        for (int curInd = 0; curInd < points.size(); curInd++) {
            int nextInd = curInd + 1;
            if (nextInd == points.size()) {
                nextInd = 0;
            }
            R2Point current = points.get(curInd);
            R2Point next = points.get(nextInd);
            g2.fillOval((int) current.getX() - 2, (int) -current.getY() - 2, 4, 4);
            g2.drawLine((int) current.getX(), (int) -current.getY(), (int) next.getX(), (int) -next.getY());
        }

        g.drawImage(bufferedImage, 0, 0, null); //или в g2d

        if (inFigure() && points.size() > 2) {
            boolean result = true;
            for (int i = 0; i < points.size(); i++) {
                int j = i+1;
                if (j == points.size()) j = 0;
                R2Point firstPoint = points.get(i);
                R2Point secondPoint = points.get(j);
                int x1 = (int) firstPoint.getX();
                int y1 = (int) firstPoint.getY();
                int x2 = (int) secondPoint.getX();
                int y2 = (int) secondPoint.getY();
                int length = (int) Math.min(distPointSegment(x1, y1, x2, y2), distPointSegment(x1, y1, x2, y2));
                if (length < circle.getDiameter()/2) {
                    System.out.println("Круг не внутри фигуры");
                    result = false;
                    break;
                }
                i = j;

            }
            if (result) System.out.println("Круг внутри фигуры");

        }
    }

    public void repaint(Convex convex) {
        this.points = convex.points();
        super.repaint();
    }

    public boolean inFigure() {
        boolean result = false;
        int j = points.size() - 1;
        for (int i = 0; i < points.size(); i++) {
            if ((points.get(i).getY() < 0 && points.get(j).getY() >= 0 || points.get(j).getY() < 0 && points.get(i).getY() >= 0)
                    // Условие при котором окружность в центре координат попадает между значениями points[i](Y) и points[j](Y)
                    &&
                    (points.get(i).getX() + points.get(i).getY() / (points.get(j).getY() - points.get(i).getY()) * (points.get(j).getX() - points.get(i).getX()) < 0))
                // Проверка нахождения стороны points[i]points[j] слева от окружности с центром в центре координат.
                result = !result; // формирование отрицательного ответа при чётном количестве сторон слева и положительного при нечётном
            // коротко говоря, если слева от центра координат находится нечётное количество сторон, то точка внутри, если чётное, то точка снаружи
            j = i;
        }
        return result;
    }

    public double distPointSegment(int x1, int y1, int x2, int y2) {
        double numerator = (x1 * y2 - x2 * y1);
        double denominator = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
        return Math.abs(numerator / denominator);

    }
//    public boolean inFigure1(Circle circle) {
//        for (R2Point point : points) {
//            double hypotenuse = Math.sqrt(point.getX() * point.getX() + point.getY() * point.getY());
//            boolean general = !(hypotenuse >= -circle.getRadius() && hypotenuse <= circle.getRadius());
//            if (general == false) {
//                return false;
//            }
//        }
//        return true;
//    }
}




