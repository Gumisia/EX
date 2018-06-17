package ZAD_20_DniTygodnia;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main(){
        initcomponents();
    }

    private  void initcomponents(){
        this.setTitle(myModel.getTittle());
        this.setBounds(700, 300, 300, 210);


        jList.setVisibleRowCount(10);
        jList.setFixedCellWidth(280);

        jPanel.add(jScrollPane);
        this.getContentPane().add(jPanel, BorderLayout.CENTER);

        this.setContentPane(jPanel);

        this.setDefaultCloseOperation(3);


    }

    MyModel myModel = new MyModel();
    JPanel jPanel = new JPanel();
    JList jList = new JList(myModel);
    JScrollPane jScrollPane = new JScrollPane(jList);

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
