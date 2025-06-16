import greenfoot.*;
public class Exit extends Button
{
    public int animationCounter=0;
    public int framecount=0;
    String [] Animation={
        "Animasi\\Button\\exit\\exit_1.png",
        "Animasi\\Button\\exit\\exit_2.png",
        "Animasi\\Button\\exit\\exit_3.png"
    };
    public int scaling = 80;
    public void act()
    {
        animationCounter = animationCounter +1;
        if(animationCounter % 6 == 0){
                framecount = super.Animate(Animation,framecount,scaling);
            }
        if (Greenfoot.mouseClicked(this)){
            PlayGround.resetCount();
            Greenfoot.stop();
        }
    }
}
