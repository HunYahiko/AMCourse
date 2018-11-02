package utm.endava.lesson2.Service;

import utm.endava.lesson2.Model.TeamStatistics;

public interface TeamStatisticsService {
    
    public void addPoints(TeamStatistics teamStatistics, int points);
    public void addGoals(TeamStatistics teamStatistics, int numberOfGoals);
}
