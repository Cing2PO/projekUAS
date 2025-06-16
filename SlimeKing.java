import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SlimeKing extends Enemy
{
    public int framecount = 0;
    private int framehit = 200;
    private int scaling = 200;
    public boolean move = false;
    public boolean alive=true; // This seems redundant as Enemy now manages HP
    public int animationCounter=0;
    public int enemyX,enemyY,enemyAtk;
    public int speed = 1;
    public int atkpoint = 10;
    // public int hp=200; // No longer needed here, handled by Enemy parent
    public int atkInterval = 200;
    public int hitpoint = 8;
    public Player player;
    public Slime slime; // This seems redundant
    public EnemyHp slimeBar;
    public Projectile bullet; // This seems redundant
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
        this.hp = 200; // Initialize HP here
        SlimeKingSprite.scale(SlimeKingSprite.getWidth()+200,SlimeKingSprite.getHeight()+200);
        setImage(SlimeKingSprite);
        this.slimeBar = new EnemyHp(this);
    }

    public void act()
    {
        if(player.alive == true && this.hp > 0){ // Check this.hp instead of `alive` boolean
            framehit++;
            enemyAtk=player.atk;
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
            if(framehit  >= 200){
                framehit =  super.collisionPlayer(framehit, player, atkpoint);
            }
            if(this.hp <= 0){ // Check this.hp
                death();
                return;
            }
            super.projectileCollision(enemyAtk,slimeBar); // Removed hp parameter
        }
        else{
            return;
        }
    }

    private void death(){
        win();
        getWorld().removeObject(slimeBar);
        getWorld().removeObject(this);
    }

    public void attack(){
        if(animationCounter % 6 == 0){
            int [] val = super.attackAnimate(RunAnimation,framecount,scaling, atkInterval,hitpoint, player, atkpoint);
            framecount = val[0];
            atkInterval = val[1];
        }
    }
    public void win(){
        Greenfoot.setWorld(new Win());
    }
}