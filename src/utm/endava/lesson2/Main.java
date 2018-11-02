package utm.endava.lesson2;

import utm.endava.lesson2.utility.PlayerDatabaseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static ArrayList<String> teamNames = new ArrayList<>(Arrays.asList("Greens", "Reds", "Blues"));

    public static void main(String[] args) {
        try {
            League league = new League();
            List<Game> games = new ArrayList<>(league.createGames(league.createTeams(3, Main.teamNames)));
            league.getLeagueAnnouncement();
            for (Game game : games) {
                game.playGame();
            }
            league.leagueConclusion();
        } catch (PlayerDatabaseException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
