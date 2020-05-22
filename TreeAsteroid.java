public class TreeAsteroid implements projectile
{
  final float R = 50.0; // radius
  chainAsteroid root;
  float x, y, speed, angle, rotA; // (x, y) is center of ring of asteroids.
  boolean bombable = false;
  float[] xs = new float[7]; // x-positions of the asteroids
  float[] ys = new float[7]; // y-positions of the asteroids
  int a = 0; // which asteroid display() is currently on.
  
  public TreeAsteroid(float xC, float yC, float newAngle, float v)
  {
    
   x = xC;
   y = yC;
   angle = newAngle;
   speed = v;
   root = new chainAsteroid(8 * PI / 7,
     new chainAsteroid(4 * PI / 7,
       new chainAsteroid(2 * PI / 7, null, null), new chainAsteroid(6 * PI / 7, null, null)),
     new chainAsteroid(12 * PI / 7,
       new chainAsteroid(10 * PI / 7, null, null), new chainAsteroid(4 * PI, null, null)));
  }
  
  public void move()
  {
    
    x += speed * cos(angle);
    y -= speed * sin(angle);
    rotA -= speed / ( 2 * PI * R );
    moveEach(root);
  }
  
  public void moveEach(chainAsteroid temp) //moves each asteroid
  {
    
    if ( temp != null )
    {
      
      xs[a] = x + R * cos(temp.getPosition() + rotA);
      ys[a] = y - R * sin(temp.getPosition() + rotA);
      a++;
      if ( a >= 5 ) a = 0;
    }
  }
  
  public void display()
  {
    display(root);
  }
  
  public void display(chainAsteroid temp)
  {
    
    if ( temp != null )
    {
      ellipseMode(CENTER);
      fill(137,98,51,125);
      stroke(137, 98, 51, 125);
      ellipse(x + R * cos(temp.getPosition() + rotA), y - R * sin(temp.getPosition() + rotA), 15, 15);
      display(temp.getLeft());
      display(temp.getRight());
      a++;
      if ( a >= 5 ) a = 0;
    }
    
    
  }
  
  public void remove(int i)
  {
    
    chainAsteroid temp = root;
    chainAsteroid parent = root;
    int go = 0; //-1 means go left, 1 means go right, 0 means this is root.
    
    
    while ( temp != null )
    {
      if ( i < (int) ( temp.getPosition() / ( 2 * PI / 7 ) ) - 1 )
      {
        parent = temp;
        temp = temp.getLeft();
        go = -1;
      }
      else if ( i > (int) ( temp.getPosition() / ( 2 * PI / 7 ) ) - 1)
      {
        parent = temp;
        temp = temp.getRight();
        go = 1;
      }
      else
      {
        if ( go < 0 )
        {
          parent.setLeft(null);
          temp = null;
        }
        else if ( go > 0 )
        {
          parent.setRight(null);
          temp = null;
        }
        else
        {
          root = null;
          temp = null;
        }
        xs[i] = -900;
        ys[i] = -900;
      }
      
    }
  }
  
  public boolean isEmpty()
  {
    
    if ( root == null ) return true;
    return false;
  }
  
  public float[] getXs(){ return xs; }
  public float[] getYs(){ return ys; }
  
  public String toString()
  {
    
    return "tree";
  }
  
  public void setX(float a){ x = a; }
  public void setY(float a){ y = a; }
  public void setAngle(float a){ angle = a; }
  public void setBombable(boolean a){ bombable = a; }
  public void setSpeed(int a){ speed = a; }
  public float getX(){ return x; }
  public float getY(){ return y; }
  public float getAngle(){ return angle; }
  public boolean isBombable(){ return bombable; }
  public float getSpeed(){ return speed; }
  
}
