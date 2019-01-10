import java.awt.Color;
import java.awt.Graphics;

public abstract class Circle
{
   private int x;
   private int y;
   private int radius;
   private Color color;
   private Color outlineColor;
   
   public void draw(Graphics g) {
      g.setColor(color);
      g.fillOval(x- radius , y- radius /2, radius * 2, radius * 2);
      g.setColor(outlineColor);
      g.drawOval(x- radius , y- radius /2, radius * 2, radius * 2);
   }

   public int getX()
   {
      return x;
   }

   public int getY()
   {
      return y;
   }

   public int getRadius()
   {
      return radius;
   }

   public Color getColor()
   {
      return color;
   }

   public Color getOutlineColor()
   {
      return outlineColor;
   }

   public void setX(int x)
   {
      this.x = x;
   }

   public void setY(int y)
   {
      this.y = y;
   }

   public void setRadius(int radius)
   {
      this.radius = radius;
   }

   public void setColor(Color color)
   {
      this.color = color;
   }

   public void setOutlineColor(Color outlineColor)
   {
      this.outlineColor = outlineColor;
   }

}
