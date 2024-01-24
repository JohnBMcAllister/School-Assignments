import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Scanner;

/**
 * The HeartShapedBoxList class represents a list of heart-shaped boxes.
 * It stores the name of the list and an ArrayList of HeartShapedBox objects.
 */
public class HeartShapedBoxList {

   // Instance Variables
   private String boxListName;
   private ArrayList<HeartShapedBox> boxList;

   // Constructor
   /**
    * Constructor for creating a HeartShapedBoxList object.
    * @param name the name of the list
    * @param list an ArrayList of HeartShapedBox objects
    */
   public HeartShapedBoxList(String name, ArrayList<HeartShapedBox> list) {
      boxListName = name;
      boxList = list;
   }

   // Methods
   /**
    * Returns the name of the HeartShapedBoxList object.
    * @return the name of the HeartShapedBoxList object
    */
   public String getName() {
      return boxListName;
   }
   /**
    * Returns the number of HeartShapedBox objects in the list.
    * @return the number of HeartShapedBox objects in the list
    */
   public int numberOfHeartShapedBoxes() {
      if (boxList.size() == 0) {
         return 0;
      }
      else {
         return boxList.size();
      }
   }
   /**
    * Returns the sum of the surface areas of all HeartShapedBox
    * objects in the list.
    * @return the sum of the surface areas of all HeartShapedBox
    * objects in the list
    */
   public double grandTotalSurfaceArea() {
      double totalSurfaceArea = 0.0;
      for (HeartShapedBox box : boxList) {
         totalSurfaceArea += box.totalSurfaceArea();
      }
      return totalSurfaceArea;
   }
   /**
    * Returns the total volume of all HeartShapedBox objects in the list.
    * @return the total volume of all HeartShapedBox objects in the list
    */
   public double totalVolume() {
      double totalVolume = 0.0;
      for (HeartShapedBox box : boxList) {
         totalVolume += box.volume();
      }
      return totalVolume;
   }
   /**
    * Returns the average surface area of all HeartShapedBox
    * objects in the list.
    * @return the average surface area of all HeartShapedBox
    * objects in the list
    */
   public double averageTotalSurfaceArea() {
      int numberOfBoxes = numberOfHeartShapedBoxes();
      if (numberOfBoxes == 0) {
         return 0.0;
      }
      else {
         return grandTotalSurfaceArea() / numberOfBoxes;
      }
   }
   /**
    * Returns the average volume of all HeartShapedBox objects in the list.
    * @return the average volume of all HeartShapedBox objects in the list
    */
   public double averageVolume() {
      int numberofBoxes = numberOfHeartShapedBoxes();
      if (numberofBoxes == 0) {
         return 0.0;
      }
      else {
         return totalVolume() / numberofBoxes;
      }
   }
   /**
    * Returns a string representation of the HeartShapedBoxList object.
    * @return a string representation of the HeartShapedBoxList object
    */
   public String toString() {
      String output = "----- " + boxListName + " -----\n";
      Iterator<HeartShapedBox> iterator = boxList.iterator();
      while (iterator.hasNext()) {
         HeartShapedBox box = iterator.next();
         output += "\n" + box.toString() + "\n";
      }
      return output;
   }
   /**
    * Returns a summary of information about the HeartShapedBoxList object.
    *The summary includes the name of the box list, the number of
    * heart-shaped boxes in the list, the total surface area and
    * volume of all the boxes in the list, and the average surface area
    * and volume of the boxes in the list. The summary is returned as a
    * String.
    * @return the summary of information about the
    * HeartShapedBoxList object
    */
   public String summaryInfo() {
      int numBoxes = numberOfHeartShapedBoxes();
      double totalSA = grandTotalSurfaceArea();
      double totalVol = totalVolume();
      double avgSA = averageTotalSurfaceArea();
      double avgVol = averageVolume();
   
      DecimalFormat format = new DecimalFormat("#,##0.0##");
   
      String summary = "----- Summary for " + boxListName + " -----";
      summary += "\nNumber of HeartShapedBoxes: " + numBoxes;
      summary += "\nTotal Surface Area: " + format.format(totalSA)
             + " square units";
      summary += "\nTotal Volume: " + format.format(totalVol)
             + " cubic units";
      summary += "\nAverage Surface Area: " + format.format(avgSA)
             + " square units";
      summary += "\nAverage Volume: " + format.format(avgVol) + " cubic units";
   
      return summary;
   }
    /**
     * Returns the list of HeartShapedBox objects.
     * @return the list of HeartShapedBox objects
     */
   public ArrayList<HeartShapedBox> getList() {
      return boxList;
   }
    /**
     * Reads a file with the given file name and creates a
     * new HeartShapedBoxList object with the data from the
     * file. The file should contain a name for the list on
     * the first line, followed by a series of lines, each
     * containing the label, radius, and height of a
     * heart-shaped box, separated by newlines. The
     * HeartShapedBox objects are then added to the list.
     * @param fileName the name of the file to read
     * @return a new HeartShapedBoxList object containing the data from the file
     * @throws FileNotFoundException if the file cannot be found
     */
   public HeartShapedBoxList readFile(String fileName)
           throws FileNotFoundException {
      Scanner scanFile = new Scanner(new File(fileName));
      boxListName = scanFile.nextLine();
      while (scanFile.hasNext()) {
         String label = scanFile.nextLine().trim();
         double radius = Double.parseDouble(scanFile.nextLine());
         double height = Double.parseDouble(scanFile.nextLine());
         boxList.add(new HeartShapedBox(label, radius, height));
      }
      System.out.println("\tFile read in and HeartShapedBox List created\n");
      return new HeartShapedBoxList(boxListName, boxList);
   }
   
