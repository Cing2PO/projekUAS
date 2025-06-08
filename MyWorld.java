import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    Player player = new Player();
    GreenfootImage playerSprite = new GreenfootImage("Animasi\\player1\\idle\\idle_down\\00_idle_down.png");
    Enemy enemy = new Enemy();
    GreenfootImage slimeSprite = new GreenfootImage("Animasi\\slime\\Slime1_Idle_full\\00_Slime1_Idle_full.png");
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1); 
        addObject(player, 200, 200);
        player.setImage(playerSprite);
        addObject(enemy, 100, 100);
        enemy.setImage(slimeSprite);
        
    }
}
