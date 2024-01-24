/**
 * UserInfoDriver class is a class that creates two instances
 * of the UserInfo class and manipulates the instance variables.
 *
 * Activity 4
 * @author JB McAllister, COMP 1210-001
 * @version 02/07/23
 */
public class UserInfoDriver {
   /**
       * The main method creates two instances of the UserInfo class,
       * sets their instance variables, and outputs their information.
       * @param args Command line arguments - not used.      
       */
   public static void main(String[] args) {
      
      UserInfo user1 = new UserInfo("Pat", "Doe");
      System.out.println("\n" + user1);
      user1.setLocation("Auburn");
      user1.setAge(19);
      user1.logOn();
      System.out.println("\n" + user1);
      
      UserInfo user2 = new UserInfo("Sam", "Jones");
      System.out.println("\n" + user2);
      user2.setLocation("Atlanta");
      user2.setAge(21);
      user2.logOn();
      System.out.println("\n" + user2);
   }
}