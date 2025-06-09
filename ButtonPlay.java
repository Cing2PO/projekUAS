import greenfoot.*;

public class ButtonPlay extends Char
{
    public ButtonPlay(){
        GreenfootImage button =new GreenfootImage("01_Red_Buttons_Pixel.png");
        button.scale(button.getWidth()+30,button.getHeight()+30);
        setImage(button);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new PlayGround());
        }
    }
    
}
