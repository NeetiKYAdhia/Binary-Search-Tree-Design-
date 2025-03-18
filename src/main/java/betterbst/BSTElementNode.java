package betterbst;

import java.util.List;
import bst.NothingThereException;

/**
 * This class represents a data-containing node of the binary search tree.
 * It mutates on all relevant operations.
 */
public class BSTElementNode<T extends Comparable<T>> extends BSTNode<T> {
  private BSTNode<T> left;
  private BSTNode<T> right;
  private T data;

  /**
   * Constructs a new data-containing node with the specified data and child nodes.
   *
   * @param data the data to store in this node
   * @param left the left child node
   * @param right the right child node
   */
  public BSTElementNode(T data, BSTNode<T> left, BSTNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  /**
   * Inserts the specified data into the subtree rooted at this node.
   * If the data is less than this node's data, it is inserted into the left subtree;
   * if greater, into the right subtree. Duplicate data is ignored.
   *
   * @param data the data to insert
   * @return this node, potentially modified
   */
  @Override
  public BSTNode<T> insert(T data) {
    if (data.compareTo(this.data) < 0) {
      this.left = this.left.insert(data);
    } else if (data.compareTo(this.data) > 0) {
      this.right = this.right.insert(data);
    }
    return this;
  }

  /**
   * Finds the minimum value in the subtree rooted at this node.
   *
   * @return the minimum value in this subtree
   * @throws NothingThereException if the subtree has no data
   */
  @Override
  public T minimum() throws NothingThereException {
    T minimum;
    try {
      minimum = this.left.minimum();
    } catch (NothingThereException e) {
      minimum = this.data;
    }
    return minimum;
  }

  /**
   * Finds the maximum value in the subtree rooted at this node.
   *
   * @return the maximum value in this subtree
   * @throws NothingThereException if the subtree has no data
   */
  @Override
  public T maximum() throws NothingThereException {
    T maximum;
    try {
      maximum = this.right.maximum();
    } catch (NothingThereException e) {
      maximum = this.data;
    }
    return maximum;
  }

  /**
   * Checks if the specified data exists in the subtree rooted at this node.
   *
   * @param data the data to search for
   * @return true if the data is present, false otherwise
   */
  @Override
  public boolean contains(T data) {
    int compareResult = data.compareTo(this.data);
    if (compareResult == 0) {
      return true;
    } else if (compareResult < 0) {
      return this.left.contains(data);
    } else {
      return this.right.contains(data);
    }
  }

  /**
   * Returns the data stored in this node.
   *
   * @return the data in this node
   */
  @Override
  T data() {
    return this.data;
  }

  /**
   * Returns a string representation of this subtree in ascending order.
   * Format: "[left data right]" with spaces separating non-empty parts.
   *
   * @return the string representation of this subtree
   */
  @Override
  public String toString() {
    String left = this.left.toString();
    String right = this.right.toString();
    String middle = this.data.toString();
    if (left.length() > 0) {
      left = left + " ";
    }
    if (right.length() > 0) {
      right = " " + right;
    }
    return left + middle + right;
  }

  /**
   * Returns the left child of this node.
   *
   * @return the left child node
   */
  public BSTNode<T> left() {
    return this.left;
  }

  /**
   * Returns the right child of this node.
   *
   * @return the right child node
   */
  public BSTNode<T> right() {
    return this.right;
  }

  /**
   * Computes the height of this subtree.
   *
   * @return the height of this subtree (1 + max of left and right heights)
   */
  @Override
  int height() {
    int leftHeight = this.left.height();
    int rightHeight = this.right.height();
    if (leftHeight > rightHeight) {
      return leftHeight + 1;
    }
    return rightHeight + 1;
  }

  /**
   * Returns a list of this node's children.
   *
   * @return a list containing the left and right child nodes
   */
  @Override
  List<BSTNode<T>> getChildren() {
    return List.of(this.left, this.right);
  }
}