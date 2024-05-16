package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  /** returns a random integer from 0 to 5. */
  @Override
  public int getFingers() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
