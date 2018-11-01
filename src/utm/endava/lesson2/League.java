package utm.endava.lesson2;

import utm.endava.lesson2.utility.GameUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class League {
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Game> games = new ArrayList<>();

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

    public ArrayList<Team> createTeams() {
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

    public void leagueConclusion() {
        printResults();
        declareWinner();
    }

    private void printResults() {
        teams.forEach(team -> System.out.println("Team " + team.getName() + "\n" + team.getTeamStatistics() + "\n"));
    }

    private void declareWinner() {
        ArrayList<Team> leagueWinnerTeam = GameUtils.getLeagueWinner(teams);

        if (leagueWinnerTeam.size() > 1) {
            System.out.print("This year's champions are: ");
            leagueWinnerTeam.forEach(team -> System.out.println("The " + team.getName()));
        } else {
            System.out.println("This year's champions are: The " + leagueWinnerTeam.get(0).getName());
        }
    }



}
