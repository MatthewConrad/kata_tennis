package com.audition;

import org.junit.Before;
import org.junit.Test;

public class TennisTest {

    /**
     * Kata: Tennis
     * The Kata uses simplified rules for Tennis.
     * - Each player can have 0 ("love"), 15 ("fifteen"), 30 ("thirty"), or 40 ("forty") points
     * - If a player has 40 points and wins another point, they win the game if they have scored at least
     *   two more times than their opponent
     * - If both players have 40 points, the game is in "deuce". The winner of the next point will have "advantage"
     *   and must score another point in a row to win, but if the other player scores instead the game is back to deuce.
     **/

    @Before
    public void beforeTennisTest(){

    }

    @Test
    public void initialScoreDescriptionShouldBeLove(){

    }

    @Test
    public void onePointScoreDescriptionShouldBeFifteen(){

    }

    @Test
    public void twoPointsScoreDescriptionShouldBeThirty(){

    }

    @Test
    public void threePointsScoreDescriptionShouldBeForty(){

    }

    @Test
    public void firstPlayerToScoreFourTimesWithATwoPointLeadShouldWin(){

    }

    @Test
    public void scoreDescriptionWhenPlayersTiedAtFortyShouldBeDeuce(){

    }

    @Test
    public void scoreDescriptionWhenOnePlayerScoresAPointPastDeuceShouldBeAdvantage(){

    }

    @Test
    public void scoreDescriptionWhenPlayerWithAdvantageFailsToScoreAgainShouldBeDeuce(){

    }

    @Test
    public void playerWithAdvantageShouldWinIfScoresAgainBeforeTheirOpponent() {

    }
}
