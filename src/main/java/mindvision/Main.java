/*
    Main.java

    Launcher class for MindVision
 */

package mindvision;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        CommandLineInterface gameInterface = new CommandLineInterface(game);
        gameInterface.start();
    }
}
