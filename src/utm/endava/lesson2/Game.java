package utm.endava.lesson2;

import utm.endava.lesson2.utility.GameUtils;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private List<Goal> goals = new ArrayList<>();
    private GameStatistics gameStatistics;

    private static double endGameTime = 90.0;
    private static int defaultMaxGoals = 6;
    private static int drawPoints = 1;
    private static int winnerPoints = 2;

    public Game(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.gameStatistics = new GameStatistics();
    }

    public Game() {
        this.awayTeam = new Team();
        this.homeTeam = new Team();
        this.gameStatistics = new GameStatistics();
    }

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

        /*Print HomeTeam vs AwayTeam*/
        declarePlayingTeams();

        /*Print teams comp*/
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

        /*Print game goals*/
        System.out.println(this);

        /*Print game statistics*/
        gameConclusion();
    }

    private void declarePlayingTeams() {
        System.out.println(homeTeam.getName() + " vs " + awayTeam.getName() + "\n");
    }

    private void gameConclusion() {
        gameStatistics.setWinner(this, homeTeam, awayTeam);
        addGoals();
        addPoints();
        printResults();
    }

    private void addGoals() {
        homeTeam.getTeamStatistics().addGoals(GameUtils.getTeamGoals(this, homeTeam));
        awayTeam.getTeamStatistics().addGoals(GameUtils.getTeamGoals(this, awayTeam));
    }

    private void addPoints() {
        if (gameStatistics.isDraw()) {
            homeTeam.getTeamStatistics().addPoints(drawPoints);
            awayTeam.getTeamStatistics().addPoints(drawPoints);
        } else {
            gameStatistics.getWinnerTeam().getTeamStatistics().addPoints(winnerPoints);
        }
    }

    private void printResults() {
        if (gameStatistics.isDraw()) {
            System.out.println("It is a draw\n");
        } else {
            System.out.println("Team " + gameStatistics.getWinnerTeam().getName() + " won!" +
                    "(" + gameStatistics.getHomeTeamGoals() + " - " + gameStatistics.getAwayTeamGoals() + ")\n");
        }
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
