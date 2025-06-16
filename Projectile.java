import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    GreenfootImage projectile = new GreenfootImage("images\\Bullets\\RifleAmmoBig.png");
    private int speed;
    public int atk=10;
    public Projectile(int speed){
        this.speed = speed;
        projectile.scale(projectile.getWidth() + 10, projectile.getHeight()+10);
        setImage(projectile);
    }
    public void act()
    {
        move(speed);
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
