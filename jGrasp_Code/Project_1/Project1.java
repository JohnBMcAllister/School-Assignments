/**
 * Program that prints a J pattern using J, A, V, A.
 * 
 * Project 1
 * @author JB McAllister
 * @version 01/20/2023
 */
public class Project1 {
   /**
    * Prints J pattern using J, A, V, A.
    * @param args Command line arguments - not used.
    */
   public static void main(String[] args) {
      // prints the top part of the J
      System.out.println("JAVAJAVAJAVA");
      System.out.println("JAVAJAVAJAVA");
      // prints part of the main shaft of the J
      System.out.println("      JAVA");
      System.out.println("      JAVA");
      System.out.println("      JAVA");
      System.out.println("      JAVA");
      /* prints part of the main shaft and
       * and the edge of the curve
       */
      System.out.println("J     JAVA");
      System.out.println("JA    JAVA");
      // prints the bottom curve of the J
      System.out.println(" JAVAJAVA");
      System.out.println("  JAVAJA");
   }
}