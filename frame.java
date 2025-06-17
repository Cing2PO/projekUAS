import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class frame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class frame extends powerup
{
    String[] frame = {
        "images\\frame\\black.png",
        "images\\frame\\white.png"
    };
    public frame(){
        GreenfootImage frame1 = new GreenfootImage(frame[Greenfoot.getRandomNumber(2)]);
        frame1.scale(frame1.getWidth()-200,frame1.getHeight()-100);
        setImage(frame1);
    }
    public void randomize(){
        //this.num = Greenfoot.getRandomNumber(8);
    }
    public void KYS(){
        this.getImage().setTransparency(0);
    }
    public void ItemSpawn(){
        this.getImage().setTransparency(255);
    }
}
