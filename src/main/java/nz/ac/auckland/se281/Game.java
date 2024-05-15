package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round;
  private String[] options;

  private Ai ai;
  private int aiFingers;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.options = options;
    ai = AiFactory.createAi(difficulty);
    round = 0;
  }

  public void play() {
    round++;
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

    while (!Utils.isInteger(input) || Integer.parseInt(input) > 5 || Integer.parseInt(input) < 0) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }
    ai.setStrategy();
    aiFingers = ai.getAction();

    MessageCli.PRINT_INFO_HAND.printMessage(options[0], input);
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(aiFingers));
  }

  public void endGame() {}

  public void showStats() {}
}
