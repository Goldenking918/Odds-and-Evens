package nz.ac.auckland.se281;

public class EasyAi implements Ai {
  private Strategy strategy;

  @Override
  public int getAction() {
    return strategy.getFingers();
  }

  @Override
  public void setStrategy() {
    this.strategy = new RandomStrategy();
  }
}
