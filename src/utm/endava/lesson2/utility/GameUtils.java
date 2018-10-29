package utm.endava.lesson2.utility;

import utm.endava.lesson2.Game;
import utm.endava.lesson2.Goal;
import utm.endava.lesson2.Player;
import utm.endava.lesson2.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
}
