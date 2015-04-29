/*Kevin Dryzga
cs110
War Game Class
*/


public class WarGame
{
   
   private Deck deck;
   private CardPile player1;
   private CardPile player2;
   private int player;
   
   
  
   /**
      The contstructor creates a a Deck of Cards and deals them
      to two CardPiles player1 and player2.
   */   
   
   public WarGame()
   {
      //create deck
      deck = new Deck();
      deck.shuffle();
      
      //create player piles
      player1 = new CardPile();
      player2 = new CardPile();
      
      
      
      //deal deck
      while( deck.isEmpty() == false)
      {
         player1.addCard(deck.dealCard());
         player2.addCard(deck.dealCard());
      }
   }
   
   /**
      The play method plays a Card from each pile and determines which player wins,
      and adds the Cards to that players pile
   */
      
   public void play() throws IndexOutOfBoundsException
   {
      if(player1.isEmpty() == false && player2.isEmpty() == false)
      {
         Card c1 = player1.playCard();
         Card c2 = player2.playCard();
         if ( c1.compareTo(c2) == -1)
         {
            player2.addCard(c1);
            player2.addCard(c2);
         }
         else if (c1.compareTo(c2) == 1)
         {
            player1.addCard(c1);
            player1.addCard(c2);
         }
         else if (c1.compareTo(c2) == 0)
         {
            
            int value = war();
        
            if (value == 1)
            {
               player1.addCard(c1);
               player1.addCard(c2);
            }
            else if (value == 2)
            {
               player2.addCard(c1);
               player2.addCard(c2); 
            }     
         }
      }   
         
   }
   
   /**
      The war method initiates a war in which each players CardPile plays two cards
      and the second Cards are compared
      @return The player number who wins the war
   */   
   public int war() throws IndexOutOfBoundsException
   {
      int winner = winner();
      if ( winner == 0)
      {
      
         int player = 0;
       
         Card c3 = player1.playCard();
         Card c4 = player2.playCard();
         Card c5 = player1.playCard();
         Card c6 = player2.playCard();
          
         if ( c5.compareTo(c6) == -1)
         {
            player = 2;
            player2.addCard(c3);
            player2.addCard(c4);
            player2.addCard(c5);
            player2.addCard(c6);
         }
         else if (c5.compareTo(c6) == 1)
         {
            
            player = 1;
            player1.addCard(c3);
            player1.addCard(c4);
            player1.addCard(c5);
            player1.addCard(c6);
               
         }
         else if (c5.compareTo(c6) == 0)
         {
            
            int value = war();
           
            if (value == 1)
            {
               player = 1;
               player1.addCard(c3);
               player1.addCard(c4);
               player1.addCard(c5);
               player1.addCard(c6);
            }
            else if (value == 2)
            {
               
               player = 2;
               player2.addCard(c3);
               player2.addCard(c4);
               player2.addCard(c5);
               player2.addCard(c6);
            }        
         }
      }   
      else 
      {
         player = winner;
      }
            
            
      return player;
         
          
          
   }
   
   /**
      The winner method Determines if either CardPile is empty
      @return the player number which is empty or 0 if neither is empty
   */   
   public int winner()
   {
      player = 0;
      if (player1.isEmpty())
      {
         player = 2;
      }
      else if(player2.isEmpty())
      {
         player = 1;
      }
      else
      {
         player = 0;
      }
      return player;
   } 
   
   
   /**
      The getP1Card method gets the top Card and returns the jpg string
      @return the jpg String name
   */
      
   public String getP1Card() throws IndexOutOfBoundsException
   {
      Card card = player1.topCard();
      String str = card.toString();
      return str;
   } 
   
   /**
      The getP2Card method gets the top Card and returns the jpg string
      @return the jpg String name
   */
   
   public String getP2Card()
   {
      Card card = player2.topCard();
      String str = card.toString();
      return str;
   }             
   
   
   
}                       