package ZAD_17_EdytorZMenu;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main extends JFrame{

    public Main(){
        initcomponents();
    }

    public void initcomponents(){

        this.setTitle("Prosty edytor - bez tytułu");
        this.setBounds(-700, 300, 500, 450);
//        this.setBounds(300, 300, 300, 200);

        jPanel.setLayout(new BorderLayout());

        jTextArea.setSize(200, 100);// nie działa

        jPanel.setBorder(new EtchedBorder(Color.gray, Color.gray));
        jTextArea.setBackground(Color.white);

        jTextArea.setFont(new Font("Dialog", Font.BOLD, 30));
        jTextArea.setForeground(Color.BLUE);

//        jTextArea.setWrapStyleWord(true);
//        jTextArea.setLineWrap(true);

        JScrollPane jScrollPane = new JScrollPane(jTextArea);



        this.setJMenuBar(menuBar);
        this.add(jPanel);
        jPanel.add(jScrollPane);

        JMenu menuFile = menuBar.add(new JMenu("File"));
        JMenu menuEdit = menuBar.add(new JMenu("Edit"));
        JMenu menuOptions = menuBar.add(new JMenu("Options"));

        JMenuItem menuFileOpen = menuFile.add(new JMenuItem("Open"));
        addSeparatorToJMenu(menuFile);
        JMenuItem menuFileSave = menuFile.add(new JMenuItem("Save"));


        menuFileOpen.addActionListener(ae->{
            JFileChooser jFileChooser = new JFileChooser();
            if(jFileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                File file = jFileChooser.getSelectedFile();
                this.setTitle(file.getAbsolutePath());

                try{
                    Scanner scanner = new Scanner(file);
                    menuFileSave.setEnabled(true);
                    while (scanner.hasNext())
                        jTextArea.append(scanner.nextLine() + "\n");
                } catch (FileNotFoundException e){
                    e.getMessage();
                }
            }

        })
        ;


//        addJMenuItem(menuFile, "Open");


        menuFileSave.setEnabled(false);
        addSeparatorToJMenu(menuFile);

        menuFileSave.addActionListener(ae->{
            File file = new File(this.getTitle());
            try{
                PrintWriter printWriter = new PrintWriter(file);
                Scanner scanner = new Scanner(jTextArea.getText());
                while (scanner.hasNext())
                    printWriter.println(scanner.nextLine());
                printWriter.close();
            } catch (FileNotFoundException e){
                e.getMessage();
            }

        });

//        addJMenuItem(menuFile, "Save");

        JMenuItem menuFileSaveAs = menuFile.add(new JMenuItem("Save as..."));
        addSeparatorToJMenu(menuFile);

        menuFileSaveAs.addActionListener(ae->{
            JFileChooser jFileChooser = new JFileChooser();
            if(jFileChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                File file = jFileChooser.getSelectedFile();

                try{
                    PrintWriter printWriter = new PrintWriter(file);
                    Scanner scanner = new Scanner(jTextArea.getText());
                    while (scanner.hasNext())
                        printWriter.print(scanner.nextLine() + "\n");
                    printWriter.close();
                } catch (FileNotFoundException e){
                    e.getMessage();
                }
            }

        })
        ;
//        addJMenuItem(menuFile, "Save as ...");
        addSeparatorToJMenu(menuFile);

        JMenuItem menuFileExit = menuFile.add(new JMenuItem("Exit"));

        menuFileExit.addActionListener(ae->{
                this.dispose();
        });
//        addLastJMenuItem(menuFile, "Exit");


        JMenu menuAdresy = new JMenu("Adresy");
        menuEdit.add(menuAdresy);

        JMenuItem menuAdresyPraca = menuAdresy.add(new JMenuItem("Praca"));
        addSeparatorToJMenu(menuAdresy);

        menuAdresyPraca.addActionListener(ae->{
            jTextArea.insert("Praca", jTextArea.getCaretPosition());
        });

        JMenuItem menuAdresySzkola = menuAdresy.add(new JMenuItem("Szkola"));
        addSeparatorToJMenu(menuAdresy);
        menuAdresySzkola.addActionListener(ae->{
            jTextArea.insert("Szkola", jTextArea.getCaretPosition());
        });

        JMenuItem menuAdresyDom = menuAdresy.add(new JMenuItem("Dom"));
        menuAdresyDom.addActionListener(ae->{
            jTextArea.insert("Dom", jTextArea.getCaretPosition());
        });

//        addJMenuItem(menuAdresy, "Praca");
//        addJMenuItem(menuAdresy, "Szkoła");
//        addLastJMenuItem(menuAdresy, "Dom");


        menuForegroud = new JMenu("Foreground");
        menuOptions.add(menuForegroud);
        addColorJMenuItemForegroud(menuForegroud);

        menuBackground = new JMenu("Background");
        menuOptions.add(menuBackground);
        addColorJMenuItemBackgroud(menuBackground);

        menuFontSize = new JMenu("Font size");
        menuOptions.add(menuFontSize);
        addFontSizeJMenuItem(menuFontSize);


        this.setDefaultCloseOperation(3);
    }

    public void addJMenuItem(JMenu jMenu, String text){
        jMenu.add(new JMenuItem(text));
        addSeparatorToJMenu(jMenu);
    }


    public void addLastJMenuItem(JMenu jMenu, String text){
        jMenu.add(new JMenuItem(text));
    }

    public void addSeparatorToJMenu(JMenu jMenu){
        jMenu.addSeparator();
    }

    public void addColorJMenuItemForegroud(JMenu jMenu){

        String[] colors = {"Blue", "Yellow", "Orange", "Red", "White", "Black", "Green"};

        JMenuItem item;
        for(int i=0; i<colors.length-2; i++){
            item = new JMenuItem(colors[i]);
            item.addActionListener(new ActionsForeground());
            jMenu.add(item);
            addSeparatorToJMenu(jMenu);
        }
        item = new JMenuItem(colors[colors.length-1]);
        item.addActionListener(new ActionsForeground());
        jMenu.add(item);
    }

    public void addColorJMenuItemBackgroud(JMenu jMenu){

        String[] colors = {"Blue", "Yellow", "Orange", "Red", "White", "Black", "Green"};
        JMenuItem item;

        for(int i=0; i<colors.length-2; i++){
            item = new JMenuItem(colors[i]);
            item.addActionListener(new ActionsBackground());
            jMenu.add(item);
            addSeparatorToJMenu(jMenu);
        }
        item = new JMenuItem(colors[colors.length-1]);
        item.addActionListener(new ActionsBackground());
        jMenu.add(item);
    }

    public void addFontSizeJMenuItem(JMenu jMenu){

        JMenuItem item;

        int i;
        for (i=4; i<12; i++){
            item = new JMenuItem(i*2+" pts");
            item.addActionListener(new ActionsFontSize());
            jMenu.add(item);
            addSeparatorToJMenu(jMenu);
        }
        item = new JMenuItem(i*2+" pts");
        item.addActionListener(new ActionsFontSize());
        jMenu.add(item);
    }

    private JPanel jPanel = new JPanel();
    private JTextArea jTextArea =  new JTextArea();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuForegroud, menuBackground,menuFontSize;

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    class ActionsForeground implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem item = (JMenuItem) e.getSource();
            String text = item.getText();
            switch (text){
                case "Yellow":{
                    jTextArea.setForeground(Color.YELLOW);
                    break;
                }
                case "Blue":{
                    jTextArea.setForeground(Color.BLUE);
                    break;
                }
                case "Orange":{
                    jTextArea.setForeground(Color.ORANGE);
                    break;
                }
                case "Red":{
                    jTextArea.setForeground(Color.RED);
                    break;
                }
                case "White":{
                    jTextArea.setForeground(Color.WHITE);
                    break;
                }
                case "Black":{
                    jTextArea.setForeground(Color.BLACK);
                    break;
                }
                case "Green":{
                    jTextArea.setForeground(Color.GREEN);
                    break;
                }
            }
        }
    }

    class ActionsBackground implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem item = (JMenuItem) e.getSource();
            String text = item.getText();
            switch (text){
                case "Yellow":{
                    jTextArea.setBackground(Color.YELLOW);
                    break;
                }
                case "Blue":{
                    jTextArea.setBackground(Color.BLUE);
                    break;
                }
                case "Orange":{
                    jTextArea.setBackground(Color.ORANGE);
                    break;
                }
                case "Red":{
                    jTextArea.setBackground(Color.RED);
                    break;
                }
                case "White":{
                    jTextArea.setBackground(Color.WHITE);
                    break;
                }
                case "Black":{
                    jTextArea.setBackground(Color.BLACK);
                    break;
                }
                case "Green":{
                    jTextArea.setBackground(Color.GREEN);
                    break;
                }
            }

        }
    }

    class ActionsFontSize implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem item = (JMenuItem) e.getSource();
            String text = item.getText();

            text = text.substring(0,2).trim();
            jTextArea.setFont(new Font("Dialog", Font.BOLD, Integer.valueOf(text)));

        }
    }
}
