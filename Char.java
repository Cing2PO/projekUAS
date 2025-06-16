import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Char extends Actor
{
    public int Animate(String FramesArray[],int framecount,int scaling){
        GreenfootImage Frames = new GreenfootImage(FramesArray[framecount]);
        Frames.scale(Frames.getWidth()+scaling,Frames.getHeight()+scaling);
        setImage(Frames);
        if(framecount == FramesArray.length -1){ 
            framecount = 0 ;
        }
        else{
            framecount = framecount+1;
        }
        return framecount;
    }
    public int attackAnimate(String FramesArray[],int framecount,int scaling,int hitpoint,int X, int Y,  Player player, int atkpoint, double distance){
        GreenfootImage Frames = new GreenfootImage(FramesArray[framecount]);
        Frames.scale(Frames.getWidth()+scaling,Frames.getHeight()+scaling);
        setImage(Frames);
        if(framecount == FramesArray.length -1){ 
            framecount = 0 ;
        }
        else if((framecount == hitpoint -1) && (distance <20)){
            framecount = framecount+1;
            player.getDamage(atkpoint);
        }
        else{
            framecount = framecount+1;
        }
        return framecount;
    }
    public boolean attackCondition(String FramesArray[],int framecount,boolean move){
        if(framecount == FramesArray.length -1){
            move = true ;
        }
        return move;
    }

}


