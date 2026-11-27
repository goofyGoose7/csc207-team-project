package interface_adapter.check_stats;

import use_case.check_stats.CheckStatsInputBoundary;
import use_case.check_stats.CheckStatsInputData;

public class CheckStatsController {
    private final CheckStatsInputBoundary checkStatsUseCaseInteractor;

    public CheckStatsController(CheckStatsInputBoundary checkStatsUseCaseInteractor) {
        this.checkStatsUseCaseInteractor = checkStatsUseCaseInteractor;
    }

    public void execute(String username) {
        final CheckStatsInputData checkStatsInputData = new CheckStatsInputData(username);
        checkStatsUseCaseInteractor.execute(checkStatsInputData);
    }

    public void switchToWelcomeView() {
        checkStatsUseCaseInteractor.switchToWelcomeView();
    }
}
