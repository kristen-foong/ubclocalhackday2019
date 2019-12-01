public class Symptom {
    int importance;
    String name;
    int timeElapsed;

    public Symptom(int importance, int timeElapsed, String name) {
        this.importance = importance;
        this.timeElapsed = timeElapsed;
        this.name = name;

    }

    public int getImportance() {
        return importance;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public String getName() {
        return name;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeElapsed(int timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}