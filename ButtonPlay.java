import greenfoot.*;

public class ButtonPlay extends Actor
{
    public ButtonPlay(){
        GreenfootImage button =new GreenfootImage("01_Red_Buttons_Pixel.png");
        button.scale(button.getWidth()+80,button.getHeight()+80);
        setImage(button);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new PlayGround());
        }
    }
    
}
