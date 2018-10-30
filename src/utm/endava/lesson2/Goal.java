package utm.endava.lesson2;

import java.text.DecimalFormat;

public class Goal {
    private Team team;
    private Player player;
    private double time;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Goal scored after " +
                new DecimalFormat("##.##").format(time) +
                " mins by " +
                player +
                " of The " +
                team.getName() +
                "\n";
    }
}
