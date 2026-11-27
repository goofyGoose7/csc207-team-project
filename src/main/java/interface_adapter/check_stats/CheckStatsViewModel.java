package interface_adapter.check_stats;

import java.util.ArrayList;
import java.util.List;

public class CheckStatsViewModel {
    public static final String VIEW_NAME = "Stats";

    public static final String DISTRIBUTION_LABEL = "Guess distribution";
    public static final String BACK_BUTTON_LABEL = "Back";

    private final List<CheckStatsViewModelListener> listeners = new ArrayList<>();

    private CheckStatsState state = new CheckStatsState();

    public CheckStatsState getState() {
        return this.state;
    }

    public void setState(CheckStatsState state) {
        this.state = state;
    }

    public void addListener(CheckStatsViewModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for (CheckStatsViewModelListener listener : listeners) {
            listener.stateChanged();
        }
    }
}
