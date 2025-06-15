import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SlimeKing extends Enemy
{
    public int framecount = 0;  
    private int framehit = 200;
    private int scaling = 200;
    public boolean move = false;
    public int animationCounter=0;
    public int enemyX,enemyY;
    public int speed = 1;
    public int atkpoint = 10; 
    public int atkInterval = 200;
    public int hitpoint = 8;
    public Player player;
    public Projectile bullet;
    String[] RunAnimation = {"Animasi\\Slimeking\\\\Slime2_Run\\00_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\01_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\02_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\03_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\04_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\05_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\06_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\07_Slime2_Run_full.png",
    };
    String[] AttackAnimation = {"Animasi\\Slimeking\\\\Slime2_Attack\\00_Slime2_Attack_full.png",
        "Animasi\\Slimeking\\\\Slime2_Attack\\01_Slime2_Attack_full.png",
        "Animasi\\Slimeking\\\\Slime2_Attack\\02_Slime2_Attack_full.png",
        "Animasi\\Slimeking\\\\Slime2_Attack\\03_Slime2_Attack_full.png",
        "Animasi\\Slimeking\\\\Slime2_Attack\\04_Slime2_Attack_full.png",
        "Animasi\\Slimeking\\\\Slime2_Attack\\05_Slime2_Attack_full.png",
        "Animasi\\Slimeking\\\\Slime2_Attack\\06_Slime2_Attack_full.png",
        "Animasi\\Slimeking\\\\Slime2_Attack\\07_Slime2_Attack_full.png",
        "Animasi\\Slimeking\\\\Slime2_Attack\\08_Slime2_Attack_full.png",
        "Animasi\\Slimeking\\\\Slime2_Attack\\09_Slime2_Attack_full.png",
        "Animasi\\Slimeking\\\\Slime2_Attack\\10_Slime2_Attack_full.png",
    };
    GreenfootImage SlimeKingSprite = new GreenfootImage("Animasi\\Slimeking\\\\Slime2_Run\\00_Slime2_Run_full.png");
    public SlimeKing(Player player){
        this.player = player;
        SlimeKingSprite.scale(SlimeKingSprite.getWidth()+200,SlimeKingSprite.getHeight()+200);
        setImage(SlimeKingSprite);
    }
    public void act()
    {
        if(player.alive == true){
            framehit++;
            enemyX = getX();
            enemyY = getY();
            super.chasePlayer(enemyX, enemyY, player, speed);
            animationCounter = animationCounter +1;
            if(getX()+10<=player.playerX && getY()+10<=player.playerY && (atkInterval <= 200)){
                attack();
            }
            else{
                if(animationCounter % 6 == 0){
                    framecount = super.Animate(RunAnimation,framecount,scaling);
                }
            }
        }
        else{
            return;
        }
    }
    
    public void attack(){
        if(animationCounter % 6 == 0){
            int [] val = super.attackAnimate(RunAnimation,framecount,scaling, atkInterval,hitpoint, player, atkpoint);
            framecount = val[0];
            atkInterval = val[1];
        }
    }
}
