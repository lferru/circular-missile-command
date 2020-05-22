//import ddf.minim.*;

public class System //this class is for collision detection, holding objects, and managing the game
{
  
  AudioPlayer laser, music, cometTune;
  ArrayList<projectile> mShower;
  ArrayList<Missile> protection;
  alien ufo = null;
  civilian cargo = null;
  Colony base;
  Integer time;
  int specialT, score, lives;
  float ammoInUse;
  String[] highScores;
  boolean hasBomb; //are we using a bomb or not
  
  public System(AudioPlayer a, AudioPlayer b, AudioPlayer c)
  {
    
    mShower = new ArrayList<projectile>();
    protection  = new ArrayList<Missile>();
    base = new Colony();
    time = new Integer(0);
    specialT = 0;
    score = 0;
    highScores = loadStrings("hs.txt");
    lives = 3;
    ammoInUse = random(0, 4);
    laser = a;
    music = b;
    cometTune = c;
    music.play();
    
  }
  
  public void move()
  {
    
    for ( projectile meteor : mShower )
      meteor.move();
    
    for ( Missile strike : protection )
      strike.move();
      
    if ( ufo != null ) ufo.move();
    if ( cargo != null ) cargo.move();  
    time = new Integer(time.intValue() + 1);
    specialT++;
  }
  
  public void display()
  {
    
    for ( projectile meteor : mShower )
      meteor.display();
    
    for ( Missile strike : protection )
      strike.display();
      
    if ( ufo != null ) ufo.display();
    if ( cargo != null ) cargo.display();  
    base.display();
    textSize(40);
    text("Score:" + score, 500, 40);
    text("Lives: " + lives, 500, 80);
  }
  
  public void recordHighScore() //only records when there are less than 12 entries.
  {
    
    if ( Integer.parseInt(highScores[0]) < 1 )
    {
      
      highScores = new String[] { "1", "" + score };
      saveStrings("hs.txt", highScores);
    }
    else if ( Integer.parseInt(highScores[0]) <= 12 )
    {
      
      String[] newLines = new String[Integer.parseInt(highScores[0]) + 1];
      int i;
      
      for ( i = 0; i < Integer.parseInt(highScores[0]); i++ )
      {
        
        if ( i == 0 ) newLines[i] = (Integer.parseInt(highScores[i]) + 1) + "";
        else newLines[i] = highScores[i];
      }
      newLines[i] = "" + score;
      highScores = newLines;
      saveStrings("hs.txt", newLines);
    }
  }
  
  public boolean isOut() //game over or not
  {
    
    return lives < 1;
  }
  
  public int timer()
  {
    
    return time;
  }
  
  public void addSome() //adds new asteroids every 5 seconds (a random kind)
  {
    
    if ( timer() > 25 )
    {
      
      time = new Integer(0);
      float type = random(0, 7);
      float x = 400;
      float y = 400;
      float aim = random(TWO_PI, 2 * TWO_PI);
      projectile temp = null;
      
      while ( x > 50 && x < 750 ) x = random(0, 800);
      while ( y > 50 && y < 750 ) y = random(0, 800);
      
      if ( type < 6 )
        temp = new normalAsteroid(x, y, aim);
      else if ( type < 7 )
        temp = new TreeAsteroid(x, y, aim, 2.5);
      
      mShower.add(temp);
    }
  }

  public void didShipLand()
  {
    
    if ( cargo != null && distance(400, 400, cargo.getX(), cargo.getY()) < 50 + 10 )
    {
      
      cargo = null;
      ammoInUse = random(0, 4); //change ammo kind
    }
  }
    

  public void addSpecial() //create civilian, alien, or comet objects randomly, every 10 seconds ( timer > 4000 ?)
  {
    
    if ( specialT > 200 )
    {
      
      specialT = 0;
      float type = random(0, 3);
      float x = 0;
      float y = 0;
      float aim = random(TWO_PI, 2 * TWO_PI);
      while ( x > 50 && x < 750 ) x = random(0, 800);
      while ( y > 50 && y < 750 ) y = random(0, 800);
      
      if ( type < 1 ) //it's a comet
      {
       
        mShower.add(new comet(x, y, aim));
        cometTune.play();
        cometTune.rewind();
      }
      else if ( type < 2  && ufo == null ) // UFO
      {
        
        
        while ( x < 50 || x > 750 ) x = random(0, 800);
        while ( y < 50 || y > 750 ) y = random(0, 800);
        
        ufo = new alien(x, y, 3.5);
      }
      else if ( type < 3 && cargo == null ) // civilian ship
      {
        
        
        x = 400;
        y = 30;
        cargo = new civilian(x, y, 3.5, -3 * PI / 2);
      }
    }  
  }  
  
  public float distance(float a, float b, float c, float d)
  {
    
    return sqrt( sq(c - a) + sq(d - b) );
  }
  
  public void displayScores() //displays high score board
  {
    
    background(80);
    text("GAME OVER", 350, 40);
    text("SCORES", 350, 120);
    
    for ( int i = 0; i < Integer.parseInt(highScores[0]); i++ )
    {
      if ( i == 0 ) continue;
      text(highScores[i], 350, 220 + ( i * 40 ));
    }
  }
  
