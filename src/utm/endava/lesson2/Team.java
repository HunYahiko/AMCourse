package utm.endava.lesson2;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private TeamStatistics teamStatistics;
    private List<Player> players = new ArrayList<>();

    public Team() {
        this.name = "";
        this.teamStatistics = new TeamStatistics();
    }

    public Team(String name) {
        this.name = name;
        this.teamStatistics = new TeamStatistics();
    }

    public Team(String name, ArrayList<Player> players) {
        this.name = name;
        this.players = players;
        this.teamStatistics = new TeamStatistics();
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

    public TeamStatistics getTeamStatistics() {
        return teamStatistics;
    }

    public void setTeamStatistics(TeamStatistics teamStatistics) {
        this.teamStatistics = teamStatistics;
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
