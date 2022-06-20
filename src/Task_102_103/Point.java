package Task_102_103;

import java.util.ArrayList;

//Класс "Одноугольник", реализующий интерфейс фигуры.
class Point implements Figure{
    private R2Point p;

    public Point(R2Point p){
        this.p = p;
    }

    public double perimeter(){
        return 0.0;
    }

    public double area(){
        return 0.0;
    }

    public Figure append(R2Point q){
        if(!R2Point.equals(p, q))
            return new Segment(p, q);
        else
            return this;
    }

    public ArrayList<R2Point> points(){
        ArrayList<R2Point> points = new ArrayList<R2Point>();
        points.add(p);
        return points;
    }
}