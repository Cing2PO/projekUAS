import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    public int framecount = 1;   
    public boolean move = false;
    public int animationCounter=0;
    GreenfootImage IdleAnimation1 = new GreenfootImage("Animasi\\player1\\idle\\idle_down\\00_idle_down.png");
    GreenfootImage IdleAnimation2 = new GreenfootImage("Animasi\\player1\\idle\\idle_down\\01_idle_down.png");
    GreenfootImage IdleAnimation3 = new GreenfootImage("Animasi\\player1\\idle\\idle_down\\02_idle_down.png");
    GreenfootImage IdleAnimation4 = new GreenfootImage("Animasi\\player1\\idle\\idle_down\\03_idle_down.png");
    GreenfootImage IdleAnimation5 = new GreenfootImage("Animasi\\player1\\idle\\idle_down\\04_idle_down.png");
    GreenfootImage IdleAnimation6 = new GreenfootImage("Animasi\\player1\\idle\\idle_down\\05_idle_down.png");
    GreenfootImage IdleAnimation7 = new GreenfootImage("Animasi\\player1\\idle\\idle_down\\06_idle_down.png");
    GreenfootImage IdleAnimation8 = new GreenfootImage("Animasi\\player1\\idle\\idle_down\\07_idle_down.png");
    public void act()
    {
        animationCounter = animationCounter +1;
        if(animationCounter % 6 == 0){
            Animate();
        }
        move();
    }
    
    private void move(){
        int speed = 2;
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
            Animate();
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
            framecount = 7;    
        }
        else if(framecount==7){
            setImage(IdleAnimation7);
            framecount = 8;    
        }
        else if(framecount==8){
            setImage(IdleAnimation8);
            framecount = 1;    
        }
    }
}
