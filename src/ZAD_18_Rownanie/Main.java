package ZAD_18_Rownanie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
            setAx2(Integer.valueOf(a.getText()));
        });

        clear.addActionListener(ae->{
            jLabel.setText(null);
            System.out.println(ax2);
        });

        this.setContentPane(jPanel);
        this.setDefaultCloseOperation(3);

    }

    JPanel jPanel = new JPanel();
    JButton solve = new JButton("Solve");
    JButton clear = new JButton("Clear");
    JLabel jLabel = new JLabel("Przykładowy tekst etykiety");
    Container container = new Container();
    JTextField a = new JTextField();
    JTextField b = new JTextField();
    JTextField c = new JTextField();

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

//    class rownanieKwadratowe{
        int ax2, bx, c0;


        public void setAx2(int ax2) {
            this.ax2 = ax2;
        }
//    }
}
