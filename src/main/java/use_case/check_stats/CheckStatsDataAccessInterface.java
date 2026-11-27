package use_case.check_stats;

import entity.Player;

public interface CheckStatsDataAccessInterface {
    Player get(String username);
}
