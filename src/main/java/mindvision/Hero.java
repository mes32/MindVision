/*
    Hero.java

    Represents the player's hero character
 */

package mindvision;

public class Hero {

    private static final int STARTING_HP = 30;

    private HealthPoints hp = new HealthPoints(STARTING_HP);

    public Hero() {

    }

    public void print() {
        
    }

    public HealthPoints getHP() {
        return hp;
    }
}
