import greenfoot.*; 
public class Win extends MyWorld
{
    public Win()
    {    
        Exit exit =new Exit();
        Restart restart = new Restart();
        Menu menu= new Menu();
        WinText wintext=new WinText();
        GreenfootImage winBg = new GreenfootImage("Map\\Win.png");
        winBg.scale(winBg.getWidth()+240,winBg.getHeight()+240);
        setBackground(winBg);
        addObject(wintext,350,150);
        addObject(menu,350,400);
        addObject(restart,350,500);
        addObject(exit,350,600);
    }
}