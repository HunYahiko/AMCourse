package utm.endava.lesson2;

import utm.endava.lesson2.utility.GameUtils;

public class GameStatistics {
    private Team winnerTeam;
    private boolean isDraw;
    private int homeTeamGoals;
    private int awayTeamGoals;

    public GameStatistics() {
        winnerTeam = new Team();
        isDraw = false;
    }

    public GameStatistics(Team winnerTeam, boolean isDraw) {
        this.winnerTeam = winnerTeam;
        this.isDraw = isDraw;
    }

    public GameStatistics(boolean isDraw) {
        this.isDraw = isDraw;
        this.winnerTeam = new Team();
    }

    public Team getWinnerTeam() {
        return winnerTeam;
    }

    public void setWinnerTeam(Team winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

    public boolean isDraw() {
        return isDraw;
    }

    public void setDraw(boolean draw) {
        isDraw = draw;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    public void setWinner(Game game, Team homeTeam, Team awayTeam) {
        homeTeamGoals = GameUtils.getTeamGoals(game, homeTeam);
        awayTeamGoals = GameUtils.getTeamGoals(game, awayTeam);

        if (homeTeamGoals == awayTeamGoals) {
            isDraw = true;
        } else {
            winnerTeam = homeTeamGoals > awayTeamGoals ? homeTeam : awayTeam;
        }
    }
}
