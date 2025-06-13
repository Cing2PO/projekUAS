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
        Frames.scale(Frames.getWidth()+50,Frames.getHeight()+50);
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


