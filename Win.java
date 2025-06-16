import greenfoot.*; 
public class Win extends MyWorld
{
    Exit exit =new Exit();
    Restart restart = new Restart();
    Menu menu= new Menu();
    public Win()
    {    
        GreenfootImage winBg = new GreenfootImage("Map\\Win.png");
        winBg.scale(winBg.getWidth()+240,winBg.getHeight()+240);
        setBackground(winBg);
        addObject(menu,350,200);
        addObject(restart,350,400);
        addObject(exit,350,600);
    }
}