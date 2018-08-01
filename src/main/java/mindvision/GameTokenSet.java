/*
    GameTokenSet.java

    Provides an interface for printing and targeting GameTokens from CommandLineInterface
 */

package mindvision;

import java.util.*;

public class GameTokenSet {
    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private Player p1;
    private Player p2;

    GameTokenSet(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public GameToken get(char index) throws IndexOutOfBoundsException {
        throw new IndexOutOfBoundsException();

        // TODO: Implement this function;
    }

    public String toString() {
        int board1 = p1.getBoard().size();
        int board2 = p2.getBoard().size();

        int index = 0;
        String str = "";

        str += "                (" + ALPHABET[index++] + ")\n";
        str += genSpaces(4 + 14 - 2*board1);
        for (int i=0; i < board1; i++) {
            str += "(" + ALPHABET[index++] + ") ";
        }
        str += "\n";
        str += genSpaces(4 + 14 - 2*board2);
        for (int i=0; i < board2; i++) {
            str += "(" + ALPHABET[index++] + ") ";
        }
        str += "\n";
        str += "                (" + ALPHABET[index++] + ")\n";

        return str;
    }

    private static String genSpaces(int n) {
        char[] spaces = new char[n];
        Arrays.fill(spaces, ' ');
        return new String(spaces);
    }
}