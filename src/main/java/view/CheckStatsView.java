package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import interface_adapter.check_stats.CheckStatsController;
import interface_adapter.check_stats.CheckStatsState;
import interface_adapter.check_stats.CheckStatsViewModel;
import interface_adapter.check_stats.CheckStatsViewModelListener;

public class CheckStatsView extends JPanel implements CheckStatsViewModelListener {
    private final CheckStatsViewModel checkStatsViewModel;
    private CheckStatsController checkStatsController;

    private final JLabel titleLabel = new JLabel("", SwingConstants.CENTER);
    private final JLabel pointsLabel = new JLabel("", SwingConstants.CENTER);
    private final JLabel gamesPlayedLabel = new JLabel("", SwingConstants.CENTER);
    private final JLabel winPercentageLabel = new JLabel("", SwingConstants.CENTER);
    private final JLabel currentStreakLabel = new JLabel("", SwingConstants.CENTER);
    private final JLabel longestStreakLabel = new JLabel("", SwingConstants.CENTER);
    private final DistributionBar[] distributionBars = new DistributionBar[5];

    public CheckStatsView(CheckStatsViewModel checkStatsViewModel) {
        this.checkStatsViewModel = checkStatsViewModel;
        this.checkStatsViewModel.addListener(this);

        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, titleLabel.getFont().getSize2D() + 2f));
        final JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);

        final JPanel numbersPanel = new JPanel(new GridLayout(0, 1));
        numbersPanel.add(pointsLabel);
        numbersPanel.add(gamesPlayedLabel);
        numbersPanel.add(winPercentageLabel);
        numbersPanel.add(currentStreakLabel);
        numbersPanel.add(longestStreakLabel);

        final JPanel distributionPanel = new JPanel(new GridLayout(0, 1, 0, 4));
        distributionPanel.setBorder(BorderFactory.createEmptyBorder(8, 24, 8, 24));
        distributionPanel.add(new JLabel(CheckStatsViewModel.DISTRIBUTION_LABEL, SwingConstants.CENTER));
        for (int i = 0; i < distributionBars.length; i++) {
            final JPanel row = new JPanel(new BorderLayout(6, 0));
            row.add(new JLabel(String.valueOf(i + 1)), BorderLayout.WEST);
            distributionBars[i] = new DistributionBar();
            row.add(distributionBars[i], BorderLayout.CENTER);
            distributionPanel.add(row);
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

        final int[] counts = state.getGuessDistribution();
        int max = 1;
        for (int count : counts) {
            max = Math.max(max, count);
        }
        for (int i = 0; i < distributionBars.length; i++) {
            distributionBars[i].setValue(counts[i], max);
        }
    }

    public String getViewName() {
        return CheckStatsViewModel.VIEW_NAME;
    }

    public void setCheckStatsController(CheckStatsController checkStatsController) {
        this.checkStatsController = checkStatsController;
    }

    private static class DistributionBar extends JPanel {
        private static final Color BAR_COLOR = new Color(120, 124, 126);
        private static final int MIN_BAR_WIDTH = 24;

        private int count;
        private int max = 1;

        DistributionBar() {
            setOpaque(false);
            setPreferredSize(new Dimension(200, 20));
        }

        void setValue(int count, int max) {
            this.count = count;
            this.max = max;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            final Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            final int barWidth = Math.max(MIN_BAR_WIDTH, getWidth() * count / max);
            g2.setColor(BAR_COLOR);
            g2.fillRect(0, 0, barWidth, getHeight());

            final String text = String.valueOf(count);
            final FontMetrics metrics = g2.getFontMetrics();
            final int textX = barWidth - metrics.stringWidth(text) - 6;
            final int textY = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
            g2.setColor(Color.WHITE);
            g2.drawString(text, textX, textY);
            g2.dispose();
        }
    }
}
