/*
    Game.java

    Represents a match between two players played in MindVision
 */

package mindvision;

public class Game {

    private Player player1;
    private Player player2;

    Game() {
        player1 = new ComputerPlayer();
        player2 = new HumanPlayer();
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}