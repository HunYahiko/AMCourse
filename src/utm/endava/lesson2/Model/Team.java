package utm.endava.lesson2.Model;

import java.util.ArrayList;
import java.util.List;

public class Team implements Comparable<Team> {
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

    public Team(String name, List<Player> players) {
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
            toString.append(player).append("\n");
        }
        return toString.toString();
    }
    
    @Override
    public int compareTo(Team team) {
        if (this.teamStatistics.getPoints() > team.getTeamStatistics().getPoints()) {
            return -1;
        } else if (this.teamStatistics.getPoints() < team.getTeamStatistics().getPoints()) {
            return 1;
        } else {
            return compareByGoals(this, team);
        }
    }
    
    private int compareByGoals(Team team1, Team team2) {
        return Integer.compare(team2.getTeamStatistics().getNumberOfGoals(), team1.getTeamStatistics().getNumberOfGoals());
    }
    
}
