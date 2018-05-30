package ZAD_15_Layouty;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    public Main(){
        setBounds(300, 300, 800, 600);

        String option = JOptionPane.showInputDialog("Podaj literę wybranego layoutu = ");
        char letter = option.charAt(0);



        setLO(letter);

        if(letter!='a'&&letter!='A')
            initComponents();

//        this.pack();
        this.setDefaultCloseOperation(3);

    }

//    JFrame jFrame = new JFrame("Layouts");
//    JPanel jPanel;

    JButton jButton1 = new JButton("Przycisk 1");
    JButton jButton2 = new JButton("P 2");
    JButton jButton3 = new JButton("Większy przycisk numer 3");
    JButton jButton4 = new JButton("Przycisk 4");
    JButton jButton5 = new JButton("P5");



    public void initComponents(){

        add(jButton1);
        add(jButton2);
        add(jButton3);
        add(jButton4);
        add(jButton5);

//        jPanel.add(jButton1);
//        jPanel.add(jButton2);
//        jPanel.add(jButton3);
//        jPanel.add(jButton4);
//        jPanel.add(jButton5);


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
            case 'A':
            case 'a': {

                this.add(jButton1, BorderLayout.WEST);
                this.add(jButton2, BorderLayout.EAST);
                this.add(jButton3, BorderLayout.NORTH);
                this.add(jButton4, BorderLayout.SOUTH);
                this.add(jButton5, BorderLayout.CENTER);
//                this.setLayout(new BorderLayout());
//                setLayout(new BorderLayout(BorderLayout.PAGE_START);
//                jPanel= new JPanel();
//                jPanel.setLayout(new BorderLayout());
//                this.add(jPanel);
                break;
            }
            case 'B':
            case 'b':{
                setLayout(new FlowLayout(FlowLayout.CENTER));
//                jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//                this.getContentPane().add(jPanel, BorderLayout.CENTER);
                break;
            }
            case 'C':
            case 'c':{
                setLayout(new FlowLayout(FlowLayout.LEFT));
//                jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//                this.getContentPane().add(jPanel, BorderLayout.LINE_START);
                break;
            }
            case 'D':
            case 'd':{
                setLayout(new FlowLayout(FlowLayout.RIGHT));
//                jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//                this.getContentPane().add(jPanel, BorderLayout.LINE_END);
                break;
            }
            case 'E':
            case 'e': {
                setLayout(new GridLayout(1, 5));
//                jPanel = new JPanel(new GridLayout(1, 5));
//                jPanel.setLayout(new GridLayout(6, 1));
                break;
            }
            case 'F':
            case 'f':{
                setLayout(new GridLayout(5, 1));
                break;
            }
            case 'G':
            case 'g':{
                setLayout(new GridLayout(3, 2));
                break;
            }

        }

    }



    public static void main(String[] args) {

        new Main().setVisible(true);

    }

}
