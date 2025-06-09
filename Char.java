import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Char extends Actor
{
    public int Animate(String FramesArray[],int framecount){
        GreenfootImage Frames = new GreenfootImage(FramesArray[framecount]);
        setImage(Frames);
        if(framecount == FramesArray.length -1){ 
            framecount = 0 ; 
        }
        else{
            framecount = framecount+1;
        }
        return framecount;
    }
}
