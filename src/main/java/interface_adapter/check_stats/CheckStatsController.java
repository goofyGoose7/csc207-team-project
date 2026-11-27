package interface_adapter.check_stats;

import use_case.check_stats.CheckStatsInputBoundary;
import use_case.check_stats.CheckStatsInputData;

public class CheckStatsController {
    private final CheckStatsInputBoundary checkStatsUseCaseInteractor;

    public CheckStatsController(CheckStatsInputBoundary checkStatsUseCaseInteractor) {
        this.checkStatsUseCaseInteractor = checkStatsUseCaseInteractor;
    }

    /**
     * Executes the Check Stats use case.
     * @param username the player whose stats to show
     */
    public void execute(String username) {
        final CheckStatsInputData checkStatsInputData = new CheckStatsInputData(username);
        checkStatsUseCaseInteractor.execute(checkStatsInputData);
    }

    /**
     * Goes back to the welcome view.
     */
    public void switchToWelcomeView() {
        checkStatsUseCaseInteractor.switchToWelcomeView();
    }
}
