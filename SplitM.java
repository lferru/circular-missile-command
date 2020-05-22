public class SplitM extends Missile
{
  
  NormalM one, two;
  
  public SplitM(float xPos, float yPos, float v, float newAngle)
  {
    one = new NormalM(xPos, yPos, v, newAngle + ( PI / 24 ));
    two = new NormalM(xPos, yPos, v, newAngle - ( PI / 24 ));
    angle = newAngle;
    x = xPos;
    y = yPos;
    speed = v;
  }
  
  public void move()
  {
    one.move();
    two.move();
    x += speed * cos(angle);
    y -= speed * sin(angle);
  }
  
  public void display()
  {
    one.display(true);
    two.display(true);
  }  
}
