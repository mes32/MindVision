/*
    Player.java

    Represents a player in Game
 */

package mindvision;

// TODO: Temporary while testing board centering
import java.util.Random;

public abstract class Player {

    private static final int MAXIMUM_HAND_SIZE = 10;
    private static final int MAXIMUM_BOARD_SIZE = 7;

    private Deck deck = new Deck();
    private Hand hand = new Hand(MAXIMUM_HAND_SIZE);
    private HeroCharacter hero = new HeroCharacter();
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

        for (int i=0; i < 3; i++) {
            Card card = deck.draw();
            hand.insert(card);
        }

        // TODO: Temporary while testing board centering
        Random rand = new Random();
        int  n = rand.nextInt(8);
        for (int i=0; i < n; i++) {
            MinionCard card = new MinionCard("Blank One", 1, 1, 1);
            SummonedMinion minion = new SummonedMinion(card);
            board.playAtEnd(minion);
        }
    }

    // TODO: This function is now inside the class Hero and should be removed here
    public HealthPoints getHP() {
        return hero.getHP();
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
