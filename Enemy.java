import greenfoot.*;

public class Enemy extends Char {
    protected int hp; // Make hp a protected field so subclasses can access it

    public void chasePlayer(int enemyX, int enemyY, Player player, int speed) {
        if (enemyX >= player.playerX) {
            if (enemyY >= player.playerY) {
                setLocation(getX(), getY() - speed);
            } else if (enemyY <= player.playerY) {
                setLocation(getX(), getY() + speed);
            }
            setLocation(getX() - speed, getY());
        } else if (enemyX <= player.playerX) {
            if (enemyY >= player.playerY) {
                setLocation(getX(), getY() - speed);
            } else if (enemyY <= player.playerY) {
                setLocation(getX(), getY() + speed);
            }
            setLocation(getX() + speed, getY());
        }
    }

    public int collisionPlayer(int framehit, Player player, int atkpoint) {
        if (isTouching(Player.class)) {
            player.getDamage(atkpoint);
            framehit = 0;
        }
        return framehit;
    }

    // This method should be abstract or empty in Enemy and overridden in subclasses
    // since each enemy has its own hp. For now, let's make it modify the enemy's hp.
    public void takeDamage(int damage) {
        this.hp -= damage;
    }

    public int getHp() {
        return this.hp;
    }

    public void projectileCollision(int atk, EnemyHp bar) { // Removed hp parameter
        if (isTouching(Projectile.class)) {
            removeTouching(Projectile.class);
            takeDamage(atk); // Call takeDamage on the instance
            bar.hpUpdate(this.hp); // Update the bar with the instance's hp

            if (this.hp <= 0) { // Check the instance's hp
                if (getWorld() != null) {
                    getWorld().removeObject(bar); // Remove HP bar first
                    getWorld().removeObject(this); // Then remove the enemy
                }
            }
        }
    }
}