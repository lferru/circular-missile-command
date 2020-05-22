public class normalAsteroid implements projectile
{
 float x, y, angle, speed;
 boolean bombable;
 int pointValue = 500;
 public normalAsteroid(){
  x=0; y=0; angle=0; bombable = true; speed = 0;
 }
 public normalAsteroid(float a, float b, float c){
  x=a; y=b; angle=c; bombable = true; speed = 3;//random(0,4.01);
 }
 public void move(){
  x+=speed*cos(angle);
  y+=speed*sin(angle);
 }
 public void display(){
  color c = color(137,98,51,125);
  fill(c);
  stroke(c);
  ellipseMode(CENTER);
  ellipse(getX(),getY(),65,65);
 }
 public int getValue(){
   return pointValue;
 }
 
 public String toString()
 {
   
   return "normal";
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
