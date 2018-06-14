package ZAD_19_WykresFunkcji;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

//    private final static Color colorFrame = Color.BLACK;
    private final static Color colorBackground = Color.WHITE;
    private final static Color colorText = Color.BLACK;

    MyPanel(){

        setPreferredSize(new Dimension(400, 500));

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Dimension dimension = getSize();

        g.setColor(colorBackground);
        g.fillRect(0, 0, dimension.width - 1, dimension.height - 1);

        g.setColor(colorText);

        g.drawLine(200, 200, 100, 100);


    }
}
