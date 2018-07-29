/*
    CommandLineInterface.java

    A CLI for MindVision games. Prints the current state of the game and prompts the human player for
    their next move.
 */

package mindvision;

import java.io.*;

public class CommandLineInterface {
    private Game game;
    private Player p1;
    private Player p2;

    CommandLineInterface(Game game) {
        this.game = game;
        p1 = game.getPlayer1();
        p2 = game.getPlayer2();
    }

    public void start() {
        printAll();
    }

    private void printAll() {
        printPlayers();
    }

    private void printPlayers() {
        int currentHP1 = p1.getHP().getCurrent();
        int totalHP1 = p1.getHP().getTotal();
        int deck1 = p1.getDeck().size();
        int hand1 = p1.getHand().size();

        int currentHP2 = p2.getHP().getCurrent();
        int totalHP2 = p2.getHP().getTotal();
        int deck2 = p2.getDeck().size();
        int hand2 = p2.getHand().size();

        System.out.println("P1");
        System.out.printf("    HP: %d/%d  deck: %d  hand: %d%n", currentHP1, totalHP1, deck1, hand1);
        System.out.println("P2");
        System.out.printf("    HP: %d/%d  deck: %d  hand: %d%n", currentHP2, totalHP2, deck2, hand2);
    }
}