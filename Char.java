import greenfoot.*;

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
    public boolean deathCondition(String FramesArray[],int framecount,boolean alive){
        if(framecount == FramesArray.length -1){
            alive = false ;
        }
        return alive;
    }

}


