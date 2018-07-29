/*
    HealthPoints.java

    Represents the health points of heroes and minions
 */

package mindvision;

public class HealthPoints {

    private int currentPoints;
    private int totalPoints; 

    HealthPoints(int currentPoints, int totalPoints) {
        this.currentPoints = currentPoints;
        this.totalPoints = totalPoints;
    }

    public void damage(int d) {
        currentPoints -= d;
    }

    public void restore(int r) {
        currentPoints += r;
        if (currentPoints > totalPoints) {
            currentPoints = totalPoints;
        }
    }

    public boolean isDestroyed() {
        if (currentPoints <= 0) {
            return true;
        } else {
            return false;
        }
    }
}