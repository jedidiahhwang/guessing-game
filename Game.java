import java.util.Scanner;

/*

A number-guessing game.

*/

public class Game {
  public static void main(String[] args){
    // Put your code here
    int num = 34;
    int counter = 1;

    System.out.println("Greetings, what is your name?");
    Scanner scanner = new Scanner(System.in);
    String userInputName = scanner.nextLine();

    System.out.println(String.format("%s, pick a number between 1 and 100.", userInputName));
    int numGuess = scanner.nextInt();
    while(numGuess != num) {
      counter++;
      if(numGuess > num) {
        System.out.println("Your number is too high.");
      } else {
        System.out.println("Your number is too low.");
      }
      System.out.println("Guess again.");
      numGuess = scanner.nextInt();
    }

    System.out.println(String.format("%s, you found my number in %d", userInputName, counter));
  }

}
