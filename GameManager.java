import greenfoot.*;  

public class GameManager {
    
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class GameManager
     */
    public GameManager()
    {
    }
    
    public void musicplay(GreenfootSound music){
        music.playLoop();
    }
    public static void stopsound(GreenfootSound music){
        music.stop();
    }
}
    

    