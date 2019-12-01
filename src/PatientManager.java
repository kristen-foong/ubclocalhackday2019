import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PatientManager {
    List<Patient> patients;
    int numpatients;
    List<Patient> priorityPatients;
    List<Patient> regularPatients;

    public PatientManager() {
        patients = new ArrayList<>();
        priorityPatients = new ArrayList<>();
        regularPatients = new ArrayList<>();
        numpatients = 1;
    }

    public void addPatient(Patient patient) {
        patient.setID(numpatients);
        patients.add(patient);
        numpatients ++;
    }

    public int patientsSize() {
        return patients.size();
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public void searchForPrioritySymptoms() {
        for (Patient p : patients) {
            for (String s: p.getSymptoms()) {
                if (s.equals("chest pain") || s.equals("difficulty breathing") || s.equals("abdominal pain")) {
                    p.setPriority(true);
                    priorityPatients.add(p);
                } else {
                    regularPatients.add(p);
                }
            }
        }
    }

    public void sortPatients() {
        priorityPatients.sort(Comparator.comparing(Patient::getSeverity).reversed());
        regularPatients.sort(Comparator.comparing(Patient::getSeverity).reversed());
        for (Patient p : priorityPatients) {
            System.out.println(p.getID());
            for (String s : p.getSymptoms()) {
                System.out.println(s);
            }
        }
        for (Patient p : regularPatients) {
            System.out.println(p.getID());
            for (String s : p.getSymptoms()) {
                System.out.println(s);
            }
        }
    }
}
