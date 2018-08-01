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

    private Scanner scan = new Scanner(System.in);

    CommandLineInterface(Game game) {
        this.game = game;
        p1 = game.getPlayer1();
        p2 = game.getPlayer2();
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
                    evalPrintItem(line);
                }
            }

            printAll();
            System.out.print(" > ");
            line = scan.nextLine();
        }
    }

    private void printAll() {
        printPlayers();
        printBoards();
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

    private void evalPrintItem(String line) {
        try {
            if (line.length() == 1) {
                char c = line.charAt(0);
                int index = 0;
                System.out.println("Printing minion at index = " + index);
            }
        } catch(NumberFormatException | IndexOutOfBoundsException e) {
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

    private static void printSpaces(int n) {
        char[] spaces = new char[n];
        Arrays.fill(spaces, ' ');
        System.out.print(new String(spaces));
    }
}