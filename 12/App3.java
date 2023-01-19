import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

public class App3 extends JFrame implements ActionListener{

    // private PlayerStatusOption[] PlayerStatusOption;
    private PlayerName playerName;
    private PlayerStatus playerStatus;
    private PlayerClass playerClass;
    private PlayerTrait playerTrait;
    private OperationButton operationButton;

    App3() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel basePanel = new JPanel();
        basePanel.setPreferredSize(new Dimension(500,500));
        basePanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        
        this.playerName = new PlayerName();
        this.playerStatus = new PlayerStatus(this);
        this.playerClass = new PlayerClass();
        this.playerTrait = new PlayerTrait();
        this.operationButton = new OperationButton(this, this.playerName, this.playerClass, this.playerStatus, this.playerTrait);

        gbc.gridx = 0;
        gbc.gridy = 0;
        basePanel.add(playerName, gbc);
        gbc.gridy = 1;
        basePanel.add(playerClass, gbc);
        gbc.gridy = 2;
        basePanel.add(playerStatus, gbc);
        gbc.gridy = 3;
        basePanel.add(playerTrait,gbc);
        gbc.gridy = 4;
        basePanel.add(operationButton,gbc);

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
        }

        public String getPlayerName() {
            return this.textField.getText();
        }

        public void resetPlayerName() {
            this.textField.setText("");
        }
    }

    private class PlayerStatus extends JPanel{
        private PlayerStatusOption[] playerStatusOptions;
        private final String[] statusOptions = {"Strength", "Intelligence", "Dexterity"};
        
        public PlayerStatus(App3 a) {
            this.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            this.playerStatusOptions = new PlayerStatusOption[this.statusOptions.length];
            for(int i = 0; i < this.statusOptions.length; i ++) {
                this.playerStatusOptions[i] = new PlayerStatusOption(this.statusOptions[i], a);
                gbc.gridx = 0;
                gbc.gridy = i;
                this.add(playerStatusOptions[i], gbc);
            }
            this.setPreferredSize(new Dimension(300, 150));
            this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Player Status", TitledBorder.CENTER, TitledBorder.CENTER));
        }


        public JButton getPlayerStatusOptionPlusButton(int index) {
            return this.playerStatusOptions[index].getPlusButton();
        }

        public JButton getPlayerStatusOptionMinusButton(int index) {
            return this.playerStatusOptions[index].getMinusButton();
        }

        public void downPlayerStatusOptionValue(int index) {
            this.playerStatusOptions[index].downValue();
        }

        public void upPlayerStatusOptionValue(int index) {
            this.playerStatusOptions[index].upValue();
        }

        public String getPlayerStatusOptionAll(int index) {
            return this.playerStatusOptions[index].getText() + " : " + this.playerStatusOptions[index].getValue();
        }

        public void resetPlayerStatusOptionValue() {
            for(int i = 0; i < this.statusOptions.length; i ++) {
                this.playerStatusOptions[i].resetValue();
            }
        }

        private class PlayerStatusOption extends JPanel{
            private JButton plusButton;
            private JButton minusButton;
            private JLabel show;
            private int value;
            private String text;
    
            public PlayerStatusOption(String s, App3 a) {
                this.text = s;
                this.value = 0;
                this.plusButton = new JButton("+");
                this.minusButton = new JButton("-");
                this.show = new JLabel();
                this.show.setText(text + " : " + Integer.toString(value));
                this.show.setHorizontalAlignment(SwingConstants.CENTER);
                this.show.setPreferredSize(new Dimension(100, 20));
                this.plusButton.addActionListener(a);
                this.minusButton.addActionListener(a);

                this.add(this.minusButton);
                this.add(this.show);
                this.add(this.plusButton);
            }
        
            public JButton getPlusButton() {
                return this.plusButton;
            }

            public JButton getMinusButton() {
                return this.minusButton;
            }

            public void upValue() {
                this.value++;
                this.updateValue();
            }

            public void downValue() {
                if(this.value > 0) {
                    this.value--;
                    this.updateValue();
                }
            }

            public void updateValue() {
                this.show.setText(this.text +" : "+ Integer.toString(this.value));
            }

            public int getValue() {
                return this.value;
            }

            public String getText() {
                return this.text;
            }

            public void resetValue() {
                this.value = 0;
                this.updateValue();
            }
        }
    }


    private class PlayerClass extends JPanel{
        private JRadioButton[] selection;
        private final String[] classSelection = {"Warrior", "Mage", "Rogue"};
        private ButtonGroup buttonGroup;
        public PlayerClass() {
            this.selection = new JRadioButton[this.classSelection.length];
            this.buttonGroup = new ButtonGroup();
            for(int i = 0; i < this.classSelection.length; i++) {
                this.selection[i] = new JRadioButton(this.classSelection[i]);
                buttonGroup.add(selection[i]);
                this.add(selection[i]);
            }
            this.setPreferredSize(new Dimension(300, 65));
            this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Player Class", TitledBorder.CENTER, TitledBorder.CENTER));
        }

        private int checkSelected() {
            int result = -1;
            for(int i = 0; i < this.selection.length; i++){
                if(this.selection[i].isSelected()) {
                    result = i;
                    break;
                }
            }
            return result;
        }
        public String getPlayerClass() {
            String result = "";
            for(int i = 0; i < this.selection.length; i++){
                if(this.checkSelected() == i) {
                    result = this.selection[i].getText();
                    break;
                }
                else {
                    result = "Class not selected";
                }
            }
            return result;
        }
        public void resetSelectedClass() {
            this.buttonGroup.clearSelection();
        }
    }

    private class PlayerTrait extends JPanel {
        private final String[][] traits = {{"Fast Reader", "Speed Demon"}, 
                                            {"Smoker", "Obese"}};
        private JCheckBox[][] checkBox;

        public PlayerTrait() {
            this.setLayout(new GridLayout(this.traits.length, this.traits.length, 60,0));
            this.checkBox = new JCheckBox[this.traits.length][this.traits.length];
            this.instantiateTraits(this.traits[0], this.traits[1], this.checkBox);
            this.addToPanel(this, this.traits[0], this.traits[1], this.checkBox);
            this.setPreferredSize(new Dimension(300, 80));
            this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Player Trait", TitledBorder.CENTER, TitledBorder.CENTER));
        }

        public String[][] getTrait() {
            return this.traits;
        }

        private void instantiateTraits(String[] positive, String[] negative, JCheckBox[][] traitCheckBox) {
            for(int i = 0; i < positive.length; i ++) {
                for(int j = 0; j < negative.length; j ++) {
                    traitCheckBox[i][j] = new JCheckBox(this.traits[i][j]);
                }
            }
        }

        private void addToPanel(JPanel panel, String[] positive, String[] negative, JCheckBox[][] traitCheckBox) {
            for(int i = 0; i < positive.length; i ++) {
                for(int j = 0; j < negative.length; j ++) {
                    panel.add(traitCheckBox[j][i]);
                }
            }
        }


        public void printTrait(String[] positive, String[] negative) {
            for(int i = 0 ; i < positive.length; i ++) {
                for(int j = 0; j < negative.length; j ++) {
                    System.out.println(this.checkBox[i][j].getText() + " : " + this.checkBox[i][j].isSelected());
                }
            }
        }

        public void resetSelected(String[] positive, String[] negative) {
            for(int i = 0 ; i < positive.length; i ++) {
                for(int j = 0; j < negative.length; j ++) {
                    this.checkBox[i][j].setSelected(false);
                }
            }
        }

    }

    private class OperationButton extends JPanel {
        private JButton[] button;
        private PlayerName pn;
        private PlayerClass pc;
        private PlayerStatus ps;
        private PlayerTrait pt;

        public OperationButton(App3 a, PlayerName pn, PlayerClass pc, PlayerStatus ps, PlayerTrait pt) {
            this.pn = pn;
            this.pc = pc;
            this.ps = ps;
            this.pt = pt;
            this.button = new JButton[2];
            this.button[0] = new JButton("Submit");
            this.button[1] = new JButton("Reset");
            this.button[0].addActionListener(a);
            this.button[1].addActionListener(a);
            this.add(button[0]);
            this.add(button[1]);
        }

        public JButton getResetButton() {
            return this.button[1];
        }
        public JButton getSubmiButton() {
            return this.button[0];
        }
        public void submitResult() {
            System.out.println("Name : " + this.pn.getPlayerName());
            System.out.println("Class : " + this.pc.getPlayerClass());
            System.out.println(this.ps.getPlayerStatusOptionAll(0));
            System.out.println(this.ps.getPlayerStatusOptionAll(1));
            System.out.println(this.ps.getPlayerStatusOptionAll(2));
            this.pt.printTrait(this.pt.getTrait()[0], this.pt.getTrait()[1]);
        }
        public void resetSelection() {
            this.pn.resetPlayerName();
            this.pc.resetSelectedClass();
            this.ps.resetPlayerStatusOptionValue();
            this.pt.resetSelected(this.pt.getTrait()[0], this.pt.getTrait()[1]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.operationButton.getResetButton()) {
            System.out.println("reset");
            this.operationButton.resetSelection();
        }
        else if(e.getSource() == this.operationButton.getSubmiButton()) {
            this.operationButton.submitResult();
        }
        else if(e.getSource() == this.playerStatus.getPlayerStatusOptionPlusButton(0)) {
            this.playerStatus.upPlayerStatusOptionValue(0);
        }
        else if(e.getSource() == this.playerStatus.getPlayerStatusOptionPlusButton(1)) {
            this.playerStatus.upPlayerStatusOptionValue(1);
        }
        else if(e.getSource() == this.playerStatus.getPlayerStatusOptionPlusButton(2)) {
            this.playerStatus.upPlayerStatusOptionValue(2);
        }
        else if(e.getSource() == this.playerStatus.getPlayerStatusOptionMinusButton(0)) {
            this.playerStatus.downPlayerStatusOptionValue(0);
        }
        else if(e.getSource() == this.playerStatus.getPlayerStatusOptionMinusButton(1)) {
            this.playerStatus.downPlayerStatusOptionValue(1);
        }
        else if(e.getSource() == this.playerStatus.getPlayerStatusOptionMinusButton(2)) {
            this.playerStatus.downPlayerStatusOptionValue(2);
        }
    }
}