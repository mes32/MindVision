/*
    MinionCard.java

    Represents an unplayed minion in a player's Hand or Deck
 */

package mindvision;

public class MinionCard implements Card {
    private String name;
    private int cost;
    private int attack;
    private int health;

    MinionCard(String name, int cost, int attack, int health) {
        this.name = name;
        this.cost = cost;
        this.attack = attack;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }
}