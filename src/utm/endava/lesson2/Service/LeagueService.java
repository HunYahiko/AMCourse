package utm.endava.lesson2.Service;

import utm.endava.lesson2.Model.Game;
import utm.endava.lesson2.Model.League;
import utm.endava.lesson2.Model.Team;
import utm.endava.lesson2.utility.PlayerDatabaseException;

import java.util.ArrayList;

public interface LeagueService {
    
    public ArrayList<Team> createTeams(int numberOfPlayers,
                                       ArrayList<String> teamNames,
                                       League league) throws PlayerDatabaseException;
    
    public ArrayList<Game> createGames(League league, ArrayList<Team> teams);
    
    public void getLeagueAnnouncement(League league);
    
    public void showBestTeams(League league);
    
    public void playAllGames(League league);
}
