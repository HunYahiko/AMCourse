package utm.endava.lesson2.utility;

import utm.endava.lesson2.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class GameUtils {

    public static Goal addGameGoals(Game game, double randomTime) {
        Goal goal = new Goal();

        goal.setTeam(GameUtils.generateRandomTeam(
                new ArrayList<>(Arrays.asList(game.getHomeTeam(), game.getAwayTeam()))));
        goal.setPlayer(GameUtils.generateRandomPlayer(goal.getTeam()));
        goal.setTime(randomTime);



        return goal;
    }

    public static double generateRandomTime(double start, double end) {
        return ThreadLocalRandom.current().nextDouble(start, end);
    }

    public static Team generateRandomTeam(ArrayList<Team> teams) {
        Random random = new Random();
        return teams.get(random.nextInt(teams.size()));
    }

    public static Player generateRandomPlayer(Team team) {
        Random random = new Random();
        return team.getPlayers().get(random.nextInt(team.getPlayers().size()));
    }

    public static void searchPlayer(String criteria, ArrayList<Team> teams) {
        teams.forEach(team -> team.getPlayers().forEach(player -> {
            if (hasCriteria(criteria, player)) {
                System.out.println("Found " + player.getName());
            }
        }));
    }

    public static boolean hasCriteria(String criteria, Player player) {
        return player.getLastName().contains(criteria);
    }

    public static void printTeamMembers(ArrayList<Team> teams) {
        teams.forEach(team -> team.getPlayers().forEach(Player::splitFirstAndLastName));
        teams.forEach(team -> team.getPlayers().forEach(player -> System.out.println(player.printName())));
    }

    public static int getTeamGoals(Game game, Team team) {
        Long goalCounter = game.getGoals().stream().filter(goal -> goal.getTeam().equals(team)).count();
        return goalCounter.intValue();
    }

    public static GameStatistics getWinnerTeam(Team homeTeam, Team awayTeam, int homeTeamGoals, int awayTeamGoals) {
        GameStatistics gameStatistics = new GameStatistics();
        if (homeTeamGoals == awayTeamGoals) {
            gameStatistics.setDraw(true);
            return gameStatistics;
        }

        gameStatistics.setWinnerTeam(homeTeamGoals > awayTeamGoals ? homeTeam : awayTeam);
        return gameStatistics;
    }

    public static ArrayList<Team> getLeagueWinner(ArrayList<Team> teams) {
        ArrayList<Team> winnerTeams = new ArrayList<>();

        winnerTeams.add(teams
                .stream()
                .max(Comparator.comparing(team -> team.getTeamStatistics().getPoints())).get());

        ArrayList<Team> finalWinnerTeams = winnerTeams;
        teams.stream()
                .filter(team -> team
                        .getTeamStatistics()
                        .getPoints() == finalWinnerTeams
                        .get(0)
                        .getTeamStatistics()
                        .getPoints())
                .forEach(winnerTeams::add);

        winnerTeams = finalWinnerTeams.stream().distinct().collect(Collectors.toCollection(ArrayList::new));

        winnerTeams.forEach(team -> System.out.println(team.getName()));

        if (winnerTeams.size() > 1) {
            winnerTeams = compareByGoals(winnerTeams);
        }

        return winnerTeams;
    }

    private static ArrayList<Team> compareByGoals(ArrayList<Team> teams) {
        ArrayList<Team> winnerTeams = new ArrayList<>();

        winnerTeams.add(teams
                .stream()
                .max(Comparator.comparing(team -> team.getTeamStatistics().getNumberOfGoals())).get());

        ArrayList<Team> finalWinnerTeams = winnerTeams;

        teams.stream()
                .filter(team -> team
                        .getTeamStatistics()
                        .getNumberOfGoals() == finalWinnerTeams
                        .get(0)
                        .getTeamStatistics()
                        .getNumberOfGoals())
                .forEach(winnerTeams::add);

        winnerTeams.forEach(team -> System.out.println(team.getName()));

        winnerTeams = finalWinnerTeams.stream().distinct().collect(Collectors.toCollection(ArrayList::new));

        winnerTeams.forEach(team -> System.out.println(team.getName()));

        return winnerTeams;
    }
}
