import greenfoot.*; 
public class EnemyHp extends HpBar
{
    int heatlhWidth =30;
    int healtHeight= 5;
    HpFull hpFull= new HpFull(100,5);
    Player player = new Player(hpFull);
    private Enemy enemy;
    public void act()
    {
        if(enemy.getWorld()!=null){
            int hp=getEnemyHp();
            FollowEnemy();
            hpUpdate(hp);
        }else{
            getWorld().removeObject(this);
        }
    }
    public EnemyHp(Enemy enemy){
        this.enemy=enemy;
    }
    public void hpUpdate(int hp){
        int pixelperhealth= (int)(double) heatlhWidth/hp;
        setImage(new GreenfootImage(heatlhWidth+1,healtHeight+1));
        GreenfootImage hpBar = getImage();
        hpBar.setColor(Color.WHITE);
        hpBar.drawRect(0,0,heatlhWidth,healtHeight);
        hpBar.setColor(Color.RED);
        hpBar.fillRect(1,1,pixelperhealth*hp,healtHeight);
        setImage(hpBar);
    }
    public void FollowEnemy(){
        setLocation(enemy.getX()-20, enemy.getY());
    }
     private int getEnemyHp() {
        // Cast to specific enemy type to access their hp field
        if (enemy instanceof Slime) {
            return ((Slime) enemy).hp;
        } else if (enemy instanceof SlimeKing) {
            return ((SlimeKing) enemy).hp;
        }
        return 0; // Default fallback
    }
}
