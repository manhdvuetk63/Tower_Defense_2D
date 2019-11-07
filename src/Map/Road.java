package Map;

import GameField.GameField;

import java.awt.*;
import java.util.List;

public class Road {
    Point[] listPoint=new Point[6];

    public Road() {
        listPoint[0]=new Point(0,128);
        listPoint[1]=new Point(256,128);
        listPoint[2]=new Point(256,320);
        listPoint[3]=new Point(576,320);
        listPoint[4]=new Point(576,224);
        listPoint[5]=new Point(768,224);
    }
    public void Draw(Graphics g){
        for (Point p:listPoint){
            g.setColor(Color.RED);
            g.fillOval(p.y,p.x,10,10);
        }
    }

    public Point[] getListPoint() {
        return listPoint;
    }

    public void setListPoint(Point[] listPoint) {
        this.listPoint = listPoint;
    }
}
