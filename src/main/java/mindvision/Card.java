/*
    Card.java

    Represents an unplayed card in a player's Hand or Deck
 */

package mindvision;

public abstract class Card {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String U_DIAMOND = "\u2666";
    public static final String U_DAGGER = "\u2020";
    public static final String U_HEART = "\u2665";

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
