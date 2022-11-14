import java.io.*;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

import java.awt.*;
import java.awt.event.*;


public class TextEditor_2 extends JFrame implements ActionListener{
    private JTextField textField;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    
    private JLabel locLabel;
    
    private JMenuBar menuBar;
    private JMenu[] menu;
    private JMenuItem[] menuItems;

    private MyCaretListener myCaretListener;
    // private MyDocumentListener myDocumentListener;
    // private JButton position;


    public TextEditor_2() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Text Editor");

        this.textField = new JTextField(26);
        
        this.textArea = new JTextArea();
        this.textArea.setLineWrap(false);
        
        this.scrollPane = new JScrollPane(this.textArea);
        this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.scrollPane.setPreferredSize(new Dimension(960,540));

        this.locLabel = new JLabel();
        this.locLabel.setText("Ln " + 1 + ", Col " + 1);

        this.menuBar = new JMenuBar();
        this.menuBar.setOpaque(true);
        this.menuBar.setBackground(Color.WHITE);

        this.menu = new JMenu[2];
        this.menu[0] = new JMenu("File");
        this.menu[1] = new JMenu("Format");

        this.menuItems = new JMenuItem[3];
        this.menuItems[0] = new JMenuItem("Open");
        this.menuItems[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)); // ctrl + o
        this.menuItems[1] = new JMenuItem("Save");
        this.menuItems[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.SHIFT_DOWN_MASK | KeyEvent.CTRL_DOWN_MASK)); // ctrl + shift + s
        this.menuItems[2] = new JMenuItem("Wrap On");
        for(int i = 0; i < this.menuItems.length; i ++) {
            this.menuItems[i].addActionListener(this);
        }

        // adding component to menubar
        this.menu[0].add(this.menuItems[0]);
        this.menu[0].add(this.menuItems[1]);
        this.menu[1].add(this.menuItems[2]);

        this.menuBar.add(this.menu[0]);
        this.menuBar.add(this.menu[1]);

        this.myCaretListener = new MyCaretListener(this.locLabel);
        this.textArea.addCaretListener(myCaretListener);

        JPanel basePanel = new JPanel();
        basePanel.setBackground(new Color(240,240,240));
        basePanel.setLayout(new BorderLayout());
        basePanel.add(this.menuBar, BorderLayout.PAGE_START);
        basePanel.add(this.scrollPane, BorderLayout.CENTER);
        basePanel.add(this.locLabel, BorderLayout.PAGE_END);

        this.getContentPane().add(basePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new TextEditor_2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.menuItems[0]) {
            System.out.println("open");
            this.openFile(this.showFileDialog(this.menuItems[0].getText()));
        }
        if(e.getSource() == this.menuItems[1]) {
            System.out.println("save");
            this.saveFile(this.showFileDialog(this.menuItems[1].getText()));
        }
        if(e.getSource() == this.menuItems[2]) {
            System.out.println("wrap");
            this.changeTextWrap();
        }
    }

    private void openFile(String fileName) {
        if(!fileName.equals("Cancel")) {
            try {
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr);
                String buf;
                int line_count = 1;
                this.clearTextArea();
                while ((buf = br.readLine()) != null) {
                    if(line_count == 1) {
                        this.textArea.append(buf);
                    } else {
                        this.textArea.append("\n" + buf);
                    }
                    line_count ++;
                }
                br.close();
                fr.close();
            }
            catch(IOException e) {
                System.out.println("file open error");
                System.exit(1);
            }
        } else {
            System.out.println("File open cancelled");
        }

    }

    private void saveFile(String fileName) {
        if(!fileName.equals("Cancel")) {
            try {
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fw);
                System.out.println(this.textArea.getText());
                bw.write(this.textArea.getText());
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("file save error");
                System.exit(1);
            }
        } else {
            System.out.println("File save canceled");
        }
    }

    private void clearTextArea() {
        this.textArea.setText("");
    }

    private String showFileDialog(String type) {
        File selectedFile = null;
        JFileChooser fileChooser = new JFileChooser();
        int result = -1;
        if(type.equals("Open")) {
            result = fileChooser.showOpenDialog(this);
            fileChooser.setDialogTitle("Open");
        } else if (type.equals("Save")) {
            result = fileChooser.showSaveDialog(this);
            fileChooser.setDialogTitle("Save As");
        }

        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            this.setTitle(selectedFile.getName());
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        } else if(result == JFileChooser.CANCEL_OPTION) {
            return "Cancel";
        } else {
            System.out.println("Process error");
        }
        return selectedFile.getAbsolutePath();
    }

    private void changeTextWrap() {
        if(this.textArea.getLineWrap()) {
            this.textArea.setLineWrap(false);
            this.menuItems[2].setText("Wrap On");
        } else {
            this.textArea.setLineWrap(true);
            this.menuItems[2].setText("Wrap Off");
        }
    }

    private class MyCaretListener implements CaretListener {
        private JLabel label;

        public MyCaretListener(JLabel label) {
            this.label = label;
        }

        @Override
        public void caretUpdate(CaretEvent e) {
            // offset itu seperti lokasi (int) tapi bebas?
            JTextArea editArea = (JTextArea)e.getSource();

            int line = 1;
            int col = 1;

            try {
                int caretpos = editArea.getCaretPosition();
                line = editArea.getLineOfOffset(caretpos); // get line based on caret position (offset)

                col = caretpos - editArea.getLineStartOffset(line) + 1; // get start line offset value 
                line += 1;
            } catch (BadLocationException ex) {
            }
            label.setText("Ln " + line + ", Col " + col);  
        }
    }
}

/* 
THINGS TO DO
- bikin shortcut untuk file menu bar (alt)
- bikin save as
- set font size (optional)

*/