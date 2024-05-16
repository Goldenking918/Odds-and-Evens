package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round;
  private String[] options = {"", "HAL-9000"};
  private Choice choice;
  private List<Boolean> choices = new ArrayList<Boolean>();

  private Ai ai;
  private int aiFingers;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.options[0] = options[0];
    this.choice = choice;
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
    ai.setStrategy(choices, choice);
    aiFingers = ai.getAction();
    choices.add(Utils.isEven(Integer.parseInt(input)));

    MessageCli.PRINT_INFO_HAND.printMessage(options[0], input);
    MessageCli.PRINT_INFO_HAND.printMessage(options[1], Integer.toString(aiFingers));
    int sum = aiFingers + Integer.parseInt(input);
    if (Utils.isEven(sum)) {
      if (choice == Choice.EVEN) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", options[0]);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", options[1]);
      }
    } else {
      if (choice == Choice.ODD) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", options[0]);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", options[1]);
      }
    }
  }

  public void endGame() {}

  public void showStats() {}
}
