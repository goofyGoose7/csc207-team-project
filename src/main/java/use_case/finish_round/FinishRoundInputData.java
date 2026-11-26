package use_case.finish_round;

import entity.Player;
import entity.Round;

public class FinishRoundInputData {
    private final Player player;
    private final Round round;

    public FinishRoundInputData(Player player, Round round){
        this.player = player;
        this.round = round;
    }

    public Player getPlayer() {return player; }

    public Round getRound() { return round;}
}
