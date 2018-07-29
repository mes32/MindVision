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

    public int size() {
        return minions.size();
    }
}