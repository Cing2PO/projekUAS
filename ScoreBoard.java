import greenfoot.*;
/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int score;
    private GreenfootImage scoreBoard;
    public ScoreBoard(){
        scoreBoard = new GreenfootImage("images\\ScoreBoard\\scoreboard.png");
        updateImage();
    }
    public void act()
    {
        updateImage();
    }
    public void updateImage(){
        GreenfootImage image = new GreenfootImage(scoreBoard);
        image.setColor(Color.WHITE);
        Font font = new Font("Arial",true, false, 14);
        image.setFont(font);
        image.drawString("Score :" + PlayGround.enemykilled, 25, 45);
        setImage(image);
    }
}
