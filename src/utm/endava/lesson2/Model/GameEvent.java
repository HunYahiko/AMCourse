package utm.endava.lesson2.Model;

public abstract class GameEvent {
    protected Team team;
    protected Player player;
    protected double time;
    
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
}
