import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.*;

public class CircleMenuBar extends JMenuBar
{
 
   private JMenu Game = new JMenu("Game");
   private JMenuItem Restart = new JMenuItem("Restart");
   private JMenuItem Quit = new JMenuItem("Quit");

   private JMenu Options = new JMenu("Options");
   private JMenuItem Pause = new JMenuItem("Toggle Pause");
   private JMenuItem LightTheme = new JMenuItem("Light Theme");
   private JMenuItem DarkTheme = new JMenuItem("Dark Theme");

   private JMenu Difficulty = new JMenu("Difficulty");
   private JMenuItem Easy = new JMenuItem("Easy");
   private JMenuItem Medium = new JMenuItem("Medium");
   private JMenuItem Hard = new JMenuItem("Hard");

   ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();

   //add Dark Theme Compaatability

   public CircleMenuBar(CircleListener listener){
      add(Game);
      Game.add(Restart);
      Game.add(Quit);

      add(Options);
      Options.add(Pause);
      Options.add(LightTheme);
      Options.add(DarkTheme);

      add(Difficulty);
      Difficulty.add(Easy);
      Difficulty.add(Medium);
      Difficulty.add(Hard);

      menuItems.add(Restart);
      menuItems.add(Quit);
      menuItems.add(Pause);
      menuItems.add(LightTheme);
      menuItems.add(DarkTheme);
      menuItems.add(Easy);
      menuItems.add(Medium);
      menuItems.add(Hard);

      for(JMenuItem item: menuItems) {
         item.addActionListener(listener);  
      }

   }



}
