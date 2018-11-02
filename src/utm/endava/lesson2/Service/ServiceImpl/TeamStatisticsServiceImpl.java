package utm.endava.lesson2.Service.ServiceImpl;

import utm.endava.lesson2.Service.TeamStatisticsService;
import utm.endava.lesson2.Model.TeamStatistics;

public class TeamStatisticsServiceImpl implements TeamStatisticsService {
    
    @Override
    public void addPoints(TeamStatistics teamStatistics, int points) {
        teamStatistics.setPoints(teamStatistics.getPoints() + points);
    }
    
    @Override
    public void addGoals(TeamStatistics teamStatistics, int numberOfGoals) {
        teamStatistics.setNumberOfGoals(teamStatistics.getNumberOfGoals() + numberOfGoals);
    }
}
