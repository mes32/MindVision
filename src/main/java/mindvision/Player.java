/*
    Player.java

    Represents a player in Game
 */

package mindvision;

public abstract class Player {

    private static final int STARTING_HP = 30;
    private static final int MAXIMUM_HP = 30;
    private static final int MAXIMUM_HAND_SIZE = 10;
    private static final int MAXIMUM_BOARD_SIZE = 7;

    private HealthPoints hp = new HealthPoints(STARTING_HP, MAXIMUM_HP);
    private Deck deck = new Deck();
    private Hand hand = new Hand(MAXIMUM_HAND_SIZE);
    private MinionBoard board = new MinionBoard(MAXIMUM_BOARD_SIZE);
}
