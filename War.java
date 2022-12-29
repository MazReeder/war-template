
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
import java.util.ArrayList;
import java.util.List;

public class War
{
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        Deck Filbur = new Deck();
        Filbur.initializeNewDeck();
        Filbur.shuffle();
        System.out.println(Filbur.getDeckSize());
        
        Deck[] Player = Filbur.dealDeck();
        
        // ...then run the event loop
        this.runEventLoop(Player);
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(Deck[] Player) {
       System.out.println(Player[0].getDeckSize()); 
       System.out.println(Player[1].getDeckSize());
       
       Card p1Card;
       Card p2Card;
       
       List<Card> warCards = new ArrayList<Card>();
       int iterations = 0;
       
       while(Player[0].getDeckSize() > 0 || Player[1].getDeckSize() > 0) {
           System.out.println("");
           System.out.println("Turn " + (iterations + 1));
           
           p1Card = Player[0].dealCardFromDeck();
           System.out.print("Player 1 plays " + p1Card.getFace() + " of ");
           System.out.println(p1Card.getSuit());
           p2Card = Player[1].dealCardFromDeck();
           System.out.print("Player 2 plays " + p2Card.getFace() + " of ");
           System.out.println(p2Card.getSuit());
           if(p1Card.getRank() > p2Card.getRank()) {
               System.out.println("Player 1 wins this one!");
               for(int i = 0; i < warCards.size(); i++) {
                   Player[0].addCardToDeck(warCards.get(i));
                   warCards.remove(i);
               }
               Player[0].addCardToDeck(p1Card);
               Player[0].addCardToDeck(p2Card);
           }
           //when one players card is greater than anothers
           if(p2Card.getRank() > p1Card.getRank()) {
               System.out.println("Player 2 wins this one!");
               for(int i = 0; i < warCards.size(); i++) {
                   Player[1].addCardToDeck(warCards.get(i));
                   warCards.remove(i);
               }
               Player[1].addCardToDeck(p1Card);
               Player[1].addCardToDeck(p2Card);
           }
           //when a war is triggered
           if(p1Card.getRank() == p2Card.getRank()) {
               System.out.println("WAR!");
               if(Player[0].getDeckSize() < 4) {
                   System.out.println("");
                   System.out.println("Player 2 wins!(player 1 is trash)");
                   break;
               }
               else if(Player[1].getDeckSize() < 4) {
                   System.out.println("");
                   System.out.println("Player 1 wins!(player 2 is trash)");
                   break;
               }
               else {
                   warCards.add(Player[0].dealCardFromDeck());
                   warCards.add(Player[0].dealCardFromDeck());
                   warCards.add(Player[0].dealCardFromDeck());
                   warCards.add(Player[1].dealCardFromDeck());
                   warCards.add(Player[1].dealCardFromDeck());
                   warCards.add(Player[1].dealCardFromDeck());
                   warCards.add(p1Card);
                   warCards.add(p2Card);
               }
           }
           //what happens when 300 turns go by
           iterations++;
           if(iterations == 300) {
               if(Player[0].getDeckSize() > Player[1].getDeckSize()) {
                  System.out.println("");
                  System.out.println("Player 1 wins!(player 2 gave it their all and came up short)");
                  break;
               }
               if(Player[1].getDeckSize() > Player[0].getDeckSize()) {
                  System.out.println("");
                  System.out.println("Player 2 wins!(player 1 gave it their all and came up short)");
                  break;
               }
               if(Player[0].getDeckSize() == Player[1].getDeckSize()) {
                  System.out.println("");
                  System.out.println("It's a tie(wow very rare)!");
                  break;
               }
           }
       }
       System.out.println("");
       System.out.println("GAME OVER");
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
