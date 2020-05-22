import ddf.minim.*;
public class Run {
public System game;
public Minim context = new Minim(this);
public AudioPlayer one, two, three;

public void setup() 
{
  
  size(800, 800);
 
  one = context.loadFile("yell.wav");
  two = context.loadFile("song.mp3");
  three = context.loadFile("comets.wav");
  game = new System(one, two, three);
}

public void draw()
{
  
  background(20);
  game.addSome();
  game.addSpecial();
  
  
  game.move();
  game.collisions();
  game.shipHit();
  game.isHurt();
  game.didShipLand();
  game.display();
  
  if ( game.isOut() )
  {
    
    game.recordHighScore();
    game.displayScores();
    stop();
  }
}

public void keyReleased()
{
  
  if ( key == 'z' )
    game.launch(mouseX, mouseY);
}
}