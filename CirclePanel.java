import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;

public class CirclePanel extends JPanel
{

   //GameTracking
   private int score = 0;
   private int currentLives = 3;
   private int maxLives = 3;
   private String currentDifficulty = "Medium";
   private int collisionRecent = 0;

   //Settings
   private double spawnRate;
   private int maxSpeed = 8;

   //Cosmetic
   private Color backgroundColor;
   private Color outlineColor = Color.BLACK;

   //Objects
   UserCircle userCircle = new UserCircle();
   ArrayList<OtherCircle> otherCircles = new ArrayList<OtherCircle>();
   private HudPanel hudPanel;

   public CirclePanel(HudPanel hudPanel) {
      this.setFocusable(true);
      userCircle.setRadius(15);
      lightTheme();
      mediumDifficulty();
      currentLives = maxLives;
      this.hudPanel = hudPanel;
   }

   public void easyDifficulty() {
      currentDifficulty = "Easy";
      score = 0;
      spawnRate = 0.45;
      maxSpeed = 3;
      maxLives = 4;
      currentLives = 4;
      otherCircles.clear();
   }

   public void mediumDifficulty() {
      currentDifficulty = "Medium";
      score = 0;
      spawnRate = 0.55;
      maxSpeed = 5;
      maxLives = 3;
      currentLives = 3;
      otherCircles.clear();
   }

   public void hardDifficulty() {
      currentDifficulty = "Hard";
      score = 0;
      spawnRate = 0.65;
      maxSpeed = 8;
      maxLives = 2;
      currentLives = 2;
      otherCircles.clear();
   }

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      this.setBackground(backgroundColor);
      userCircle.draw(g);

         if(collisionRecent > 0) {
         g.setColor(Color.RED);
         g.fillRect(0, 0, 800, 520);
         collisionRecent--;
      }
      
      for(OtherCircle item: otherCircles) {
         item.draw(g);
      }

   }

   public void doActions() {
      hudPanel.update(currentLives, maxLives, score, currentDifficulty);
      spawnCircles();
      collisionCheck();
      for(OtherCircle circle: otherCircles) {
         circle.move();
      }
      despawnCircles();
      repaint();
   }


   public boolean collisionCheck() {
      for(int i = 0; i < otherCircles.size(); i++) {
         if( Math.hypot(userCircle.getX() - otherCircles.get(i).getX(), userCircle.getY() - otherCircles.get(i).getY()) 
               < userCircle.getRadius() + otherCircles.get(i).getRadius()) {
            currentLives--;
            otherCircles.remove(i);
            collisionRecent = 5;
            return true;
         }
      }
      return false;
   }


   public void restart() {
      score = 0;

      if(currentDifficulty.equals("Easy"))
         easyDifficulty();
      else if(currentDifficulty.equals("Medium"))
         mediumDifficulty();
      else
         hardDifficulty();

      otherCircles.clear();
   }

   public void spawnCircles() {
      if(Math.random() < spawnRate) {
         otherCircles.add(new OtherCircle(maxSpeed, outlineColor));
      }
   }

   public void despawnCircles() {
      for(int i = 0; i < otherCircles.size(); i++ ) {
         if(Math.abs(otherCircles.get(i).getX() - otherCircles.get(i).getInitialX()) > 1100) {
            otherCircles.remove(otherCircles.get(i));
            score++;
         }
         else if(Math.abs(otherCircles.get(i).getY() - otherCircles.get(i).getInitialY()) > 800) {
            otherCircles.remove(otherCircles.get(i));
            score++;
         }
      }

   }

   public void updateUserPosition(int x, int y) {
      userCircle.setX(x);
      userCircle.setY(y);
   }
   public void lightTheme(){
      backgroundColor = Color.GRAY;
      userCircle.setOutlineColor(Color.BLACK);

      for(Circle item: otherCircles) {
         item.setOutlineColor(Color.BLACK);
      }
      outlineColor = Color.BLACK;
   }


   public void darkTheme(){
      backgroundColor = Color.DARK_GRAY;
      userCircle.setOutlineColor(Color.WHITE);

      for(Circle item: otherCircles) {
         item.setOutlineColor(Color.WHITE);
      }
      outlineColor = Color.WHITE;
   }

   public int getCurrentLives() {
      return currentLives;
   }

}