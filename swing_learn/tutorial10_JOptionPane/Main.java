package swing_learn.tutorial10_JOptionPane;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {
    // JOptionPane = pop up standard dialog box that prompts users for a value
    //               or informs them of something
    public static void main(String[] args) {
        // JOptionPane.showMessageDialog(null, "This is some useless info", "Title", JOptionPane.PLAIN_MESSAGE);
        // JOptionPane.showMessageDialog(null, "Here is more useless info :)", "Title", JOptionPane.INFORMATION_MESSAGE);
        // JOptionPane.showMessageDialog(null, "Really?", "Title", JOptionPane.QUESTION_MESSAGE);
        // JOptionPane.showMessageDialog(null, "Your computer has A virus", "Title", JOptionPane.WARNING_MESSAGE);
        // JOptionPane.showMessageDialog(null, "Call tech support now or else", "Title", JOptionPane.ERROR_MESSAGE);
    
        //int answer = JOptionPane.showConfirmDialog(null, "Bro do you even code?", "A Title", JOptionPane.YES_NO_CANCEL_OPTION); 
        // String name = JOptionPane.showInputDialog(null, "What is your name?: ");
        // System.out.println("Hello " + name);

        String[] responses = {"No, You are awesome!", "Thank you!", "*blush*"};

        ImageIcon icon = new ImageIcon("D:\\高専\\Java\\swing_learn\\tutorial10_JOptionPane\\small.png");

        JOptionPane.showOptionDialog(null,
        "You are awesome", 
        "Secret Message", 
        JOptionPane.YES_NO_CANCEL_OPTION, 
        JOptionPane.INFORMATION_MESSAGE, 
        icon, 
        responses,
        0);

    }
}
