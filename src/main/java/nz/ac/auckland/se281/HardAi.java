package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class HardAi extends Ai {

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
