package utm.endava.lesson2.Model;

import java.text.DecimalFormat;

public class Possession extends GameEvent {
    
    public Possession() {
        this.team = new Team();
        this.player = new Player();
        this.time = 0.0;
    }
    
    public Possession(Team team, Player player, double time) {
        this.team = team;
        this.player = player;
        this.time = time;
    }
    
    @Override
    public String toString() {
        return "Possession got after " +
                       new DecimalFormat("##.##").format(time) +
                       " mins by " +
                       player +
                       " of The " +
                       team.getName();
    }
}
