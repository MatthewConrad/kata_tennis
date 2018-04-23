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
 *
 * ADDITIONAL FEATURE FROM MATTHEW: when score is tied before deuce, it's announced as "[score] all"
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
    public void initialScoreDescriptionShouldBeLoveAll(){
        assertEquals("love all", game.getScore());
    }

    @Test
    public void onePointScoreDescriptionShouldBeFifteen(){
        player1.scorePoint();

        assertEquals("fifteen, love", game.getScore());
    }

    @Test
    public void twoPointsScoreDescriptionShouldBeThirty(){
        int x = 0;
        for(x = 0; x < 2; x++) {
            player1.scorePoint();
        }

        assertEquals("thirty, love", game.getScore());
    }

    @Test
    public void threePointsScoreDescriptionShouldBeForty(){
        int x = 0;
        for(x = 0; x < 3; x++) {
            player1.scorePoint();
        }

        assertEquals("forty, love", game.getScore());
    }

    @Test
    public void tiedPointsBelowDeuceShouldBeScoreAll(){
        // love all tested earlier; 40-40 is covered by deuce

        player1.scorePoint();
        player2.scorePoint();
        assertEquals("fifteen all", game.getScore());

        player1.scorePoint();
        player2.scorePoint();
        assertEquals("thirty all", game.getScore());

    }

    @Test
    public void playersShouldScorePointsIndependently(){
        player1.scorePoint();
        assertEquals("fifteen, love", game.getScore());

        player1.scorePoint();
        assertEquals("thirty, love", game.getScore());

        player2.scorePoint();
        assertEquals("thirty, fifteen", game.getScore());

        player2.scorePoint();
        player2.scorePoint();
        assertEquals("thirty, forty", game.getScore());
    }

    @Test
    public void firstPlayerToScoreFourTimesWithAtLeastATwoPointLeadShouldWin(){
        int x = 0;
        for(x = 0; x < 4; x++) {
            player1.scorePoint();
        }

        assertEquals("PlayerOne wins", game.getScore());
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

        assertEquals("PlayerOne wins", game.getScore());
    }

    @Test
    public void scoreDescriptionWhenPlayersTiedAtFortyShouldBeDeuce(){
        int x = 0;
        for(x = 0; x < 3; x++) {
            player1.scorePoint();
            player2.scorePoint();
        }

        assertEquals("deuce", game.getScore());
    }

    @Test
    public void scoreDescriptionWhenOnePlayerScoresAPointPastDeuceShouldBeAdvantage(){
        int x = 0;
        for(x = 0; x < 3; x++) {
            player1.scorePoint();
            player2.scorePoint();
        }

        assertEquals("deuce", game.getScore());

        player1.scorePoint();
        assertEquals("advantage PlayerOne", game.getScore());
    }

    @Test
    public void scoreDescriptionWhenPlayerWithAdvantageFailsToScoreAgainShouldBeDeuce(){
        int x = 0;
        for(x = 0; x < 3; x++) {
            player1.scorePoint();
            player2.scorePoint();
        }
        player1.scorePoint();

        assertEquals("advantage PlayerOne", game.getScore());
        player2.scorePoint();
        assertEquals("deuce", game.getScore());
    }

    @Test
    public void playerWithAdvantageShouldWinIfScoresAgainBeforeTheirOpponent() {
        int x = 0;
        for(x = 0; x < 3; x++) {
            player1.scorePoint();
            player2.scorePoint();
        }
        player1.scorePoint();

        assertEquals("advantage PlayerOne", game.getScore());
        player1.scorePoint();
        assertEquals("PlayerOne wins", game.getScore());
    }

    @Test
    public void playerTwoCanGetAdvantage(){
        int x = 0;
        for(x = 0; x < 3; x++) {
            player1.scorePoint();
            player2.scorePoint();
        }

        player2.scorePoint();
        assertEquals("advantage PlayerTwo", game.getScore());
    }

    @Test
    public void playerTwoCanWinFromAdvantage() {
        int x = 0;
        for(x = 0; x < 3; x++) {
            player1.scorePoint();
            player2.scorePoint();
        }

        player2.scorePoint();
        player2.scorePoint();
        assertEquals("PlayerTwo wins", game.getScore());
    }

    @Test
    public void playerTwoCanWin(){
        int x = 0;
        for(x = 0; x < 4; x++) {
            player2.scorePoint();
        }

        assertEquals("PlayerTwo wins", game.getScore());
    }

}
