import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * A program that solves for the result of the
 * expressing in the formula for a value x of
 * type double which is read in from the user input,
 * shows the numbers that are left and right
 * of the decimal, and formats the result to
 * two decimal places.
 *
 * Project 3
 * @author JB McAllister. COMP 1210-001
 * @version 02/02/2023
 */
public class MathFormula {
   /**
    * solves the equation using the user input value
    * and prints the results, # on the left side and 
    * right side of decimal, and formatted result.
    * @param args Command line arguments - not used. 
    */
   public static void main(String[] args) {
        // create Scanner object
      Scanner userInput = new Scanner(System.in);

        // create a decimalFormat object
      DecimalFormat decimalFormat = new DecimalFormat("#,##0.0##");

        // variables
      Double numX, result;
      int strIndex, leftSide, rightSide;
      String strResults;

      // enters user input
      System.out.print("Enter a value for x: ");
      numX = userInput.nextDouble();

      // calculates formula
      result = (Math.pow(numX, 9) + 10) / (Math.abs(5 * Math.pow(numX, 3)
              - 3 * Math.pow(numX, 2)) + Math.sqrt(4 * Math.pow(numX, 6)
              - 2 * Math.pow(numX, 2) + 1));

      // prints results
      System.out.println("Result: " + result);

      strResults = Double.toString(result);
      strIndex = strResults.indexOf(".");
      leftSide = strIndex;
      rightSide = strResults.length() - strIndex - 1;

      System.out.println("# digits to left of decimal point: " + leftSide);
      System.out.println("# digits to right of decimal point: " + rightSide);
      System.out.println("Formatted Result: " + decimalFormat.format(result));

   }
}