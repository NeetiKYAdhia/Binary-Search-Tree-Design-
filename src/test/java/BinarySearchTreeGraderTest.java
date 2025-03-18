import org.junit.Before;
import org.junit.Test;

import bst.BST;
import bst.NothingThereException;
import betterbst.BSTImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

/**
 * A test class for grading the functionality of a Binary Search Tree implementation.
 * Tests insertion, min/max operations, emptiness checks, contains, and traversal methods.
 */
public class BinarySearchTreeGraderTest {
  private BST<Integer> tree;

  /**
   * Sets up a new BST instance before each test.
   */
  @Before
  public void setup() {
    tree = new BSTImpl<>();
  }

  /**
   * Tests that inserting elements produces the correct string representation.
   */
  @Test
  public void testInsertions() {
    Set<Integer> expected = new TreeSet<>();

    for (int i = 0; i < 1000; i++) {
      expected.add((int) (Math.random() * 2000 - 1000));
    }

    for (Integer e : expected) {
      tree.insert(e);
    }

    StringBuilder sb = new StringBuilder();
    for (Integer e : expected) {
      sb.append(e + " ");
    }
    String output = sb.toString();
    output = "[" + output.substring(0, output.length() - 1) + "]";

    assertEquals(output, tree.toString());
  }

  /**
   * Tests that minimum and maximum operations return correct values after insertions.
   */
  @Test
  public void testMinMax() {
    TreeSet<Integer> expected = new TreeSet<>();

    for (int i = 0; i < 1000; i++) {
      expected.add((int) (Math.random() * 2000 - 1000));
    }

    for (Integer e : expected) {
      tree.insert(e);
    }

    assertEquals(expected.first(), tree.minimum());
    assertEquals(expected.last(), tree.maximum());
  }

  /**
   * Tests that minimum throws NothingThereException on an empty tree.
   */
  @Test(expected = NothingThereException.class)
  public void testMinWhenEmpty() {
    new BSTImpl<Integer>().minimum();
  }

  /**
   * Tests that maximum throws NothingThereException on an empty tree.
   */
  @Test(expected = NothingThereException.class)
  public void testMaxWhenEmpty() {
    new BSTImpl<Integer>().maximum();
  }

  /**
   * Tests that contains correctly identifies present and absent elements.
   */
  @Test
  public void testContains() {
    List<Integer> expected = new ArrayList<>();

    for (int i = 0; i < 1000; i++) {
      expected.add((int) (Math.random() * 2000 - 1000));
    }

    for (Integer e : expected) {
      tree.insert(e);
    }

    for (int i = -1000; i <= 1000; i++) {
      assertEquals(expected.contains(i), tree.present(i));
    }
  }

  /*
                              10
                   5                   15
           1             7                      20
                2     6       8               19
   */
  /**
   * Tests that preorder traversal visits nodes in the correct order.
   */
  @Test
  public void testPreorder() {
    tree.insert(10);
    tree.insert(15);
    tree.insert(5);
    tree.insert(1);
    tree.insert(2);
    tree.insert(7);
    tree.insert(6);
    tree.insert(8);
    tree.insert(20);
    tree.insert(19);

    List<Integer> expectedList = Arrays.asList(10, 5, 1, 2, 7, 6, 8, 15, 20, 19);
    List<Integer> actualList = new ArrayList<>();

    tree.preorder(i -> actualList.add(i));

    assertEquals(expectedList, actualList);
  }

  /*
                              10
                   5                   15
           1             7                      20
                2     6       8               19
   */
  /**
   * Tests that inorder traversal visits nodes in ascending order.
   */
  @Test
  public void testInorder() {
    tree.insert(10);
    tree.insert(15);
    tree.insert(5);
    tree.insert(1);
    tree.insert(2);
    tree.insert(7);
    tree.insert(6);
    tree.insert(8);
    tree.insert(20);
    tree.insert(19);

    List<Integer> expectedList = Arrays.asList(1, 2, 5, 6, 7, 8, 10, 15, 19, 20);
    List<Integer> actualList = new ArrayList<>();

    tree.inorder(i -> actualList.add(i));

    assertEquals(expectedList, actualList);
  }

  /*
                              10
                   5                   15
           1             7                      20
                2     6       8               19
   */
  /**
   * Tests that postorder traversal visits nodes in the correct order.
   */
  @Test
  public void testPostorder() {
    tree.insert(10);
    tree.insert(15);
    tree.insert(5);
    tree.insert(1);
    tree.insert(2);
    tree.insert(7);
    tree.insert(6);
    tree.insert(8);
    tree.insert(20);
    tree.insert(19);

    List<Integer> expectedList = Arrays.asList(2, 1, 6, 8, 7, 5, 19, 20, 15, 10);
    List<Integer> actualList = new ArrayList<>();

    tree.postorder(i -> actualList.add(i));

    assertEquals(expectedList, actualList);
  }
}