/*
    CommandLineInterface.java

    A CLI for MindVision games. Prints the current state of the game and prompts the human player for
    their next move.
 */

package mindvision;

import java.io.*;
import java.util.*;

public class CommandLineInterface {
    private Game game;
    private Player p1;
    private Player p2;
    private GameTokenSet gameTokens;

    private Scanner scan = new Scanner(System.in);

    CommandLineInterface(Game game) {
        this.game = game;
        p1 = game.getPlayer1();
        p2 = game.getPlayer2();
        gameTokens = new GameTokenSet(p1, p2);
    }

    public void start() {
        printAll();
        System.out.print(" > ");
        String line = scan.nextLine();

        while (!line.equals(".")) {
            if (line.length() == 1) {
                if (isNumeric(line)) {
                    evalPrintCard(line);
                } else {
                    evalPrintToken(line);
                }
            }

            printAll();
            System.out.print(" > ");
            line = scan.nextLine();
        }
    }

    private void printAll() {
        printPlayers();
        printTokens();
        printHand();
    }

    private void printPlayers() {
        HealthPoints hp1 = p1.getHP();
        int deck1 = p1.getDeck().size();
        int hand1 = p1.getHand().size();

        HealthPoints hp2 = p2.getHP();
        int deck2 = p2.getDeck().size();
        int hand2 = p2.getHand().size();

        System.out.printf("P1    HP: %s    deck: %d    hand: %d%n", hp1, deck1, hand1);
        System.out.printf("P2    HP: %s    deck: %d    hand: %d%n", hp2, deck2, hand2);
        System.out.println();
    }

    private void printTokens() {
        System.out.println(gameTokens.toString());
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

    private void evalPrintCard(String line) {
        try {
            if (line.length() == 1) {
                int index = Integer.parseInt(line);
                Hand hand = p2.getHand();
                Card card = hand.get(index);
                card.print();
            }
        } catch(NumberFormatException | IndexOutOfBoundsException e) {
            // Do nothing
        }
    }

    private void evalPrintToken(String line) {
        try {
            if (line.length() == 1) {
                char index = line.charAt(0);
                GameToken token = gameTokens.get(index);
                token.print();
            }
        } catch(IndexOutOfBoundsException e) {
            // Do nothing
        }
    }        

    private static boolean isNumeric(String line) {  
        try {  
            int number = Integer.parseInt(line);  
        } catch(NumberFormatException e) {  
            return false;  
        }  
        return true;
    }
}