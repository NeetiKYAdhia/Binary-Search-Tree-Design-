package bst;

/**
 * When an operation is attempted on an empty binary search tree an exception is thrown.
 * The exception such as finding the minimum or maximum value when no data exists is thrown.
 */
public class NothingThereException extends RuntimeException {

  /**
   * Constructs a new exception with a detailed message.
   *
   * @param message the detail message
   */
  public NothingThereException(String message) {
    super(message);
  }

  /**
   * Constructs a new exception with no detail message.
   */
  public NothingThereException() {
    super();
  }
}