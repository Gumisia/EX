package ZAD_19_WykresFunkcji;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        SwingUtilities.invokeLater(() -> createGUI());
    }

    JFrame jFrame = new JFrame();
    MyPanel myPanel = new MyPanel();
    JTextField wykres = new JTextField();
    Container container = new Container();

    JTextField xmin = new JTextField();
    JTextField xmax = new JTextField();
    JTextField ymin = new JTextField();
    JTextField ymax = new JTextField();

    JTextField wzor = new JTextField();

    public void createGUI(){

        jFrame.setTitle("Wykres");
        jFrame.setBounds(900, 200, 450, 550);
        jFrame.setVisible(true);

//        myPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
//        setSize(100, 400); // nie działa bez pozycjonowania absolutnego czyli .setLayout(null);
        myPanel.setLayout(null);
        wykres.setSize(500, 400);
        myPanel.add(wykres);
        myPanel.add(container);
        myPanel.add(wzor);

        wzor.setSize(20, 20);

//        container.setLayout(new GridLayout(1,4));
        container.add(xmin);
        container.add(xmax);
        container.add(ymin);
        container.add(ymax);

        jFrame.setContentPane(myPanel);
        jFrame.setDefaultCloseOperation(3);

    }

}
