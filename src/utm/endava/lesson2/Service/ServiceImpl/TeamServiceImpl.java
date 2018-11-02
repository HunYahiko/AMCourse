package utm.endava.lesson2.Service.ServiceImpl;

import utm.endava.lesson2.Model.Player;
import utm.endava.lesson2.Service.TeamService;
import utm.endava.lesson2.Model.Team;

public class TeamServiceImpl implements TeamService {
    
    @Override
    public boolean addPlayer(Team team, Player player) {
        return team.getPlayers().add(player);
    }
    
    @Override
    public boolean hasSameStatistics(Team team1, Team team2) {
        assert(team1 != null);
        assert(team2 != null);
        
        if (team1.getTeamStatistics().getNumberOfGoals() != team2.getTeamStatistics().getNumberOfGoals()) {
            return false;
        }
        
        if (team1.getTeamStatistics().getPoints() != team2.getTeamStatistics().getPoints()) {
            return false;
        }
        
        return true;
    }
}
