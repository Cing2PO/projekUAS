import greenfoot.*;  

public class PlayGround extends MyWorld
{
    public int spawntimer1= 250;  
    public int spawntimer2= 250;
    public int spawntimer3= 250;
    public int spawntimer4= 250;
    HpEmpty hpEmpty= new HpEmpty(100,5);
    HpFull hpFull= new HpFull(100,5);
    Player player = new Player(hpFull);
    Weapon weapon = new Weapon(player);
    public static int enemykilled = 0;
    public boolean boss = false;
    GreenfootImage playerSprite = new GreenfootImage("Animasi\\player1\\idle\\idle_down\\00_idle_down.png");
    GreenfootImage slimeSprite = new GreenfootImage("Animasi\\slime\\Slime1_Idle_full\\00_Slime1_Idle_full.png");
    ScoreBoard scoreBoard = new ScoreBoard();
    SlimeKing slimeking;
    public PlayGround()
    {     
        GreenfootImage playBackgorund = new GreenfootImage("Map\\Playground.png");
        playBackgorund.scale(playBackgorund.getWidth()+240,playBackgorund.getHeight()+240);
        setBackground(playBackgorund);
        addObject(player, 320, 320);
        player.setImage(playerSprite);
        addObject(weapon,200,210);
        addObject(hpEmpty,70,20);
        addObject(hpFull,70,20);
        addObject(scoreBoard, 575, 50);
    }
    public void act(){
        if (boss && slimeking != null && slimeking.hp <= 0) {
            Greenfoot.setWorld(new Win());
            return;
        }
        if(boss == false){
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
            if(enemykilled>=10){
                boss = true;
                slimeking = new SlimeKing(player);
                addObject(slimeking,320,0);
                addObject(slimeking.slimeBar,320, 0);
            }
        }
        else{
            return;
        }
        
    }
    public int enemySpawner(int x, int xstart,int y, int ystart,int spawntimer, GreenfootImage enemySprite){
        Slime slime = new Slime(player);
        int slimeX = xstart + Greenfoot.getRandomNumber(x);
        int slimeY = ystart + Greenfoot.getRandomNumber(y);
        addObject(slime, slimeX, slimeY);
        addObject(slime.slimeBar, slimeX, slimeY - 2);
        slime.setImage(enemySprite);
        return spawntimer = 0;
    }
    public void bossSpawner(int x, int y ){
        SlimeKing slimeking = new SlimeKing(player);
        addObject(slimeking,320,0);
        addObject(slimeking.slimeBar,320, 0);
    }
    public void enemykillcounter(){
        PlayGround.enemykilled++;
    }
}
