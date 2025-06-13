import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Musuh here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Char
{
    
    public void chasePlayer(int enemyX, int enemyY, Player player, int speed){
        if(enemyX >= player.playerX){
            if(enemyY >=player.playerY){
                setLocation(getX(), getY()-speed);
            }
            else if(enemyY <=player.playerY){
                setLocation(getX(), getY()+speed);
            }
            setLocation(getX()-speed, getY());
        }
        else if (enemyX <= player.playerX){
            if(enemyY >=player.playerY){
                setLocation(getX(), getY()-speed);
            } 
            else if(enemyY <=player.playerY){
                setLocation(getX(), getY()+speed);
            }
            setLocation(getX()+speed, getY());
        }
    }
    
    public int collisionPlayer(int framehit, Player player, int atkpoint){
        if(isTouching(Player.class)) {
            player.getDamage(atkpoint);
            framehit = 0;
        }
        return framehit;
    }
    public void projectileCollision(){
        if(isTouching(Projectile.class)){
            removeTouching(Projectile.class);
            getWorld().removeObject(this);
        }
    }
}
