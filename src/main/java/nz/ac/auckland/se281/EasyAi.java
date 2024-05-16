package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class EasyAi implements Ai {
  private Strategy strategy;

  @Override
  public int getAction() {
    return strategy.getFingers();
  }

  @Override
  public void setStrategy(List<Boolean> choices, Choice choice) {
    this.strategy = new RandomStrategy();
  }
}
