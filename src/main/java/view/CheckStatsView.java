package view;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interface_adapter.check_stats.CheckStatsController;
import interface_adapter.check_stats.CheckStatsState;
import interface_adapter.check_stats.CheckStatsViewModel;
import interface_adapter.check_stats.CheckStatsViewModelListener;

public class CheckStatsView extends JPanel implements CheckStatsViewModelListener {
    private final CheckStatsViewModel checkStatsViewModel;
    private CheckStatsController checkStatsController;

    private final JLabel titleLabel = new JLabel();
    private final JLabel pointsLabel = new JLabel();
    private final JLabel gamesPlayedLabel = new JLabel();
    private final JLabel winPercentageLabel = new JLabel();
    private final JLabel currentStreakLabel = new JLabel();
    private final JLabel longestStreakLabel = new JLabel();
    private final JLabel[] distributionLabels = new JLabel[5];

    public CheckStatsView(CheckStatsViewModel checkStatsViewModel) {
        this.checkStatsViewModel = checkStatsViewModel;
        this.checkStatsViewModel.addListener(this);

        final JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);

        final JPanel numbersPanel = new JPanel(new GridLayout(0, 1));
        numbersPanel.add(pointsLabel);
        numbersPanel.add(gamesPlayedLabel);
        numbersPanel.add(winPercentageLabel);
        numbersPanel.add(currentStreakLabel);
        numbersPanel.add(longestStreakLabel);

        final JPanel distributionPanel = new JPanel(new GridLayout(0, 1));
        distributionPanel.add(new JLabel(CheckStatsViewModel.DISTRIBUTION_LABEL));
        for (int i = 0; i < distributionLabels.length; i++) {
            distributionLabels[i] = new JLabel();
            distributionPanel.add(distributionLabels[i]);
        }

        final JPanel buttonPanel = new JPanel();
        final JButton back = new JButton(CheckStatsViewModel.BACK_BUTTON_LABEL);
        buttonPanel.add(back);
        back.addActionListener(e -> checkStatsController.switchToWelcomeView());

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(titlePanel);
        add(numbersPanel);
        add(distributionPanel);
        add(buttonPanel);
    }

    @Override
    public void stateChanged() {
        final CheckStatsState state = checkStatsViewModel.getState();

        if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError());
            return;
        }

        titleLabel.setText(state.getTitle());
        pointsLabel.setText(state.getPoints());
        gamesPlayedLabel.setText(state.getGamesPlayed());
        winPercentageLabel.setText(state.getWinPercentage());
        currentStreakLabel.setText(state.getCurrentStreak());
        longestStreakLabel.setText(state.getLongestStreak());

        final String[] distribution = state.getGuessDistribution();
        for (int i = 0; i < distributionLabels.length; i++) {
            distributionLabels[i].setText(distribution[i]);
        }
    }

    public String getViewName() {
        return CheckStatsViewModel.VIEW_NAME;
    }

    public void setCheckStatsController(CheckStatsController checkStatsController) {
        this.checkStatsController = checkStatsController;
    }
}
