import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Char
{
    public int framecount = 0;   
    public boolean move = false;
    public int animationCounter=0;
    public int speed = 3;
    public static int playerX,playerY;
    String[] IdleAnimation = {"Animasi\\player1\\idle\\idle_down\\00_idle_down.png",
        "Animasi\\player1\\idle\\idle_down\\01_idle_down.png",
        "Animasi\\player1\\idle\\idle_down\\02_idle_down.png",
        "Animasi\\player1\\idle\\idle_down\\03_idle_down.png",
        "Animasi\\player1\\idle\\idle_down\\04_idle_down.png",
        "Animasi\\player1\\idle\\idle_down\\05_idle_down.png",
        "Animasi\\player1\\idle\\idle_down\\06_idle_down.png",
        "Animasi\\player1\\idle\\idle_down\\07_idle_down.png"};
    public void act()
    {
        playerX = getX();
        playerY = getY();
        animationCounter = animationCounter +1;
        if(animationCounter % 6 == 0){
            framecount = super.Animate(IdleAnimation, framecount);
        }
        move();
    }
    
    private void move(){
        if(Greenfoot.isKeyDown("Up")){
            setLocation(getX(), getY()-speed);
        }
         if(Greenfoot.isKeyDown("Down")){
            setLocation(getX(), getY()+speed);
        }
         if(Greenfoot.isKeyDown("Left")){
            setLocation(getX()-speed, getY());
        }
         if(Greenfoot.isKeyDown("Right")){
            setLocation(getX()+speed, getY());
        }
    }
    
    
}
