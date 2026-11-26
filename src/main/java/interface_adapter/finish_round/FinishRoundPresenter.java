package interface_adapter.finish_round;

import use_case.finish_round.FinishRoundOutputBoundary;
import use_case.finish_round.FinishRoundOutputData;

public class FinishRoundPresenter implements FinishRoundOutputBoundary {
    private final FinishRoundViewModel finishRoundViewModel;

    public FinishRoundPresenter(FinishRoundViewModel finishRoundViewModel){
        this.finishRoundViewModel = finishRoundViewModel;
    }

    @Override
    public void prepareSuccessView(FinishRoundOutputData outputData) {
        // TODO: work out what View is going to display FIRST

        // TODO: reset State
    }
}
