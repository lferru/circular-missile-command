public class NormalM extends Missile
{
  
  public NormalM(float xPos, float yPos, float v, float newAngle)
  {
    speed = v;
    x = xPos;
    y = yPos;
    angle = newAngle;
  }
  
  public void move()
  {
    x += speed * cos(angle);
    y -= speed * sin(angle);
  }
  
  public void display()
  {
    rectMode(CENTER);
    fill(245, 112, 2);
    stroke(245, 112, 2);
    rect(x, y, 15, 15);
  }
  
  public void display(boolean isGreen) // for SplitM to call, so it can look different.
  {
    rectMode(CENTER);
    fill(14, 227, 0);
    stroke(14, 227, 0);
    rect(x, y, 15, 15);
  }
}
