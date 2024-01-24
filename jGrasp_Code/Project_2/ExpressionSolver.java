import java.util.Scanner;

/**
 * A program that inputs values of type double
 * for x, y, and z and solves 
 * for the result of the indicated formula when xyz
 * is not equal to zero.  If xyz is equal to zero, then 
 * the result is undefined.
 *
 * Project 2
 * @author JB McAllister. COMP 1210-001
 * @version 1/27/2023
 */
public class ExpressionSolver {
   /**
    * Calculates expression using user's values
    * and prints undefine if any input values is
    * 0.
    * @param args Command line arguements - not used.
    */
   public static void main(String[] args) {
     // creates an object of Scanner 
      Scanner userInput = new Scanner(System.in);
      // variables
      double numX, numY, numZ, result;
      
   
      // print the equation that the program will solve
      System.out.println("result = (7.1x + 3.6) "
         + "(5.0y + 4.9) (2.5z - 5.2) / xyz");
   
      // enter NumX value
      System.out.print("\tEnter x: ");
      numX = userInput.nextDouble();
      
      // enter NumY value
      System.out.print("\tEnter y: ");
      numY = userInput.nextDouble();
      
      // enter NumZ value
      System.out.print("\tEnter z: ");
      numZ = userInput.nextDouble();
      
      // calculate the expression
      result = ((((7.1 * numX) + 3.6) * ((5.0 * numY) + 4.9) 
         * ((2.5 * numZ) - 5.2)) / ((numX * numY) * numZ));
   
      if (numX == 0 || numY == 0 || numZ == 0) {
         //if any enter values = 0 prints undefined
         System.out.println("result is undefined");
      } else { // if all entered values don't = 0, then prints the results
         System.out.println("result = " + result);
      }
   }
       

}