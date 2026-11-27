package use_case.check_stats;

public interface CheckStatsInputBoundary {
    void execute(CheckStatsInputData inputData);
    void switchToWelcomeView();
}
