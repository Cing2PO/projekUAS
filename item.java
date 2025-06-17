import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class item extends powerup
{
    String[] powerup1 = {"images\\powerup\\stat_boost1.png",
        "images\\powerup\\enemy_debuff1.png",
        "images\\powerup\\armor.png",
        "images\\powerup\\heal_potion1.png",
        "images\\powerup\\atk_potion1.png",
        "images\\powerup\\def_potion1.png",
        "images\\powerup\\speed_potion1.png",
        "images\\powerup\\+maxhp1.png",
    };
    String[] powerup2 = {"images\\powerup\\statboost (2).png",
        "images\\powerup\\enemydebuff (2).png",
        "images\\powerup\\armor.png",
        "images\\powerup\\heal_potion (2).png",
        "images\\powerup\\atk_potion (2).png",
        "images\\powerup\\def_potion (2).png",
        "images\\powerup\\speed_potion (2).png",
        "images\\powerup\\+maxhp (2).png",
    };
    String[] powerup3 = {"images\\powerup\\statboost (3).png",
        "images\\powerup\\enemydebuff (3).png",
        "images\\powerup\\heal_potion (3).png",
        "images\\powerup\\atk_potion (3).png",
        "images\\powerup\\def_potion (3).png",
        "images\\powerup\\speed_potion (3).png",
        "images\\powerup\\+maxhp3.png",
        "images\\powerup\\balatro.png"
    };
    private int num;
    GameManager manage;
    GreenfootImage itemimage;
    public item(){
        this.itemimage = new GreenfootImage(powerup1[num]);
        itemimage.scale(itemimage.getWidth()+100,itemimage.getHeight()+100);
        setImage(this.itemimage);
    }
    public void press(){
    if (Greenfoot.mouseClicked(this)){
        switch (this.num){
            case 1:
                Player.atk = Player.atk + 5;
                Player.speed = Player.speed + 1;
                Player.hp = Player.hp + 25;
                Weapon.cooldownTime = Weapon.cooldownTime - 10;
                GameManager.gamestatus = true;
                PlayGround.itempop = false;
            case 2:
                Slime.atkpoint = Slime.atkpoint -2;
                SlimeKing.atkpoint = SlimeKing.atkpoint -5;
                SlimeKing.speed = SlimeKing.speed-1;
                GameManager.gamestatus = true;
                PlayGround.itempop = false;
            case 3:
                Player.hp= Player.hp+2;
                GameManager.gamestatus = true;
                PlayGround.itempop = false;
            case 4:
                Player.hp = Player.hp + 5;
                GameManager.gamestatus = true;
                PlayGround.itempop = false;
            case 5:
                Player.atk = Player.atk + 5;
                GameManager.gamestatus = true;                
                PlayGround.itempop = false;
            case 6:
                Weapon.cooldownTime = Weapon.cooldownTime - 10;
                GameManager.gamestatus = true;                
                PlayGround.itempop = false;
            case 7:
                Player.speed = Player.speed + 2;
                GameManager.gamestatus = true;
                PlayGround.itempop = false;
            case 8:
                Player.hp = Player.hp+2;
                GameManager.gamestatus = true;
                PlayGround.itempop = false;
                
                
            }
        }
    }
    
    public void randomize(){
        this.num = Greenfoot.getRandomNumber(8);
        this.itemimage = new GreenfootImage(powerup1[num]);
        itemimage.scale(itemimage.getWidth()+100,itemimage.getHeight()+100);
        setImage(this.itemimage);
    }
    public void KYS(){
        this.getImage().setTransparency(0);
    }
    public void ItemSpawn(){
        this.getImage().setTransparency(255);
    }
}
