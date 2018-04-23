package com.audition;

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

public class Game {

    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore(){
        String score;
        if(player1.getScore() == player2.getScore()){
            if( player1.getScore() >= 3){
                score = "deuce";
            }else{
                score = player1.getScoreDescription() + " all";
            }
        }else if(player1.getScore() > 3 || player2.getScore() > 3){
            Player leadPlayer = (player1.getScore() > player2.getScore()) ? player1 : player2;
            if (Math.abs(player1.getScore() - player2.getScore()) >= 2){
                score = leadPlayer.getName() + " wins";
            }else {
                score = "advantage " + leadPlayer.getName();
            }
        }else{
            score = player1.getScoreDescription() + ", " + player2.getScoreDescription();
        }

        return score;
    }
}
