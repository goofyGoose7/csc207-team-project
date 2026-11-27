package interface_adapter.check_stats;

public class CheckStatsState {
    private String title = "";
    private String points = "";
    private String gamesPlayed = "";
    private String winPercentage = "";
    private String currentStreak = "";
    private String longestStreak = "";
    private String[] guessDistribution = {"", "", "", "", ""};
    private String error;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(String gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(String winPercentage) {
        this.winPercentage = winPercentage;
    }

    public String getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(String currentStreak) {
        this.currentStreak = currentStreak;
    }

    public String getLongestStreak() {
        return longestStreak;
    }

    public void setLongestStreak(String longestStreak) {
        this.longestStreak = longestStreak;
    }

    public String[] getGuessDistribution() {
        return guessDistribution;
    }

    public void setGuessDistribution(String[] guessDistribution) {
        this.guessDistribution = guessDistribution;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
