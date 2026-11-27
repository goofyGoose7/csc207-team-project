package interface_adapter.check_stats;

import use_case.check_stats.CheckStatsOutputBoundary;
import interface_adapter.ViewManagerModel;
import interface_adapter.welcome_menu.WelcomeViewModel;
import use_case.check_stats.CheckStatsOutputData;

public class CheckStatsPresenter implements CheckStatsOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final CheckStatsViewModel checkStatsViewModel;

    public CheckStatsPresenter(ViewManagerModel viewManagerModel,
                               CheckStatsViewModel checkStatsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.checkStatsViewModel = checkStatsViewModel;
    }

    @Override
    public void prepareSuccessView(CheckStatsOutputData outputData) {
        final CheckStatsState state = checkStatsViewModel.getState();
        state.setTitle(outputData.getUsername() + "'s stats");
        state.setPoints("Total points: " + outputData.getPoints());
        state.setGamesPlayed("Games played: " + outputData.getGamesPlayed());
        state.setWinPercentage("Win %: " + outputData.getWinPercentage());
        state.setCurrentStreak("Current streak: " + outputData.getCurrentStreak());
        state.setLongestStreak("Longest streak: " + outputData.getLongestStreak());

        final int[] counts = outputData.getGuessDistribution();
        final String[] distribution = new String[counts.length];
        for (int i = 0; i < counts.length; i++) {
            distribution[i] = "Won on attempt " + (i + 1) + ": " + counts[i];
        }
        state.setGuessDistribution(distribution);
        state.setError(null);

        checkStatsViewModel.setState(state);
        checkStatsViewModel.notifyStateChanged();

        viewManagerModel.setState(CheckStatsViewModel.VIEW_NAME);
        viewManagerModel.notifyViewChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final CheckStatsState state = checkStatsViewModel.getState();
        state.setError(errorMessage);
        checkStatsViewModel.notifyStateChanged();
    }

    @Override
    public void switchToWelcomeView() {
        viewManagerModel.setState(WelcomeViewModel.VIEW_NAME);
        viewManagerModel.notifyViewChanged();
    }
}
