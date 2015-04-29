/*Kevin Dryzga
cs110
Deck Class
assissted by Jackie Horton
*/

import java.util.Random;
public class Deck 
{
   //number of card in a standard deck
   public final static int CARDS_IN_DECK = 52;

   //card array
   private Card [] deck;
   //Current number of Cards in Deck 
   private int ct;
   
   /**
      The Constructor creates a regular 52-card deck in sorted order
   */
   public Deck()
   {
      freshDeck();
   }
   /**
      The freshDeck method creates a fresh 52 card deck in sorted order
   */
   public void freshDeck()
   {
      deck = new Card[CARDS_IN_DECK];
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
            deck[ct]=new Card(r,s);
            ct = ct + 1;
         }
      }
     
   
   }
   
   /** 
       The dealCard method Removes and return the top Card on the Deck
       @return A reference to a Card that was top on the Deck
   */
   public Card dealCard()
   {
      ct--;
      return deck[0];
   }
   
   /** 
       The cardsRemaining method Returns the current number of Cards in Deck
       @return number of Cards in Deck
   */
   public int cardsRemaining()
   {  
      return ct;
   }
   
   /** 
      The shuffle method Randomizes the order of Cards in Deck
   */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < ct; i++)
      {
         randNum = r.nextInt(ct);
         temp = deck[i];
         deck[i]=deck[randNum];
         deck[randNum]=temp;
      }
   }
   
   /** 
       The isEmpty method Determines if Deck is empty
       @return true if there are no more cards, false otherwise
   */
   public boolean isEmpty()
   {
      return (cardsRemaining() == 0);
   }

}   

