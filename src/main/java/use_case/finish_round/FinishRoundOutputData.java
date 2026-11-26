package use_case.finish_round;

public class FinishRoundOutputData {
    // username, points, current win streak,
    private final String username;
    private final int points;
    private final int currentStreak;

    public FinishRoundOutputData(String username, int points, int currentStreak){
        this.username = username;
        this.points = points;
        this.currentStreak = currentStreak;
    }

    public String getUsername() {return username;}

    public int getPoints() {return points;}

    public int getStreak() {return currentStreak;}

    // TODO: decide what needs to be displayed on finish round view
}
