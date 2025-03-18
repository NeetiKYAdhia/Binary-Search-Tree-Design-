package betterbst;

import java.util.List;

import bst.NothingThereException;

/**
 * This class represents the operations on all nodes of a binary search tree.
 */
public abstract class BSTNode<T extends Comparable<T>> {
  /**
   * Inserts new data into the tree rooted at this node and returns the resulting tree.
   *
   * @param data the data to insert into the tree
   * @return the modified tree rooted at this node
   */
  abstract BSTNode<T> insert(T data);

  /**
   * Determines and returns the minimum element in the tree rooted at this node.
   *
   * @return the minimum element in the tree
   * @throws NothingThereException if the tree does not have any data
   */
  abstract T minimum() throws NothingThereException;

  /**
   * Determines and returns the maximum element in the tree rooted at this node.
   *
   * @return the maximum element in the tree
   * @throws NothingThereException if the tree does not have any data
   */
  abstract T maximum() throws NothingThereException;

  /**
   * Searches to see if the specified data is present in the tree rooted at this node.
   *
   * @param data the data to search for
   * @return true if the data is present in the tree, false otherwise
   */
  abstract boolean contains(T data);

  /**
   * Returns the data stored in this node.
   *
   * @return the data in this node
   */
  abstract T data();

  /**
   * Returns the left child of this node.
   *
   * @return the left child node
   */
  abstract BSTNode<T> left();

  /**
   * Returns the right child of this node.
   *
   * @return the right child node
   */
  abstract BSTNode<T> right();

  /**
   * Computes the height of the tree rooted at this node.
   *
   * @return the height of the tree
   */
  abstract int height();

  /**
   * Returns a list of this node's children.
   *
   * @return a list containing the left and right child nodes
   */
  abstract List<BSTNode<T>> getChildren();
}