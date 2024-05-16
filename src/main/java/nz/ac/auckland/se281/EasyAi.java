package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class EasyAi extends Ai {
  /** Sets the strategy to Random Strategy in the EasyAi. */
  @Override
  public void setStrategy(List<Boolean> choices, Choice choice, Boolean result) {
    this.strategy = new RandomStrategy();
  }
}
