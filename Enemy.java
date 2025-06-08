import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Musuh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    public int framecount = 1;   
    public boolean move = false;
    public int animationCounter=0;
    public int enemyX,enemyY;
    public int speed = 1;
    public Player player;
    GreenfootImage IdleAnimation1 = new GreenfootImage("Animasi\\slime\\Slime1_Idle_full\\00_Slime1_Idle_full.png");
    GreenfootImage IdleAnimation2 = new GreenfootImage("Animasi\\slime\\Slime1_Idle_full\\01_Slime1_Idle_full.png");
    GreenfootImage IdleAnimation3 = new GreenfootImage("Animasi\\slime\\Slime1_Idle_full\\02_Slime1_Idle_full.png");
    GreenfootImage IdleAnimation4 = new GreenfootImage("Animasi\\slime\\Slime1_Idle_full\\03_Slime1_Idle_full.png");
    GreenfootImage IdleAnimation5 = new GreenfootImage("Animasi\\slime\\Slime1_Idle_full\\04_Slime1_Idle_full.png");
    GreenfootImage IdleAnimation6 = new GreenfootImage("Animasi\\slime\\Slime1_Idle_full\\05_Slime1_Idle_full.png");
    public void act()
    {
        enemyX = getX();
        enemyY = getY();
        chasePlayer();
        animationCounter = animationCounter +1;
        if(animationCounter % 6 == 0){
            Animate();
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
    public void Animate(){
        if(framecount==1){
            setImage(IdleAnimation1);
            framecount = 2;
        }
        else if(framecount==2){
            setImage(IdleAnimation2);
            framecount = 3;
        }
        else if(framecount==3){
            setImage(IdleAnimation3);
            framecount = 4;
        }
        else if(framecount==4){
            setImage(IdleAnimation4);
            framecount = 5;    
        }
        else if(framecount==5){
            setImage(IdleAnimation5);
            framecount = 6;    
        }
        else if(framecount==6){
            setImage(IdleAnimation6);
            framecount = 1;    
        }
    }
}
