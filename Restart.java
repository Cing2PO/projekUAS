import greenfoot.*; 
public class Restart extends Button
{
    public int animationCounter=0;
    public int framecount=0;
    String [] Animation={
        "Animasi\\Button\\restart\\restart_1.png",
        "Animasi\\Button\\restart\\restart_2.png",
        "Animasi\\Button\\restart\\restart_3.png"
    };
    public int scaling = 80;
    public void act()
    {
        animationCounter = animationCounter +1;
        if(animationCounter % 6 == 0){
                framecount = super.Animate(Animation,framecount,scaling);
            }
        if (Greenfoot.mouseClicked(this)){
            GameManager.winning_music.stop();
            GameManager.gameover_music.stop();
            GameManager.battle_music.playLoop();
            PlayGround.resetCount();
            Greenfoot.setWorld(new PlayGround());
        }
    }
}
