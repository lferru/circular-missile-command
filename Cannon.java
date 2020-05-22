public class Cannon
{
  float position; //angular position (as it goes around Colony)
  float x = -900, y = -900;
  public Cannon(float pos)
  {
    position = pos;
  }
  
  public void display()
  {
    if ( (float) mouseY - 400 != 0 )
    {  
      position = atan(( (float) mouseX - 400 ) / ( (float) mouseY - 400 ));
      position -= HALF_PI;
      if ( (float) mouseY - 400 < 0 )
      {
        position += PI;
      }
    }
    else if ( (float) mouseY - 400 == 0.0 && (float) mouseX - 400 > 0.0 )
    { position = PI;/*print(position + " ");*/}
    else if ( (float) mouseY - 400 == 0.0 && (float) mouseX - 400 < 0.0 )
    {  position = 0;/*print(position + " ");*/}
    
    color c = color(124, 38, 29);
    fill(c);
    stroke(c);
    x = 400 + 62.5 * cos(position);
    y = 400 - 62.5 * sin(position);
    ellipse(x, y, 25, 25);
    //arc(400 + 62.5 * cos(position), 400 - 62.5 * sin(position), 25, 25, position - ( PI / 2 ), position + ( PI / 2 )) ;
  }
  
  public float getAngle()
  {
    
    return position;
  }
  
  public float getX()
  {
    
    return x;
  }
  
  public float getY()
  {
    
    return y;
  }
}
    
