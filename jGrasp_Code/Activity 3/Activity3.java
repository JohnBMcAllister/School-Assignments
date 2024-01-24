import java.util.Scanner;

public class Activity3 {
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      String message = "";
      int outputType;
      String result = "";
      
      System.out.print("Type in a message and press enter:\n\t> ");
      message = userInput.nextLine();
   
      System.out.print("\nOutput types:"
         + "\n\t0: As is "
         + "\n\t1: Trimmed"
         + "\n\t2: lower case"
         + "\n\t3: UPPER CASE"
         + "\n\t4: v_w_ls r_pl_c_d"
         + "\n\t5: Without first and last character"
         + "\nEnter your choice: ");
   
      outputType = Integer.parseInt(userInput.nextLine());
        
      switch (outputType) {
         case 0:
            result = message;
            break;
         case 1:
            result = message.trim();
            break;
         case 2:
            result = message.toLowerCase();
            break;
         case 3:
            result = message.toUpperCase();
            break;
         case 4:
            result = message.replaceAll("[aeiouAEIOU]", "_");
            break;
         case 5:
            result = message.length() > 2 ? message.substring(1, message.length() - 1) : "Error: Message too short.";
            break;
         default:
            result = "Error: Invalid choice input.";
            break;
      }
      System.out.println("\n" + result);
   }
}