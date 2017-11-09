import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    int value = 0;
    String scoreString = "Score: ";
    
    int stringLength;
    
    Color color = Color.WHITE;
    
    FlappyWorld world;
    
    public Score(){
        stringLength = (scoreString.length() + 2) * 16;
        setImage(new GreenfootImage(stringLength, 24));
        
        Font font = getImage().getFont();
        getImage().setFont(font.deriveFont(24.0F));
        
        updateImage();
    }
    
    public void updateImage(){
        GreenfootImage image = getImage();
        image.clear();
        image.setColor(color);
        image.drawString(scoreString + value, 1, 18);
    }
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        value = world.getScore();
        updateImage();
    }   
    
    public void addedToWorld(World world) {
        this.world = (FlappyWorld) world;
    }
}
