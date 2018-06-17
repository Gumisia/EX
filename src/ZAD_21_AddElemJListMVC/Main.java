package ZAD_21_AddElemJListMVC;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main(){
        initcomponents();
    }

    private void initcomponents(){

        this.setTitle("Capitals");
        this.setBounds(700, 300, 300, 210);

        jList.setVisibleRowCount(9);
        jList.setFixedCellWidth(280);

        jPanel.setLayout(new BorderLayout());

        jPanel.add(jTextField, BorderLayout.PAGE_START);
        jPanel.add(jScrollPane);

        this.getContentPane().add(jPanel, BorderLayout.CENTER);

        this.setContentPane(jPanel);


        jTextField.addActionListener(e -> myModel.addElementList(jTextField.getText()));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private JPanel jPanel = new JPanel();
    private JTextField jTextField = new JTextField();
    private MyModel myModel = new MyModel();
    private JList jList = new JList(myModel);
    private JScrollPane jScrollPane = new JScrollPane(jList);


    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
