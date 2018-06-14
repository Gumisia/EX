package ZAD_19_WykresFunkcji;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    public static void main(String[] args) {
        new Main();
    }

    public Main(){

        SwingUtilities.invokeLater(() -> createGUI());
    }

//    JFrame jFrame = new JFrame();
    MyPanel myPanel = new MyPanel();
//    JTextField wykres = new JTextField();
    Container container = new Container();
    JPanel jPanelEnd = new JPanel();
    Container containerAll = getContentPane();

    JTextField xmin = new JTextField();
    JTextField xmax = new JTextField();
    JTextField ymin = new JTextField();
    JTextField ymax = new JTextField();

    JTextField wzor = new JTextField();

    public void createGUI(){

        this.setTitle("Wykres");
        this.setBounds(-700, 200, 450, 550);
        this.setVisible(true);

        container.add(xmin);
        container.add(xmax);
        container.add(ymin);
        container.add(ymax);
        container.setLayout(new GridLayout(1,4));

        jPanelEnd.add(container);
        jPanelEnd.add(wzor);
        jPanelEnd.setLayout(new GridLayout(2,1));


        containerAll.setLayout(new BorderLayout());
        containerAll.add(myPanel, BorderLayout.CENTER);
        containerAll.add(jPanelEnd, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(3);

    }

}
