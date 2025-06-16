import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SlimeKing extends Enemy
{
    public int framecount = 0;  
    private int framehit = 200;
    private int scaling = 200;
    public boolean move = false;
    public boolean alive=true;
    public int animationCounter=0;
    public int enemyX,enemyY,enemyAtk;
    public int speed = 1;
    public int atkpoint = 10;
    public int hp=200; 
    public Player player;
    public Slime slime;
    public EnemyHp slimeBar;
    public Projectile bullet;
    String[] IdleAnimation = {"Animasi\\Slimeking\\\\Slime2_Run\\00_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\01_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\02_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\03_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\04_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\05_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\06_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\07_Slime2_Run_full.png",
    };
    GreenfootImage SlimeKingSprite = new GreenfootImage("Animasi\\Slimeking\\\\Slime2_Run\\00_Slime2_Run_full.png");
    public SlimeKing(Player player){
        this.player = player;
        SlimeKingSprite.scale(SlimeKingSprite.getWidth()+200,SlimeKingSprite.getHeight()+200);
        setImage(SlimeKingSprite);
        this.slimeBar = new EnemyHp(this);
    }
    public void act()
    {
        if(player.alive == true&&alive==true){
            framehit++;
            enemyAtk=player.atk;
            enemyX = getX();
            enemyY = getY();
            super.chasePlayer(enemyX, enemyY, player, speed);
            animationCounter = animationCounter +1;
            if(animationCounter % 6 == 0){
                framecount = super.Animate(IdleAnimation,framecount,scaling);
            }
            if(framehit  >= 200){
            framehit =  super.collisionPlayer(framehit, player, atkpoint);
            }
            if(hp <= 0){
                death();
            }
            super.projectileCollision(enemyAtk,this.hp,slimeBar);
        }
        else{
            return;
        }
    }
    private void death(){
        alive = false;
        getWorld().removeObject(slimeBar);
        getWorld().removeObject(this);
    }
    public void takeDamage(int damage) {
        this.hp -= damage; // Modify the instance's hp
        slimeBar.hpUpdate(this.hp); // Update the bar with the instance's hp
    }
    public int getHp() {
        return this.hp; // Return the instance's hp
    }
}
