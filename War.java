
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
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
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
