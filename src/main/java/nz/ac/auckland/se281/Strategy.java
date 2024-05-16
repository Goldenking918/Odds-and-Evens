package nz.ac.auckland.se281;

/**
 * Strategy interface uses Strategy Design pattern for implementation in the different strategies.
 */
public interface Strategy {

  /**
   * Empty method to Override in the Strategy classes.
   *
   * @return the number of fingers 0 to 5 for the Ai
   */
  public int getFingers();
}
