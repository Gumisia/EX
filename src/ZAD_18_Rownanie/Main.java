package ZAD_18_Rownanie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

//DONE negative value jTextField
//DONE tooltip jTextField
//DONE FocusListener b, c jTextField
//DONE if jTextField is empty

public class Main extends JFrame {

    private Main(){
        initcomponents();
    }

    private void initcomponents(){

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


        a.setText("3");
        setAx2(3);
        a.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
//                a.setText("3");
            }

            @Override
            public void focusLost(FocusEvent e) {
                String text = a.getText();
//                int negative = 1;


//                if(numberTest(text)){
//                    if(checkNegative(text)){
//                        text = text.substring(1);
//                        negative = (-1);
//                    }
//                    setAx2(Integer.parseInt(text)*negative);
//                }

//                NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
//                DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
//                decimalFormat.setGroupingUsed(false);
//                a = new JFormattedTextField(decimalFormat);
//                a.setColumns(5);

                try {

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
                } catch (StringIndexOutOfBoundsException ex){
                    System.out.println("Empty String A");
                    setAx2(0); setBx(0); setC0(0);
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

        b.setText("2");
        setBx(2);
        b.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
//                b.setText("-2");
            }

            @Override
            public void focusLost(FocusEvent e) {
                String text = b.getText();

                try{

                    if(checkNegative(text)){
                        text = text.substring(1);
                        if(numberTest(text)) {
                            setBx(Integer.parseInt(text) * (-1));
                        }
                    }
                    else if(numberTest(text)) {
                        setBx(Integer.parseInt(text));
                    }
                } catch (StringIndexOutOfBoundsException ex){
                    System.out.println("Empty String B");
                    setAx2(0); setBx(0); setC0(0);
                }
            }
        });

//        b.addActionListener(ae->{
//            String text = b.getText();
//
//            if(checkNegative(text)){
//                text = text.substring(1);
//                if(numberTest(text)) {
//                    setBx(Integer.parseInt(text) * (-1));
//                }
//            }
//            else if(numberTest(text)) {
//                setBx(Integer.parseInt(text));
//            }
//        });

        c.setText("-8");
        setC0(-8);
        c.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
//                c.setText("8");
            }

            @Override
            public void focusLost(FocusEvent e) {
                String text = c.getText();

                try{

                    if(checkNegative(text)){
                        text = text.substring(1);
                        if(numberTest(text)) {
                            setC0(Integer.parseInt(text) * (-1));
                        }
                    }
                    else if(numberTest(text)) {
                        setC0(Integer.parseInt(text));
                    }
                }catch (StringIndexOutOfBoundsException ex){
                    System.out.println("Empty String C");
                    setAx2(0); setBx(0); setC0(0);
                }
            }
        });

//        c.addActionListener(ae->{
//            String text = c.getText();
//
//            if(checkNegative(text)){
//                text = text.substring(1);
//                if(numberTest(text)) {
//                    setC0(Integer.parseInt(text) * (-1));
//                }
//            }
//            else if(numberTest(text)) {
//                setC0(Integer.parseInt(text));
//            }
//        });

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
            setBackgroundOnMac(jLabel, Color.WHITE);
//            jLabel.setText(" ");

            if(quadraticEquation()) {

                jLabel.setText(countQuadraticEquation());
//                x1 = 0; x2 = 0;
//                setAx2(0); setBx(0); setC0(0);

            }
        });

        this.setContentPane(jPanel);
        this.setDefaultCloseOperation(3);

    }

    private JPanel jPanel = new JPanel();
    private JButton solve = new JButton("Solve");
    private JButton clear = new JButton("Clear");
    private JLabel jLabel = new JLabel("Hello in QuadraticEquation :) !");
    private Container container = new Container();
    private JTextField a = new JTextField();
    private JTextField b = new JTextField();
    private JTextField c = new JTextField();

    double x1, x2, delta;

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

//    class rownanieKwadratowe{
    private int ax2, bx, c1;


    private void setAx2(int ax2) {
        this.ax2 = ax2;
    }

    private void setBx(int bx) {
        this.bx = bx;
    }

    private void setC0(int c1) {
        this.c1 = c1;
    }

    private boolean numberTest(String text){
        char tab[] = text.toCharArray();
        boolean test = true;
        for(int i=0; (i<tab.length)&&(test); i++){
            if(tab[i]<'0'||tab[i]>'9') test = false;
        }
        if(!test){
            jLabel.setText("Number format error!");
            delta=0; x1=0; x2=0;
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

    private boolean checkNegative(String text){
        boolean test=false;
        if(text.charAt(0)=='-'){
            test=true;
        }
        return test;
    }

    private boolean quadraticEquation(){
//        final int zero = 0;
        boolean test = true;
        if(ax2==0||bx==0||c1==0){
            test = false;
            jLabel.setText("Not a quadratic equation!");
            setBackgroundOnMac(jLabel, Color.RED);
        }

        return test;
    }

    private void setBackgroundOnMac(JComponent component, Color color){
        component.setBackground(color);
        component.setOpaque(true);
    }

    private String countQuadraticEquation(){
        delta = bx*bx - 4*ax2*c1;
        double deltSqrt = Math.sqrt(delta);

        x1 = (((-1)*bx)+deltSqrt)/(2.0*ax2);
        x2 = (((-1)*bx)-deltSqrt)/(2.0*ax2);

//        System.out.println("Delta = " + delta + "  x1 = "+ x1 + ", x2 = " + x2);

        if(delta<0) {
            delta = 0;
            return "Delta < 0, no solutions :(";
        }
        else if(delta>0){
            delta=0;
            return "x1 = "+ x1 + ", x2 = " + x2;
        }
        delta=0;
        return "";

    }



    //    }
}