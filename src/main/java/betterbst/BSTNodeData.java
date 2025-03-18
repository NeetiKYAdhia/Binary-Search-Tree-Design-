package betterbst;

/**
 * Represents data associated with a node in a Binary Search Tree (BST),
 * also containing the node and an action to be executed. This class is
 * parameterized to work with any comparable type T, permitting adaptable usage
 * in BST implementations where there is a need for node reference and action tracking.
 *
 * @param <T> the type of elements stored in the BST, must implement Comparable
 */
public class BSTNodeData<T extends Comparable<T>> {

  private BSTNode<T> node;
  private String action;

  public BSTNodeData(BSTNode<T> node, String action) {
    this.node = node;
    this.action = action;
  }

  public BSTNode<T> node() {
    return node;
  }

  public String action() {
    return action;
  }
}