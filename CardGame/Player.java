import java.util.ArrayList;
import java.util.Random;

public class Player {
    Random r = new Random();
    
    private String name;
    private int lives;
    ArrayList<Card> deck;
    ArrayList<Card> hand;
    ArrayList<Card> discard;
    
    public Player(String names, int health) {
        name = names;
        lives = health;
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        discard = new ArrayList<Card>();
    }
    
    public String getName() {
        return name;
    }
    
    public int getLives() {
        return lives;
    }
    
    public void setLives(int newLives) {
        lives = newLives;
    }
    
    //gets the sizes of the arrays
    public int getDeckSize() {
        return deck.size();
    }
    
    public int getHandSize() {
        return hand.size();
    }
    
    public int getDiscardSize(){
        return discard.size();
    }
    
    public void createDeck() {
        //creates 3 cards of each special sub type
        for (int i = 0; i < 3; i++) {
            LightGrapple c = new LightGrapple("Light Grapple");
            deck.add(c);
        }
        for (int i = 0; i < 3; i++) {
            MediumGrapple c = new MediumGrapple("Medium Grapple");
            deck.add(c);
        }
        for (int i = 0; i < 3; i++) {
            HeavyGrapple c = new HeavyGrapple("Heavy Grapple");
            deck.add(c);
        }
        for (int i = 0; i < 3; i++) {
            LightStrike c = new LightStrike("Light Strike");
            deck.add(c);
        }
        for (int i = 0; i < 3; i++) {
            MediumStrike c = new MediumStrike("Medium Strike");
            deck.add(c);
        }
        for (int i = 0; i < 3; i++) {
            HeavyStrike c = new HeavyStrike("Heavy Strike");
            deck.add(c);
        }
        for (int i = 0; i < 3; i++) {
            LifeShield c = new LifeShield("Life Shield");
            deck.add(c);
        }
        for (int i = 0; i < 3; i++) {
            LightShield c = new LightShield("Light Shield");
            deck.add(c);
        }
        for (int i = 0; i < 3; i++) {
            HeavyShield c = new HeavyShield("Heavy Shield");
            deck.add(c);
        }
    }
    
    //adds a card to hand
    public void addCard(Card c) {
        hand.add(c);
    }
    
    //removes card from hand and adds to discard
    public void removeCard(int index) {
        discard.add(hand.get(index));
        hand.remove(hand.get(index));
    }
    
    //discard every card in hand and adds to discard pile
    public void discardHand() {
        for(int i = 0; i < hand.size(); i++) {
            discard.add(hand.get(i));
            hand.remove(i);
        } 
    }
    
    //returns a specific card from hand
    public Card getCard(int index) {
        return hand.get(index);
    }
    
    public void draw() {
        //simulates deck being shuffled and a card drawn. creates a random number, goes to the array and gets the card at the random index, adds to hand, removes from deck
        if(deck.size() > 0) {
            int num = r.nextInt(deck.size());
            hand.add(deck.get(num));
            discard.add(deck.get(num));
            deck.remove(deck.get(num));
        } else {
            System.out.println(name + " is out of cards in the deck, only cards already in hand can be used");
        }
    }
    
    //prints all the cards in hand
    public void printHand() {
        System.out.println("Cards in your hand");
         for(int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i));
        }
    }
    
    public String toString() {
        return name + " Lives Remaining: " + lives;
    }
}