package utm.endava.lesson2.Service.ServiceImpl;

import utm.endava.lesson2.Model.Game;
import utm.endava.lesson2.Service.GameStatisticsService;
import utm.endava.lesson2.utility.GameUtils;

public class GameStatisticsServiceImpl implements GameStatisticsService {
    
    @Override
    public void setStatistics(Game game) {
        game.getGameStatistics()
                .setHomeTeamGoals(GameUtils.getTeamGoals(game, game.getHomeTeam()));
        game.getGameStatistics()
                .setAwayTeamGoals(GameUtils.getTeamGoals(game, game.getAwayTeam()));
    
        if (game.getGameStatistics().getHomeTeamGoals() == game.getGameStatistics().getAwayTeamGoals()) {
            game.getGameStatistics().setDraw(true);
        } else {
            game.getGameStatistics()
                    .setWinnerTeam((
                    game.getGameStatistics()
                            .getHomeTeamGoals() > game.getGameStatistics()
                                                          .getAwayTeamGoals()) ? game.getHomeTeam() : game.getAwayTeam());
        }
    }
}
