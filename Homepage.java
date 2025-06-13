import greenfoot.*; 

public class Homepage extends MyWorld
{
    ButtonPlay play = new ButtonPlay();
    public Homepage()
    {    
        GreenfootImage homeBg = new GreenfootImage("Map\\Homepage.png");
        homeBg.scale(homeBg.getWidth()+240,homeBg.getHeight()+240);
        setBackground(homeBg);
        addObject(play,320,320);
    }
}
