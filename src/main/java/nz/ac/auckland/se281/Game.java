package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round = 0;
  private String[] options = {"", "HAL-9000"};
  private Choice choice;
  private List<Boolean> choices;
  private Boolean result;
  private int wins;
  private int aiWins;

  private Ai ai;
  private int aiFingers;

  /**
   * User inputs a difficulty, either EVEN or ODD and their name. The method uses these and creates
   * a new game by creating an Ai and setting the round to 1.
   *
   * @param difficulty difficulty in the Difficulty Enum EASY, MEDIUM or HARD
   * @param choice Either EVEN or ODD in the Choice Enum
   * @param options User inputted name
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.options[0] = options[0];
    this.choice = choice;
    choices = new ArrayList<Boolean>();
    ai = AiFactory.createAi(difficulty);
    round = 1;
  }

  /**
   * Gets an integer from 1 to 5 (number of fingers) inputted from the user, then the Ai outputs a
   * integer changing strategy based on difficulty. Depending on the choice of either EVEN or ODD
   * made by the player and if the sum of the two numbers is even or odd the winner changes. If the
   * answer is identical to what the player picked the player wins, otherwise 'HAL-9000' wins and a
   * winning message is printed out.
   */
  public void play() {
    if (round == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

    while (!Utils.isInteger(input) || Integer.parseInt(input) > 5 || Integer.parseInt(input) < 0) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }
    ai.setStrategy(choices, choice, result);
    aiFingers = ai.getAction();
    choices.add(Utils.isEven(Integer.parseInt(input)));

    MessageCli.PRINT_INFO_HAND.printMessage(options[0], input);
    MessageCli.PRINT_INFO_HAND.printMessage(options[1], Integer.toString(aiFingers));
    int sum = aiFingers + Integer.parseInt(input);
    if (Utils.isEven(sum)) {
      if (choice == Choice.EVEN) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", options[0]);
        result = false;
        wins++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "EVEN", options[1]);
        result = true;
      }
    } else {
      if (choice == Choice.ODD) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", options[0]);
        result = false;
        wins++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), "ODD", options[1]);
        result = true;
      }
    }
    round++;
  }

  public void endGame() {
    showStats();
    if (wins > aiWins) {
      MessageCli.PRINT_END_GAME.printMessage(options[0]);
    } else if ((wins < aiWins)) {
      MessageCli.PRINT_END_GAME.printMessage(options[1]);
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
    round = 0;
  }

  public void showStats() {
    if (round == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    } else {
      aiWins = (round - 1) - wins;
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          options[0], Integer.toString(wins), Integer.toString(aiWins));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          options[1], Integer.toString(aiWins), Integer.toString(wins));
    }
  }
}
