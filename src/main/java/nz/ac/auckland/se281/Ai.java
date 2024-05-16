package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public interface Ai {
  void setStrategy(List<Boolean> choices, Choice choice, Boolean result);

  int getAction();
}
