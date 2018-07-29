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

    public Player() {
        for (int i = 0; i < 6; i++) {
            MinionCard card = new MinionCard("Bloodfen Raptor", 2, 3, 2);
            deck.insert(card);
            card = new MinionCard("Chillwind Yeti", 4, 4, 5);
            deck.insert(card);
            card = new MinionCard("Boulderfist Ogre", 6, 6, 7);
            deck.insert(card);
            card = new MinionCard("Murloc Raider", 1, 2, 1);
            deck.insert(card);
            card = new MinionCard("Oasis Snapjaw", 4, 2, 7);
            deck.insert(card);

            /*"River Crocolisk", 2, 2, 3
            "Blank One", 1, 1, 1
            "Blank Two", 2, 2, 2
            "Blank Three", 3, 3, 3
            "Blank Four", 4, 4, 4
            "Blank Five", 5, 5, 5
            "Blank Six", 6, 6, 6
            "War Golem", 7, 7, 7
            "Blank Eight", 8, 8, 8
            "Blank Ten", 10, 10, 10*/
        }
        deck.shuffle();

        for (int i = 0; i < 3; i++) {
            Card card = deck.draw();
            hand.insert(card);
        }
    }

    public HealthPoints getHP() {
        return hp;
    }

    public Deck getDeck() {
        return deck;
    }

    public Hand getHand() {
        return hand;
    }

    public MinionBoard getBoard() {
        return board;
    }
}
