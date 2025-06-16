import greenfoot.*;  

public class GameManager {
    public static GreenfootSound menu_music = new GreenfootSound("menu.mp3");
    public static GreenfootSound battle_music = new GreenfootSound("PlayGround.mp3");
    public static GreenfootSound winning_music = new GreenfootSound("winning.mp3");
    public static GreenfootSound gameover_music = new GreenfootSound("gameover.mp3");
    public GameManager()
    {
    }
    
    public static void musicplay(GreenfootSound music){
        music.playLoop();
    }
    public static void stopsound(GreenfootSound music){
        music.stop();
    }
}
    

    