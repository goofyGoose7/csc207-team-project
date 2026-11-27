package use_case.check_stats;

public class CheckStatsOutputData {
    private final String username;
    private final int points;
    private final int gamesPlayed;
    private final int winPercentage;
    private final int currentStreak;
    private final int longestStreak;
    private final int[] guessDistribution;

    public CheckStatsOutputData(String username, int points, int gamesPlayed, int winPercentage,
                                int currentStreak, int longestStreak, int[] guessDistribution) {
        this.username = username;
        this.points = points;
        this.gamesPlayed = gamesPlayed;
        this.winPercentage = winPercentage;
        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
        this.guessDistribution = guessDistribution;
    }

    public String getUsername() {
        return username;
    }

    public int getPoints() {
        return points;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getWinPercentage() {
        return winPercentage;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

    public int[] getGuessDistribution() {
        return guessDistribution;
    }
}
