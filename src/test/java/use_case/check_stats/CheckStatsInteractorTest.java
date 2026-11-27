package use_case.check_stats;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import entity.Player;
import org.junit.jupiter.api.Test;

class CheckStatsInteractorTest {
    @Test
    void successTest() {
        CheckStatsDataAccessInterface dao =
                username -> new Player("nikola", 150, 4, 3, 2, 3, new int[]{1, 1, 1, 0, 0});
        final boolean[] called = {false};

        CheckStatsOutputBoundary presenter = new CheckStatsOutputBoundary() {
            @Override
            public void prepareSuccessView(CheckStatsOutputData data) {
                called[0] = true;
                assertEquals("nikola", data.getUsername());
                assertEquals(150, data.getPoints());
                assertEquals(4, data.getGamesPlayed());
                assertEquals(75, data.getWinPercentage());
                assertEquals(2, data.getCurrentStreak());
                assertEquals(3, data.getLongestStreak());
                assertArrayEquals(new int[]{1, 1, 1, 0, 0}, data.getGuessDistribution());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToWelcomeView() {
            }
        };

        new CheckStatsInteractor(dao, presenter).execute(new CheckStatsInputData("nikola"));
        assertTrue(called[0]);
    }

    @Test
    void noGamesPlayedTest() {
        CheckStatsDataAccessInterface dao = username -> new Player("newbie");
        final boolean[] called = {false};

        CheckStatsOutputBoundary presenter = new CheckStatsOutputBoundary() {
            @Override
            public void prepareSuccessView(CheckStatsOutputData data) {
                called[0] = true;
                assertEquals(0, data.getGamesPlayed());
                assertEquals(0, data.getWinPercentage());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToWelcomeView() {
            }
        };

        new CheckStatsInteractor(dao, presenter).execute(new CheckStatsInputData("newbie"));
        assertTrue(called[0]);
    }

    @Test
    void unknownPlayerTest() {
        CheckStatsDataAccessInterface dao = username -> null;
        final boolean[] called = {false};

        CheckStatsOutputBoundary presenter = new CheckStatsOutputBoundary() {
            @Override
            public void prepareSuccessView(CheckStatsOutputData data) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                called[0] = true;
                assertEquals("Stats could not be loaded", errorMessage);
            }

            @Override
            public void switchToWelcomeView() {
            }
        };

        new CheckStatsInteractor(dao, presenter).execute(new CheckStatsInputData("nobody"));
        assertTrue(called[0]);
    }
}
