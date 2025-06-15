import greenfoot.*;
public abstract class Enemy extends Char
{
    public abstract void takeDamage(int damage); // This will be implemented by subclasses
    public abstract int getHp(); // This will be implemented by subclasses
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
            if (getHp() > 0) {
                removeTouching(Projectile.class);
                takeDamage(atk);
            }else{
                if (getWorld() != null) { 
                        getWorld().removeObject(this);
                    }
            }
        }
    }
}
