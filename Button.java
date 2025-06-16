import greenfoot.*; 
public class Button extends Actor
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
}
