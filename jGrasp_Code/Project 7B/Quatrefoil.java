import java.text.DecimalFormat;

/**
 * This class represents a quatrefoil with a given label and diameter.
 * 
 * Project 7A
 * @author JB McAllister, COMP 1210-001
 * @version 03/17/2023
 */
public class Quatrefoil implements Comparable<Quatrefoil> {

   //Instance Variables
   private String label = "";
   private double diameter = 0.0;
   private static int count = 0;

   // Constructor

   /**
    * Constructs a Quatrefoil object with the specified
    * label and diameter values.
    * @param labelIn the label to set for the Quatrefoil object
    * @param diameterIn the diameter to set for the Quatrefoil object
    */
   public Quatrefoil(String labelIn, double diameterIn) {
      setLabel(labelIn);
      setDiameter(diameterIn);
      count++;
   }

   // Method

   /**
    * Returns Label.
    * @return label of Quatrefoil
    */
   public String getLabel() {
      return label;
   }

   /**
    * Sets the label for this Quatrefoil object.
    * @param labelIn the label to set for this Quatrefoil object
    * @return true if the label is not null, false otherwise
    */
   public boolean setLabel(String labelIn) {
      if (labelIn != null) {
         this.label = labelIn.trim();
         return true;
      } else {
         return false;
      }
   }
   
   /**
    * Returns the diameter of the quatrefoil in inches.
    * @return the diameter of the quatrefoil in inches
    */
   public double getDiameter() {
      return diameter;
   }
   
   /**
    * Sets the diameter of the quatrefoil in inches. 
    * The diameter must be greater than 0.
    * @param diameterIn the diameter of the quatrefoil in inches
    * @return true if the diameter was set, false otherwise
    */
   public boolean setDiameter(double diameterIn) {
      if (diameterIn > 0) {
         this.diameter = diameterIn;
         return true;
      } else {
         return false;
      }
   }

   /**
    * Returns the perimeter of the quatrefoil in inches.
    * @return the perimeter of the quatrefoil in inches
    */
   public double perimeter() {
      return Math.PI * diameter;
   }

   /**
    * Returns the perimeter of the quatrefoil in feet.
    * @return the perimeter of the quatrefoil in feet
    */
   public double perimeterInFt() {
      return perimeter() / 12;
   }

   /**
    * Returns the area of the quatrefoil in square inches.
    * @return the area of the quatrefoil in square inches
    */
   public double area() {
      return Math.pow(diameter / 2, 2) + 2
             * (Math.PI * Math.pow(diameter / 2, 2) / 4);
   }

   /**
    * Returns the area of the quatrefoil in square feet.
    * @return the area of the quatrefoil in square feet
    */
   public double areaInSqFt() {
      return area() / 144;
   }
   /**
    * Returns a string representation of the Quatrefoil object.
    * @return a string representation of the Quatrefoil object
    */
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      return "Quatrefoil \"" + label + "\" with diameter " 
               + diameter + " inches has:\n"
               + "\tperimeter = " + df.format(perimeter()) + " inches (or " 
               + df.format(perimeterInFt()) + " feet)\n"
               + "\tarea = " + df.format(area()) + " square inches (or " 
               + df.format(areaInSqFt()) + " square feet)\n";
   }
   
   /**
    * Returns the number of Quatrefoil objects created.
    * @return the number of Quatrefoil objects created
    */
   public static int getCount() {
      return count;
   }
   
   /**
    * Resets the count of Quatrefoil objects created to 0.
    */
   public static void resetCount() {
      count = 0;
   }

   /**
    * Determines if this Quatrefoil object is equal to another object
    * by comparing their label and diameter values.
    * @param obj the object to compare to this Quatrefoil
    * @return true if the object is a Quatrefoil object and has the same
    * label and diameter values as this Quatrefoil, false otherwise
    */
   public boolean equals(Object obj) {
      if (!(obj instanceof Quatrefoil)) {
         return false;
      }
      else {
         Quatrefoil qf = (Quatrefoil) obj;
         return (label.equalsIgnoreCase(qf.getLabel())
                && Math.abs(diameter - qf.getDiameter()) < .000001);
      }
   }
   /**
    * Generates a hash code for this Quatrefoil object. Since the equals()
    * method uses only the label and diameter fields, this method also
    * uses only those fields to generate the hash code.
    * @return the hash code for this Quatrefoil object
    */
   public int hashCode() {
      return 0;
   }
    /**
     * Compares this Quatrefoil object with another Quatrefoil
     * object based on their diameter.
     * @param other the other Quatrefoil object to compare with this object
     * @return -1 if this object's diameter is less than the other object's
     * diameter, 1 if this object's diameter is greater than the other
     * object's diameter, or 0 if the diameters are equal
     */
   public int compareTo(Quatrefoil other) {
      if (this.diameter < other.diameter) {
         return -1;
      } else if (this.diameter > other.diameter) {
         return 1;
      } else {
         return 0;
      }
   }
}
