import greenfoot.*;
public class HpFull extends HpBar
{
    public GreenfootImage barFull= new GreenfootImage("HpBar\\HPBarIn.png");
    private int originalWidth;
    
    public HpFull(int width,int height)
    {
        barFull.scale(barFull.getWidth()+width,barFull.getHeight()+height);
        originalWidth = barFull.getWidth();
        setImage(barFull);
    }
    public void act()
    {
        // Add your action code here.
    }
    public GreenfootImage hpUpdate(int currentHp){
         GreenfootImage image= getImage(); 
        int percentage = currentHp;
        int newWidth = (originalWidth * percentage) / 100;
        if (newWidth > originalWidth) {
            newWidth = originalWidth;
        }
        if (currentHp>0){
            image.scale(newWidth,image.getHeight());
        }else if(currentHp <= 0)
        {
             image.setTransparency(0);
        }
         
        return barFull=image;
    }
}