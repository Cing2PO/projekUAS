import greenfoot.*; 
public class EnemyHp extends HpBar
{
    int heatlhWidth =30;
    int healtHeight= 5;
    HpFull hpFull= new HpFull(100,5);
    Player player = new Player(hpFull);
    private Slime slime = new Slime(player);
    public void act()
    {
        if(slime.getWorld()!=null){
            int hp=slime.hp;
            FollowEnemy();
            hpUpdate(hp);
        }else{
            getWorld().removeObject(this);
        }
    }
    public EnemyHp(Slime slime){
        this.slime=slime;
    }
    public void hpUpdate(int hp){
        hp=slime.hp;
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
        setLocation(slime.getX()-20, slime.getY());
    }
}
