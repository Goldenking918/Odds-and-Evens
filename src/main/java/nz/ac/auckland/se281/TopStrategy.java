package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {
  private List<Boolean> choices;
  private Choice choice;
  private int even;
  private int odd;

  public TopStrategy(List<Boolean> choices, Choice choice) {
    this.choices = choices;
    this.choice = choice;
  }

  @Override
  public int getFingers() {
    for (Boolean evenOdd : choices) {
      if (evenOdd) {
        even++;
      } else {
        odd++;
      }
    }
    if (even > odd) {
      if (choice == Choice.EVEN) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomEvenNumber();
      }
    } else if (odd > even) {
      if (choice == Choice.EVEN) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomOddNumber();
      }
    } else {
      return Utils.getRandomNumberRange(0, 5);
    }
  }
}
