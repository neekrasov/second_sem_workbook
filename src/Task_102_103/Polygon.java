package Task_102_103;

import java.util.ArrayDeque;
import java.util.ArrayList;


//Класс "Многоугольник", реализующий интерфейс фигуры.
class Polygon extends ArrayDeque<R2Point> implements Figure{
    private double s, p;

    public Polygon(R2Point a, R2Point b, R2Point c){
        addFirst(b);

        if (b.light(a, c)){
            addFirst(a);
            addLast(c);
        }
        else{
            addFirst(c);
            addLast(a);
        }

        p = R2Point.dist(a, b) + R2Point.dist(b, c) + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
    }

    public double perimeter(){
        return p;
    }

    public double area(){
        return s;
    }

    private void grow(R2Point a, R2Point b, R2Point t){
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }

    public Figure append(R2Point t){
        int i;
        //Ищем освещенные ребра, просматривая их одно за другим.
        for(i = size(); i > 0 && !t.light(peekLast(), peekFirst()); i--)
            addLast(removeFirst());

        //УТВЕРЖДЕНИЕ:
        //либо ребро [back(), front()] освещено из t,
        //либо освещенных ребер нет совсем.
        if (i>0){
            R2Point x;
            grow(peekLast(), peekFirst(), t);

            //Удаляем все освещенные ребра из начала дека.
            for(x = removeFirst(); t.light(x, peekFirst()); x = removeFirst())
                grow(x, peekFirst(), t);
            addFirst(x);

            //Удаляем все освещенные ребра из конца дека.
            for (x = removeLast(); t.light(peekLast(), x); x = removeLast())
                grow(peekLast(), x, t);
            addLast(x);

            //Завершаем обработку добавляемой точки.
            assert peekFirst() != null;
            p += R2Point.dist(peekLast(), t) + R2Point.dist(t, peekFirst());
            addFirst(t);
        }

        return this;
    }
    public ArrayList<R2Point> points(){
        return new ArrayList<R2Point>(this);
    }
}