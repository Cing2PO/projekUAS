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
    public void projectileCollision(int hp, int atk,EnemyHp bar){
        if(isTouching(Projectile.class)){
            getDamage(hp,atk,bar);
            removeTouching(Projectile.class);
            if (hp <= 0) {
                if (getWorld() != null) { 
                        getWorld().removeObject(this);
                    }
            }
        }
    }
    public void getDamage(int hp,int damage,EnemyHp bar){
        hp = hp - damage;
        bar.hpUpdate(hp);
    }
}
