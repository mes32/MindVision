/*
    Game.java

    Represents a match between two players played in MindVision
 */

package mindvision;

public class Game {

    private Player player1;
    private Player player2;
    private GameTokenSet gameTokens;

    Game() {
        player1 = new ComputerPlayer();
        player2 = new HumanPlayer();
        gameTokens = new GameTokenSet(player1, player2);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public GameTokenSet getGameTokens() {
        return gameTokens;
    }

    public void play(Player player, Card card, GameToken target) throws InvalidTargetException {
        try {
            card.play(target);
            player.removeCard(card);
        } catch (InvalidTargetException e) {
            throw e;
        }
    }
}