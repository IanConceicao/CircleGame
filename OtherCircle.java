import java.awt.Color;

public class OtherCircle extends Circle
{

   private double angle;
   private int speed = 0;
   private int maxSpeed;
   private int initialX, initialY;

   public OtherCircle(int maxSpeed, Color outlineColor) {
      super.setRadius(randomRadius());
      randomColor();
      super.setOutlineColor(outlineColor);
      this.maxSpeed = maxSpeed;
      randomSpeed();
      randomPointAndAngle();
      //System.out.println("circle created with speed: " + speed + " and angle: " + angle);
   }
   
   public int randomRadius() {
      int r = (int)(10 + Math.random() * 35);
      return r;
   }

   public void randomColor() {
      int r = 2 + (int)(240 * Math.random());
      int g = (int)(240 * Math.random());
      int b = 2 + (int)(240 * Math.random());
      super.setColor(new Color(r, g, b));
   }
   
   public void randomSpeed() {
         speed = (int)(5 + maxSpeed * Math.random());
   }
   
   public void randomPointAndAngle() {
      double rand = Math.random();
      //left
      if(rand < 0.25) {
         super.setX((int)(-50 - Math.random() * 100));
         super.setY(40 + (int)(480 * Math.random()));
         
         angle = (Math.PI * Math.random() - Math.PI / 2);
      }
      
      //right
      else if(rand < 0.5) {
         super.setX((int)(850 + Math.random() * 100));
         super.setY(40 + (int)(480 * Math.random()));
         
         angle = (Math.PI * Math.random() + Math.PI / 2);         
      } 
     
      //top
      else if(rand < 0.75) {
         super.setX(40 + (int)(760 * Math.random()));
         super.setY((int)(-50 - Math.random() * 100));
         angle = (Math.PI * Math.random() + Math.PI);         
      }
      
      //bottom
      else {
         super.setX(40 + (int)(760 * Math.random()));
         super.setY((int)(570 + Math.random() * 100));
         
         angle = (Math.PI * Math.random());         
      }
      
      initialX = super.getX();
      initialY = super.getY();
   }
   
   public void move() {
       super.setX((int)(super.getX() + 1 + speed * Math.cos(angle)));
       super.setY((int)(super.getY() + 1 + speed * Math.sin(angle)));
   }

   public int getInitialX()
   {
      return initialX;
   }

   public int getInitialY()
   {
      return initialY;
   }

   public void setInitialX(int initialX)
   {
      this.initialX = initialX;
   }

   public void setInitialY(int initialY)
   {
      this.initialY = initialY;
   }
  
 


}
