package ZAD_18_Rownanie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

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

        a.setToolTipText("Enter a");
        b.setToolTipText("Enter b");
        c.setToolTipText("Enter c");

        clear.setToolTipText("Clear everything? Click!");
        solve.setToolTipText("Check the solution of the quadratic equation");

        solve.setMnemonic(KeyEvent.VK_S);
        clear.setMnemonic(KeyEvent.VK_C);

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

        a.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                a.setText("ax2");
            }

            @Override
            public void focusLost(FocusEvent e) {
                String text = a.getText();

                if(checkNegative(text)){
                    text = text.substring(1);
                    if(numberTest(text)) {
                        setAx2(Integer.parseInt(text) * (-1));
                    }
                }
                else if(numberTest(text)){
                    setAx2(Integer.parseInt(text));
//                System.out.println(" ->"+ax2);
                }
            }
        });
//            a.addFocusListener(this);
//            public void focusGained(FocusEvent e){
//                a.setText("ax2");
//            }
//            public void focusLost(FocusEvent e){
//                String text = a.getText();
//
//                if(checkNegative(text)){
//                    text = text.substring(1);
//                    if(numberTest(text)) {
//                        setAx2(Integer.parseInt(text) * (-1));
//                    }
//                }
//                else if(numberTest(text)){
//                    setAx2(Integer.parseInt(text));
////                System.out.println(" ->"+ax2);
//                }
//            }
//        });

//        a.addActionListener(ae->{
////            System.out.print(numberTest(a.getText()));
//            String text = a.getText();
//
//            if(checkNegative(text)){
//                text = text.substring(1);
//                if(numberTest(text)) {
//                    setAx2(Integer.parseInt(text) * (-1));
//                }
//            }
//            else if(numberTest(text)){
//                setAx2(Integer.parseInt(text));
////                System.out.println(" ->"+ax2);
//            }
//        });

        b.addActionListener(ae->{
            String text = b.getText();

            if(checkNegative(text)){
                text = text.substring(1);
                if(numberTest(text)) {
                    setBx(Integer.parseInt(text) * (-1));
                }
            }
            else if(numberTest(text)) {
                setBx(Integer.parseInt(text));
            }
        });

        c.addActionListener(ae->{
            String text = c.getText();

            if(checkNegative(text)){
                text = text.substring(1);
                if(numberTest(text)) {
                    setC0(Integer.parseInt(text) * (-1));
                }
            }
            else if(numberTest(text)) {
                setC0(Integer.parseInt(text));
            }
        });

        clear.addActionListener(ae->{
            jLabel.setText(null);
            setBackgroundOnMac(jLabel, Color.WHITE);
            a.setText("");
            b.setText("");
            c.setText("");

            setAx2(0);
            setBx(0);
            setC0(0);
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

    public boolean checkNegative(String text){
        boolean test=false;
        if(text.charAt(0)=='-'){
            test=true;
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
        double deltSqrt = Math.sqrt(delta);
        double x1, x2;

        x1 = (((-1)*bx)+deltSqrt)/(2.0*ax2);
        x2 = (((-1)*bx)-deltSqrt)/(2.0*ax2);

        System.out.println("Delta = " + delta + "  x1 = "+ x1 + ", x2 = " + x2);

        if(delta<0)
            return "Delta < 0, no solutions :(";
        else
        return "x1 = "+ x1 + ", x2 = " + x2;
    }

    //    }
}
