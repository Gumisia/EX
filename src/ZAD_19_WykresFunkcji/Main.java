package ZAD_19_WykresFunkcji;

import javax.swing.*;
import java.awt.*;

public class Main
        extends JFrame{

    private Main(){
        SwingUtilities.invokeLater(()-> createGUI());
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    private void createGUI(){

        JTextField xMin = new JTextField();
        JTextField xMax = new JTextField();
        JTextField yMin = new JTextField();
        JTextField yMax = new JTextField();
        JTextField formula = new JTextField();

        Container containerXY = new Container();
        Container containerPanels = new Container();
        GraphicPanel graphicPanel = new GraphicPanel(xMin, xMax, yMin, yMax, formula);
        JPanel jPanelJTextFields = new JPanel();

        containerXY.setLayout(new GridLayout(1,4));
        containerXY.add(xMin);
        containerXY.add(xMax);
        containerXY.add(yMin);
        containerXY.add(yMax);

        jPanelJTextFields.setLayout(new GridLayout(2, 1));
        jPanelJTextFields.add(containerXY);
        jPanelJTextFields.add(formula);

        containerPanels.setLayout(new BorderLayout());
        containerPanels.add(graphicPanel, BorderLayout.CENTER);
        containerPanels.add(jPanelJTextFields, BorderLayout.SOUTH);

        xMin.addActionListener(graphicPanel);

        this.setContentPane(containerPanels);

        this.setTitle("Wykres funkcji wielomianowej");
        this.setBounds(700, 200, 450, 550);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
