package ZAD_12_DrwaSwing;

import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class DrawSwing {



    public static void main(String[] args)
    {

//        static int x;
//        static int y;
//        Scanner odczyt = new Scanner(System.in);
//        System.out.println("Podaj x: ");
//        x = odczyt.nextInt();
//        System.out.println("\nPodaj y: ");
//        y = odczyt.nextInt();

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
        MyPanel p = new MyPanel();

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

    // konstruktor
    MyPanel()
    {
        // ustalenie rozmiarĂłw poczÄtkowych
        setPreferredSize(new Dimension(400,400));
    }


    public void paintComponent(Graphics g)
    {
        // musi byÄ jako pierwsza instrukcja
        super.paintComponent(g);

        // pobranie aktualnych rozmiarĂłw
        int width = getWidth();
        int height = getHeight();

        int w, h;

        // TU RYSUJEMY!
        // ........
        g.setColor(Color.red);
//        g.setFont(new Font("Dialog", Font.BOLD|Font.ITALIC, 30));
//        g.drawString("Tu rysujemy!", width/2, height/2);

        int x=50, y=50;



        w=300;h=300;

        g.fillOval(x, y, w, h);

        g.setColor(Color.white);
        g.fillArc(x+20,y+20,w-40, h-40, 0,180);


        // ........
    }
}