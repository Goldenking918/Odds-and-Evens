package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * A class using the Strategy design pattern by implementing Strategy. It checks if the players
 * previous answers was more even or odd and changes the outputted integer to win if the player
 * picks the same answer.
 */
public class TopStrategy implements Strategy {
  private List<Boolean> choices;
  private Choice choice;
  private int even;
  private int odd;

  public TopStrategy(List<Boolean> choices, Choice choice) {
    this.choices = choices;
    this.choice = choice;
  }

  /**
   * Gets the number of even and odd answers the player has given. Checks whether there is more even
   * or odd and returns a even or odd number depending on which would make the Ai win. Otherwise if
   * even and odd are equal, a random number is returned.
   */
  @Override
  public int getFingers() {
    // Iterates through the choices list and counts the number of even and odd answers.
    for (Boolean evenOdd : choices) {
      if (evenOdd) {
        even++;
      } else {
        odd++;
      }
    }
    // Chooses the output that would result in a win for the Ai if the player picks the most used
    // answer.
    if (even > odd) {
      if (choice == Choice.EVEN) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomEvenNumber();
      }
    } else if (odd > even) {
      if (choice == Choice.EVEN) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomOddNumber();
      }
    } else {
      // Picks a Random number if odd and even are equal.
      return Utils.getRandomNumberRange(0, 5);
    }
  }
}
