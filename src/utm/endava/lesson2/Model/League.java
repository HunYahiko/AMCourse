package utm.endava.lesson2.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class League {
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Game> games = new ArrayList<>();
    private LocalDateTime gameDate;

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
    
    public LocalDateTime getGameDate() {
        return gameDate;
    }
    
    public void setGameDate(LocalDateTime gameDate) {
        this.gameDate = gameDate;
    }
    
}
