package ZAD_13_Figury;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        setPreferredSize(new Dimension(1000,600));
    }


    public void paintComponent(Graphics g)
    {

        // musi byÄ jako pierwsza instrukcja
        super.paintComponent(g);

        // pobranie aktualnych rozmiarĂłw
        int width = getWidth();
        int height = getHeight();

        Pattern compiledPatternOval = Pattern.compile("\\d+ \\d+ \\d+");
        Matcher macherOval;

        Pattern compiledPatternRect = Pattern.compile("\\d+ \\d+ \\d+ \\d+");
        Matcher macherRect;


        BufferedReader plik2 = null;
        try {

            plik2 = new BufferedReader(new FileReader("/Users/admin/IdeaProjects/GUI-ĆWICZENIA/src/ZAD_13_Figury/file.txt"));
            System.out.println("\n\nOdczyt buforowany:\n");
            String l = plik2.readLine();
            while (l != null) {
                macherOval = compiledPatternOval.matcher(l);
                if(macherOval.matches()) {
                    System.out.println("oval: "+l);
                    rysujOval(g, l);
                }

                macherRect = compiledPatternRect.matcher(l);
                if(macherRect.matches()) {
                    System.out.println("rect: " + l);
                    rysujRect(g, l);
                }
                l = plik2.readLine();
            }
            plik2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public void rysujOval(Graphics graphics, String l){

        int x, y, r;
        String[] parts = l.split(" ");
        x = Integer.parseInt(parts[0]);
        y = Integer.parseInt(parts[1]);
        r = Integer.parseInt(parts[2]);

        Random random = new Random();
        int c1 = random.nextInt(255);
        int c2 = random.nextInt(255);
        int c3 = random.nextInt(255);

        graphics.setColor(new Color(c1, c2, c3));

        graphics.fillOval(x-r, y-r, 2*r, 2*r);

    }

    static public void rysujRect(Graphics graphics, String l){

        int x, y, z, t;
        String[] parts = l.split(" ");
        x = Integer.parseInt(parts[0]);
        y = Integer.parseInt(parts[1]);
        z = Integer.parseInt(parts[2]);
        t = Integer.parseInt(parts[3]);

        Random random = new Random();
        int c1 = random.nextInt(255);
        int c2 = random.nextInt(255);
        int c3 = random.nextInt(255);

        graphics.setColor(new Color(c1, c2, c3));

        graphics.fillRect(x,y,z-x,t-y);

    }


}