import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class HudPanel extends JPanel 
{

   private Color backgroundColor = Color.WHITE;
   private int maxLives = 3;
   private int currentLives = 3;
   private int score = 0;
   private Color circleAndTextColor = Color.BLACK;
   private String currentDifficulty;

   public void update(int currentLives, int maxLives, int score, String currentDifficulty) {
      this.currentLives = currentLives;
      this.maxLives = maxLives;
      this.score = score;
      this.currentDifficulty = currentDifficulty;
      repaint();
   }

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      this.setBackground(backgroundColor);

      g.setColor(circleAndTextColor);
      g.drawString("Score: " + score, 25, 20);

      for(int i = 0; i < maxLives; i++) {
         g.drawOval(600 + i * 40, 20, 15, 15);
      }

      for(int i = 0; i < currentLives; i ++) {
         g.setColor(Color.RED);
         g.fillOval(600 + i * 40, 20, 15, 15);
      }
      
      g.setColor(circleAndTextColor);
      g.drawString(currentDifficulty, 330, 30);
   }

   public void lightTheme() {
      backgroundColor = Color.WHITE;
      circleAndTextColor = Color.BLACK;
   }

   public void darkTheme() {
      backgroundColor = Color.BLACK;
      circleAndTextColor = Color.WHITE;
   }
}

