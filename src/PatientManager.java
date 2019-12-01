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
        numpatients = 0;
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
            for (Symptom s: p.getSymptoms()) {
                if (s.getName().equals("chest pain") || s.getName().equals("difficulty breathing") || s.getName().equals("abdominal pain")) {
                }
            }

            for (Symptom s: p.getSymptoms()) {
                if (s.getName().equals("chest pain") || s.getName().equals("difficulty breathing") || s.getName().equals("abdominal pain")
                        || (s.equals("fever") && p.getAge() < 12)) {
                    p.setPriority(true);
                    patients.remove(p);
                    priorityPatients.add(p);
                } else {
                    patients.remove(p);
                    regularPatients.add(p);
                }
            }
        }
    }

    public void sortPatients() {
        priorityPatients.sort(Comparator.comparing(Patient::getSeverity).reversed());
        regularPatients.sort(Comparator.comparing(Patient::getSeverity).reversed());
        patients.addAll(priorityPatients);
        patients.addAll(regularPatients);
    }
}
