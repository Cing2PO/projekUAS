import greenfoot.*; 
public class EnemyHp extends HpBar
{
    int heatlhWidth =10;
    int healtHeight= 5;
    HpFull hpFull= new HpFull(100,5);
    Player player = new Player(hpFull);
    private Slime slime = new Slime(player);
    public void act()
    {
        FollowEnemy();
    }
    public EnemyHp(Slime slime){
        this.slime=slime;
    }
    public void hpUpdate(int hp){
        hp=slime.hp;
        int pixelperhealth= (int) heatlhWidth/hp;
        setImage(new GreenfootImage(heatlhWidth+1,healtHeight+1));
        GreenfootImage hpBar = getImage();
        hpBar.setColor(Color.WHITE);
        hpBar.drawRect(0,0,heatlhWidth,healtHeight);
        hpBar.setColor(Color.RED);
        hpBar.fillRect(1,1,pixelperhealth*hp,healtHeight);
    }
    public void FollowEnemy(){
        setLocation(slime.getX()-2, slime.getY());
    }
}
