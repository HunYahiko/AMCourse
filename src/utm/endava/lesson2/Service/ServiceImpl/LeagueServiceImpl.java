package utm.endava.lesson2.Service.ServiceImpl;

import utm.endava.lesson2.Model.Game;
import utm.endava.lesson2.Model.League;
import utm.endava.lesson2.Service.LeagueService;
import utm.endava.lesson2.Model.Team;
import utm.endava.lesson2.utility.PlayerDatabase;
import utm.endava.lesson2.utility.PlayerDatabaseException;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class LeagueServiceImpl implements LeagueService {
    
    TeamServiceImpl teamService = new TeamServiceImpl();
    private GameServiceImpl gameService = new GameServiceImpl();
    
    @Override
    public ArrayList<Team> createTeams(int numberOfPlayers, ArrayList<String> teamNames, League league) throws PlayerDatabaseException {
        for (String teamName : teamNames) {
            league.getTeams()
                    .add(PlayerDatabase.getTeam(numberOfPlayers, teamName));
        }
        return league.getTeams();
    }
    
    @Override
    public ArrayList<Game> createGames(League league,ArrayList<Team> teams) {
        league.setGameDate(LocalDateTime.now());
        teams.forEach(team -> IntStream.range(teams.indexOf(team) + 1, teams.size())
                                      .forEach(nextTeamIndex -> {
                                          Game game1 = new Game(team, teams.get(nextTeamIndex));
                                          game1.setGameDate(league.getGameDate());
                                          Game game2 = new Game(teams.get(nextTeamIndex), team);
                                          league.setGameDate(league.getGameDate().plusDays(7));
                                          game2.setGameDate(league.getGameDate());
                                          league.setGameDate(league.getGameDate().plusDays(7));
                                          league.getGames().add(game1);
                                          league.getGames().add(game2);
                                      }));
        return league.getGames();
    }
    
    @Override
    public void getLeagueAnnouncement(League league) {
        Period leagueDuration = Period.between(league.getGames()
                                                       .get(0)
                                                       .getGameDate()
                                                       .toLocalDate(),
                league.getGames()
                        .get(league.getGames().size() - 1)
                        .getGameDate()
                        .toLocalDate());
    
        leagueDuration = leagueDuration.normalized();
    
        System.out.println("The league is scheduled to run for "
                                   + leagueDuration.getMonths() +
                                   " month(s)" +
                                   " and " +
                                   leagueDuration.getDays() +
                                   " day(s).");
    }
    
    @Override
    public void showBestTeams(League league) {
        Collections.sort(league.getTeams());
        league.getTeams().forEach(team -> System.out.println("Team "
                                                         + team.getName()
                                                         + "\n" + team.getTeamStatistics()
                                                         + "\n"));
        System.out.print("This year's champions are: The " + league.getTeams().get(0).getName());
        for (Team team : league.getTeams()) {
            if (teamService.hasSameStatistics(team, league.getTeams().get(0))
                        && !team.getName().equals(league.getTeams()
                                                          .get(0)
                                                          .getName())) {
                System.out.print(", The " + team.getName());
            } else {
                break;
            }
        }
    }
    
    @Override
    public void playAllGames(League league) {
        league.getGames().forEach(gameService::playGame);
    }
}
