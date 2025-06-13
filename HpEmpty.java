import greenfoot.*; 
public class HpEmpty extends HpBar
{
    public GreenfootImage barEmpty= new GreenfootImage("HpBar\\HPBarOut.png");
    public HpEmpty(int width,int height)
    {
        barEmpty.scale(barEmpty.getWidth()+width,barEmpty.getHeight()+height);
        setImage(barEmpty);
    }
    public void act()
    {
        // Add your action code here.
    }
}
