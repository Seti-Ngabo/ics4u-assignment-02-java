/*
* This is the string blowup program
*
* @author  Seti Ngabo
* @version 11.0.16
* @since   2022-10-10
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This is the Blowup class.
 */

class Blowup {
  /**
   * The function replaces the number in the string to letters on its right.
   */
// process
  static String blowup(String string) {
    List<String> logic = new ArrayList<String>();
    String firstString;
    ArrayList<String> finalOutput = new ArrayList<String>();
    String secondString;
    int firstInt = -1;
    int secondInt = -1;
    final String outString;
    logic = Arrays.asList(string.split(""));
    for (int count = 0; count < logic.size(); count++) {
      firstString = logic.get(count);
      int newInt1 = 1;
      int newInt2 = 1;
      char newString = firstString.charAt(0);
      if (Character.isDigit(newString)) {
        newInt1 = 1;
      } else {
        newInt1 = 0;
      }
      // if the firstString is not the last character in the string
      if (count + 1 != logic.size()) {
        secondString = logic.get(count + 1);
        char secondNewStr = secondString.charAt(0);
        if (Character.isDigit(secondNewStr)) {
          newInt2 = 1;
        } else {
          newInt2 = 0;
        }
        if (newInt1 == 1 && newInt2 == 0) {
          firstInt = Integer.parseInt(firstString);
          for (int i = 1; i < firstInt; i++) {
            finalOutput.add(secondString);
          }
          continue;
        } else if (newInt1 == 1 && newInt2 == 1) {
          continue;
        } else {
          finalOutput.add(firstString);
          continue;
        }
      } else {
        if (newInt1 == 1) {
          continue;
        } else {
          finalOutput.add(firstString);
        }
      }
    }
    outString = String.join("", finalOutput);
    return outString;
  }

// Input & Output
  public static void main(String[] args) {
    String newStr;
    Scanner ppr = new Scanner(System.in);
    System.out.print("Enter any string with numbers: ");
    String userInput = ppr.next();
    if (userInput.equals(null)) {
      System.out.println("\nInsert a string with numbers!");
    } else {
      newStr = blowup(userInput);
      System.out.println(newStr);
    }
    System.out.println("\nDone.");
  }
}
