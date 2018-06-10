package ZAD_17_EdytorZMenu;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

//TODO
//skroty klawiszow
//ma otwierac ostatnie mijsce zapisu pliku
//DONE ikonki kolorow
//DONE lista kolorow

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

        JMenuItem menuFileOpen = menuFile.add(new JMenuItem("Open", 'o'));
        addSeparatorToJMenu(menuFile);
        JMenuItem menuFileSave = menuFile.add(new JMenuItem("Save", 's'));




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

        JMenuItem menuFileSaveAs = menuFile.add(new JMenuItem("Save as...", 'a'));
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
        addSeparatorToJMenu(menuFile);

        JMenuItem menuFileExit = menuFile.add(new JMenuItem("Exit", 'e'));

        menuFileExit.addActionListener(ae->{
                this.dispose();
        });

        menuAdresy = new JMenu("Adresy");
        menuEdit.add(menuAdresy);

        JMenuItem menuAdresyPraca = menuAdresy.add(new JMenuItem("Firma", 'f'));
        addSeparatorToJMenu(menuAdresy);
        JMenuItem menuAdresySzkola = menuAdresy.add(new JMenuItem("Szkola", 's'));
        addSeparatorToJMenu(menuAdresy);
        JMenuItem menuAdresyDom = menuAdresy.add(new JMenuItem("Dom", 'd'));

        menuAdresyPraca.addActionListener(ae->{
            jTextArea.insert("Firma", jTextArea.getCaretPosition());
        });
        menuAdresySzkola.addActionListener(ae->{
            jTextArea.insert("Szkola", jTextArea.getCaretPosition());
        });

        menuAdresyDom.addActionListener(ae->{
            jTextArea.insert("Dom", jTextArea.getCaretPosition());
        });


        menuForegroud = new JMenu("Foreground");
        menuBackground = new JMenu("Background");
        menuFontSize = new JMenu("Font size");

        menuOptions.add(menuForegroud);
        menuOptions.add(menuBackground);
        menuOptions.add(menuFontSize);

        addColorJMenuItemForegroud(menuForegroud);
        addColorJMenuItemBackgroud(menuBackground);
        addFontSizeJMenuItem(menuFontSize);


        this.setDefaultCloseOperation(3);
    }

    public void addSeparatorToJMenu(JMenu jMenu){

        jMenu.addSeparator();
    }

    public void addColorJMenuItemForegroud(JMenu jMenu){

        ColorMap colorMap = new ColorMap();
        List<String> list = colorMap.getList();

        JMenuItem item;

        for(int i=0; i<list.size()-1; i++){
            item = new JMenuItem(list.get(i), new ColorIcons(colorMap.getValueColor(list.get(i))));
            item.addActionListener(new ActionsForeground());
            jMenu.add(item);
            addSeparatorToJMenu(jMenu);
        }
        item = new JMenuItem(list.get(list.size()-1), new ColorIcons(colorMap.getValueColor(list.get(list.size()-1))));
        item.addActionListener(new ActionsForeground());
        jMenu.add(item);

    }

    public void addColorJMenuItemBackgroud(JMenu jMenu){

        ColorMap colorMap = new ColorMap();
        List<String> list = colorMap.getList();

        JMenuItem item;

        for(int i=0; i<list.size()-1; i++){
            item = new JMenuItem(list.get(i), new ColorIcons(colorMap.getValueColor(list.get(i))));
            item.addActionListener(new ActionsBackground());
            jMenu.add(item);
            addSeparatorToJMenu(jMenu);
        }
        item = new JMenuItem(list.get(list.size()-1), new ColorIcons(colorMap.getValueColor(list.get(list.size()-1))));
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
    private JMenu menuAdresy;


    public static void main(String[] args) {

        new Main().setVisible(true);
    }

    class ActionsForeground implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem item = (JMenuItem) e.getSource();
            ColorMap colorMap = new ColorMap();

            String text = item.getText();

            jTextArea.setForeground(colorMap.getValueColor(text));

        }
    }

    class ActionsBackground implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem item = (JMenuItem) e.getSource();
            ColorMap colorMap = new ColorMap();

            String text = item.getText();
            jTextArea.setBackground(colorMap.getValueColor(text));

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
