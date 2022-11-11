package u3pp;
import java.util.Arrays;

public class Deck {
    private Card[] deck;
    private int cardsUsed;
    public Deck(){
        deck = new Card[52];
        String[] values = Card.VALUES;
        String[] suits = Card.SUITS;
        int index = 0;
        for (int i = 0; i < values.length; i++){
            for (int j = 0; j <suits.length; j++){
                deck[index] = new Card(suits[j], values[i]);
                index++;
            }
            
        }
        shuffle();
        // System.out.println(Arrays.toString(deck));
        cardsUsed = 0;

    }
    public void shuffle(){
        for (int i = 51; i > 0; i--){
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck [i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;
    }
    public Card deal(){
        if (cardsUsed == 52)
            shuffle();
        cardsUsed++;
        return deck[cardsUsed-1];
    }
    public int numLeft(){
        return 52 - cardsUsed;
    }
}
// public void shuffle(){
//     int[] indice = new int[52];
//     Card[] shuffled = new Card[52];
//     for (int i = 0; i < 52; i++){
//         int rnd = (int)(Math.random()*52);
//         while (contains(indice, rnd)){
//             rnd = (int)(Math.random()*52);
//         }
//         indice[i] = rnd;
//         shuffled[i] = cards[rnd];
//     }
//     cards = shuffled;
//     dealt = 0;
// }
// private boolean contains(int[] a, int b){
//     for (int i = 0; i < a.length; i++){
//         if (a[i] == b){
//             return true;
//         }
//     }
//     return false;
// }

// public int numLeft(){
//     return 52-dealt;
// }
// public card Deal(){
//     dealt++
//     return cards[cards.length-dealt-1];
//}


//      Card[] deck = new Card[52];
    
//     public Deck(){
        
//         this.cards = new Card[52];
//         for (int i = 0; i < 52; i++) {
//             Card card = new Card();
//             this.cards[i] = card;
//         }
//     public Card deal(){

//     }
    
        
//     }
// }
