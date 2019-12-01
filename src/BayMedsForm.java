import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BayMedsForm extends JFrame{
    private JPanel title;
    private JPanel firstPanel;
    private JPanel firstWestPanel;
    private JPanel firstEastPanel;
    private JLabel ageLabel;
    private JTextField ageText;
    private JLabel genderLabel;
    private JComboBox genderBox;
    private JPanel secondPanel;
    private JLabel symptomsLabel;
    private JCheckBox chestPainCheckBox;
    private JCheckBox nauseaCheckBox;
    private JCheckBox muscleAcheCheckBox;
    private JCheckBox breathingDifficultiesCheckBox;
    private JCheckBox feverCheckBox;
    private JLabel commentsLabel;
    private JTextArea commentText;
    private JCheckBox yesCheckBox;
    private JCheckBox noCheckBox;
    private JPanel symptomsPanel;
    private JLabel medicationLabel;
    private JButton submitButton;
    private JTextField textField1;
    private JTextField medicationText;
    private JButton enterButton;
    private JList list1;
    private JCheckBox abdominalPainCheckBox;
    private JCheckBox coughCheckBox;
    private JCheckBox headacheCheckBox;
    private DefaultListModel demoList;

    public static void main(String[] args) {
        JFrame bmf = new JFrame("BayMedsForm");
        bmf.setContentPane(new BayMedsForm().title);
        bmf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bmf.pack();
        bmf.setVisible(true);

    }

    public BayMedsForm() {
        ButtonGroup bg = new ButtonGroup();
        bg.add(noCheckBox);
        bg.add(yesCheckBox);
        demoList = new DefaultListModel();
        list1.setModel(demoList);
        list1 = new JList(demoList);
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                demoList.addElement(medicationText.getText());
            }
        });
    }
}

