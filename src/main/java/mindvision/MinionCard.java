/*
    MinionCard.java

    Represents an unplayed minion in a player's Hand or Deck
 */

package mindvision;

public class MinionCard extends Card {
    // private String name;
    // private int cost;
    private int attack;
    private int health;

    MinionCard(String name, int cost, int attack, int health) {
        this.name = name;
        this.cost = cost;
        this.attack = attack;
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public void print() {
        System.out.println(ANSI_RED + " - " + name + " - " + ANSI_RESET);
        System.out.println("     cost " + ANSI_BLUE + U_DIAMOND + ANSI_RESET + " " + cost);
        System.out.println("   attack " + ANSI_YELLOW + U_DAGGER + ANSI_RESET + " " + attack);
        System.out.println("   health " + ANSI_RED + U_HEART + ANSI_RESET + " " + health);
        System.out.println();
    }
}