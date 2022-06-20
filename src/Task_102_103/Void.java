package Task_102_103;

import java.util.ArrayList;

//Класс "Нульугольник", реализующий интерфейс фигуры.
class Void implements Figure{
    R2Point p;

    public double perimeter(){
        return 0.0;
    }

    public double area(){
        return 0.0;
    }

    public Figure append(R2Point p){
        this.p = p;
        return new Point(p);
    }

    public ArrayList<R2Point> points() {
        ArrayList<R2Point> points = new ArrayList<>();
        points.add(p);
        return points;
    }
}