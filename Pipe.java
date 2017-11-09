import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pipe extends Actor
{
    
    int height;
    
    public Pipe(){
        this(300);
    }
    public Pipe(int height){
        this.height = height;
        
        setImage(new GreenfootImage(50, height));
        
        drawPipe();
    }
    
    public void drawPipe() {
        GreenfootImage image = getImage();
        image.clear();
        image.setColor(Color.GREEN);
        image.fill();
        
    }
    /**
     * Act - do whatever the Pipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        drawPipe();
    }    
}
