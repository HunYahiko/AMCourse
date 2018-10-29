package utm.endava.lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class League {
    private static double endGameTime = 90.0;
    public static void main(String[] args) {

        Team greens = new Team("Greens");
        Team reds = new Team("Reds");

        Player georgeElliot = new Player("George Elliot");
        Player grahamGreen = new Player("Graham Green");
        Player joffreyChaucer = new Player("Joffrey Chaucer");

        Player robertService = new Player("Robert Service");
        Player robbieBurns = new Player("Robbie Burns");
        Player rafaelSabatini = new Player("Rafael Sabatini");

        greens.addPlayer(georgeElliot);
        greens.addPlayer(grahamGreen);
        greens.addPlayer(joffreyChaucer);

        reds.addPlayer(robbieBurns);
        reds.addPlayer(robertService);
        reds.addPlayer(rafaelSabatini);

        System.out.println(greens);
        System.out.println(reds);

        Game game1 = new Game();
        game1.setHomeTeam(reds);
        game1.setAwayTeam(greens);

        double randomTime = 0.0;

        while ((randomTime = generateRandomTime(randomTime, endGameTime + 1.0)) < endGameTime){
            Goal goal = new Goal();
            goal.setTeam(generateRandomTeam(new ArrayList<>(Arrays.asList(greens, reds))));
            goal.setPlayer(generateRandomPlayer(goal.getTeam()));
            goal.setTime(randomTime);
            game1.addGoal(goal);
        }

        System.out.println(game1.toString());

        Arrays.asList(greens, reds).forEach(team -> team.getPlayers().forEach(Player::splitFirstAndLastName));

        Arrays.asList(greens, reds).forEach(team ->
                team.getPlayers().forEach(player -> System.out.println(player.printName())));
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

    
}
