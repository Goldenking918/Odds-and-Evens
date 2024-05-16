package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * Class extending Ai when the hard difficulty is selected uses Random for the first 3 rounds then
 * switches between top and random depending on if the Ai won the previous round.
 */
public class HardAi extends Ai {

  /**
   * For the first 3 rounds the strategy is set to the Random Strategy. After the 3rd round the
   * strategy changes it the Ai lost the previous round and stays the same otherwise.
   */
  @Override
  public void setStrategy(List<Boolean> choices, Choice choice, Boolean result) {
    if (choices.size() < 3) {
      this.strategy = new RandomStrategy();
    } else if (!result) {
      // Switches the Strategy if the previous round was lost by the Ai, otherwise stays the same.
      if (this.strategy instanceof RandomStrategy) {
        this.strategy = new TopStrategy(choices, choice);
      } else {
        this.strategy = new RandomStrategy();
      }
    }
  }
}
