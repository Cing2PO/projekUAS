import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    GreenfootImage bullet = new GreenfootImage("images\\Bullets\\PistolAmmoSmall.png");
    private int speed;
    public int atk=10;
    public Projectile(int speed){
        this.speed = speed;
        bullet.scale(bullet.getWidth() + 10, bullet.getHeight()+10);
        setImage(bullet);
    }
    public void act()
    {
        move(speed);
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
