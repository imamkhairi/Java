import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class App3 extends JFrame {

    // private PlayerStatusOption[] PlayerStatusOption;
    private PlayerName playerName;
    private PlayerStatus playerStatus;
    private PlayerClass playerClass;
    private PlayerTrait playerTrait;

    App3() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel basePanel = new JPanel();
        basePanel.setPreferredSize(new Dimension(500,500));
        basePanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        
        this.playerName = new PlayerName();
        this.playerStatus = new PlayerStatus();
        this.playerClass = new PlayerClass();
        this.playerTrait = new PlayerTrait();

        gbc.gridx = 0;
        gbc.gridy = 0;
        basePanel.add(playerName, gbc);
        gbc.gridy = 1;
        basePanel.add(playerClass, gbc);
        gbc.gridy = 2;
        basePanel.add(playerStatus, gbc);
        gbc.gridy = 3;
        basePanel.add(playerTrait,gbc);

        this.getContentPane().add(basePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new App3();
    }

    private class PlayerName extends JPanel {
        private JTextField textField;
        private JLabel label;
        public PlayerName() {
            // this.setPreferredSize(new Dimension(300, 50));
            this.label = new JLabel();
            this.label.setText("Player Name : ");

            this.textField = new JTextField();
            this.textField.setPreferredSize(new Dimension(250, 40));
            this.textField.setFont(new Font("Monaco", Font.PLAIN, 20));

            this.add(this.label);
            this.add(this.textField);
            // this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Player Name", TitledBorder.CENTER, TitledBorder.CENTER));
        }
    }

    private class PlayerStatus extends JPanel{
        private PlayerStatusOption[] playerStatusOptions;
        private final String[] statusOptions = {"Strength", "Intelligence", "Dexterity"};
        
        public PlayerStatus() {
            this.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            this.playerStatusOptions = new PlayerStatusOption[this.statusOptions.length];
            for(int i = 0; i < this.statusOptions.length; i ++) {
                this.playerStatusOptions[i] = new PlayerStatusOption(this.statusOptions[i]);
                gbc.gridx = 0;
                gbc.gridy = i;
                this.add(playerStatusOptions[i], gbc);
            }
            this.setPreferredSize(new Dimension(300, 150));
            this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Player Status", TitledBorder.CENTER, TitledBorder.CENTER));
        }
        
        private class PlayerStatusOption extends JPanel{
            private JButton plusButton;
            private JButton minusButton;
            private JLabel show;
            private int value;
    
            public PlayerStatusOption(String s) {
                this.value = 0;
                this.plusButton = new JButton("+");
                this.minusButton = new JButton("-");
                this.show = new JLabel();
                this.show.setText(s + " : " + Integer.toString(value));
                this.show.setHorizontalAlignment(SwingConstants.CENTER);
                this.show.setPreferredSize(new Dimension(100, 20));
            
                this.add(this.minusButton);
                this.add(this.show);
                this.add(this.plusButton);
            }
        
            public JButton getButton() {
                return this.plusButton;
            }
        }
    }


    private class PlayerClass extends JPanel{
        private JRadioButton[] selection;
        private final String[] classSelection = {"Warrior", "Mage", "Rogue"};
        public PlayerClass() {
            this.selection = new JRadioButton[this.classSelection.length];
            ButtonGroup buttonGroup = new ButtonGroup();
            for(int i = 0; i < this.classSelection.length; i++) {
                this.selection[i] = new JRadioButton(this.classSelection[i]);
                buttonGroup.add(selection[i]);
                this.add(selection[i]);
            }
            this.setPreferredSize(new Dimension(300, 65));
            this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Player Class", TitledBorder.CENTER, TitledBorder.CENTER));
        }
    }

    private class PlayerTrait extends JPanel {
        private final String[] traits = {"Fast Reader", "Speed Demon", "Smoker", "Obese"};
        private JCheckBox[] checkBox;

        public PlayerTrait() {
            this.checkBox = new JCheckBox[this.traits.length];
            for(int i = 0; i < this.traits.length; i ++) {
                this.checkBox[i] = new JCheckBox(this.traits[i]);
                this.add(checkBox[i]);
            }
        }
    }
}
