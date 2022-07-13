package СonvexHull;

import java.awt.*;

public class Circle {
    private double d;
    private final int x=0;
    private final int y =0;

    public Circle(double d) {
        this.d = d;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDiameter(){
        return d;
    }

    public void setDiameter(int d){
        this.d=d;
    }

    public void draw(Graphics g) {
        g.drawOval(((int)-d)/2, ((int)-d)/2, (int) d, (int) d);
    }
}
