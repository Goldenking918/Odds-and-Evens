package nz.ac.auckland.se281;

/** Strategy which outputs a random integer from the range 0 to 5. */
public class RandomStrategy implements Strategy {

  /** returns a random integer from 0 to 5. */
  @Override
  public int getFingers() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
