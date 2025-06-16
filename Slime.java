import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Slime extends Enemy
{
    public int framecount = 0;
    private int framehit = 200;
    private int scaling = 20;
    public boolean move = false;
    public boolean live; // This variable seems redundant, can be removed
    public int animationCounter=0;
    public int enemyX,enemyY,enemyAtk;
    public int speed = 1;
    public int atkpoint = 10;
    public Player player;
    public Slime slime; // This variable seems redundant
    public EnemyHp slimeBar;
    public Projectile bullet; // This variable seems redundant
    String[] IdleAnimation = {"Animasi\\slime\\Slime1_Idle_full\\00_Slime1_Idle_full.png",
        "Animasi\\slime\\Slime1_Idle_full\\01_Slime1_Idle_full.png",
        "Animasi\\slime\\Slime1_Idle_full\\02_Slime1_Idle_full.png",
        "Animasi\\slime\\Slime1_Idle_full\\03_Slime1_Idle_full.png",
        "Animasi\\slime\\Slime1_Idle_full\\04_Slime1_Idle_full.png",
        "Animasi\\slime\\Slime1_Idle_full\\05_Slime1_Idle_full.png"};

    public Slime(Player player){
        this.player = player;
        this.hp = 20; // Initialize HP here
        this.slimeBar= new EnemyHp(this);
    }

    public void act()
    {
        if(player.alive == true){
            framehit++;
            enemyAtk=player.atk;
            enemyX = getX();
            enemyY = getY();
            super.chasePlayer(enemyX, enemyY, player, speed);
            animationCounter = animationCounter +1;
            if(animationCounter % 6 == 0){
                framecount = super.Animate(IdleAnimation,framecount, scaling);
            }
            if(framehit  >= 200){
                framehit =  super.collisionPlayer(framehit, player, atkpoint);
            }
            super.projectileCollision(enemyAtk,slimeBar); // Removed hp parameter
        }
        else{
            return;
        }
    }
}