import greenfoot.*;  

public class PlayGround extends MyWorld
{
    public int spawntimer1= 150;  
    public int spawntimer2= 150;
    public int spawntimer3= 150;
    public int spawntimer4= 150;
    Player player = new Player();
    HpEmpty hpEmpty= new HpEmpty(100,5);
    HpFull hpFull= new HpFull(100,5);
    Weapon weapon = new Weapon(player);
    GreenfootImage playerSprite = new GreenfootImage("Animasi\\player1\\idle\\idle_down\\00_idle_down.png");
    GreenfootImage slimeSprite = new GreenfootImage("Animasi\\slime\\Slime1_Idle_full\\00_Slime1_Idle_full.png");
    public PlayGround()
    {     
        GreenfootImage playBackgorund = new GreenfootImage("Map\\Playground.png");
        playBackgorund.scale(playBackgorund.getWidth()+240,playBackgorund.getHeight()+240);
        setBackground(playBackgorund);
        addObject(player, 320, 320);
        player.setImage(playerSprite);
        addObject(weapon,200,210);
        SlimeKing slimeking = new SlimeKing(player);
        addObject(slimeking,320,100);
        addObject(hpEmpty,70,20);
        addObject(hpFull,70,20);
    }
    public void act(){
        spawntimer1 = spawntimer1 + 1 ;
        spawntimer2 = spawntimer2 + 1 ;
        spawntimer3 = spawntimer3 + 1 ;
        spawntimer4 = spawntimer4 + 1 ;
        if(spawntimer1 > 250+Greenfoot.getRandomNumber(500)){
            spawntimer1 = enemySpawner(400,1,1,1,spawntimer1, slimeSprite);
        }
        if(spawntimer2 > 250+Greenfoot.getRandomNumber(500)){
            spawntimer2 = enemySpawner(1,1,400,1,spawntimer2, slimeSprite);
        }
        if(spawntimer3 > 250+Greenfoot.getRandomNumber(500)){
            spawntimer3 = enemySpawner(400,400,400,1,spawntimer3, slimeSprite);
        }
        if(spawntimer4 > 250+Greenfoot.getRandomNumber(500)){
            spawntimer4 = enemySpawner(400,1,400,400,spawntimer4, slimeSprite);
        }
    }
    public int enemySpawner(int x, int xstart,int y, int ystart,int spawntimer, GreenfootImage enemySprite){
        Slime slime = new Slime(player);
        addObject(slime, xstart+Greenfoot.getRandomNumber(x), ystart+Greenfoot.getRandomNumber(y));
        slime.setImage(enemySprite);
        return spawntimer = 0;
    }
}
