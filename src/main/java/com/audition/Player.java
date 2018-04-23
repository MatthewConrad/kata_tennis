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

public class Player {

    String name;
    private int score;

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public String getScoreDescription(){
        String description;
        switch (this.score){
            case 0:
                description = "love";
                break;
            case 1:
                description = "fifteen";
                break;
            case 2:
                description = "thirty";
                break;
            case 3:
                description = "forty";
                break;
            default:
                description = "";
        }

        return description;
    }

    public void scorePoint(){
        this.score += 1;
    }
}
