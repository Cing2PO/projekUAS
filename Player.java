import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Char
{
    public int framecount = 0;
    private int scaling  = 50;
    public boolean alive;
    public boolean move = false;
    public int animationCounter=0;
    public static int speed = 3;
    public static int hp = 100;
    public static int atk=100;
    public static int diagonalspeed = speed/2;
    public static int playerX,playerY;
    HpFull bar;
    String[] IdleAnimation = {"Animasi\\player1\\idle\\idle_down\\00_idle_down.png","Animasi\\player1\\idle\\idle_down\\01_idle_down.png","Animasi\\player1\\idle\\idle_down\\02_idle_down.png","Animasi\\player1\\idle\\idle_down\\03_idle_down.png","Animasi\\player1\\idle\\idle_down\\04_idle_down.png","Animasi\\player1\\idle\\idle_down\\05_idle_down.png","Animasi\\player1\\idle\\idle_down\\06_idle_down.png","Animasi\\player1\\idle\\idle_down\\07_idle_down.png"};
    String[] WalkUpAnimation = {"Animasi\\player1\\Walk\\walk_up\\00_walk_up.png","Animasi\\player1\\Walk\\walk_up\\01_walk_up.png","Animasi\\player1\\Walk\\walk_up\\02_walk_up.png","Animasi\\player1\\Walk\\walk_up\\03_walk_up.png","Animasi\\player1\\Walk\\walk_up\\04_walk_up.png","Animasi\\player1\\Walk\\walk_up\\05_walk_up.png","Animasi\\player1\\Walk\\walk_up\\06_walk_up.png","Animasi\\player1\\Walk\\walk_up\\07_walk_up.png"};
    String[] WalkDownAnimation = {"Animasi\\player1\\Walk\\walk_down\\00_walk_down.png","Animasi\\player1\\Walk\\walk_down\\01_walk_down.png","Animasi\\player1\\Walk\\walk_down\\02_walk_down.png","Animasi\\player1\\Walk\\walk_down\\03_walk_down.png","Animasi\\player1\\Walk\\walk_down\\04_walk_down.png","Animasi\\player1\\Walk\\walk_down\\05_walk_down.png","Animasi\\player1\\Walk\\walk_down\\06_walk_down.png","Animasi\\player1\\Walk\\walk_down\\07_walk_down.png"};
    String[] WalkRightUpAnimation = {"Animasi\\player1\\Walk\\walk_right_up\\00_walk_right_up.png","Animasi\\player1\\Walk\\walk_right_up\\01_walk_right_up.png","Animasi\\player1\\Walk\\walk_right_up\\02_walk_right_up.png","Animasi\\player1\\Walk\\walk_right_up\\03_walk_right_up.png","Animasi\\player1\\Walk\\walk_right_up\\04_walk_right_up.png","Animasi\\player1\\Walk\\walk_right_up\\05_walk_right_up.png","Animasi\\player1\\Walk\\walk_right_up\\06_walk_right_up.png","Animasi\\player1\\Walk\\walk_right_up\\07_walk_right_up.png"};
    String[] WalkRightDownAnimation = {"Animasi\\player1\\Walk\\walk_right_down\\00_walk_right_down.png","Animasi\\player1\\Walk\\walk_right_down\\01_walk_right_down.png","Animasi\\player1\\Walk\\walk_right_down\\02_walk_right_down.png","Animasi\\player1\\Walk\\walk_right_down\\03_walk_right_down.png","Animasi\\player1\\Walk\\walk_right_down\\04_walk_right_down.png","Animasi\\player1\\Walk\\walk_right_down\\05_walk_right_down.png","Animasi\\player1\\Walk\\walk_right_down\\06_walk_right_down.png","Animasi\\player1\\Walk\\walk_right_down\\07_walk_right_down.png"};
    String[] WalkLeftUpAnimation = {"Animasi\\player1\\Walk\\walk_left_up\\00_walk_left_up.png","Animasi\\player1\\Walk\\walk_left_up\\01_walk_left_up.png","Animasi\\player1\\Walk\\walk_left_up\\02_walk_left_up.png","Animasi\\player1\\Walk\\walk_left_up\\03_walk_left_up.png","Animasi\\player1\\Walk\\walk_left_up\\04_walk_left_up.png","Animasi\\player1\\Walk\\walk_left_up\\05_walk_left_up.png","Animasi\\player1\\Walk\\walk_left_up\\06_walk_left_up.png","Animasi\\player1\\Walk\\walk_left_up\\07_walk_left_up.png"};
    String[] WalkLeftDownAnimation = {"Animasi\\player1\\Walk\\walk_left_down\\00_walk_left_down.png","Animasi\\player1\\Walk\\walk_left_down\\01_walk_left_down.png","Animasi\\player1\\Walk\\walk_left_down\\02_walk_left_down.png","Animasi\\player1\\Walk\\walk_left_down\\03_walk_left_down.png","Animasi\\player1\\Walk\\walk_left_down\\04_walk_left_down.png","Animasi\\player1\\Walk\\walk_left_down\\05_walk_left_down.png","Animasi\\player1\\Walk\\walk_left_down\\06_walk_left_down.png","Animasi\\player1\\Walk\\walk_left_down\\07_walk_left_down.png"};
    
    public Player(HpFull bar){
        this.bar =  bar;
        alive = true;
    }
    
    public void act()
    {
        if(alive == true){
            playerX = getX();
            playerY = getY();
            animationCounter = animationCounter +1;
            if(move == false){
                if(animationCounter % 6 == 0){
                    framecount = super.Animate(IdleAnimation, framecount,scaling);
                }
            }
            if(hp <= 0){
                death();
            }
            move();
        }
        else{
            return;
        }
    }
    
    private void move(){
        if(Greenfoot.isKeyDown("W")){
            move = true;
            if(animationCounter % 6 == 0 && move){
            framecount = super.Animate(WalkUpAnimation, framecount, scaling);
            }
            setLocation(getX(), getY()-speed);
        }
        else if(Greenfoot.isKeyDown("S")){
            move = true;
            if(animationCounter % 6 == 0 && move){
            framecount = super.Animate(WalkDownAnimation, framecount, scaling);
            }
            setLocation(getX(), getY()+speed);
        }
        else if(Greenfoot.isKeyDown("A")){
            move = true;
            if(animationCounter % 6 == 0 && move){
            framecount = super.Animate(WalkLeftDownAnimation, framecount,scaling);
            }
            setLocation(getX()-speed, getY());
        }
        else if(Greenfoot.isKeyDown("D")){
            move = true;
            if(animationCounter % 6 == 0 && move){
            framecount = super.Animate(WalkRightDownAnimation, framecount, scaling);
            }
            setLocation(getX()+speed, getY());
        }
        if(Greenfoot.isKeyDown("W") && Greenfoot.isKeyDown("D")){
            move = true;
            if(animationCounter % 6 == 0 && move){
            framecount = super.Animate(WalkRightUpAnimation, framecount, scaling);
            }
            setLocation(getX()+diagonalspeed, getY()-diagonalspeed);
        }
        if(Greenfoot.isKeyDown("W") && Greenfoot.isKeyDown("A")){
            move = true;
            if(animationCounter % 6 == 0 && move){
            framecount = super.Animate(WalkLeftUpAnimation, framecount, scaling);
            }
            setLocation(getX()-diagonalspeed, getY()-diagonalspeed);
        }
        if(Greenfoot.isKeyDown("S") && Greenfoot.isKeyDown("A")){
            move = true;
            if(animationCounter % 6 == 0 && move){
            framecount = super.Animate(WalkLeftDownAnimation, framecount, scaling);
            }
            setLocation(getX()-diagonalspeed, getY()+diagonalspeed);
        }
        if(Greenfoot.isKeyDown("S") && Greenfoot.isKeyDown("D")){
            move = true;
            if(animationCounter % 6 == 0 && move){
            framecount = super.Animate(WalkRightDownAnimation, framecount, scaling);
            }
            setLocation(getX()+diagonalspeed, getY()+diagonalspeed);
        }
        else {
            move = false;
        }
    }
    
    public void getDamage(int damage){
        hp = hp - damage;
        bar.hpUpdate(hp);
    }
    private void death(){
        alive = false;
        GameManager.battle_music.stop();
        GameManager.gameover_music.playLoop();
        getWorld().removeObject(bar);
        getImage().setTransparency(0);
        LoseText lose = new LoseText();
        Restart restart = new Restart();
        Exit exit = new Exit();
        getWorld().addObject(lose, 320,200);
        getWorld().addObject(restart, 200,400);
        getWorld().addObject(exit, 400,400);
    }
    
    
    
    
}
