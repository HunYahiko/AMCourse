package utm.endava.lesson2;

import utm.endava.lesson2.utility.GameUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        League league = new League();
        List<Game> games = new ArrayList<>(league.createGames(league.createTeams()));
        for (Game game : games) {
            game.playGame();
        }
        league.leagueConclusion();
    }
}
