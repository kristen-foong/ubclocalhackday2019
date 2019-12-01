import java.util.ArrayList;
import java.util.List;

public class SymptomList {
    List<Symptom> symptoms;
    Symptom s;
    int total;

    public SymptomList(){
        symptoms = new ArrayList<>();
        total = 0;
    }

    public void addSymptom(Symptom s) {
        symptoms.add(s);
    }

    public void removeSymptom(Symptom s) {
        symptoms.remove(s);
    }

    public int sum(Symptom symptom){
        this.total = total + symptom.getImportance();
        return total;
    }

    public void getTotal(){
        for (Symptom s: symptoms) {
            sum(s);
        }
    }
}
