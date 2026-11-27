package use_case.check_stats;

import entity.Player;

public class CheckStatsInteractor implements CheckStatsInputBoundary {
    private final CheckStatsDataAccessInterface dataAccess;
    private final CheckStatsOutputBoundary presenter;

    public CheckStatsInteractor(CheckStatsDataAccessInterface dataAccess,
                                CheckStatsOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(CheckStatsInputData inputData) {
        final Player player = dataAccess.get(inputData.getUsername());
        if (player == null) {
            presenter.prepareFailView("Stats could not be loaded");
            return;
        }

        int winPercentage = 0;
        if (player.getGamesPlayed() > 0) {
            winPercentage = player.getWins() * 100 / player.getGamesPlayed();
        }

        final CheckStatsOutputData outputData = new CheckStatsOutputData(
                player.getName(),
                player.getPoints(),
                player.getGamesPlayed(),
                winPercentage,
                player.getCurrentStreak(),
                player.getLongestStreak(),
                player.getGuessDistribution());
        presenter.prepareSuccessView(outputData);
    }

    @Override
    public void switchToWelcomeView() {
        presenter.switchToWelcomeView();
    }
}
