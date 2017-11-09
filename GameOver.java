import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    String text = "Game Over";
    
    int stringLength;
    
    public GameOver() {
        setImage(new GreenfootImage(300, 100));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(30.0F));
        stringLength = 160;
        updateImage();
    }
    
    public void updateImage() {
        GreenfootImage image = getImage();
        image.clear();
        image.fill();
        image.setColor(Color.WHITE);
        
        image.drawRect(0, 0, image.getWidth()-1 , image.getHeight()-1);
        image.drawString(text, (image.getWidth()/2) - (stringLength/2), (image.getHeight()/2) + 10);
    }
    
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        updateImage();
    }    
}
