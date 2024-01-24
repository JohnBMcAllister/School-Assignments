import java.text.DecimalFormat;
/**
 * class that stores the label, radius, and height.
 * The HeartShapedBox class also includes methods to
 * set and get each of these fields, as well as methods to
 * calculate the area of the heart shape, lateral surface area,
 * total surface area, and volume of a HeartShapedBox object,
 * and a method to provide a String value of a
 * HeartShapedBox object
 *
 * Project 4
 * @author JB McAllister - Comp 1210-001
 * @version 02/10/2023
 */
public class HeartShapedBox {
   // instance variables
   private String label =  "";
   private double radius = 0;
   private double height = 0;

   // constructor
   /**
    * Constructs a new HeartShapedBox object with
    * the given label, radius, and height.
    *
    * @param labelIn the label of the heart-shaped box
    * @param radiusIn the radius of the heart-shaped box
    * @param heightIn the height of the heart-shaped box
    */
   public HeartShapedBox(String labelIn, double radiusIn, double heightIn) {
      setLabel(labelIn);
      setRadius(radiusIn);
      setHeight(heightIn);
   }

   // methods
   /**
    * Returns the label of the heart-shaped box.
    *
    * @return the label of the heart-shaped box
    */
   public String getLabel() {
      return label;
   }
   /**
    * Sets the label of the heart-shaped box to the given value.
    *
    * @param labelOut the new label for the heart-shaped box
    * @return false if label is null, true otherwise
    */
   public boolean setLabel(String labelOut) {
      if (labelOut != null) {
         this.label = labelOut.trim();
         return true;
      }
      return false;
   }

   /**
    * Returns the radius of the heart-shaped box.
    *
    * @return the radius of the heart-shaped box
    */
   public double getRadius() {
      return radius;
   }

   /**
    * Sets the radius of the heart-shaped box to the given value.
    *
    * @param radiusOut the new radius for the heart-shaped box
    * @return false if radius is not positive, true otherwise
    */
   public boolean setRadius(double radiusOut) {
      if (radiusOut > 0) {
         this.radius = radiusOut;
         return true;
      } else {
         return false;
      }
   }
   /**
    * Returns the height of the heart-shaped box.
    *
    * @return the height of the heart-shaped box
    */
   public double getHeight() {
      return height;
   }
   /**
    * Sets the height of the heart-shaped box to the given value.
    *
    * @param heightOut the new height for the heart-shaped box
    * @return false if height is not positive, true otherwise
    */
   public boolean setHeight(double heightOut) {
      if (heightOut > 0) {
         this.height = heightOut;
         return true;
      } else {
         return false;
      }
   }
   /**
    * Calculates the heart-shaped area of a HeartShapedBox.
    *
    * @return the heart-shaped area in squared units.
    */
   public double heartShapedArea() {
      double area = (Math.PI * Math.pow(radius, 2))
             + (4 * Math.pow(radius, 2));
      return area;
   }
   /**
    * Calculates the lateral surface area of a HeartShapedBox.
    *
    * @return the lateral surface area in square units.
    */
   public double lateralSurfaceArea() {
      double latSurfArea = height * (4 * radius + 2 * Math.PI * radius);
      return latSurfArea;
   }
   /**
    * Calculates the total surface area of a HeartShapedBox.
    *
    * @return the total surface area in square units.
    */
   public double totalSurfaceArea() {
      double totalSurfaceArea = 2 * heartShapedArea() + lateralSurfaceArea();
      return totalSurfaceArea;
   }
   /**
    * Calculates the volume of a HeartShapedBox.
    *
    * @return the volume in cubic units.
    */
   public double volume() {
      double volume = height * heartShapedArea();
      return volume;
   }
   /**
    * Returns a string representation of the HeartShapedBox.
    * The string includes the label, radius, height, heart-shaped area,
    * lateral surface area,
    * total surface area, and volume.
    *
    * @return the string representation of the HeartShapedBox.
    */
   public String toString() {
      // creates a decimal format object
      DecimalFormat decimalFormat = new DecimalFormat("#,##0.0##");
   
      String output = "HeartShapedBox " + "\"" + label + "\"" + " with radius "
             + decimalFormat.format(radius) + " units and height "
             + decimalFormat.format(height) + " units:\n";
      output += "\theart shaped area = "
             + decimalFormat.format(heartShapedArea())
             + " square units\n";
      output += "\tlateral surface area = "
             + decimalFormat.format(lateralSurfaceArea())
             + " square units\n";
      output += "\ttotal surface area = "
             + decimalFormat.format(totalSurfaceArea())
             + " square units\n";
      output += "\tvolume = "
             + decimalFormat.format(volume()) + " cubic units";
      return output;
   }
}