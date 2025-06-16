import greenfoot.*;
public class EnemyHp extends HpBar
{
    int heatlhWidth =30;
    int healtHeight= 5;
    private Enemy enemy;
    private int maxHp; // Added to store maximum HP

    public void act()
    {
        if(enemy.getWorld()!=null){
            FollowEnemy();
        }else{
            // If the enemy is removed, also remove the health bar
            getWorld().removeObject(this);
        }
    }
    public EnemyHp(Enemy enemy){
        this.enemy=enemy;
        this.maxHp = enemy.getHp(); // Store the initial HP as maxHp
        hpUpdate(enemy.getHp()); // Initial update when created
    }
    public void hpUpdate(int currentHp){ // Renamed parameter to currentHp for clarity
        // Calculate the percentage of current HP remaining
        double hpPercentage = (double) currentHp / maxHp;
        // Calculate the width of the health bar based on the percentage
        int pixelperhealth = (int) (heatlhWidth * hpPercentage);

        // Ensure that pixelperhealth is not negative
        if (pixelperhealth < 0) {
            pixelperhealth = 0;
        }

        setImage(new GreenfootImage(heatlhWidth+1,healtHeight+1));
        GreenfootImage hpBar = getImage();
        hpBar.setColor(Color.WHITE);
        hpBar.drawRect(0,0,heatlhWidth,healtHeight);
        hpBar.setColor(Color.RED);
        hpBar.fillRect(1,1,pixelperhealth,healtHeight);
        setImage(hpBar);
    }
    public void FollowEnemy(){
        setLocation(enemy.getX(), enemy.getY()-20);
    }
}
