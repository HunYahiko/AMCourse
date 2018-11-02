package utm.endava.lesson2;

import utm.endava.lesson2.utility.GameUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private List<GameEvent> gameEvents = new ArrayList<>();
    private GameStatistics gameStatistics;
    private LocalDateTime gameDate;

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

    public List<GameEvent> getGameEvents() {
        return gameEvents;
    }

    public void setGameEvents(List<GameEvent> gameEvents) {
        this.gameEvents = gameEvents;
    }

    public LocalDateTime getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDateTime gameDate) {
        this.gameDate = gameDate;
    }

    public void playGame() {
        double gameTime = 0.0;
    
        /*Print HomeTeam vs AwayTeam*/
        declarePlayingTeams();
    
        /*Display Game Date*/
        declareGameDate();
        
        /*Generate random events*/
        GameEvent gameEvent;
        do {
            if (GameUtils.random.nextInt(2) != 0) {
                gameEvent = GameUtils.generateRandomEvent(this, gameTime);
                if (gameEvents.size() > 5 && gameEvent instanceof Goal
                            && !areNotGoals(gameEvents.subList(gameEvents.size() - 5, gameEvents.size()))) {
                    ++gameTime;
                } else {
                    gameEvents.add(gameEvent);
                    ++gameTime;
                }
            }
        } while (gameTime <= endGameTime);
        
        /*Print game events*/
        gameDescription();

        /*Print game statistics*/
        gameConclusion();
    }
    
    private boolean areNotGoals(List<GameEvent> lastFiveEvents) {
        for (GameEvent gameEvent : lastFiveEvents) {
            if (gameEvent instanceof Goal) {
                return false;
            }
        }
        return true;
    }

    private void declarePlayingTeams() {
        System.out.println(homeTeam.getName() + " vs " + awayTeam.getName() + "\n");
    }

    private void declareGameDate() { System.out.println("Date: " + gameDate.toLocalDate().toString()); }
    
    private void gameDescription() { gameEvents.forEach(System.out::println); }

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
        for (GameEvent goal : this.gameEvents) {
            goals.append(goal);
        }
        return goals.toString();
    }
    
}
