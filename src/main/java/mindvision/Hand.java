/*
    Hand.java

    Represents a player's hand of currently playable Cards
 */

package mindvision;

import mindvision.utilities.*;

public class Hand {

    private MVStack<Card> cards;

    Hand(int capacity) {
        cards = new MVStack<Card>(capacity);
    }

    public void insert(Card card) {
        cards.push(card);
    }

    public Card get(int index) throws IndexOutOfBoundsException {
        return cards.get(index);
    }

    public int size() {
        return cards.size();
    }
}