/*
    HeroCharacter.java

    Represents the player's hero character
 */

package mindvision;

public class HeroCharacter implements GameToken {

    private static final int STARTING_HP = 30;

    private int attack = 0;
    private HealthPoints hp = new HealthPoints(STARTING_HP);

    public HeroCharacter() {

    }

    public void print() {
        System.out.println(ANSI_PURPLE + " + PLAYER HERO + " + ANSI_RESET);
        System.out.println("   attack " + ANSI_YELLOW + U_DAGGER + ANSI_RESET + " " + attack);
        System.out.println("   health " + ANSI_RED + U_HEART + ANSI_RESET + " " + hp);
        System.out.println();
    }

    public HealthPoints getHP() {
        return hp;
    }
}
