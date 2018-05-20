package ZAD_15_Layouty;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    public Main(){
        setBounds(300, 300, 800, 600);

        String option = JOptionPane.showInputDialog("Podaj literę wybranego layoutu = ");
        char letter = option.charAt(0);

        setLO(letter);

        initComponents();
//        this.pack();
        this.setDefaultCloseOperation(3);

    }

    JFrame jFrame = new JFrame("Layouts");
    JPanel jPanel;

    JButton jButton1 = new JButton("Przycisk 1");
    JButton jButton2 = new JButton("P 2");
    JButton jButton3 = new JButton("Większy przycisk numer 3");
    JButton jButton4 = new JButton("Przycisk 4");
    JButton jButton5 = new JButton("P5");



    public void initComponents(){

        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jButton4);
        jPanel.add(jButton5);


    }

    public void setLO(char letter){

        //        a) w układzie BorderLayout
//        b) w układzie FlowLayout
//        c) w układzie FlowLayout z wyrównaniem do lewej
//        d) w układzie FlowLayout z wyrównaniem do prawej
//        e) w układzie GridLayout jako jeden wiersz
//        f) w układzie GridLayout jako jedną kolumnę
//        g) w układzie GridLayout jako tablice (3, 2)


        switch (letter){
            case 'a':{
                JPanel jPanel= new JPanel();
                jPanel.setLayout(new BorderLayout());
            }
            case 'b':{
                jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                this.getContentPane().add(jPanel, BorderLayout.CENTER);

            }
            case 'c':{

            }
            case 'd':{

            }
        }
    }

    public static void main(String[] args) {

        new Main().setVisible(true);

    }

}
