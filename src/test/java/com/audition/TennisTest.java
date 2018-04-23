package com.audition;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Kata: Tennis
 * The Kata uses simplified rules for Tennis.
 * - Each player can have 0 ("love"), 15 ("fifteen"), 30 ("thirty"), or 40 ("forty") points
 * - If a player has 40 points and wins another point, they win the game if they have scored at least
 *   two more times than their opponent
 * - If both players have 40 points, the game is in "deuce". The winner of the next point will have "advantage"
 *   and must score another point in a row to win, but if the other player scores instead the game is back to deuce.
 **/

public class TennisTest {
    Player player1;
    Player player2;
    Game game;

    @Before
    public void beforeTennisTest(){
        player1 = new Player("PlayerOne");
        player2 = new Player("PlayerTwo");
        game = new Game(player1, player2);
    }

    @Test
    public void initialScoreDescriptionShouldBeLove(){
        assertEquals(game.getScore(), "love, love");
    }

    @Test
    public void onePointScoreDescriptionShouldBeFifteen(){
        player1.scorePoint();

        assertEquals(game.getScore(), "fifteen, love");
    }

    @Test
    public void twoPointsScoreDescriptionShouldBeThirty(){
        int x = 0;
        for(x = 0; x < 2; x++) {
            player1.scorePoint();
        }

        assertEquals(game.getScore(), "thirty, love");
    }

    @Test
    public void threePointsScoreDescriptionShouldBeForty(){
        int x = 0;
        for(x = 0; x < 3; x++) {
            player1.scorePoint();
        }

        assertEquals(game.getScore(), "forty, love");
    }

    @Test
    public void playersShouldScorePointsIndependently(){
        player1.scorePoint();
        assertEquals(game.getScore(), "fifteen, love");

        player1.scorePoint();
        assertEquals(game.getScore(), "thirty, love");

        player2.scorePoint();
        assertEquals(game.getScore(), "thirty, fifteen");

        player2.scorePoint();
        player2.scorePoint();
        assertEquals(game.getScore(), "thirty, forty");
    }

    @Test
    public void firstPlayerToScoreFourTimesWithAtLeastATwoPointLeadShouldWin(){
        int x = 0;
        for(x = 0; x < 4; x++) {
            player1.scorePoint();
        }

        assertEquals(game.getScore(), "PlayerOne wins");
    }

    @Test
    public void firstPlayerToScoreFourTimesWithExactlyATwoPointLeadShouldWin(){
        int x = 0;
        for(x = 0; x < 2; x++) {
            player1.scorePoint();
            player2.scorePoint();
        }

        player1.scorePoint();
        player1.scorePoint();

        assertEquals(game.getScore(), "PlayerOne wins");
    }

    @Test
    public void scoreDescriptionWhenPlayersTiedAtFortyShouldBeDeuce(){
        int x = 0;
        for(x = 0; x < 3; x++) {
            player1.scorePoint();
            player2.scorePoint();
        }

        assertEquals(game.getScore(), "deuce");
    }

    @Test
    public void scoreDescriptionWhenOnePlayerScoresAPointPastDeuceShouldBeAdvantage(){
        int x = 0;
        for(x = 0; x < 3; x++) {
            player1.scorePoint();
            player2.scorePoint();
        }

        assertEquals(game.getScore(), "deuce");
    }

    @Test
    public void scoreDescriptionWhenPlayerWithAdvantageFailsToScoreAgainShouldBeDeuce(){
        int x = 0;
        for(x = 0; x < 3; x++) {
            player1.scorePoint();
            player2.scorePoint();
        }
        player1.scorePoint();

        assertEquals(game.getScore(), "advantage PlayerOne");
        player2.scorePoint();
        assertEquals(game.getScore(),"deuce");
    }

    @Test
    public void playerWithAdvantageShouldWinIfScoresAgainBeforeTheirOpponent() {
        int x = 0;
        for(x = 0; x < 3; x++) {
            player1.scorePoint();
            player2.scorePoint();
        }
        player1.scorePoint();

        assertEquals(game.getScore(), "advantage PlayerOne");
        player1.scorePoint();
        assertEquals(game.getScore(),"PlayerOne wins");
    }
}
