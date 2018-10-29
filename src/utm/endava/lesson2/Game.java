package utm.endava.lesson2;

import utm.endava.lesson2.utility.GameUtils;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private List<Goal> goals = new ArrayList<>();

    private static double endGameTime = 90.0;
    private static int defaultMaxGoals = 6;

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

    public void playGame(int maxGoals) {
        double randomTime = 0.0;

        /*Print teams*/
        System.out.println(awayTeam);
        System.out.println(homeTeam);

        /*Generate random goals*/
        while ((randomTime = GameUtils.generateRandomTime(randomTime, endGameTime + 0.01)) < endGameTime
                && goals.size() < maxGoals){
            goals.add(GameUtils.addGameGoals(this, randomTime));
        }

        /*Print game statistics*/
        System.out.println(this);
    }

    public void playGame() {
        double randomTime = 0.0;

        /*Print teams*/
        System.out.println(awayTeam);
        System.out.println(homeTeam);

        /*Generate random goals*/
        while (goals.size() < defaultMaxGoals) {
            randomTime = GameUtils.generateRandomTime(randomTime, endGameTime + 0.01);
            if (randomTime > endGameTime) {
                break;
            }
            goals.add(GameUtils.addGameGoals(this, randomTime));
        }

        /*Print game statistics*/
        System.out.println(this);
    }
}
