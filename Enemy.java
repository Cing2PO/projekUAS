import greenfoot.*;
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
    public void takeDamage(int damage,int hp, EnemyHp slimeBar){
        hp -= damage; // Modify the instance's hp
        slimeBar.hpUpdate(hp);
    }
    public int getHp(int hp){
        return hp;
    }
    public void projectileCollision(int hp, int atk,EnemyHp bar){
        if(isTouching(Projectile.class)){
            if (getHp(hp) > 0) {
                removeTouching(Projectile.class);
                takeDamage(atk,hp,bar);
            }else{
                if (getWorld() != null) { 
                        getWorld().removeObject(this);
                    }
            }
        }
    }
}
