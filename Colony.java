public class Colony
{ //this class just displays a colony & its cannon
 
  Cannon defense;
 
  public Colony()
  { 
    defense = new Cannon(2 * PI / 4);
  }
  
  public void display()
  {
    
    color c = color(100);
    ellipseMode(CENTER);
    fill(c);
    stroke(c);
    ellipse(400, 400, 100, 100);
    defense.display();
  }
  
  public float angle()
  {
    
    return defense.getAngle();
  }
  
  public float getCX()
  {
    
    return defense.getX();
  }
  
  public float getCY()
  {
    
    return defense.getY();
  }
}
