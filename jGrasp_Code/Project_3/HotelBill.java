import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * A program that accepts a hotel bill code as input
 * that includes room number, price per night, check-in date,
 * number of nights, and guest name. The program prints the
 * information along with the total cost of the stay and
 * a lucky number.
 *
 * Project 3
 * @author JB McAllister. COMP 1210-001
 * @version 02/02/2023
 */
public class HotelBill {
   /**
    * A program that accepts a hotel bill code and prints
    * the information along with the total cost of the stay
    * and a lucky number.
    * @param args Command line arguments - not used.
    */
   public static void main(String[] args) {
   
     // creates scanner object
      Scanner userInput = new Scanner(System.in);
   
      // creates random object
      Random numberGenerater = new Random();
      
      // creates decimal formats
      DecimalFormat decimalFormat = new DecimalFormat("$#,##0.00");
      DecimalFormat luckyFormat = new DecimalFormat("000000");
   
      // variables
      String billCode, trimmedBillCode;
      Double costPerNight, totalPerNight, tax, totalOfStay;
      int nights, luckyNumber;
   
      // inputs hotel bill code
      System.out.print("Enter hotel bill code: ");
      billCode = userInput.nextLine();
      
      // trims the whitespace
      trimmedBillCode = billCode.trim();
      
      if (trimmedBillCode.length() < 22) {
         System.out.println("\nInvalid Hotel Bill Code.");
         System.out.println("Hotel Bill Code must have " 
            + "at least 22 characters.");
      }
      else {
         // calculates, tax, total per night, and total of stay
         costPerNight = Double.parseDouble(trimmedBillCode.substring(3, 9));
         nights = Integer.parseInt(trimmedBillCode.substring(19, 21));
         tax = costPerNight * 0.15;
         totalPerNight = costPerNight + tax;
         totalOfStay = totalPerNight * (double) nights;
         
         // generates random number between 1 and 999999
         luckyNumber = numberGenerater.nextInt(999999);
      
         // prints all the information
         System.out.println("\nName: " + trimmedBillCode.substring(21));
         System.out.println("Room: " + trimmedBillCode.substring(0, 3));
         System.out.println("Check-in Date: " 
            + trimmedBillCode.substring(9, 19));
         System.out.println("Nights: " + nights);
         System.out.println("Cost Per Night: " 
            + decimalFormat.format(totalPerNight) 
            + "   (Room: " + decimalFormat.format(costPerNight) + "   Tax: " 
            + decimalFormat.format(tax) + ")");
         System.out.println("Total: " + decimalFormat.format(totalOfStay));
         System.out.println("Lucky Number: " + luckyFormat.format(luckyNumber));
      }
   }
}