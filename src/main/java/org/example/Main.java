package org.example;

/**
 * A simple class to demonstrate basic output and looping in Java.
 * This serves as an entry point for running a small console application.
 */
public class Main {
  /**
   * The main entry point of the application.
   * Prints a welcome message and iterates from 1 to 5, printing each value.
   *
   * @param args command-line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Press Alt+Enter with your caret at the highlighted text to see how
    // IntelliJ IDEA suggests fixing it.
    System.out.printf("Hello and welcome!");

    for (int i = 1; i <= 5; i++) {
      // Press Ctrl+F5 to start debugging your code. We have set one breakpoint
      // for you, but you can always add more by pressing Ctrl+F8.
      System.out.println("i = " + i);
    }
  }
}