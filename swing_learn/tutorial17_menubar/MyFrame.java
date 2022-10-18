package swing_learn.tutorial17_menubar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{

    private JMenuBar menuBar;

    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu helpMenu;

    private JMenuItem loadItem;
    private JMenuItem saveItem;
    private JMenuItem exitItem;

    private ImageIcon loadIcon;
    private ImageIcon saveIcon;
    private ImageIcon exitIcon;


    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());

        // buat ImageIcon (ngasal ini iconnya)
        loadIcon = new ImageIcon("swing_learn\\tutorial17_menubar\\check.png");
        saveIcon = new ImageIcon("swing_learn\\tutorial17_menubar\\small.png");
        exitIcon = new ImageIcon("swing_learn\\tutorial17_menubar\\x_icon.png");

        // menubar <- menu <- menuitem

        menuBar = new JMenuBar();

        // ini pilihan menu yang akan dimasukkan ke dalam menubar gitu
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        loadItem.setIcon(loadIcon);
        saveItem.setIcon(saveIcon);
        exitItem.setIcon(exitIcon);

        fileMenu.setMnemonic(KeyEvent.VK_F); // alt + f for file
        editMenu.setMnemonic(KeyEvent.VK_E); // alt + e for edit
        helpMenu.setMnemonic(KeyEvent.VK_H); // alt + h for help
        loadItem.setMnemonic(KeyEvent.VK_L); // l for load
        saveItem.setMnemonic(KeyEvent.VK_S); // s for load
        exitItem.setMnemonic(KeyEvent.VK_E); // e for exit

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loadItem) {
            System.out.println("You loaded a file");
        }
        else if(e.getSource() == saveItem) {
            System.out.println("You saved a file");
        }
        else if(e.getSource() == exitItem) {
            System.exit(0); // agar exit
        }
    }
    
}
