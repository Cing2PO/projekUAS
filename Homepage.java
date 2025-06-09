import greenfoot.*; 

public class Homepage extends MyWorld
{
    GreenfootImage homeBg = new GreenfootImage("Homepage.png");
    ButtonPlay play = new ButtonPlay();
    public Homepage()
    {    
        setBackground(homeBg);
        addObject(play,200,200);
    }
}
