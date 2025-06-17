import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class GameManager extends Actor {
    public static GreenfootSound menu_music = new GreenfootSound("menu.mp3");
    public static GreenfootSound battle_music = new GreenfootSound("PlayGround.mp3");
    public static GreenfootSound winning_music = new GreenfootSound("winning.mp3");
    public static GreenfootSound gameover_music = new GreenfootSound("gameover.mp3");
    public static boolean gamestatus = true;
    
    public GameManager(){
        
    }
    public static void musicplay(GreenfootSound music){
        music.playLoop();
    }
    public static void stopsound(GreenfootSound music){
        music.stop();
    }
    public void itempopup(){
        frame frame1 = new frame();
        item item1 = new item();
        frame frame2 = new frame();
        item item2 = new item();
        getWorld().addObject(frame1,160,320);
        getWorld().addObject(frame2,480,320);
        getWorld().addObject(item1,160,320);
        getWorld().addObject(item2,480,320);
    }
    public void removeItem(frame frame1,frame frame2,item item1,item item2){
        frame1.KYS();
        frame2.KYS();
        item1.KYS();
        item2.KYS();
    }
    
    public void spawnItem(frame frame1,frame frame2,item item1,item item2){
        frame1.ItemSpawn();
        frame2.ItemSpawn();
        item1.ItemSpawn();
        item2.ItemSpawn();
    }
}
    

    