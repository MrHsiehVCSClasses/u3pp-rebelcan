package u3pp;
import java.util.Scanner;


public class Blackjack {

    private Deck d;
    private Card[] userHand;
    private Card[] dealerHand;
    private String name;

    public Blackjack(String n) {
        d = new Deck();
        userHand = new Card[0];
        dealerHand = new Card[0];
        name = n;
    }

    private Card[] addCard(Card[] hand) {
        
        int n = hand.length;
        Card[] newHand = new Card[n + 1];

        for (int i = 0; i < n; i++) {
            newHand[i] = hand[i];
        }

        newHand[n] = d.deal();
        return newHand;
        
    }

    private String printCards(Card[] hand) {

        String cards = "";

        for (int i = 0; i < hand.length; i++) {
            cards += hand[i] + " & ";
        
        }

        return cards.substring(0, cards.length() - 3);
    }

    public void play (Scanner scanner) {
        
        boolean keepPlaying = true;
        boolean gameNotOver = true;

        userHand = addCard(userHand);
        dealerHand = addCard(dealerHand);
        userHand = addCard(userHand);
        dealerHand = addCard(dealerHand);

        System.out.println("Your Hand: " + printCards(userHand));
        System.out.println("Dealer's Hand: " + printCards(dealerHand));

        if (isBlackjack(userHand) && isBlackjack(dealerHand)){
            System.out.println("Result: User Pushes");
        }
        else if (isBlackjack(userHand)){
            System.out.println("Congrats " + name + " you got a BlackJack!");
            keepPlaying = false;
            gameNotOver = false;
        }
        else if (isBlackjack(dealerHand)){
            System.out.println("Result: User Loses");
            keepPlaying = false;
            gameNotOver = false;
        }

        while (keepPlaying) {
            System.out.print("Would you like to (H)it or (S)tay?: ");
            String hitOrStand = scanner.nextLine();

            if (hitOrStand.toLowerCase().equals("h") || hitOrStand.toLowerCase().equals("hit")) {
                userHand = addCard(userHand);
                System.out.println("Your new hand: " + printCards(userHand));

                if (isBust(userHand)) {
                    keepPlaying = false;
                    gameNotOver = false;
                    System.out.println(name + " I'm so sorry you busted!");
                    System.out.println("Result: User Loses");
                }
                
            } 
            else if (hitOrStand.toLowerCase().equals("s") || hitOrStand.toLowerCase().equals("stay")) {
                keepPlaying = false;
                while (shouldDealerKeepHitting(dealerHand)) {
                    dealerHand = addCard(dealerHand);
                }
            } 
            else {
                System.out.println("Invalid input, try again");
            }
        }
        
        if (gameNotOver) {
            
            System.out.println("Your Hand: " + printCards(userHand));
            System.out.println("Dealer's Hand: " + printCards(dealerHand));

            if (isBust(dealerHand)) { 
                System.out.println("Result: User Wins");
            } 
            else {
                System.out.println("Result: " + determineResult(userHand, dealerHand));
            }

        }
        
        
        Boolean goAgain = true;
        
        while(goAgain) {

            System.out.print("Would you like to play again? (Y)es/(N)o: ");
            String answer = scanner.nextLine();

            if (answer.toLowerCase().equals("no") || answer.toLowerCase().equals("n")){
                System.out.println("Thanks for playing " + name + "! Have a great day!");
                goAgain = false;
            } 
            else if (answer.toLowerCase().equals("yes") || answer.toLowerCase().equals("y")){
                userHand = new Card[0];
                dealerHand = new Card[0];
                goAgain = false;
                play(scanner);
            } 
            else {
                System.out.println("Invalid input, try again");
            }

        }
    }
      
    public static int calcPoints(Card[] hand) {
        int totalpoints = 0;
        for (Card c: hand){
            if (c != null) {
                if (c.getValue().equals("Ace")){
                    totalpoints+= 11;
                }
                else if (c.getValue().equals("Jack")||c.getValue().equals("King")||c.getValue().equals("Queen")){
                    totalpoints+= 10;
                }
                else totalpoints+= Integer.parseInt(c.getValue());
            }
        }
        return totalpoints;
    }

    public static String determineResult(Card[] userHand, Card[] dealerHand) {
        if (isBlackjack(userHand) && isBlackjack(dealerHand)){
            return "User Pushes";
        }
        else if (isBlackjack(userHand)){
            return "User Wins";
        }
        else if (isBlackjack(dealerHand)){
            return "User Loses";
        }
        else if (isBust(dealerHand)){
            return "User Wins";
        }
        else if (isBust(userHand)){
            return "User Loses";
        }
        else if (calcPoints(dealerHand)>calcPoints(userHand)){
            return "User Loses";
        }
        else if (calcPoints(userHand)>calcPoints(dealerHand)){
            return "User Wins";
        }
        return "User Pushes";
    }  
      
    public static boolean isBust(Card[] hand) {
        return calcPoints(hand) > 21;
    }

    public static boolean isBlackjack (Card[] hand) {
        if (hand.length > 2) {
            return false;
        }
        return calcPoints(hand) == 21;
    }

    public static boolean shouldDealerKeepHitting (Card[] hand) {
        return calcPoints(hand) <= 16;
    }
}


