import java.io.*;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import java.awt.*;
import java.awt.event.*;


public class TextEditor_2 extends JFrame implements ActionListener{
    private JTextArea textArea;
    private JScrollPane scrollPane;
    
    private JLabel locLabel;
    
    private JMenuBar menuBar;
    private JMenu[] menu;
    private JMenuItem[] menuItems;

    private MyCaretListener myCaretListener;
    private MyDocumentListener myDocumentListener;

    private boolean isSaved;
    private String filePath;

    public TextEditor_2() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Text Editor");
        
        this.textArea = new JTextArea();
        this.textArea.setLineWrap(false);
        
        this.scrollPane = new JScrollPane(this.textArea);
        this.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.scrollPane.setPreferredSize(new Dimension(960,540));

        this.isSaved = false;
        this.filePath = "";

        this.locLabel = new JLabel();
        this.locLabel.setText("Ln " + 1 + ", Col " + 1);

        this.menuBar = new JMenuBar();
        this.menuBar.setOpaque(true);
        this.menuBar.setBackground(Color.WHITE);

        this.menu = new JMenu[2];
        this.menu[0] = new JMenu("File");
        this.menu[1] = new JMenu("Format");

        this.menuItems = new JMenuItem[5];
        this.menuItems[0] = new JMenuItem("New");
        this.menuItems[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); // ctrl + o
        this.menuItems[1] = new JMenuItem("Open");
        this.menuItems[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)); // ctrl + o
        this.menuItems[2] = new JMenuItem("Save");
        this.menuItems[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK)); // ctrl + shift + s
        this.menuItems[3] = new JMenuItem("Save As");
        this.menuItems[3].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.SHIFT_DOWN_MASK | KeyEvent.CTRL_DOWN_MASK));
        this.menuItems[4] = new JMenuItem("Wrap On");
        for(int i = 0; i < this.menuItems.length; i ++) {
            this.menuItems[i].addActionListener(this);
        }

        // adding component to menubar
        this.menu[0].add(this.menuItems[0]);
        this.menu[0].add(this.menuItems[1]);
        this.menu[0].add(this.menuItems[2]);
        this.menu[0].add(this.menuItems[3]);
        this.menu[1].add(this.menuItems[4]);

        this.menuBar.add(this.menu[0]);
        this.menuBar.add(this.menu[1]);

        //Add listener
        this.myCaretListener = new MyCaretListener(this.locLabel);
        this.textArea.addCaretListener(myCaretListener);
        this.myDocumentListener = new MyDocumentListener(this);
        this.textArea.getDocument().addDocumentListener(myDocumentListener);

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
        if(e.getSource() == this.menuItems[0]){
            this.initiateNewFile();
        }
        if(e.getSource() == this.menuItems[1]) {
            System.out.println("open");
            this.openFile(this.setFilePath(this.showFileDialog(this.menuItems[1].getText())));
        }
        if(e.getSource() == this.menuItems[2]) {
            System.out.println("save");
            if(this.getSaved()) {
                this.saveAsFile(getFilePath());
            } else {
                this.saveAsFile(this.setFilePath(this.showFileDialog(this.menuItems[2].getText())));
                System.out.println("save as");
            }
        }
        if(e.getSource() == this.menuItems[3]) {
            System.out.println("save as");
            this.saveAsFile(this.setFilePath(this.showFileDialog(this.menuItems[2].getText())));
        }
        if(e.getSource() == this.menuItems[4]) {
            this.changeTextWrap();
        }
    }

    private void initiateNewFile() {
        this.clearTextArea();
        this.setTitle("Text Editor");
        this.myDocumentListener.setFileName(this.getTitle());
        this.setFilePath("");
        this.setSaved(false);
        System.out.println("new file created");
    }

    private String setFilePath(String filePath) {
        this.filePath = filePath;
        return filePath;
    }

    private String getFilePath() {
        return this.filePath;
    }

    private boolean getSaved() {
        return this.isSaved;
    }
    
    private void setSaved(boolean status) {
        this.isSaved = status;
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
                        line_count++;
                    } else {
                        this.textArea.append("\n" + buf);
                    }
                }
                br.close();
                fr.close();
                this.setSaved(true);
                this.myDocumentListener.savedTitle();
                this.myDocumentListener.setBuffText(this.textArea.getText());
            }
            catch(IOException e) {
                System.out.println("file open error");
                System.exit(1);
            }
        } else {
            System.out.println("File open cancelled");
        }
    }

    private void saveAsFile(String fileName) {
        if(!fileName.equals("Cancel")) {
            try {
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(this.textArea.getText());
                bw.close();
                fw.close();
                this.setSaved(true);
                this.myDocumentListener.savedTitle();
                this.myDocumentListener.setBuffText(this.textArea.getText());
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

    public JTextArea getTextArea() {
        return this.textArea;
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
            this.myDocumentListener.setFileName(this.getTitle());
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
            this.menuItems[3].setText("Wrap On");
        } else {
            this.textArea.setLineWrap(true);
            this.menuItems[3].setText("Wrap Off");
        }
    }

    private class MyCaretListener implements CaretListener {
        private JLabel label;

        public MyCaretListener(JLabel label) {
            this.label = label;
        }

        @Override
        public void caretUpdate(CaretEvent e) {
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

    private class MyDocumentListener implements DocumentListener {
        private TextEditor_2 appFrame;
        private String fileName;
        private String buffText;

        public MyDocumentListener(TextEditor_2 appFrame) {
            this.appFrame = appFrame;
            this.fileName = this.appFrame.getTitle();
            this.buffText = this.appFrame.getTextArea().getText();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            this.changeCheck();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            this.changeCheck();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }

        public void setFileName(String newFileName) {
            this.fileName = newFileName;
        }

        public void unsavedTitle() {
            this.appFrame.setTitle("*" + this.fileName);
        }

        public void savedTitle() {
            this.appFrame.setTitle(this.fileName);
        }
        
        private void changeCheck() {
            if(this.buffText.equals(this.appFrame.getTextArea().getText())) {
                this.savedTitle();
            } else {
                this.unsavedTitle();
            }
        }

        public void setBuffText(String newBuff) {
            this.buffText = newBuff;
        } 
    }
}

/* 
THINGS TO DO
- kalau save as yang udh pernah di save buka dialog di direktori itu langsung
- bikin shortcut untuk file menu bar (alt)
- set font size (optional)
*/