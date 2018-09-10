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
        gameTokens = game.getGameTokens();
    }

    public void start() {
        printAll();
        System.out.print(" > ");
        String line = scan.nextLine();

        while (true) {
            char[] units = getCommandUnits(line);
            if (units.length == 1 && units[0] == '.') {
                break;
            }

            try {
                if (units.length == 1) {
                    char u0 = units[0];
                    if (isNumeric(u0)) {
                        evalPrintCard(u0);
                    } else {
                        evalPrintToken(u0);
                    }
                } else if (units.length == 2) {
                    char u0 = units[0];
                    char u1 = units[1];
                    if (isNumeric(u0)) {
                        evalPlayCard(u0, u1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            printAll();
            System.out.print(" > ");
            line = scan.nextLine();
        }
    }

    private char[] getCommandUnits(String line) {
        String[] strings = line.split("\\s");
        char[] units = new char[strings.length];
        for (int i = 0; i < strings.length; i++) {
            units[i] = strings[i].charAt(0);
        }
        return units;
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

    private void evalPrintCard(char c) throws NumberFormatException, IndexOutOfBoundsException {
        int index = Character.getNumericValue(c);
        Hand hand = p2.getHand();
        Card card = hand.get(index);
        card.print();
    }

    private void evalPrintToken(char c) throws IndexOutOfBoundsException {
        String line = "" + c;
        char index = line.charAt(0);
        GameToken token = gameTokens.get(index);
        token.print();
    }

    private void evalPlayCard(char u0, char u1) throws IndexOutOfBoundsException {
        int index = Character.getNumericValue(u0);
        char target = u1;
        Hand hand = p2.getHand();

        Card card = hand.get(index);
        GameToken token = gameTokens.get(target);

        // TODO: Replace this print with instructing the game object to make the play
        card.print();
        token.print();

        game.play(p2, card, token);
    }

    private static boolean isNumeric(char c) {
        return Character.isDigit(c);
    }
}