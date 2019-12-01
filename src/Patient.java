import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Patient {
    int ID;
    boolean priority;
    String sex;
    int age;
    int severity = 0;
    boolean medication;
    ArrayList<String> symptoms;
    String waittime;
    long starttime;

    int chestPain = 10;
    int difficultBreathing = 8;
    int abPain = 8;
    int fever = 4;
    int cough = 3;
    int smallInjury = 2;

    public Patient(String sex, int age, boolean medication) {
        this.sex = sex;
        this.age = age;
        this.priority = false;
        this.medication = medication;
        symptoms = new ArrayList<>();
        setSeverity();
    }

    public void addSymptom(String s) {
        symptoms.add(s);
    }

    public int getID() {return this.ID; }

    public String getSex() {return this.sex; }

    public Boolean getPriority() {return this.priority; }

    public int getAge() {return this.age; }

    public boolean getMedication() { return this.medication;}

    public int getSeverity() {
        return this.severity;
    }

    public ArrayList<String> getSymptoms() {
        return this.symptoms;
    }

    public void setID(int id) {this.ID = id; }

    public void setSex(String s) {this.sex = s; }

    public void setAge(int a) {this.age = a; }

    public void setPriority(boolean prio) {this.priority = prio; }

    public void setMedication(boolean medication) {
        this.medication = medication;
    }

    public void setSeverity() {
        for (String s : symptoms) {
            if (s.equals("chest pain")) {
                severity = severity + chestPain;
            } else if (s.equals("difficulty breathing")) {
                severity = severity + difficultBreathing;
            } else if (s.equals("abdominal pain")) {
                severity = severity + abPain;
            } else if (s.equals("fever")) {
                severity = severity + fever;
            } else if (s.equals("cough")) {
                severity = severity + cough;
            } else if (s.equals("small external injuries")) {
                severity = severity + smallInjury;
            } else {
                severity = severity + 2;
            }
        }
    }

    public String getWaitTime() {
        long calcWait = System.currentTimeMillis() - starttime;
        long secondLength = 1000;
        long minuteLength = 60000;
        long hourLength = 3600000;
        String output = "";
        if (TimeUnit.MILLISECONDS.toHours(calcWait) / hourLength >= 1) {
            int numHours = (int) TimeUnit.MILLISECONDS.toHours(calcWait);
            calcWait -= numHours*hourLength;
            output += numHours + ":";
        } else {
            output += "00:";
        }
        if (TimeUnit.MILLISECONDS.toMinutes(calcWait) / minuteLength >= 1) {
            int numMinutes = (int) TimeUnit.MILLISECONDS.toMinutes(calcWait);
            calcWait -= numMinutes*minuteLength;
            output += numMinutes + ":";
        } else {
            output += "00:";
        }
        if (TimeUnit.MILLISECONDS.toSeconds(calcWait) / secondLength >= 1) {
            int numSeconds = (int) TimeUnit.MILLISECONDS.toSeconds(calcWait);
            calcWait -= numSeconds*secondLength;
            output += numSeconds;
        }
        return output;
    }
}
