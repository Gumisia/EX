package ZAD_22_MiniBazaDanychMVC;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    public Main(){
        initcomponents();
    }

    private void initcomponents(){

        this.setTitle("Java Departments");
        this.setBounds(700, 300, 500, 350);

        imieL = new JLabel("Imie");
        nazwiskoL = new JLabel("Nazwisko");
        wiekL = new JLabel("Wiek");
        stanowiskoL = new JLabel("Stanowisko");
        rocznikL = new JLabel("Rocznik");


        container.add(imieL);
        container.add(nazwiskoL);
        container.add(wiekL);
        container.add(stanowiskoL);
        container.add(rocznikL);
//        container.setLayout(new GridLayout(1,5));

        jList.setFixedCellWidth(100);
        jList.setFixedCellHeight(40);
        jList.setVisibleRowCount(2);
        jList.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        jPanel.add(container, BorderLayout.PAGE_START);
        jPanel.add(jScrollPane);

        this.getContentPane().add(jPanel, BorderLayout.CENTER);
        this.setContentPane(jPanel);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }



    private JPanel jPanel = new JPanel();
//    private JTextField jTextField = new JTextField();
    private JLabel imieL, nazwiskoL, wiekL, stanowiskoL, rocznikL;
    private Container container = new Container();
    private JList<Pracownik> jList = new JList(new String[]{"a1","a2","a3","a4","a5","b1","b2","b3","b4","b5"});
    private JScrollPane jScrollPane = new JScrollPane(jList);

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
