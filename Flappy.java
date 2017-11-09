import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flappy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flappy extends Actor
{
    private double fallingSpeed = 1.0;
    
    private static final double FLAP = 16.0;
    
    private boolean hasFlapped = false;
    
    FlappyWorld world;
    
    GreenfootImage flapImage, fallImage;
    
    private boolean alive = true;
    
    public Flappy(){
        fallImage = getImage();
        fallImage.scale(fallImage.getWidth()/10, fallImage.getHeight()/10);
        setImage(fallImage);
        
        flapImage = new GreenfootImage("frame-2.png");
        flapImage.scale(flapImage.getWidth()/10, flapImage.getHeight()/10);
    }
    /**
     * Act - do whatever the Flappy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(alive){
        if(Greenfoot.isKeyDown("up") && !hasFlapped) {
            fallingSpeed -= FLAP;
            hasFlapped = true;
        }
        if(!Greenfoot.isKeyDown("up") && hasFlapped) {
            hasFlapped = false;
        }
      }
        
        fallingSpeed += world.getGravity();
        
        if(fallingSpeed > 20) {
            fallingSpeed = 20;
        }
        if(fallingSpeed < -20) {
            fallingSpeed = -20;
        }
        if(fallingSpeed > 0) {
            setImage(fallImage);
        } else {
            setImage(flapImage);
        }
        

        setLocation(getX(), getY()+(int)fallingSpeed);
        
        checkCollision();
    }    
    
    public void checkCollision(){
        java.util.List<Pipe> pipes = getIntersectingObjects(Pipe.class);
        
        if(pipes.size() > 0 && alive) {
            alive = false;
            
            fallImage.mirrorVertically();
        }
        
        if(getY() >= world.getHeight()-10) {
            alive = false;
            world.addObject(new GameOver(), 300, 300);
            Greenfoot.stop();
        }
    }
    
    public void addedToWorld(World world) {
        this.world = (FlappyWorld) world;
    }
    
    public boolean isAlive() {
        return alive;
    }
}
