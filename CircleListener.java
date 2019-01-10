import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;
import javax.swing.event.ChangeEvent;

public class CircleListener implements FocusListener, MouseListener, ActionListener
{

   private CirclePanel circlePanel;
   private HudPanel hudPanel;
   private Timer timer = new Timer(30, this);
   private boolean paused = false;
   Point circlePanelLoc;
   private boolean mouseOnScreen = true;


   public CircleListener(CirclePanel circlePanel, HudPanel hudPanel){
      this.circlePanel = circlePanel;
      this.hudPanel = hudPanel;
      circlePanel.addMouseListener(this);
      circlePanel.addFocusListener(this);
      timer.start();
   }



   public void stateChanged(ChangeEvent e)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseClicked(MouseEvent e)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void mousePressed(MouseEvent e)
   {
      // TODO Auto-generated method stub
      circlePanel.requestFocusInWindow();

   }

   @Override
   public void mouseReleased(MouseEvent e)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseEntered(MouseEvent e)
   {
      // TODO Auto-generated method stub
      mouseOnScreen = true;
   }

   @Override
   public void mouseExited(MouseEvent e)
   {
      // TODO Auto-generated method stub
      mouseOnScreen = false;

   }

   @Override
   public void focusGained(FocusEvent e)
   {
      // TODO Auto-generated method stub
   }

   @Override
   public void focusLost(FocusEvent e)
   {
      // TODO Auto-generated method stub

   }


   //check for menu items pressed you nerd
   @Override
   public void actionPerformed(ActionEvent e)
   {
      if(circlePanel.getCurrentLives() <= 0) {
         paused = true;
         timer.stop();
      }
      
      String s = e.getActionCommand();
      if(s != null) {
         if(s.equals("Restart")) {
            if(paused)
               timer.start();
            circlePanel.restart();
         }
         else if(s.equals("Quit")) {
            System.exit(0);
         }
         else if(s.equals("Pause")) {
            if(paused)
               timer.start();                  
            else 
               timer.stop();            
            paused = !paused;
         }
         else if(s.equals("Light Theme")) {
            hudPanel.lightTheme();
            circlePanel.lightTheme();
         }
         else if(s.equals("Dark Theme")) {
            hudPanel.darkTheme();
            circlePanel.darkTheme();
         }
         else if(s.equals("Easy")) {   
            circlePanel.restart();
            circlePanel.easyDifficulty();
         }
         else if(s.equals("Medium")) {
            circlePanel.restart();
            circlePanel.mediumDifficulty();

         }
         else if(s.equals("Hard")) {
            circlePanel.restart();
            circlePanel.hardDifficulty();    
         }
         
      }

      try {
         if(mouseOnScreen) {
            circlePanelLoc = circlePanel.getLocationOnScreen();
            circlePanel.updateUserPosition((int)(MouseInfo.getPointerInfo().getLocation().getX() - circlePanelLoc.getX()), 
                  (int)(MouseInfo.getPointerInfo().getLocation().getY() - circlePanelLoc.getY()));
         }
      }
      catch(Exception e1) {

      }
      circlePanel.doActions();      
   }

}
