import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BayMedsForm extends JFrame {
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
    private Boolean onMedication;

    public static void main(String[] args) {
        JFrame bmf = new JFrame("BayMedsForm");
        bmf.setContentPane(new BayMedsForm().title);
        bmf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bmf.pack();
        bmf.setVisible(true);

    }

    public BayMedsForm() {
        PatientManager patientManager = new PatientManager();
        ButtonGroup bg = new ButtonGroup();
        bg.add(noCheckBox);
        bg.add(yesCheckBox);
        demoList = new DefaultListModel();
        list1.setModel(demoList);
        list1 = new JList(demoList);
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                demoList.addElement(medicationText.getText());
                repaint();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkMedication();
                Patient patient = new Patient(genderBox.getSelectedItem().toString(),
                        Integer.parseInt(ageText.getText()), onMedication);
                if (chestPainCheckBox.isSelected()) {
                    patient.addSymptom("chest pain");
                } else if (nauseaCheckBox.isSelected()) {
                    patient.addSymptom("nausea");
                } else if (muscleAcheCheckBox.isSelected()) {
                    patient.addSymptom("muscle ache");
                } else if (breathingDifficultiesCheckBox.isSelected()) {
                    patient.addSymptom("breathing difficulties");
                } else if (feverCheckBox.isSelected()) {
                    patient.addSymptom("fever");
                } else if (abdominalPainCheckBox.isSelected()) {
                    patient.addSymptom("abdominal pain");
                } else if (coughCheckBox.isSelected()) {
                    patient.addSymptom("cough");
                } else if (headacheCheckBox.isSelected()) {
                    patient.addSymptom("headache");
                }
                patientManager.addPatient(patient);
                patientManager.searchForPrioritySymptoms();
                patientManager.sortPatients();
                repaint();
            }
        });
    }
    public void checkMedication() {
        if (yesCheckBox.isSelected()) {
            onMedication = true;
        } else {
            onMedication = false;
        }
    }
}

