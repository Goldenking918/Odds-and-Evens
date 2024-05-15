package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public int getFingers() {
    return Utils.random.nextInt(5);
  }
}
