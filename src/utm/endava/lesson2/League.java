package utm.endava.lesson2;

import utm.endava.lesson2.utility.GameUtils;
import utm.endava.lesson2.utility.PlayerDatabase;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class League {
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Game> games = new ArrayList<>();
    private LocalDateTime gameDate;

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public ArrayList<Team> createTeams(int numberOfPlayers, ArrayList<String> teamNames) {
        try {
            teamNames.forEach(teamName -> teams.add(PlayerDatabase.getTeam(numberOfPlayers, teamName)));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There are not enough players to create another team, we are sorry");
            System.exit(0);
        }
        return teams;
    }

    public ArrayList<Game> createGames(ArrayList<Team> teams) {
        gameDate = LocalDateTime.now();

        teams.forEach(team -> IntStream.range(teams.indexOf(team) + 1, teams.size())
                .forEach(nextTeamIndex -> {
                    Game game1 = new Game(team, teams.get(nextTeamIndex));
                    game1.setGameDate(gameDate);
                    Game game2 = new Game(teams.get(nextTeamIndex), team);
                    game2.setGameDate(gameDate.plusDays(7));
                    gameDate = gameDate.plusDays(7);
                    games.add(game1);
                    games.add(game2);
                }));
        return games;
    }

    public void leagueConclusion() {
        showBestTeams();
    }

    private void showBestTeams() {
        Collections.sort(teams);
        teams.forEach(team -> System.out.println("Team " + team.getName() + "\n" + team.getTeamStatistics() + "\n"));
        System.out.print("This year's champions are: The " + teams.get(0).getName());
        for (Team team : teams) {
            if (team.equals(teams.get(0)) && !team.getName().equals(teams.get(0).getName())) {
                System.out.print(", The " + team.getName());
            } else {
                break;
            }
        }
    }

    public void getLeagueAnnouncement() {
        Period leagueDuration = Period.between(games.get(0).getGameDate().toLocalDate(),
                games.get(games.size() - 1).getGameDate().toLocalDate());

        leagueDuration = leagueDuration.normalized();

        System.out.println("The league is scheduled to run for "
                + leagueDuration.getMonths() +
                " month(s)" +
                " and " +
                leagueDuration.getDays() +
                " day(s).");
    }
}
