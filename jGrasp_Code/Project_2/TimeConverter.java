import java.util.Scanner; 

/**
 * A program that accpets a raw time measurement
 * in seconds and then prints the time as
 * a combination of days, hours, minutes, and seconds.
 *
 * Project 2
 * @author JB McAllister. COMP 1210-001
 * @version 1/27/2023
 */
public class TimeConverter {
   /**
    *takes users input in seconds and converts it
    * into days, hours, minutes, and remaing seconds
    * also prevents usings a value less than zero.
    * @param args Command line arguements - not used.
    */ 
   public static void main(String[] args) {
      // creates an object of Scanner  
      Scanner input = new Scanner(System.in);
      
      // Interger Variable
      int rawTime, days, remainingSeconds, hours, minutes;
      
      // User inputs raw time in seconds
      System.out.print("Enter the raw time measurement in seconds: "); 
      rawTime = input.nextInt(); 
      
      // checks if input is more or less than zero
      if (rawTime < 0) { 
         System.out.println("Measurement must be non-negative!"); 
      } 
      else { 
         // calculates days
         days = rawTime / (24 * 60 * 60); 
         remainingSeconds = rawTime % (24 * 60 * 60); 
         
         // calculates hours
         hours = remainingSeconds / (60 * 60); 
         remainingSeconds = remainingSeconds % (60 * 60); 
         
         //cal culates minutes
         minutes = remainingSeconds / 60; 
         remainingSeconds = remainingSeconds % 60; 
         
         // prints days, hours, minutes, and remaining seconds
         System.out.println("\nMeasurement by combined days, " 
            + "hours, minutes, seconds: ");
         System.out.println("\tdays: " + days);
         System.out.println("\thours: " + hours);
         System.out.println("\tminutes: " + minutes);
         System.out.println("\tseconds: " 
            + remainingSeconds);
         System.out.println("\n" + rawTime + " seconds = "
            + days + " days, " + hours + " hours, " 
            + minutes + " minutes, " + remainingSeconds 
            + " seconds");
      } 
   } 
}