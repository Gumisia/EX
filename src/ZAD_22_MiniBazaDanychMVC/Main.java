package ZAD_22_MiniBazaDanychMVC;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel{

    public Main(){
        super(new GridLayout(1,0));

        JTable jTable = new JTable(new MyTableModel());
        jTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        jTable.setFillsViewportHeight(true);
        jTable.setAutoCreateRowSorter(true);

        JScrollPane jScrollPane = new JScrollPane(jTable);

        add(jScrollPane);

    }

    private static void initcomponents(){

        JFrame jFrame = new JFrame("Java Department");

        Main newContentPane = new Main();
        newContentPane.setOpaque(true);
        jFrame.setContentPane(newContentPane);

        jFrame.pack();
        jFrame.setVisible(true);


        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> initcomponents());
    }
}
