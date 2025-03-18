package betterbst;

import java.util.Stack;
import java.util.function.Consumer;

import bst.BST;
import bst.NothingThereException;

/**
 * This class represents a binary search tree. It implements the BST interface.
 */
public class BSTImpl<T extends Comparable<T>> implements BST<T> {
  private BSTNode<T> root;

  /**
   * Constructs an empty binary search tree.
   */
  public BSTImpl() {
    root = new BSTEmptyNode<>();
  }

  @Override
  public void insert(T data) {
    root = root.insert(data);
  }

  @Override
  public boolean present(T data) {
    return root.contains(data);
  }

  @Override
  public T minimum() throws NothingThereException {
    return root.minimum();
  }

  @Override
  public T maximum() throws NothingThereException {
    return root.maximum();
  }

  @Override
  public String toString() {
    return "[" + root.toString() + "]";
  }

  @Override
  public void preorder(Consumer<T> consumer) {
    Stack<BSTNodeData<T>> stack = new Stack<>();
    stack.push(new BSTNodeData<>(root, "traverse"));
    while (!stack.isEmpty()) {
      BSTNodeData<T> nodeData = stack.pop();
      if (nodeData.node().data() == null) {
        continue;
      }
      if (nodeData.action().equals("traverse")) {
        stack.push(new BSTNodeData<>(nodeData.node().right(), "traverse"));
        stack.push(new BSTNodeData<>(nodeData.node().left(), "traverse"));
        stack.push(new BSTNodeData<>(nodeData.node(), "process"));
      } else if (nodeData.action().equals("process")) {
        consumer.accept(nodeData.node().data());
      }
    }
  }

  @Override
  public void postorder(Consumer<T> consumer) {
    Stack<BSTNodeData<T>> stack = new Stack<>();
    stack.push(new BSTNodeData<>(root, "traverse"));
    while (!stack.isEmpty()) {
      BSTNodeData<T> nodeData = stack.pop();
      if (nodeData.node().data() == null) {
        continue;
      }
      if (nodeData.action().equals("traverse")) {
        stack.push(new BSTNodeData<>(nodeData.node(), "process"));
        stack.push(new BSTNodeData<>(nodeData.node().right(), "traverse"));
        stack.push(new BSTNodeData<>(nodeData.node().left(), "traverse"));
      } else if (nodeData.action().equals("process")) {
        consumer.accept(nodeData.node().data());
      }
    }
  }

  @Override
  public void inorder(Consumer<T> consumer) {
    Stack<BSTNodeData<T>> stack = new Stack<>();
    stack.push(new BSTNodeData<>(root, "traverse"));
    while (!stack.isEmpty()) {
      BSTNodeData<T> nodeData = stack.pop();
      if (nodeData.node().data() == null) {
        continue;
      }
      if (nodeData.action().equals("traverse")) {
        stack.push(new BSTNodeData<>(nodeData.node().right(), "traverse"));
        stack.push(new BSTNodeData<>(nodeData.node(), "process"));
        stack.push(new BSTNodeData<>(nodeData.node().left(), "traverse"));
      } else if (nodeData.action().equals("process")) {
        consumer.accept(nodeData.node().data());
      }
    }
  }

  @Override
  public boolean isBalanced() {
    return isBalancedHelper(root);
  }

  /**
   * Helper method to check if the tree is balanced recursively.
   *
   * @param elementNode the root of the subtree to check
   * @return true if the subtree is balanced, false otherwise
   */
  private boolean isBalancedHelper(BSTNode<T> elementNode) {
    if (elementNode == null) {
      return true;
    }

    int leftHeight = 0;
    int rightHeight = 0;

    if (elementNode.left() != null) {
      leftHeight = elementNode.left().height();
    }

    if (elementNode.right() != null) {
      rightHeight = elementNode.right().height();
    }

    // Check if height difference is <= 1 and subtrees are balanced
    return Math.abs(leftHeight - rightHeight) <= 1
            && isBalancedHelper(elementNode.left())
            && isBalancedHelper(elementNode.right());
  }
}

