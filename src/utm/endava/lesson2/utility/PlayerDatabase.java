package utm.endava.lesson2.utility;

import utm.endava.lesson2.Model.Player;
import utm.endava.lesson2.Model.Team;

import java.util.Arrays;
import java.util.HashMap;

public class PlayerDatabase {
    private static HashMap<String, Team> teams = new HashMap<>();
    private static HashMap<String, Player> players = new HashMap<>();

    static {
        players.put("Graham Green", new Player("Graham Green"));
        players.put("Joffrey Chaucer", new Player("Joffrey Chaucer"));
        players.put("George Elliot", new Player("George Elliot"));
        players.put("Robert Service", new Player("Robert Service"));
        players.put("Robbie Burns", new Player("Robbie Burns"));
        players.put("Rafael Sabatini",  new Player("Rafael Sabatini"));
        players.put("Bon Jovi", new Player("Bon Jovi"));
        players.put("Blueno Albione", new Player("Blueno Albione"));
        players.put("Bistro Nemesis", new Player("Bistro Nemesis"));
        
        teams.put("Greens", new Team("Greens", Arrays.asList(players.get("Graham Green"),
                                                                    players.get("Joffrey Chaucer"),
                                                                    players.get("George Elliot"))));
        
        teams.put("Reds", new Team("Reds", Arrays.asList(players.get("Robert Service"),
                                                                players.get("Robbie Burns"),
                                                                players.get("Rafael Sabatini"))));
        
        teams.put("Blues", new Team("Blues",  Arrays.asList(players.get("Bon Jovi"),
                                                                    players.get("Blueno Albione"),
                                                                    players.get("Bistro Nemesis"))));
    }
    
    public static Team getTeam(String teamName) throws PlayerDatabaseException {
        if (teams.get(teamName) == null) {
            throw new PlayerDatabaseException("This team: " + teamName + " does not exist in the database!");
        }
        return teams.get(teamName);
    }
    
}
