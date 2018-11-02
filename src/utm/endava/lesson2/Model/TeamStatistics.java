package utm.endava.lesson2.Model;

public class TeamStatistics {
    private int numberOfGoals;
    private int points;

    public int getNumberOfGoals() {
        return numberOfGoals;
    }

    public void setNumberOfGoals(int numberOfGoals) {
        this.numberOfGoals = numberOfGoals;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Goals: "
                + numberOfGoals
                + "\n"
                + "Points: "
                + points;
    }
}
