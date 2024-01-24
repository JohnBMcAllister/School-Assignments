import java.util.Scanner;
/**
 * A program that exchange letters in a 
 * String that is inputed by the user to 
 * encode a message.
 *
 * Activity 3
 * @author JB McAllister. COMP 1210-001
 * @version 1/31/2023
 */
public class MessageConverter {
   /**
    * encodes a String that is inputed by the user.
    * @param args Command line arguements - not used.
    */
   public static void main(String[] args) {
     // Creates the object userInput
      Scanner userInput = new Scanner(System.in);
      // Variables
      String message = "";
      int outputType;
      String result = "";
      
      // requests user input
      System.out.print("Type in a message and press enter:\n\t> ");
      message = userInput.nextLine();
      
      // displays users options
      System.out.print("\nOutput types:"
         + "\n\t0: As is "
         + "\n\t1: Trimmed"
         + "\n\t2: lower case"
         + "\n\t3: UPPER CASE"
         + "\n\t4: v_w_ls r_pl_c_d"
         + "\n\t5: Without first and last character"
         + "\nEnter your choice: ");
   
      outputType = Integer.parseInt(userInput.nextLine());
      
      if (outputType == 0) { // as is
         result = message;
      }
      else if (outputType == 1) { // trimmed
         result = message.trim();
      }
      else if (outputType == 2) { // lower case
         result = message.toLowerCase();
      }
      else if (outputType == 3) { // upper case
         result = message.toUpperCase();
      }
      else if (outputType == 4) { // replace vowels
         result = message.replace('a', '_');
         result = message.replace('e', '_');
         result = message.replace('i', '_');
         result = message.replace('o', '_');
         result = message.replace('u', '_');
      }
      else if (outputType == 5) { // without first and last character
         result = message.substring(1, message.length() - 1);
      }
      else { // invalid input
         result = "Error: Invalid choice input.";
      }
      System.out.println("\n" + result);
   }
}