   /**
    * Adds a new {@code HeartShapedBox} object with the specified
    * label, radius, and height to the current list of heart-shaped boxes.
    * @param label the label of the new heart-shaped box
    * @param radius the radius of the new heart-shaped box
    * @param height the height of the new heart-shaped box
    */
   public void addHeartShapedBox(String label, double radius, double height) {
      HeartShapedBox newBox = new HeartShapedBox(label, radius, height);
      boxList.add(newBox);
   }
   /**
    * Returns the HeartShapedBox with the specified label.
    * @param label the label of the HeartShapedBox to find
    * @return the HeartShapedBox with the specified label, 
    * or null if no such box is found
    */
   public HeartShapedBox findHeartShapedBox(String label) {
      for (HeartShapedBox box : boxList) {
         if (box.getLabel().equalsIgnoreCase(label)) {
            return box;
         }
      }
      return null;
   }
   /**
    * Removes the HeartShapedBox with the specified label from
    * the list of HeartShapedBoxes. If the HeartShapedBox with
    * the specified label is found in the list, it is removed from
    * the list and returned. If the HeartShapedBox with the specified
    * label is not found in the list, null is returned.
    * @param label the label of the HeartShapedBox to be deleted
    * @return the HeartShapedBox that was removed, or null if no
    * HeartShapedBox was found with the specified label
    */
   public HeartShapedBox deleteHeartShapedBox(String label) {
      for (int i = 0; i < boxList.size(); i++) {
         HeartShapedBox currentBox = boxList.get(i);
         if (currentBox.getLabel().equalsIgnoreCase(label)) {
            boxList.remove(i);
            return currentBox;
         }
      }
      return null;
   }
  
    /**
     * Edits an existing HeartShapedBox object with the specified label
     * by updating its radius and height values.
     * @param label the label of the HeartShapedBox object to be edited
     * @param radius the new radius value for the HeartShapedBox object
     * @param height the new height value for the HeartShapedBox object
     * @return true if the HeartShapedBox object was found and edited
     * successfully, false otherwise
     */
   public boolean editHeartShapedBox(String label,
      double radius, double height) {
      HeartShapedBox box = findHeartShapedBox(label);
      if (box != null) {
         box.setRadius(radius);
         box.setHeight(height);
         return true;
      } else {
         return false;
      }
   }
}
