/**
 * The UserInfo class represents information about a user.
 * It contains the user's first name, last name,
 * location, age, and online status.
 *
 * Activity 4
 * @author JB McAllister, COMP 1210-001
 * @version 02/07/23
 */
public class UserInfo {
   // instance variables
   private String firstName;
   private String lastName;
   private String location;
   private int age;
   private int status;
   private static final int OFFLINE = 0, ONLINE = 1;

   // constructor
   /**
    * Constructor for creating a UserInfo object.
    * @param firstNameIn The first name of the user.
    * @param lastNameIn The last name of the user.
    */
   public UserInfo(String firstNameIn, String lastNameIn) {
      firstName = firstNameIn;
      lastName = lastNameIn;
      location = "Not specified";
      age = 0;
      status = OFFLINE;
   
   }

   // methods
   /**
    * Returns a string representation of the user's information.
    * @return The string representation of the user's information.
    */
   public String toString() {
      String output = "Name: " + firstName + " "
             + lastName + "\n";
      output += "Location: " + location + "\n";
      output += "Age: " + age + "\n";
      output += "Status: ";
      if (status == OFFLINE) {
         output += "Offline";
      }
      else {
         output += "Online";
      }
      return output;
   }
    /**
     * Sets the location of the user.
     * @param locationIn The new location of the user.
     */
   public void setLocation(String locationIn) {
      location = locationIn;
   }

   /**
    * Sets the age of the user.
    * @param ageIn The new age of the user.
    * @return True if the age was set successfully, false otherwise.
    */
   public boolean setAge(int ageIn) {
      boolean isSet = false;
      if (ageIn > 0) {
         age = ageIn;
         isSet = true;
      }
      return isSet;
   }
   /**
    * Gets the age of the user.
    * @return The age of the user.
    */
   public int getAge() {
      return age;
   }
  /**
    * Gets the location of the user.
    * @return The location of the user.
    */ 
   public String getLocation() {
      return location;
   }
   /**
    * Sets the status of the user to offline.
    */
   public void logOff() {
      status = OFFLINE;
   }
   /**
    * Sets the status of the user to online.
    */
   public void logOn() {
      status = ONLINE;
   }
}
