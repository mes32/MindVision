/*
    SummonedMinion.java

    Represents a played/summoned minion on a player's board
 */

package mindvision;

public class SummonedMinion {
    private MinionCard card;
    private String name;
    private int cost;
    private int attack;
    private HealthPoints hp;

    SummonedMinion(MinionCard card) {
        this.card = card;
        name = card.getName();
        cost = card.getCost();
        attack = card.getAttack();
        hp = new HealthPoints(card.getHealth());
    }
}