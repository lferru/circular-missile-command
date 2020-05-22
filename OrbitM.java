public class OrbitM extends Missile
{
  
  float radius; // "height" of orbit
  boolean isInOrbit;
  
  public OrbitM(float x1, float y1, float v, float newAngle, float r)
  {
    x = x1;
    y = y1;
    angle = newAngle;
    radius = r;
    speed = v;
    isInOrbit = false;
  }
  
  public float distance(float x1, float y1, float x2, float y2)
  {
    return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
  }
  
  public void move()
  {
    
    if ( !isInOrbit && distance(x, y, 400, 400) < radius ) //still "ascending" to the desired "altitude" (radius)
    {
      x += speed * cos(angle);
      y -= speed * sin(angle);
    }
    else // in orbit
    {
      isInOrbit = true;
      angle -= speed / ( 2 * PI * radius);
      x = 400 + radius * cos(angle);
      y = 400 - radius * sin(angle);
    }
  }
  
  public void display()
  {
    
    rectMode(CENTER);
    fill(255, 0, 0);
    stroke(255, 0, 0);
    rect(x, y, 15, 15);
  }
}
