package utm.endava.lesson2.Service.ServiceImpl;

import utm.endava.lesson2.Model.Game;
import utm.endava.lesson2.Model.GameEvent;
import utm.endava.lesson2.Model.Goal;
import utm.endava.lesson2.Service.GameService;
import utm.endava.lesson2.utility.GameUtils;

import java.util.List;

public class GameServiceImpl implements GameService {
    
    private static double endGameTime = 90.0;
    private static int defaultMaxGoals = 6;
    private static int drawPoints = 1;
    private static int winnerPoints = 2;
    
    private GameStatisticsServiceImpl gameStatisticsService = new GameStatisticsServiceImpl();
    private TeamStatisticsServiceImpl teamStatisticsService = new TeamStatisticsServiceImpl();
    
    @Override
    public void playGame(Game game) {
        double gameTime = 0.0;
    
        /*Print HomeTeam vs AwayTeam*/
        declarePlayingTeams(game);
    
        /*Display Game Date*/
        declareGameDate(game);
    
        /*Generate random events*/
        GameEvent gameEvent;
        do {
            if (GameUtils.random.nextInt(2) != 0) {
                gameEvent = GameUtils.generateRandomEvent(game, gameTime);
                if (game.getGameEvents().size() > 5 && gameEvent instanceof Goal
                            && !areNotGoals(game.getGameEvents()
                                                    .subList(game.getGameEvents().size() - 5,
                                                            game.getGameEvents().size()))) {
                    ++gameTime;
                } else {
                    game.getGameEvents().add(gameEvent);
                    ++gameTime;
                }
            }
        } while (gameTime <= endGameTime);
    
        /*Print game events*/
        gameDescription(game);
    
        /*Print game statistics*/
        gameConclusion(game);
    }
    
    private boolean areNotGoals(List<GameEvent> lastFiveEvents) {
        for (GameEvent gameEvent : lastFiveEvents) {
            if (gameEvent instanceof Goal) {
                return false;
            }
        }
        return true;
    }
    
    private void declarePlayingTeams(Game game) {
        System.out.println(game.getHomeTeam().getName() + " vs " + game.getAwayTeam().getName() + "\n");
    }
    
    private void declareGameDate(Game game) { System.out.println("Date: " +
                                                                         game.getGameDate().toLocalDate().toString()); }
    
    private void gameDescription(Game game) { game.getGameEvents().forEach(System.out::println); }
    
    private void gameConclusion(Game game) {
        gameStatisticsService.setStatistics(game);
        addGoals(game);
        addPoints(game);
        printResults(game);
    }
    
    private void addGoals(Game game) {
        teamStatisticsService.addGoals(
                game.getHomeTeam().getTeamStatistics(),
                GameUtils.getTeamGoals(game, game.getHomeTeam()));
        teamStatisticsService.addGoals(
                game.getAwayTeam().getTeamStatistics(),
                GameUtils.getTeamGoals(game, game.getAwayTeam()));
    }
    
    private void addPoints(Game game) {
        if (game.getGameStatistics().isDraw()) {
            teamStatisticsService.addPoints(game.getHomeTeam()
                                                    .getTeamStatistics(), drawPoints);
            
            teamStatisticsService.addPoints(game.getAwayTeam()
                                                    .getTeamStatistics(), drawPoints);
        } else {
            teamStatisticsService.addPoints(game.getGameStatistics()
                                                    .getWinnerTeam()
                                                    .getTeamStatistics(), winnerPoints);
        }
    }
    
    private void printResults(Game game) {
        if (game.getGameStatistics().isDraw()) {
            System.out.println("It is a draw\n");
        } else {
            System.out.println("Team " +
                                       game.getGameStatistics().getWinnerTeam().getName()
                                       + " won!" +
                                       "(" +
                                       game.getGameStatistics().getHomeTeamGoals() +
                                       " - "
                                       + game.getGameStatistics().getAwayTeamGoals() + ")\n");
        }
    }
}
