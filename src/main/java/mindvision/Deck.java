/*
    Deck.java

    Represents a player's deck of Cards that are queued to be drawn into thier Hand
 */

package mindvision;

import mindvision.utilities.*;

public class Deck {

    private MVStack<Card> cards = new MVStack<Card>();

    Deck() {

    }

    public void insert(Card card) {
        cards.push(card);
    }

    public Card draw() {
        return cards.pop();
    }

    public void shuffle() {
        cards.shuffle();
    }

    public int size() {
        return cards.size();
    }
}