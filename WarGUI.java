/* Kevin Dryzga
cs110
WarGUI
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   //variables/constants
   private WarGame game;
   private final int WINDOW_HEIGHT = 600;
   private final int WINDOW_WIDTH = 800;
   private final int CARD_WIDTH = 154;
   private final int CARD_HEIGHT = 215;
   
   private String p1Card, p2Card;
   
   //gui components
   private JPanel titlePanel, p1Panel, p2Panel, gamePanel, buttonPanel;
   private JLabel title, p1Back, p2Back, player1, player2, p1Face, p2Face, p1Space, p2Space, winnerMsg;
   private JButton play;
   private ImageIcon back, face1, face2;
   
   
   /**
      The constructor creates a new WarGUI frame
   */
      
   public WarGUI()
   {
      
      game = new WarGame();
      //intialize window
      setTitle("WAR");
      setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      setLayout(new BorderLayout());
      
      //set panels
      titlePanel = new JPanel();
      titlePanel.setBackground(Color.BLUE);
      add(titlePanel, BorderLayout.NORTH);
      titlePanel.setVisible(true);
      
      p1Panel = new JPanel();
      p1Panel.setLayout(new BorderLayout());
      add(p1Panel, BorderLayout.WEST);
      
      p2Panel = new JPanel();
      p2Panel.setLayout(new BorderLayout());
      add(p2Panel, BorderLayout.EAST);
      
      gamePanel = new JPanel();
      gamePanel.setLayout( new GridLayout(1,2));
      add(gamePanel, BorderLayout.CENTER);
      
      buttonPanel = new JPanel();
      buttonPanel.setBackground(Color.BLUE);
      add(buttonPanel, BorderLayout.SOUTH);
      
      
      //titlePanel
      title = new JLabel("GAME OF WAR");
      title.setFont( new Font("ARIAL", Font.BOLD, 28));
      titlePanel.add(title);
      
      //buttonPanel
      play = new JButton("PLAY");
      play.setPreferredSize(new Dimension(80,60));
      play.setBackground(Color.WHITE);
      play.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
      play.addActionListener(new PlayButtonListener());
      buttonPanel.add(play);
      
      //playerPlanels
      player1 = new JLabel("Player 1");
      player2 = new JLabel("Player2");
      p1Panel.add(player1, BorderLayout.NORTH);
      p2Panel.add(player2, BorderLayout.NORTH);
      
      back = new ImageIcon("cardpics/back.jpg");
      p1Back = new JLabel(back);
      p2Back = new JLabel(back);
      p1Panel.add(p1Back, BorderLayout.CENTER);
      p2Panel.add(p2Back, BorderLayout.CENTER);
      
      //gamePanel
      p1Space = new JLabel(back);
      p2Space = new JLabel(back);
      gamePanel.add(p1Space);
      gamePanel.add(p2Space);
      p1Space.setVisible(false);
      p2Space.setVisible(false);
      
      
      //display window
      pack();
      setVisible(true);
   }
   
   /**
      PlayButtonListener creates an action event for the play buttton
   */   
   private class PlayButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //get card picture jpg strings
         p1Card = game.getP1Card();
         p2Card = game.getP2Card();
         //add card picture to image icon
         face1 = new ImageIcon(p1Card);
         face2 = new ImageIcon(p2Card);
         //add imageicon to jlabel
         p1Face = new JLabel(face1);
         p2Face = new JLabel(face2);
         //play a hand
         game.play();
         //display cards
         p1Face.setVisible(true);
         p2Face.setVisible(true);
         
         //determine if there is a winner
         int winner = game.winner();
         if (winner != 0)
         {
            play.setEnabled(false);
            if (winner == 1)
            {
               winnerMsg = new JLabel("Player 1 Wins!");
               titlePanel.add(winnerMsg);
               setVisible(false);
                
            }
            else if (winner == 2)
            {
               winnerMsg = new JLabel("Playeer 2 Wins!");
               titlePanel.add(winnerMsg);
               setVisible(false);
            }
         }             
         
      }
      
   }      
         
   
   
}      