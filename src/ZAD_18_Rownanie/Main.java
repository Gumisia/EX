package ZAD_18_Rownanie;

import javax.swing.*;
import java.awt.*;

//TODO dla wspolczynnikow z minusem
//TODO tooltip

public class Main extends JFrame {

    public Main(){
        initcomponents();
    }

    public void initcomponents(){

        this.setTitle("Quadratic Equation");
        this.setBounds(700, 300, 500, 250);

        jPanel.setLayout(new GridLayout(4,1));


        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setVerticalAlignment(JLabel.CENTER);
        jLabel.setOpaque(true);
        jLabel.setBackground(Color.WHITE);

        container.setLayout(new GridLayout(1,3));
        container.add(a);
        container.add(b);
        container.add(c);

        jPanel.add(jLabel);
        jPanel.add(container);
        jPanel.add(solve);
        jPanel.add(clear);

//        a.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                int key = e.getKeyCode();
////                System.out.println(key);
////                if(key<'0' && key>'9') e.setKeyChar(' ');
//                setAx2((int)key);
//            }
//        });

        a.addActionListener(ae->{
//            System.out.print(numberTest(a.getText()));
            if(numberTest(a.getText())){
                setAx2(Integer.parseInt(a.getText()));
//                System.out.println(" ->"+ax2);
            }
        });

        b.addActionListener(ae->{
            if(numberTest(b.getText())) {
                setBx(Integer.parseInt(b.getText()));
            }
        });

        c.addActionListener(ae->{
            if(numberTest(c.getText())) {
                setC0(Integer.parseInt(c.getText()));
            }
        });

        clear.addActionListener(ae->{
            jLabel.setText(null);
            setBackgroundOnMac(jLabel, Color.WHITE);
//            jLabel.setBackground(Color.WHITE);
//            jLabel.setOpaque(true);
        });

        solve.addActionListener(ae->{
            if(quadraticEquation()) {
                jLabel.setText(countQuadraticEquation());
            }
        });

        this.setContentPane(jPanel);
        this.setDefaultCloseOperation(3);

    }

    JPanel jPanel = new JPanel();
    JButton solve = new JButton("Solve");
    JButton clear = new JButton("Clear");
    JLabel jLabel = new JLabel("Hello in QuadraticEquation :) !");
    Container container = new Container();
    JTextField a = new JTextField();
    JTextField b = new JTextField();
    JTextField c = new JTextField();

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

//    class rownanieKwadratowe{
        int ax2, bx, c1;


    public void setAx2(int ax2) {
        this.ax2 = ax2;
    }

    public void setBx(int bx) {
        this.bx = bx;
    }

    public void setC0(int c1) {
        this.c1 = c1;
    }

    public boolean numberTest(String text){
        char tab[] = text.toCharArray();
        boolean test = true;
        for(int i=0; (i<tab.length)&&(test==true); i++){
            if(tab[i]<'0'||tab[i]>'9') test = false;
        }
        if(!test){
            jLabel.setText("Number format error!");
            setBackgroundOnMac(jLabel, Color.RED);
        }
        if(test && (ax2!=0) && (bx!=0) && (c1!=0)){
            jLabel.setText(null);
            setBackgroundOnMac(jLabel, Color.WHITE);
//            jLabel.setBackground(Color.WHITE);
//            jLabel.setOpaque(true);
        }
        return test;
    }

    public boolean quadraticEquation(){
//        final int zero = 0;
        boolean test = true;
        if(ax2==0||bx==0||c1==0){
            test = false;
            jLabel.setText("Not a quadratic equation!");
            setBackgroundOnMac(jLabel, Color.RED);
        }

        return test;
    }

    public void setBackgroundOnMac(JComponent component, Color color){
        component.setBackground(color);
        component.setOpaque(true);
    }

    public String countQuadraticEquation(){
        double delta = bx*bx - 4*ax2*c1;
        double x1, x2;

        x1 = (((-1)*bx)-Math.sqrt(delta))/2.0*ax2;
        x2 = (bx-Math.sqrt(delta))/2.0*ax2;

        System.out.println("Delta = " + delta + "  x1 = "+ x1 + ", x2 = " + x2);

        if(delta<0)
            return "Delta < 0, brak rozwiazań";
        else
        return "x1 = "+ x1 + ", x2 = " + x2;
    }

    //    }
}
