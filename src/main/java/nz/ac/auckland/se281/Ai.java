package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public abstract class Ai {
  protected Strategy strategy;

  void setStrategy(List<Boolean> choices, Choice choice, Boolean result) {}

  int getAction() {
    return strategy.getFingers();
  }
}
