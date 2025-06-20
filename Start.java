import greenfoot.*;
public class Start extends Button
{
    public int animationCounter=0;
    public int framecount=0;
    String [] Animation={
        "Animasi\\Button\\start\\start_1.png",
        "Animasi\\Button\\start\\start_2.png",
        "Animasi\\Button\\start\\start_3.png"
    };
    public int scaling = 80;
    GameManager manage = new GameManager();
    public void act()
    {
        Homepage homepage = new Homepage();
        animationCounter = animationCounter +1;
        if(animationCounter % 6 == 0){
                framecount = super.Animate(Animation,framecount,scaling);
            }
        if (Greenfoot.mouseClicked(this)){
            PlayGround.resetCount();
            manage.stopsound(manage.menu_music);
            manage.musicplay(manage.battle_music);
            Greenfoot.setWorld(new PlayGround());
        }
    }
}
