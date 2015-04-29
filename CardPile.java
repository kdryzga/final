/* Kevin Dryzga
cs110
card pile class
*/

import java.util.ArrayList;
public class CardPile extends Deck
{
   // ArrayList of Card objects
   private ArrayList<Card> pile;
   
   
   /**
      The constructor intializes an ArrayList of Cards
   */
      
   public CardPile() 
   {
      pile = new ArrayList<Card>();
   }
   
   /**
      The addCard method Adds a card to the end of the ArrayList
      @param c The Card to add
   */
      
   public void addCard(Card c)
   {
      pile.add(c);
   }
   
   
   /**
      The playCard method gets the Card from the beginning of the ArrayList and removes it
      @return The Card at the beginning of the ArrayList
   */
      
   public Card playCard()
   {
      Card card;
      card = pile.get(0); 
      pile.remove(0);
         
      return card;
      
   }
   
   /**
      The topCard method gets the Card from he beginning of the ArrayList
      @return the Card at the beginning of the ArrayList
   */
      
   public Card topCard()
   {
      Card card = pile.get(0);
      return card;
   }   
}      


       