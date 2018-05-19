package ZAD_14_Edytor;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class DrawSwing {

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setTitle("Edytor");

        jf.setVisible(true);

        jf.setResizable(false);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp = new JPanel();

        JTextArea jt = new JTextArea();
        jp.setLayout(new BorderLayout());
        jt.setBackground(Color.GREEN);
        jp.setBorder(new EtchedBorder(Color.green, Color.green));
        jt.setFont(new Font("Dialog", Font.BOLD, 30));
        jt.setForeground(Color.red);
        jp.add(jt);
        jf.add(jp);

        jf.setSize(400, 400);



    }


    class MyPanel
            extends JPanel {

        // konstruktor
        MyPanel() {
            // ustalenie rozmiarĂłw poczÄtkowych
            setPreferredSize(new Dimension(400, 400));
            JTextArea text = new JTextArea();


//        this.setMinimumSize(new Dimension(400, 400));

        }
    }
}