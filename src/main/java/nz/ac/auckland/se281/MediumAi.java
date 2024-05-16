package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class MediumAi implements Ai {
  private Strategy strategy;

  @Override
  public void setStrategy(List<Boolean> choices, Choice choice) {
    if (choices.size() < 3) {
      this.strategy = new RandomStrategy();
    } else {
      this.strategy = new TopStrategy(choices, choice);
    }
  }

  @Override
  public int getAction() {
    return strategy.getFingers();
  }
}
