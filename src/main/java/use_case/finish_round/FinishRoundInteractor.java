package use_case.finish_round;


import entity.Round;

public class FinishRoundInteractor implements FinishRoundInputBoundary{
    private final FinishRoundOutputBoundary presenter;
    private final FinishRoundDataAccessInterface dataAccess;

    public FinishRoundInteractor(FinishRoundDataAccessInterface dataAccess,
                                 FinishRoundOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(FinishRoundInputData inputData) {
        Round round = inputData.getRound();

        // TODO: calculate points using NormalScoring entity

        // TODO: update Player entity

        // TODO: save results -> DAO

        // TODO: output data -> presenter
    }
}
