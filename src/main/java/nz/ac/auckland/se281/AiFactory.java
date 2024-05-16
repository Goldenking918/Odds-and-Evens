package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {
  /**
   * Creates different Ai based on the difficulty inputted.
   *
   * @param difficulty A Difficulty either EASY, MEDIUM or HARD in the Difficulty Enum.
   * @return returns null if a correct difficulty isn't inputted.
   */
  public static Ai createAi(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAi();
      case MEDIUM:
        return new MediumAi();
      case HARD:
        return new HardAi();
    }
    return null;
  }
}
