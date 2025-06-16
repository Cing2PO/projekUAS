import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

public class SlimeKing extends Enemy
{
    public int framecount = 0;
    private int framehit = 200;
    private int scaling = 200;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    public boolean move = false;
    public boolean alive=true; // This seems redundant as Enemy now manages HP
=======
=======
>>>>>>> Stashed changes
    public boolean move = true;
    public boolean attack = false;
    public boolean alive=true;
>>>>>>> Stashed changes
    public int animationCounter=0;
    public int enemyX,enemyY,enemyAtk;
    public int speed = 1;
    public int atkpoint = 10;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    // public int hp=200; // No longer needed here, handled by Enemy parent
=======
    public int hp = 200; 
>>>>>>> Stashed changes
=======
    public int hp = 200; 
>>>>>>> Stashed changes
    public int atkInterval = 200;
    public int hitpoint = 4;
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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
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
=======
=======
>>>>>>> Stashed changes
        enemyX = getX();
        enemyY = getY();
        framehit++;
        enemyAtk=player.atk;
        animationCounter = animationCounter +1;
        double distance = distance(player.playerX,player.playerY);
        move = distanceCheck(distance,move,attack);
        if(hp <= 0){
            death();
        }
        else if(player.alive == true&&alive==true){
            if(move == false){
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
                if(animationCounter % 6 == 0){
                    //framecount = super.Animate(AttackAnimation,framecount,scaling);
                    framecount = super.attackAnimate(AttackAnimation, framecount, scaling, hitpoint,enemyX,enemyY, player, atkpoint, distance);
                    move = super.attackCondition(AttackAnimation, framecount, move);
                }
            }
<<<<<<< Updated upstream
<<<<<<< Updated upstream
            if(framehit  >= 200){
                framehit =  super.collisionPlayer(framehit, player, atkpoint);
            }
            if(this.hp <= 0){ // Check this.hp
                death();
                return; // Important: Add return after calling death()
            }
            super.projectileCollision(enemyAtk,slimeBar); // Removed hp parameter
=======
            else if(move == true){
            super.chasePlayer(enemyX, enemyY, player, speed);
            if(animationCounter % 6 == 0){
                framecount = super.Animate(RunAnimation,framecount,scaling);
                }
            }
>>>>>>> Stashed changes
=======
            else if(move == true){
            super.chasePlayer(enemyX, enemyY, player, speed);
            if(animationCounter % 6 == 0){
                framecount = super.Animate(RunAnimation,framecount,scaling);
                }
            }
>>>>>>> Stashed changes
        }
        else{
            return;
        }
    }
<<<<<<< Updated upstream
<<<<<<< Updated upstream

=======
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    private void death(){
        //win();
        getWorld().removeObject(slimeBar);
        getWorld().removeObject(this);
        Greenfoot.setWorld(new Win());
        Greenfoot.stop();
    }

    public void attack(){
        
    }
    
<<<<<<< Updated upstream
    public void win(){
        Greenfoot.setWorld(new Win());
=======
    public void attack(){
        
>>>>>>> Stashed changes
    }
}