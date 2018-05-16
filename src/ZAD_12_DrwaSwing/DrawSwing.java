package ZAD_12_DrwaSwing;

import java.awt.*;
import javax.swing.*;

public class DrawSwing {


    public static void main(String[] args)
    {

        new DrawSwing();

    }

    public DrawSwing()
    {
        String tekst = JOptionPane.showInputDialog("Podaj promień (w px) = ");
        int r = Integer.parseInt(tekst);

        SwingUtilities.invokeLater(() -> createGUI(r));
    }


    protected void createGUI(int r)
    {
        // utworzenie okna
        JFrame jf = new JFrame();
        JTextField textField = new JTextField();

        // okreĹlenie tytuĹu okna
        jf.setTitle("Rysowanie");

        // obsĹuga zamkniÄcia okna JFrame
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // okreĹlenie poĹoĹźenia okna
        jf.setLocation(50,50);

        // uniemoĹźliwienie zmiany rozmiarĂłw okna
        jf.setResizable(false);

        // utworzenie obszaru rysowania - pulpitu
        MyPanel p = new MyPanel(r);

        // wymiana domyĹlnego pulpitu na wĹasny
        jf.setContentPane(p);

        // upakowanie okna
        jf.pack( );

        // wyĹwietlenie okna
        jf.setVisible(true);
    }
}

class MyPanel
        extends JPanel {

    int promien;

    // konstruktor
    MyPanel(int promien)
    {
        this.promien = promien;
        // ustalenie rozmiarĂłw poczÄtkowych
        setPreferredSize(new Dimension(400,400));
    }


    public void paintComponent(Graphics g)
    {
        // musi byÄ jako pierwsza instrukcja
        super.paintComponent(g);

        // pobranie aktualnych rozmiarĂłw
//        int width = getWidth();
//        int height = getHeight();

//        int promien = wejsciePromien();
        int proc = promien*(13)/100;

        // TU RYSUJEMY!
        // ........
        g.setColor(Color.red);
//        g.setFont(new Font("Dialog", Font.BOLD|Font.ITALIC, 30));
//        g.drawString("Tu rysujemy!", width/2, height/2);


        g.fillOval(200-promien, 200-promien, 2*promien, 2*promien);

        g.setColor(Color.white);
        g.fillArc(200-promien+proc,200-promien+proc,2*promien-2*proc, 2*promien-2*proc, 0,180);


        // ........
    }
}