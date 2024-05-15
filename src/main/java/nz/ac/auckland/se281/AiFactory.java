package nz.ac.auckland.se281;

public class AiFactory {
  public Ai createAi(String difficulty) {
    switch (difficulty) {
      case "EASY":
        return new EasyAi();
    }
    return null;
  }
}
