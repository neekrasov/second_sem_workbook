package Task_102_103;

import java.util.ArrayList;

interface Figure{
    double perimeter();
    double area();
    Figure append(R2Point p);
    ArrayList<R2Point> points();
}