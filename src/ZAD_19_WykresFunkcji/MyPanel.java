package ZAD_19_WykresFunkcji;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyPanel extends JPanel {

//    private final static Color colorFrame = Color.BLACK;
    private final static Color colorBackground = Color.WHITE;
    private final static Color colorText = Color.BLACK;
    List<Point> pointList = new ArrayList<>();
    int[] intsX;
    int[] intsY;

    MyPanel(){

    }

    MyPanel(List<Point> pointList){

        setPreferredSize(new Dimension(400, 500));
        this.pointList = pointList;

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Dimension dimension = getSize();

        g.setColor(colorBackground);
        g.fillRect(0, 0, dimension.width - 1, dimension.height - 1);

        g.setColor(colorText);
        int n = pointList.size();
        intsX = new int[n];
        intsY = new int[n];

//        for(Point point: pointList){
//            System.out.println(point.x);
//        }

        System.out.println("MyPanel");

        for(int i=0; i<n; i++){
            intsX[i] = pointList.get(i).getX();
            intsY[i] = (int)(pointList.get(i).getY());
            System.out.println("x: "+intsX[i]+" y:"+intsY[i]);
        }





//        g.drawLine(200, 200, 100, 100);

        int[] xs = {25, 75, 125, 85, 125, 75, 25, 65};
        int[] ys = {50, 90, 50, 100, 150, 110, 150, 100};
//        for(int i=0; i<xs.length; i++){
//            System.out.println(xs[i]);
//        }

        g.drawPolyline(intsX, intsY, pointList.size());


    }

//    public void setPointList(List<Point> pointList) {
//        this.pointList = pointList;
//    }
}
