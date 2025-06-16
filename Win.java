import greenfoot.*; 
public class Win extends MyWorld
{
    public Win()
    {    
        GreenfootImage winBg = new GreenfootImage("Map\\Win.png");
        winBg.scale(winBg.getWidth()+240,winBg.getHeight()+240);
        setBackground(winBg);
    }
}
