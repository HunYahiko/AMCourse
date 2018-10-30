package utm.endava.lesson2;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players = new ArrayList<>();

    public Team() {
        this.name = null;
    }

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, ArrayList<Player> players) {
        this.name = name;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder(name);
        toString.append("\n");
        for (Player player : players) {
            toString.append(player + "\n");
        }
        return toString.toString();
    }
}
