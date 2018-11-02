package utm.endava.lesson2.Service;

import utm.endava.lesson2.Model.Player;
import utm.endava.lesson2.Model.Team;

public interface TeamService {
    
    public boolean addPlayer(Team team, Player player);
    public boolean hasSameStatistics(Team team1, Team team2);
}
