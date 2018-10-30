package utm.endava.lesson2;

import utm.endava.lesson2.utility.GameUtils;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class League {

    public ArrayList<Team> createTeams() {
        ArrayList<Team> teams = new ArrayList<>();
        Team greens = new Team("Greens");
        Team reds = new Team("Reds");
        Team blues = new Team("Blues");

        Player georgeElliot = new Player("George Elliot");
        Player grahamGreen = new Player("Graham Green");
        Player joffreyChaucer = new Player("Joffrey Chaucer");

        Player robertService = new Player("Robert Service");
        Player robbieBurns = new Player("Robbie Burns");
        Player rafaelSabatini = new Player("Rafael Sabatini");

        Player bonJovi = new Player("Bon Jovi");
        Player bluenoAlbione = new Player("Blueno Albione");
        Player bistroNemesis = new Player("Bistro Nemesis");

        greens.addPlayer(georgeElliot);
        greens.addPlayer(grahamGreen);
        greens.addPlayer(joffreyChaucer);

        reds.addPlayer(robbieBurns);
        reds.addPlayer(robertService);
        reds.addPlayer(rafaelSabatini);

        blues.addPlayer(bonJovi);
        blues.addPlayer(bluenoAlbione);
        blues.addPlayer(bistroNemesis);

        teams.add(greens);
        teams.add(reds);
        teams.add(blues);
        return teams;
    }

    public ArrayList<Game> createGames(ArrayList<Team> teams) {
        ArrayList<Game> games = new ArrayList<>();

        IntStream.range(0, 4)
                .forEach(team -> {
                    Team awayTeam;
                    Game game1 = new Game();
                    game1.setHomeTeam(GameUtils.generateRandomTeam(teams));
                    while((awayTeam = GameUtils.generateRandomTeam(teams)) == game1.getHomeTeam());
                    game1.setAwayTeam(awayTeam);
                    games.add(game1);
                });
        return games;
    }

}
