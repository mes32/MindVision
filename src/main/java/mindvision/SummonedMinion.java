/*
    SummonedMinion.java

    Represents a played/summoned minion on a player's board
 */

package mindvision;

public class SummonedMinion implements GameToken {
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

    public void print() {
        System.out.println(ANSI_PURPLE + " + " + name + " + " + ANSI_RESET);
        System.out.println("     cost " + ANSI_BLUE + U_DIAMOND + ANSI_RESET + " " + cost);
        System.out.println("   attack " + ANSI_YELLOW + U_DAGGER + ANSI_RESET + " " + attack);
        System.out.println("   health " + ANSI_RED + U_HEART + ANSI_RESET + " " + hp);
        System.out.println();
    }
}