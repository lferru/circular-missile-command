public class alien { 
  float x, y, speed;
  boolean bombable;
  int pointValue = 1500;
  public alien(){
    x=0; y=0; speed=1;
  }
  public alien(float a, float b, float spd){
    x=a; y=b; speed=spd;
  }
  public void move(){
   if(getY()<400){ setX(getX()+1); }
   if(getY()>400){ setX(getX()-1); } 
  }
  public void display(){
    color c = color(155,153,153,155);
    fill(c);
    stroke(c);
    ellipse(getX(),getY(),50,20);
    c = color(36,180,29,155);
    fill(c);
    ellipse(getX(),getY()-10,35,15);
  }
  public void setX(float a){ x=a; }
  public void setY(float a){ y=a; }
  public void setSpeed(float a){ speed=a; }
  public float getSpeed(){ return speed; }
  public float getX(){ return x; }
  public float getY(){ return y; }
  public int getValue(){
   return pointValue;
  }
} 
