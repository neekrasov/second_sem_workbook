package Task_102_103;

import java.util.ArrayList;

//Класс "Выпуклая оболочка".
class Convex {
    private Figure fig;
    public Convex() {
        fig = new Void();
    }

    public void add(R2Point p) {
        fig = fig.append(p);
    }

    public double area() {
        return fig.area();
    }

    public double perimeter() {
        return fig.perimeter();
    }

    ArrayList<R2Point> points() {
        return fig.points();
    }


}