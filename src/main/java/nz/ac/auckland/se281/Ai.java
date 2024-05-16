package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public abstract class Ai {
  protected Strategy strategy;

  /**
   * Empty setStrategy Method to be Overriden by Ai classes.
   *
   * @param choices A Boolean list containing 1 if player answer was Even and 0 if Odd
   * @param choice Either EVEN or ODD in the Choice Enum that the player picked
   * @param result 1 if the player won the previous round, 0 if they lost
   */
  void setStrategy(List<Boolean> choices, Choice choice, Boolean result) {}

  /**
   * A method that is used in all extended classes to get the number of fingers for the strategy
   * picked.
   *
   * @return Number of fingers of the Ai based on the strategy picked
   */
  int getAction() {
    return strategy.getFingers();
  }
}
