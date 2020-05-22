public class MysteryM extends Missile
{
  float x2, y2;
  float sinTime;
  Integer a = new Integer(1), b = new Integer(1);
  public MysteryM(float xPos, float yPos, float v, float newAngle)
  {
    speed = v;
    x = xPos;
    y = yPos;
    angle = newAngle;
    sinTime = 0;
  }
  
  public void move()
  {
    
    
    
    //println(sin( sinTime / 16 ) );
    /*if ( ( sinTime / 16 ) % ( 2 * PI ) > PI )
    {
      a = -1; 
    }
    else
    {
      a = 1;
    }*/
    
    x += speed * cos(angle);
    y -= speed * sin(angle);
    x2 = x;
    y2 = y; //for the sin curve, so y will remain for the line. 
    // to-do: add a variable to multiply cos & sin of perpendicular angle (depending on quadrant) 
    /*if ( sin(-1 / angle) > 0 ) a = -1;
    else a = 1;
    if ( cos(-1 / angle) > 0 ) b = -1;
    else b = 1;
    if ( angle  ) //for when angle == PI or 2 PI
    {
      y2 += 30 * sin( sinTime / 16 )
    }*/
    if ( sinTime / 16 % ( 2 * PI ) <= PI )
    {
      x2 += 70 * sin( sinTime / 16 ) * cos(angle + ( PI / 2 )); 
      y2 -= 70 * sin( sinTime / 16 ) * sin(angle + ( PI / 2 )) * a;
    }
    else
    {
      x2 += 70 * sin( sinTime / 16 ) * cos(angle + ( PI / 2));
      y2 -= 70 * sin( sinTime / 16 ) * sin(angle + ( PI / 2)) * a;
    }
    sinTime += speed;
    
  }
  
  public void display()
  {
    fill(13, 200, 250);
    stroke(13, 200, 250);
    rectMode(CENTER);
    rect(x2, y2, 15, 15);
  }
}
