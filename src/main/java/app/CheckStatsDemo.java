package app;

import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import entity.Player;
import interface_adapter.ViewManagerModel;
import interface_adapter.check_stats.CheckStatsController;
import interface_adapter.check_stats.CheckStatsPresenter;
import interface_adapter.check_stats.CheckStatsViewModel;
import interface_adapter.welcome_menu.WelcomeViewModel;
import use_case.check_stats.CheckStatsDataAccessInterface;
import use_case.check_stats.CheckStatsInteractor;
import view.CheckStatsView;
import view.ViewManager;

public class CheckStatsDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // View models
            final ViewManagerModel viewManagerModel = new ViewManagerModel();
            final CheckStatsViewModel checkStatsViewModel = new CheckStatsViewModel();

            // Views
            final CheckStatsView checkStatsView = new CheckStatsView(checkStatsViewModel);

            // Use case wiring, with a fake player in place of real storage
            final CheckStatsDataAccessInterface fakeStorage =
                    username -> new Player(username, 320, 14, 11, 2, 5, new int[]{1, 3, 5, 2, 0});
            final CheckStatsPresenter presenter =
                    new CheckStatsPresenter(viewManagerModel, checkStatsViewModel);
            final CheckStatsInteractor interactor = new CheckStatsInteractor(fakeStorage, presenter);
            final CheckStatsController controller = new CheckStatsController(interactor);
            checkStatsView.setCheckStatsController(controller);

            // Stand-in for the main menu, so the Back button has somewhere to go
            final JPanel menuStandIn = new JPanel();
            menuStandIn.setLayout(new BoxLayout(menuStandIn, BoxLayout.Y_AXIS));
            menuStandIn.add(new JLabel("Main menu (stand-in for the demo)"));
            final JButton viewStats = new JButton("View Stats");
            viewStats.addActionListener(e -> controller.execute("nikola"));
            menuStandIn.add(viewStats);

            // Card layout holding both screens
            final CardLayout cardLayout = new CardLayout();
            final JPanel views = new JPanel(cardLayout);
            views.add(menuStandIn, WelcomeViewModel.VIEW_NAME);
            views.add(checkStatsView, checkStatsView.getViewName());

            new ViewManager(views, cardLayout, viewManagerModel);

            final JFrame frame = new JFrame("CityGuesser");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setContentPane(views);
            frame.setMinimumSize(new java.awt.Dimension(300, 200));

            // Open straight on the stats screen
            controller.execute("nikola");

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
