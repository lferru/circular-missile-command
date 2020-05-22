public class civilian { 
  float x, y, speed, angle; 
  int id;
  int pointValue = -10000;
  public civilian(){
    x=0.0; y=0.0; speed=1.0; angle=0.0; id=setID();
  }
  public civilian(float a, float b, float spd, float ang){
    x=a; y=b; speed=spd; angle=ang; id=setID();
  }
  public void display(){
   color c = color(160,26,170,155);
   fill(c);
   stroke(c);
   triangle(getX()-20,getY()-20,getX(),getY()+20,getX()+20,getY()-20);
  }
  public void move(){
   setY(getY()+1); 
  }
  public int setID(){
    int i;
    i = (int)random(0,4);
    if(i == 4){
      i = (int)random(0,4);
    }
    return i;
  }
  public void setX(float a){ x=a; }
  public void setY(float a){ y=a; }
  public void setSpeed(float a){ speed=a; }
  public float getSpeed(){ return speed; }
  public float getX(){ return x; }
  public float getY(){ return y; }
  public int getValue(){ return pointValue; }
  public int getID(){ return id; }
}
  
  
