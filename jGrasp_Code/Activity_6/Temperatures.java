import java.util.ArrayList;

/**
 * A program that holds a set of integer values representing daily
 * temperatures.
 *
 * Activity 6
 * @author JB McAllister, Comp 1210-001
 * @version 02/19/2023
 */
public class Temperatures {

   // Instance Variables
   private ArrayList<Integer> temperatures;

   // constructor
   /**
    * Constructor that initializes the temperature list.
    *
    * @param temperaturesIn a list of temperatures
    */
   public Temperatures(ArrayList<Integer> temperaturesIn) {
      temperatures = temperaturesIn;
   }

   // methods
   /**
    * Returns the lowest temperature in the list of
    ^ temperatures.
    *
    * @return the lowest temperature in the list
    */
   public int getLowTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      int low = temperatures.get(0);
      for (int i = 1; i < temperatures.size(); i++) {
         if (temperatures.get(i) < low) {
            low = temperatures.get(i);
         }
      }
      return low;
   }

   /**
    * Returns the highest temperature in the list
    * of temperatures.
    *
    * @return the highest temperature in the list
    */
   public int getHighTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      int high = temperatures.get(0);
      for (Integer temp : temperatures) {
         if (temp > high) {
            high = temp;
         }
      }
      return high;
   }
   /**
    * Returns the lower of the given minimum and
    * the lowest temperature in the list.
    *
    * @param lowIn the minimum temperature
    * @return the lower of the minimum temperature and 
    * the lowest temperature in the list
    */
   public int lowerMinimum(int lowIn) {
      return lowIn < getLowTemp() ? lowIn : getLowTemp();
   }

   /**
    * Returns the higher of the given maximum and the highest
    * temperature in the list.
    *
    * @param highIn the maximum temperature
    * @return the higher of the maximum temperature and the highest
    * temperature in the list
    */
   public int higherMaximum(int highIn) {
      return highIn > getHighTemp() ? highIn : getHighTemp();
   }

   /**
    * Returns a string representation of the temperature information.
    *
    * @return a string containing the temperature list, the lowest
    * temperature, and the highest temperature
    */
   public String toString() {
      return "\tTemperatures: " + temperatures
             + "\n\tLow: " + getLowTemp()
             + "\n\tHigh: " + getHighTemp();
   }
}