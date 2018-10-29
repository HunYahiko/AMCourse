package utm.endava.lesson2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private List<Goal> goals = new ArrayList<>();

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    @Override
    public String toString() {
        StringBuilder goals = new StringBuilder("Goals:\n");
        for (Goal goal : this.goals) {
            goals.append(goal);
        }
        return goals.toString();
    }
}
