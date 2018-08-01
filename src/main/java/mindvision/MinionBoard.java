/*
    MinionBoard.java

    Represents a player's board of SummonedMinions on the game table
 */

package mindvision;

import mindvision.utilities.*;

public class MinionBoard {

    private MVStack<SummonedMinion> minions;

    MinionBoard(int capacity) {
        minions = new MVStack<SummonedMinion>(capacity);
    }

    public void playAtEnd(SummonedMinion minion) {
        minions.push(minion);
    }

    public SummonedMinion get(int index) {
        return minions.get(index);
    }

    public int size() {
        return minions.size();
    }
}