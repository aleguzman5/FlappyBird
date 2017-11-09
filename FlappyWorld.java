import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyWorld extends World
{
    private final double GRAVITY = 0.5; //5px per second
    
    Flappy flappy;
    
    Pipe topPipe, bottomPipe;
    
    int score;
    
    boolean scored = false;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public FlappyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        flappy = new Flappy();
        addObject(flappy, 300, 300);
        
        addObject(new Score(), 100, 50);
        
        setPaintOrder(Flappy.class, Score.class);
        
        checkPipes();
    }
    
    public void act() {
        super.act();
        
        topPipe.setLocation(topPipe.getX()-3, topPipe.getY());
        bottomPipe.setLocation(bottomPipe.getX()-3, bottomPipe.getY());
        
        checkPipes();
        checkScore();
    }
    
    public void checkScore() {
        if(topPipe.getX() < 300 && !scored && flappy.isAlive()) {
            score++;
            scored = true;
        }
    }
    
    public double getGravity() {
        return GRAVITY;
    }
    
    private void checkPipes() {
        if(topPipe == null || topPipe.getX() <= 0) {
            removeObject(topPipe);
            removeObject(bottomPipe);
            
            int openingSize = (int)(Math.random()*150)+200;
            int centerY = (int)(Math.random()*200)+200;
            
            int topPHeight = centerY - (openingSize/2);
            topPipe = new Pipe(topPHeight);
            addObject(topPipe, 600, topPHeight/2);
            
            int bottomPHeight = getHeight() - (centerY + openingSize/2);
            bottomPipe = new Pipe(bottomPHeight);
            addObject(bottomPipe, 600, getHeight() - (bottomPHeight/2));
            
            scored =false;
        }
    }
    
    public int getScore() {
        return score;
    }
    
}
