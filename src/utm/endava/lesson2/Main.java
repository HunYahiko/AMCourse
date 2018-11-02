package utm.endava.lesson2;

import utm.endava.lesson2.Service.ServiceImpl.LeagueServiceImpl;
import utm.endava.lesson2.utility.PlayerDatabaseException;
import utm.endava.lesson2.Model.League;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static ArrayList<String> teamNames = new ArrayList<>(Arrays.asList("Greens", "Reds", "Blues"));

    public static void main(String[] args) {
        LeagueServiceImpl leagueService = new LeagueServiceImpl();
        try {
            League league = new League();
            leagueService.createGames(league, leagueService.createTeams(3, teamNames, league));
            leagueService.getLeagueAnnouncement(league);
            leagueService.playAllGames(league);
            leagueService.showBestTeams(league);
        } catch (PlayerDatabaseException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
