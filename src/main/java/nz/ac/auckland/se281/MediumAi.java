package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * Class extending Ai if the Difficulty selected is Medium. Uses Random for the first 3 rounds then
 * switches to the top strategy.
 */
public class MediumAi extends Ai {

  /**
   * For the first 3 rounds the strategy is set to Random Strategy. Afterwards the strategy is set
   * to Top Strategy.
   */
  @Override
  public void setStrategy(List<Boolean> choices, Choice choice, Boolean result) {
    if (choices.size() < 3) {
      this.strategy = new RandomStrategy();
    } else {
      this.strategy = new TopStrategy(choices, choice);
    }
  }
}
