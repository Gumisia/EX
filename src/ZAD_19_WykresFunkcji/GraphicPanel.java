package ZAD_19_WykresFunkcji;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class GraphicPanel
        extends JPanel
        implements ActionListener {


    Map<String, Integer> map;
    String formulaText;

    JTextField xMin;
    JTextField xMax;
    JTextField yMin;
    JTextField yMax;
    JTextField formula;

    public GraphicPanel(JTextField xMin, JTextField xMax, JTextField yMin, JTextField yMax ,JTextField formula){

        map = new LinkedHashMap<>();

        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        this.formula = formula;

        xMin.setText("-5");
        xMax.setText("5");
        yMin.setText("-3");
        yMax.setText("3");
        formula.setText("3x^3+2x^2-3x+1");

        map.put("xMin", Integer.valueOf(xMin.getText()));
        map.put("xMax", Integer.valueOf(xMax.getText()));
        map.put("yMin", Integer.valueOf(yMin.getText()));
        map.put("yMax", Integer.valueOf(yMax.getText()));
        formulaText = formula.getText();
    }

    public void paint(Graphics g){

        Dimension dimension = getSize();
        Vector vector = new Vector(map, dimension);
        Points points = new Points(formulaText, map, vector);

        g.setColor(Color.PINK);
        g.fillRect(0,0, dimension.width, dimension.height);

        map.put("xMin", Integer.valueOf(xMin.getText()));
        map.put("xMax", Integer.valueOf(xMax.getText()));
        map.put("yMin", Integer.valueOf(yMin.getText()));
        map.put("yMax", Integer.valueOf(yMax.getText()));
        formulaText = formula.getText();

        g.setColor(Color.BLACK);
        g.drawLine(vector.getXVector(), 0, vector.getXVector(), dimension.height);
        g.drawLine(0, vector.getYVector(), dimension.width, vector.getYVector());

        g.setColor(Color.BLUE);
        g.drawPolyline(points.getTabX(), points.getTabY(), points.tabX.length);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        getParent().repaint();
    }
}
