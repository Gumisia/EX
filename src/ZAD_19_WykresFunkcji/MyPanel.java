package ZAD_19_WykresFunkcji;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyPanel extends JPanel implements ActionListener{

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

    public void setPointList(List<Point> pointList) {
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
            intsX[i] = pointList.get(i).getX()+dimension.width/2;
            intsY[i] = (int)(pointList.get(i).getY()+dimension.height/2);
            System.out.println("x: "+intsX[i]+" y:"+intsY[i]);
        }
        g.setColor(Color.RED);
        g.drawPolyline(intsX, intsY, pointList.size());


        g.setColor(colorText);
        g.drawLine(dimension.width/2, 0, dimension.width/2, dimension.height);
        g.drawLine(0, dimension.height/2, dimension.width, dimension.height/2);
/*      int[] xs = {25, 75, 125, 85, 125, 75, 25, 65};
        int[] ys = {50, 90, 50, 100, 150, 110, 150, 100};*/




    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //new idea
        // w My Panel stworzyć jtextfieldy i postawić je z przekazanych parametrów w konstruktorze
        // w konstruktorze przesłać w parametrach wszystkie jtextfield
        // w tym miejscu pobierać dopiero wzor i inne... .getText()
        //

//        getParent().repaint();
    }

//    public void setPointList(List<Point> pointList) {
//        this.pointList = pointList;
//    }
}
