package utm.endava.lesson2;

import java.util.ArrayList;

public class League {

    public ArrayList<Team> createTeams() {
        ArrayList<Team> teams = new ArrayList<>();
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

        teams.add(greens);
        teams.add(reds);
        return teams;
    }

    public ArrayList<Game> createGames(ArrayList<Team> teams) {
        ArrayList<Game> games = new ArrayList<>();
        Game game1 = new Game();
        game1.setHomeTeam(teams.get(0));
        game1.setAwayTeam(teams.get(1));
        games.add(game1);
        return games;
    }

}
