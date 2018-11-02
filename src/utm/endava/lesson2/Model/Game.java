package utm.endava.lesson2.Model;

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
    
    public GameStatistics getGameStatistics() {
        return gameStatistics;
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
