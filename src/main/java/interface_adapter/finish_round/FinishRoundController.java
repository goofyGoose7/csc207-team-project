package interface_adapter.finish_round;

import entity.Player;
import entity.Round;
import use_case.finish_round.FinishRoundInputBoundary;
import use_case.finish_round.FinishRoundInputData;

public class FinishRoundController {
    private final FinishRoundInputBoundary finishRoundUseCaseInteractor;

    public FinishRoundController(FinishRoundInputBoundary finishRoundUseCaseInteractor){
        this.finishRoundUseCaseInteractor = finishRoundUseCaseInteractor;
    }

    // TODO: check if this is right - what parameters?
    public void execute(Player player, Round round){
        final FinishRoundInputData finishRoundInputData = new FinishRoundInputData(player, round);
        finishRoundUseCaseInteractor.execute(finishRoundInputData);
    }
}
