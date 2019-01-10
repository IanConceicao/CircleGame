import java.awt.*;
import javax.swing.*;

public class CircleMain
{

   public static void main(String[] args) {
      
      JFrame window = new JFrame("Circle Game");
      JPanel container = new JPanel();
      container.setLayout(new BorderLayout());
      
      HudPanel hudPanel = new HudPanel();
      CirclePanel circlePanel = new CirclePanel(hudPanel);

      CircleListener listener = new CircleListener(circlePanel, hudPanel);

      CircleMenuBar circleMenuBar = new CircleMenuBar(listener);
      
      circleMenuBar.setPreferredSize(new Dimension(800, 30));
      container.add(circleMenuBar, BorderLayout.NORTH);
      
      circlePanel.setPreferredSize(new Dimension(800, 520));
      container.add(circlePanel, BorderLayout.CENTER);
      
      hudPanel.setPreferredSize(new Dimension(800, 50));
      container.add(hudPanel, BorderLayout.SOUTH);
     
      window.setContentPane(container);
      window.setSize(800, 600);
      window.setLocationRelativeTo(null);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
      window.setResizable(false);
      window.setResizable(false);  
      window.setVisible(true);

      
      
      
   }
   
   
}
