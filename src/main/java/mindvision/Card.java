/*
    Card.java

    Represents an unplayed card in a player's Hand or Deck
 */

package mindvision;

public abstract class Card implements Printable {
    protected String name;
    protected int cost;

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public void print() {
        System.out.println(ANSI_RED + " - " + name + " - " + ANSI_RESET);
        System.out.println("   cost " + ANSI_BLUE + U_DIAMOND + ANSI_RESET + " " + cost);
        System.out.println();
    }
}
