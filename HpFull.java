import greenfoot.*;
public class HpFull extends HpBar
{
    public GreenfootImage barFull= new GreenfootImage("HpBar\\HPBarIn.png");
    public HpFull(int width,int height)
    {
        barFull.scale(barFull.getWidth()+width,barFull.getHeight()+height);
        setImage(barFull);
    }
    public void act()
    {
        // Add your action code here.
    }
    public GreenfootImage hpUpdate(int hp){
         GreenfootImage image= getImage(); 
        int width= image.getWidth();
        int hpminus= (int)width-hp;
        if (hp!=0){
            image.scale(image.getWidth()-hpminus,image.getHeight());
        }else{
             image.setTransparency(0);
        }
         
        return barFull=image;
    }
}
