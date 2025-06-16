import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SlimeKing extends Enemy
{
    public int framecount = 0;
    private int framehit = 200;
    private int scaling = 100;
    public boolean move = true;
    public boolean attack = false;
    public boolean alive=true;
    public int animationCounter=0;
    public int enemyX,enemyY,enemyAtk;
    public int speed = 1;
    public int atkpoint = 10; 
    public int atkInterval = 200;
    public int hitpoint = 4;
    public Player player;
    public Slime slime; 
    public EnemyHp slimeBar;
    public Projectile bullet;
    GameManager manage = new GameManager();
    String[] RunAnimation = {"Animasi\\Slimeking\\\\Slime2_Run\\00_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\01_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\02_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\03_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\04_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\05_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\06_Slime2_Run_full.png",
        "Animasi\\Slimeking\\\\Slime2_Run\\07_Slime2_Run_full.png",
    };
    String[] AttackAnimation = {
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
        this.hp = 20; // Initialize HP here
        SlimeKingSprite.scale(SlimeKingSprite.getWidth()+200,SlimeKingSprite.getHeight()+200);
        setImage(SlimeKingSprite);
        this.slimeBar = new EnemyHp(this);
    }

    public void act()
    {
        enemyX = getX();
        enemyY = getY();
        framehit++;
        enemyAtk=player.atk;
        animationCounter = animationCounter +1;
        double distance = distance(player.playerX,player.playerY);
        move = distanceCheck(distance,move,attack);
        if(hp <= 0){
            //GameManager.battle_music.stop();
            PlayGround playground = new PlayGround();
            super.death(slimeBar);
        }
        else if(player.alive == true&&alive==true){
            if(move == false){
                if(animationCounter % 6 == 0){
                    //framecount = super.Animate(AttackAnimation,framecount,scaling);
                    framecount = super.attackAnimate(AttackAnimation, framecount, scaling, hitpoint,enemyX,enemyY, player, atkpoint, distance);
                    move = super.attackCondition(AttackAnimation, framecount, move);
                }
            }
            else if(move == true){
            super.chasePlayer(enemyX, enemyY, player, speed);
            if(animationCounter % 6 == 0){
                framecount = super.Animate(RunAnimation,framecount,scaling);
            }
            super.projectileCollision(player.atk, slimeBar);
        }
        else{
            return;
            }
        }
    }
    private boolean distanceCheck(double distance, boolean move, boolean attack){
        if(distance < 20){
            move = false;
        }
        return move;
    }
    private double distance(int playerX, int playerY){
         double distance = Math.sqrt(Math.pow(playerX - enemyX, 2) + Math.pow(playerY - enemyY, 2));
         return distance;
    }                                 
}
    