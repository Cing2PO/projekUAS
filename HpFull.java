import greenfoot.*;
public class HpFull extends PlayerHP
{
    private final GreenfootImage barFull= new GreenfootImage("HpBar\\HPBarIn.png");
    public HpFull(int width,int height)
    {
        barFull.scale(barFull.getWidth()+width,barFull.getHeight()+height);
        setImage(barFull);
    }
    public void act()
    {
        // Add your action code here.
    }
    public void hpUpdate(int HP,int width){
        
    }
}
