import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Musuh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Char
{
    public int framecount = 0;  
    private int framehit = 200;
    public boolean move = false;
    public int animationCounter=0;
    public int enemyX,enemyY;
    public int speed = 1;
    public int atkpoint = 10; 
    public Player player;
    public Projectile bullet;
    String[] IdleAnimation = {"Animasi\\slime\\Slime1_Idle_full\\00_Slime1_Idle_full.png",
        "Animasi\\slime\\Slime1_Idle_full\\01_Slime1_Idle_full.png",
        "Animasi\\slime\\Slime1_Idle_full\\02_Slime1_Idle_full.png",
        "Animasi\\slime\\Slime1_Idle_full\\03_Slime1_Idle_full.png",
        "Animasi\\slime\\Slime1_Idle_full\\04_Slime1_Idle_full.png",
        "Animasi\\slime\\Slime1_Idle_full\\05_Slime1_Idle_full.png"};
    public Enemy(Player player){
        this.player = player;
    }
    public void act()
    {
        if(player.alive == true){
            framehit++;
            enemyX = getX();
            enemyY = getY();
            chasePlayer();
            animationCounter = animationCounter +1;
            if(animationCounter % 6 == 0){
                framecount = super.Animate(IdleAnimation,framecount);
            }
            if(framehit  >= 200){
            collisionPlayer();
            }
            projectileCollision();
        }
        else{
            return;
        }
        
    }
    
    public void chasePlayer(){
        if(enemyX >= player.playerX){
            if(enemyY >=player.playerY){
                setLocation(getX(), getY()-speed);
            }
            else if(enemyY <=player.playerY){
                setLocation(getX(), getY()+speed);
            }
            setLocation(getX()-speed, getY());
        }
        else if (enemyX <= player.playerX){
            if(enemyY >=player.playerY){
                setLocation(getX(), getY()-speed);
            } 
            else if(enemyY <=player.playerY){
                setLocation(getX(), getY()+speed);
            }
            setLocation(getX()+speed, getY());
        }
    }
    
    public void collisionPlayer(){
        if(isTouching(Player.class)) {
            player.getDamage(atkpoint);
            framehit = 0;
        }
    }
    public void projectileCollision(){
        if(isTouching(Projectile.class)){
            removeTouching(Projectile.class);
            getWorld().removeObject(this);
        }
    }
}
