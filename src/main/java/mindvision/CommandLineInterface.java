/*
    CommandLineInterface.java

    A CLI for MindVision games. Prints the current state of the game and prompts the human player for
    their next move.
 */

package mindvision;

import java.io.*;
import java.util.*;

public class CommandLineInterface {
    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

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
        printBoards();
        printHand();
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

        System.out.printf("P1    HP: %d/%d    deck: %d    hand: %d%n", currentHP1, totalHP1, deck1, hand1);
        System.out.printf("P2    HP: %d/%d    deck: %d    hand: %d%n", currentHP2, totalHP2, deck2, hand2);
        System.out.println();
    }

    private void printBoards() {
        int board1 = p1.getBoard().size();
        int board2 = p2.getBoard().size();

        int index = 0;
        System.out.println("                (" + ALPHABET[index++] + ")");

        printSpaces(4 + 14 - 2*board1);
        for (int i=0; i < board1; i++) {
            System.out.print("(" + ALPHABET[index++] + ") ");
        }
        System.out.println();

        printSpaces(4 + 14 - 2*board2);
        for (int i=0; i < board2; i++) {
            System.out.print("(" + ALPHABET[index++] + ") ");
        }
        System.out.println();

        System.out.println("                (" + ALPHABET[index++] + ")");

        System.out.println();
    }

    private void printHand() {
        int len = p2.getHand().size();

        if (len > 0) {
            System.out.print("    ");
            for (int i=0; i < len; i++) {
                System.out.print("|" + i);
            }
            System.out.println("|");
        }
        System.out.println();
    }

    private void printSpaces(int n) {
        char[] spaces = new char[n];
        Arrays.fill(spaces, ' ');
        System.out.print(new String(spaces));
    }
}