package betterbst;

import java.util.List;
import bst.NothingThereException;

/**
 * This node represents an empty node in the binary search tree (i.e. the
 * leaves)
 */
public class BSTEmptyNode<T extends Comparable<T>> extends BSTNode<T> {
  @Override
  public BSTNode<T> insert(T data) {
    return new BSTElementNode(data,new BSTEmptyNode(),new BSTEmptyNode());
  }

  @Override
  public T minimum() throws NothingThereException {
    throw new NothingThereException("Tree does not have any data");
  }

  @Override
  public T maximum() throws NothingThereException {
    throw new NothingThereException("Tree does not have any data");
  }

  @Override
  public boolean contains(T data) {
    return false;
  }

  @Override
  T data() {
    return null;
  }

  @Override
  BSTNode<T> left() {
    return null;
  }

  @Override
  BSTNode<T> right() {
    return null;
  }

  @Override
  int height() {
    return 0;
  }

  @Override
  List<BSTNode<T>> getChildren() {
    return List.of();
  }

  @Override
  public String toString() {
    return "";
  }


}
