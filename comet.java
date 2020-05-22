public class comet implements projectile
{
 float x, y, angle, speed;
 boolean bombable;
 int pointValue = 10000;
 public comet(){
  x=0; y=0; angle=0; bombable = true; speed = 0;
 }
 public comet(float a, float b, float c){
  x=a; y=b; angle=c; bombable = true; speed = random(0,4.01);
 }
 public void move(){
  x+=speed*cos(angle);
  y+=speed*sin(angle);
 }
 public void display(){
  color c = color(153,245,238,125);
  fill(c);
  stroke(c);
  ellipse(getX(),getY(),50,25);
 }
 public int getValue(){
   return pointValue;
 }
 
 public String toString()
 {
   
   return "comet";
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