  public void isHurt() //sees if colony is hit
  {
    
    projectile inBound = null;
    
    for ( int i = 0; i < mShower.size(); i++ )
    {
      
      inBound = mShower.get(i);
      
      if ( inBound.toString().equals("normal") )
        {
          if ( distance(400, 400, inBound.getX(), inBound.getY()) <= 50 + 32.5 )
          {
            
            
            
            mShower.remove(i);
            lives--;
            i--;
            break;
          }
        }
        else if ( inBound.toString().equals("comet") )
        {
          if ( distance(400, 400, inBound.getX(), inBound.getY()) <= 50 + 18.75 )
          {
            
            
            
            mShower.remove(i);
            lives--;
            i--;
            break;
          }
        }
      else
      {
          float horiz[] = ((TreeAsteroid) inBound).getXs();
          float verti[] = ((TreeAsteroid) inBound).getYs();
          
          for ( int k = 0; k < 7; k++ )
          {
            if ( horiz[k] == -900 ) continue;
            
            if ( distance(400, 400, horiz[k], verti[k]) <= 7.5 + 7.5 )
            {
            
              
              
              ((TreeAsteroid) inBound).remove(k);
              if ( ((TreeAsteroid) inBound).isEmpty() )
              {  mShower.remove(i);
                i--;
              }
              lives--;
              
              break;
            }
          }
      }
    }
  }
  
  
  
  public void shipHit() //sees if civilian ship is hit, amd if it reaches the colony, player gets a missile.
  {
    
    if ( cargo == null ) return;
    projectile inBound = null;
    for ( int i = 0; i < mShower.size(); i++ )
    {
      
      inBound = mShower.get(i);
      
      if ( inBound.toString().equals("normal") )
        {
          if ( distance(cargo.getX(), cargo.getY(), inBound.getX(), inBound.getY()) <= 50 + 32.5 )
          {
            
            
            cargo = null;
            mShower.remove(i);
            
            i--;
            break;
          }
        }
        else if ( inBound.toString().equals("comet") )
        {
          if ( distance(cargo.getX(), cargo.getY(), inBound.getX(), inBound.getY()) <= 50 + 18.75 )
          {
            
            
            cargo = null;
            mShower.remove(i);
            
            i--;
            break;
          }
        }
      else
      {
          float horiz[] = ((TreeAsteroid) inBound).getXs();
          float verti[] = ((TreeAsteroid) inBound).getYs();
          
          for ( int k = 0; k < 7; k++ )
          {
            if ( horiz[k] == -900 ) continue;
            
            if ( distance(cargo.getX(), cargo.getY(), horiz[k], verti[k]) <= 7.5 + 7.5 )
            {
            
              
              cargo = null;
              ((TreeAsteroid) inBound).remove(k);
              if ( ((TreeAsteroid) inBound).isEmpty() )
              {  mShower.remove(i);
                i--;
              }
              
              
              break;
            }
          }
      }
    }
      
  }
  public void collisions() // detects collisions and removes them.
  {
    
    Missile temp = null;
    projectile inBound = null;
    
    for ( int i = 0; i < protection.size(); i++ ) //go through the missiles
    {
      
      temp = protection.get(i);
      
      for ( int j = 0; j < mShower.size(); j++ ) //go through all projectiles
      {
        
        inBound = mShower.get(j);
        
        if ( inBound.toString().equals("normal") )
        {
          if ( distance(temp.getX(), temp.getY(), inBound.getX(), inBound.getY()) < 7.5 + 32.5 )
          {
            
            score += 500;
            protection.remove(i);
            mShower.remove(j);
            i--;
            break;
          }
        }
        else if ( inBound.toString().equals("comet") )
        {
          if ( distance(temp.getX(), temp.getY(), inBound.getX(), inBound.getY()) < 7.5 + 18.75 )
          {
            
            score += 10000;
            protection.remove(i);
            mShower.remove(j);
            i--;
            break;
          }
        }
        else //if this is a TreeAsteroid
        {
          
          float horiz[] = ((TreeAsteroid) inBound).getXs();
          float verti[] = ((TreeAsteroid) inBound).getYs();
          
          for ( int k = 0; k < 7; k++ )
          {
            if ( horiz[k] == -900 ) continue;
            
            if ( distance(temp.getX(), temp.getY(), horiz[k], verti[k]) < 7.5 + 7.5 )
            {
            
              score += 350;
              protection.remove(i);
              ((TreeAsteroid) inBound).remove(k);
              if ( ((TreeAsteroid) inBound).isEmpty() )
                mShower.remove(j);
              i--;
              break;
            }
          }    
        
        }
      }
      
      if ( ufo != null && distance(ufo.getX(), ufo.getY(), temp.getX(), temp.getY()) < 32 )  //if an alien was hit
      {
        
        ufo = null;
        float decision = random(0, 2);
        
        if ( decision < 1 )
        {
          
          lives++;
        }
        else
        {
          
          hasBomb = true;
        }
      }   
    }
  }
  
  public void launch(float x, float y) //when you click, new missiles appear
  {
    
    if ( hasBomb )
    {
      
      mShower = new ArrayList<projectile>(); //erase all asteroids
      hasBomb = false;
    }
    else
    {
      Missile temp = null;
    
      if ( ammoInUse < 1 )
        temp = new NormalM(base.getCX(), base.getCY(), 3.5, base.angle());
      else if ( ammoInUse < 2 )
        temp = new SplitM(base.getCX(), base.getCY(), 3.5, base.angle());
      else if ( ammoInUse < 3 )
        temp = new OrbitM(base.getCX(), base.getCY(), 3.5, base.angle(), distance(400, 400, (float) mouseX, (float) mouseY));
      else if ( ammoInUse < 4 )
        temp = new MysteryM(base.getCX(), base.getCY(), 3.5, base.angle());
      protection.add(temp);
      laser.play();
      laser.rewind();
    }
  }
}
