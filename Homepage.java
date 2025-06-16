import greenfoot.*; 

public class Homepage extends MyWorld
{
    GameManager manage = new GameManager();
    public Homepage()
    {    
        Start start = new Start();
        GreenfootImage homeBg = new GreenfootImage("Map\\Homepage.png");
        homeBg.scale(homeBg.getWidth()+240,homeBg.getHeight()+240);
        setBackground(homeBg);
        addObject(start,320,320);
    }
    public void started(){
        manage.musicplay(manage.menu_music);
    }
}