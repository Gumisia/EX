package ZAD_16_PrzyciskKol;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DrawSwing {

    public static void main(String[] args)
    {
        new DrawSwing();
    }

    public DrawSwing()
    {
        SwingUtilities.invokeLater(() -> createGUI());
    }

    protected void createGUI()
    {
        // utworzenie okna
        JFrame jf = new JFrame();

        // okreĹlenie tytuĹu okna
        jf.setTitle("Rysowanie");

        // obsĹuga zamkniÄcia okna JFrame
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // okreĹlenie poĹoĹźenia okna
        jf.setLocation(50,50);

        // uniemoĹźliwienie zmiany rozmiarĂłw okna
        jf.setResizable(true);

        // utworzenie obszaru rysowania - pulpitu
        MyPanel p = new MyPanel();

        // wymiana domyĹlnego pulpitu na wĹasny
        jf.setContentPane(p);

        // upakowanie okna
        jf.pack();

        // wyĹwietlenie okna
        jf.setVisible(true);
    }
}

class MyPanel
        extends JPanel {

    JButton przycisk;
    static int tmp;

    // konstruktor
    MyPanel()
    {
        // ustalenie rozmiarĂłw poczÄtkowych
        //setPreferredSize(new Dimension(400,400));
        setBounds(200, 200, 300, 300);

        budujPrzycisk();
        tmp=0;

    }

    public void budujPrzycisk(){

        przycisk = new JButton("Klik!");
        this.add(przycisk);

        przycisk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                przycisk.setOpaque(true);
                przycisk.setBackground(getColor());

            }
        });

    }

    public Color getColor(){
        Color[] tab = {Color.GREEN, Color.black, Color.BLUE, Color.CYAN, Color.pink, Color.yellow};
            if(tmp<tab.length-1)tmp++;
            else tmp=0;
        return tab[tmp];

    }


}