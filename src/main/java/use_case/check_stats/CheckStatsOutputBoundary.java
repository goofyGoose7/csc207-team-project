package use_case.check_stats;

public interface CheckStatsOutputBoundary {
    void prepareSuccessView(CheckStatsOutputData outputData);
    void prepareFailView(String errorMessage);
    void switchToWelcomeView();
}
