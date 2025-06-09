import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Actor
{
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Player player;
    GreenfootImage weapon = new GreenfootImage("images\\Guns\\AK47.png");
    boolean spreadMode = false;
    int cooldown = 0;
    public Weapon(Player player){
        this.player = player;
        setImage(weapon);
    }
    public void act()
    {
        followPlayer();
        handleModeSwitch();
        shoot();
    }
    public void followMouse(){
        MouseInfo mouse = Greenfoot.getMouseInfo();    
        if(mouse != null){
            turnTowards(mouse.getX(), mouse.getY());
        }
    }
    public void followPlayer(){
        setLocation(player.getX() + 5, player.getY());
    }
    public void handleModeSwitch() {
        if (Greenfoot.isKeyDown("m")) {
            spreadMode = !spreadMode;
            Greenfoot.delay(10);
        }
    }
    private void shoot(){
        if(Greenfoot.mouseClicked(null)){
            if(spreadMode == false){
                shootStraight();
            } else {
                shootSpread();
            }
        }
    }
    private void shootStraight(){
        Projectile p = new Projectile(10);
        getWorld().addObject(p, getX(), getY());
        p.setRotation(getRotation());
    }
    private void shootSpread(){
        for (int angle : new int[] {-10, 0, 10}) {
            Projectile p = new Projectile(5);
            getWorld().addObject(p, getX(), getY());
            p.setRotation(getRotation() + angle);
        }
    }
}
