/*Kevin Dryzga
cs110
Card Class*/



public class Card
{
   //constants and variables
   public final static int SPADES = 1, CLUBS = 2, HEARTS = 3, DIAMONDS = 4, ACE = 13 , JACK = 10, QUEEN = 11, KING = 12;
   private int rank;
   private int suit;
   
   
   /**
      Contructor
      @param suit The suit of the card in an int
      @param rank The int rank of the card
   */
      
   public Card(int suit, int rank)
   {
   
      this.suit = suit;
      this.rank = rank;
      
   }
   
   /**
      The getSuit method returns the suit of the card as an int
      @return suit The suit of the card as an int
   */
      
   public int getSuit()
   {
      
      return suit;
   }
   
   
   /**
      The getRank method returns the int rank of the card
      @return rank The rank of the card
   */
      
   public int getRank()
   {
      
      return rank;
   }
   
   /**
      The toString method returns the String of the card as a jpg name
      @return The String jpg name
   */   
   
   public String toString()
   {
      String str1= ""; 
      
      if (rank < 10)
      {
         str1 = str1 + rank;
      }
      else if (rank == JACK)
      {
         str1 = "jack";
      }
      else if (rank == QUEEN)
      {
         str1 = "queen";
      }
      else if (rank == KING)
      {
         str1 = "king";
      }
      else if (rank == ACE)
      {
         str1 = "ace";
      }
      
      ////
      String str2 = "";
      
      if (suit == SPADES)
      {
         str2 = "s";
      }
      else if (suit == CLUBS)
      {
         str2 = "c";
      }
      else if (suit == HEARTS)
      {
         str2 = "h";
      }
      else if (suit == DIAMONDS)
      {
         str2 = "d";
      }
      
      String str3 = str1 + str2+ ".jpg";
      
      return str3;
                 
   }
   
   /**
      The compareTo method compares the rank of two cards
      @param otherCard The card to compare to
      @return An int. 0 if equal, -1 if card is less than otherCard, and
      1 if card is more than otherCard
   */   
   
   public int compareTo(Card otherCard)
   {
      int value = 0;
      if (rank == otherCard.getRank())
      {
         value = 0;
         
      }
      else if (rank < otherCard.getRank())
      {
         value = -1;
         
      }
      else if (rank > otherCard.getRank())
      {
         value = 1;
         
      }
      return value;   
   }
   
   
   
}   