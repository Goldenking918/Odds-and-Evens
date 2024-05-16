package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

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
      if (this.strategy instanceof RandomStrategy) {
        this.strategy = new TopStrategy(choices, choice);
      } else {
        this.strategy = new RandomStrategy();
      }
    }
  }
}
