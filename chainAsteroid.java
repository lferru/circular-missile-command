public class chainAsteroid implements projectile
{
 float x, y, angle, speed; 
 boolean bombable;
 int pointValue = 350;
 chainAsteroid left = null, right = null; //this class serves as a node for TreeAsteroid
 float position; // angle (as treeAsteroid has them in a ring)
 float index;
 
 public chainAsteroid(){
  x=0; y=0; angle=0; setBombable(true); speed = 0;
 }
 public chainAsteroid(float pos, chainAsteroid l, chainAsteroid r){
  position = pos;
  bombable = true;
  left = l;
  right = r;
 }
 public void move(){
  x+=speed*cos(angle);
  y+=speed*sin(angle);
 }
 public void display(){
  color c = color(137,98,51,125);
  fill(c);
  ellipse(getX(),getY(),40,40);
 }
 public int getValue(){
   return pointValue;
 }
 
 public chainAsteroid getLeft()
 { return left;
 }
 public chainAsteroid getRight()
 { return right;
 }
 
 public void setLeft(chainAsteroid n)
 { left = n;
 }
 public void setRight(chainAsteroid n)
 { right = n;
 }
 
 public float getPosition()
 {
   return position;
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
