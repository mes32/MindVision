/*
    HeroCharacter.java

    Represents the player's hero character
 */

package mindvision;

public class HeroCharacter implements GameToken {

    private static final int STARTING_HP = 30;

    private HealthPoints hp = new HealthPoints(STARTING_HP);

    public HeroCharacter() {

    }

    public void print() {
        
    }

    public HealthPoints getHP() {
        return hp;
    }
}
