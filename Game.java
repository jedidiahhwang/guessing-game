import java.util.Scanner;
import java.util.Random;

/*

A number-guessing game.

Using Scanner and Random packages, we will ask users for inputs until they guess the right number.

*/

public class Game {
  public static void main(String[] args){

    // Create a new Random instance. Declare its upper bound to be 100 (1-100).
    Random rand = new Random();
    int num = rand.nextInt(100);

    // Initialize the counter.
    int counter = 0;

    // Grab the user's name input.
    System.out.println("Greetings, what is your name?");
    Scanner scanner = new Scanner(System.in);
    String userInputName = scanner.nextLine(); // Expects of type string input.

    // Using string formatting, ask the user to provide a number.
    System.out.println(String.format("%s, pick a number between 1 and 100.", userInputName));

    // The following logic will run the scanner until the number is found.
    // The argument of "true" is a way to ensure it keeps running.
    // Breaking out of the loop is how we will wnd its functionality.
    // Could also try a for loop, where your condition is if your guess is not equal to the number.
    while(true) {
      int numGuess; // Declare a variable to be your guess.

      // The following try catch block will check if the input is a number or not.
      // Using a catch with an exception, the try catch will continue until a number is provided.
      // Continue stops the loop where it is, but will rerun the loop (doesn't break out).
      try {
        numGuess = Integer.parseInt(scanner.next());
      } catch(Exception e) {
        System.out.println("Please input an integer.");
        continue;
      }

      // Check if guess is in the range.
      if (numGuess < 1 || numGuess > 100){
        System.out.println(String.format("%d is not in the valid range, try again.", numGuess));
        continue;
      }

      counter++; // Increment the counter.

      // Basic logic to tell if your guess is too high or too low.
      if(numGuess > num) {
        System.out.println("Your number is too high.");
      } else if(numGuess < num) {
        System.out.println("Your number is too low.");
      } else if(numGuess == num) {
        System.out.println(String.format("%s, you found my number in %d tries.", userInputName, counter));
        break; // If you've guessed correctly, break out of the loop.
      }

      // Since you need to guess again if it's both too high or low, just throw this at the end.
      // Don't violate DRY.
      System.out.println("Guess again.");
    }
  }
}
