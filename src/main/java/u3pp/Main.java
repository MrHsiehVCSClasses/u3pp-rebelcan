package u3pp;
import java.util.*;

public class Main {
        
        
        // Use this space to test your code, or actually run your project
        public static void main(String[] args) {
            // System.out.println(PalindromeTester.isPalindrome("mom"));
            // System.out.println(PalindromeTester.isPalindrome("RacEcAr"));

            Deck myDeck = new Deck();
            // System.out.println (myDeck);
            System.out.println("Hi, welcome to Blackjack! What is your name?");
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            System.out.println("Hello " + name + " ! I am Gambletron 5000! Let's play some cards.");
            Blackjack bj = new Blackjack(name);
            bj.play(input);
        }
        
        
}          
        


