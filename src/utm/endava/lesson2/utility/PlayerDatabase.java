package utm.endava.lesson2.utility;

import utm.endava.lesson2.Player;
import utm.endava.lesson2.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class PlayerDatabase {
    private static final String player = "George Elliot," +
            "Graham Green," +
            "Joffrey Chaucer," +
            "Robert Service," +
            "Robbie Burns," +
            "Rafael Sabatini," +
            "Bon Jovi," +
            "Blueno Albione," +
            "Bistro Nemesis";

    private static List<String> players;
    private static int numberOfPlayers;
    private static int lastTakenPlayerIndex;

    static {
        players = new ArrayList<>(Arrays.asList(player.split(",")));
        numberOfPlayers = players.size();
        lastTakenPlayerIndex = 0;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public static List<String> getPlayers() {
        return players;
    }

    public static Team getTeam(int numberOfPlayers, String teamName) throws PlayerDatabaseException {
        try {
            Team newTeam = new Team(teamName);
            IntStream.range(lastTakenPlayerIndex, lastTakenPlayerIndex + numberOfPlayers)
                    .forEach(index -> newTeam.addPlayer(new Player(players.get(index))));
    
            lastTakenPlayerIndex += numberOfPlayers;
            return newTeam;
        } catch (IndexOutOfBoundsException e) {
            throw new PlayerDatabaseException();
        }
    }
}
