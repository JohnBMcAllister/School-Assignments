import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * The HeartShapedBoxListMenuApp class provides a command-line
 * interface for managing a list of HeartShapedBox objects. It
 * allows users to read HeartShapedBox objects from a file,
 * print the list of HeartShapedBox objects, print a summary of
 * the HeartShapedBox list, add, delete, find, and edit
 * HeartShapedBox objects in the list. This class uses the
 * HeartShapedBoxList and HeartShapedBox classes to create, manage,
 * and manipulate HeartShapedBox objects and their list.
 
 * Project 6
 * @author JB McAllister, Comp 1210-001
 * @version 2/24/2023
 */
public class HeartShapedBoxListMenuApp {
/**
* The main method is the entry point of the program. It creates a
* new HeartShapedBoxList object, displays a menu of options, prompts
* the user to enter a code for an action to perform, and performs the
* selected action until the user chooses to quit.
*
* @param args an array of command-line arguments
* @throws FileNotFoundException if the input file is not found
*/
   public static void main(String[] args)
           throws FileNotFoundException {
      String listName = "";
      ArrayList<HeartShapedBox> boxes = new ArrayList<HeartShapedBox>();
      HeartShapedBoxList boxList = new HeartShapedBoxList(listName, boxes);
   
      char choice = 'Q';
      Scanner userInput = new Scanner(System.in);
   
      System.out.println("HeartShapedBox List System Menu");
      System.out.println("R - Read File and Create HeartShapedBox List");
      System.out.println("P - Print HeartShapedBox List");
      System.out.println("S - Print Summary");
      System.out.println("A - Add HeartShapedBox");
      System.out.println("D - Delete HeartShapedBox");
      System.out.println("F - Find HeartShapedBox");
      System.out.println("E - Edit HeartShapedBox");
      System.out.println("Q - Quit");
   
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         choice = userInput.nextLine().toUpperCase().charAt(0);
         switch (choice) {
            case 'R':
               String fileName = "";
               System.out.print("\tFile name: ");
               fileName = userInput.nextLine();
            
               boxList.readFile(fileName);
               break;
            case 'P':
               System.out.println("");
               System.out.println(boxList);
               
               break;
            case 'S':
               System.out.println("");
               System.out.println(boxList.summaryInfo());
               System.out.println("");
               break;
            case 'A':
               String addLabel = "";
               double addRadius = 0;
               double addHeight = 0;
               System.out.print("\tLabel: ");
               addLabel = userInput.nextLine().trim();
               System.out.print("\tRadius: ");
               addRadius = Double.parseDouble(userInput.nextLine());
               System.out.print("\tHeight: ");
               addHeight = Double.parseDouble(userInput.nextLine());
               boxList.addHeartShapedBox(addLabel, addRadius, addHeight);
               System.out.println("\t*** HeartShapedBox added ***\n");
               break;
         
            case 'D':
               String deleteLabel = "";
               System.out.print("\tLabel: ");
               deleteLabel = userInput.nextLine().trim();
               if (boxList.findHeartShapedBox(deleteLabel) == null) {
                  System.out.println("\t\"" + deleteLabel + "\" not found\n");
                  break;
               }
               else {
                  System.out.println("\t\""
                         + boxList.findHeartShapedBox(deleteLabel).getLabel()
                         + "\" deleted\n");
                  boxList.deleteHeartShapedBox(deleteLabel);
                  break;
               }
            
            case 'F':
               Scanner findInput = new Scanner(System.in);
               System.out.print("\tLabel: ");
               String labelToFind = findInput.nextLine();
               HeartShapedBox foundBox 
                  = boxList.findHeartShapedBox(labelToFind);
               if (foundBox != null) {
                  System.out.println("\nHeartShapedBox found: " 
                     + foundBox.toString() + "\n");
               } else {
                  System.out.println("\n\t\"" 
                     + labelToFind + "\" not found.\n");
               }
               break;
         
            case 'E':
               String editLabel = "";
               double editRadius = 0;
               double editHeight = 0;
               System.out.print("\tLabel: ");
               editLabel = userInput.nextLine().trim();
               System.out.print("\tRadius: ");
               editRadius = Double.parseDouble(userInput.nextLine());
               System.out.print("\tHeight: ");
               editHeight = Double.parseDouble(userInput.nextLine());
               if (boxList.findHeartShapedBox(editLabel) != null) {
                  boxList.editHeartShapedBox(editLabel, editRadius, editHeight);
                  System.out.println("\t\"" + editLabel 
                     + "\" successfully edited\n");
               }
               else {
                  System.out.println("\t\"" + editLabel + "\" not found\n");
               }
               break;
         
            case 'Q':
               break;
         
            default:
               System.out.println("\t*** invalid code ***\n");
         }
      } while (choice != 'Q');
   }
}

