package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round;
  private String[] options;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.options = options;
    round = 0;
  }

  public void play() {
    round++;
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    int fingers = Integer.parseInt(input);

    while (fingers > 5 || fingers < 0) {
      MessageCli.INVALID_INPUT.printMessage();
      input = Utils.scanner.nextLine();
      fingers = Integer.parseInt(input);
    }

    MessageCli.PRINT_INFO_HAND.printMessage(options[0], input);
  }

  public void endGame() {}

  public void showStats() {}
}
