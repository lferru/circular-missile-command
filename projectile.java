public interface projectile
{

  public void setX(float a);
  public void setY(float a);
  public void setAngle(float a);
  public void setBombable(boolean a);
  public void setSpeed(int a);
  public float getX();
  public float getY();
  public float getAngle();
  public boolean isBombable();
  public float getSpeed();
  public void move();
  public void display();
}

