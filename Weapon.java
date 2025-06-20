import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Weapon extends Actor
{
    private Player player;
    final GreenfootImage Bow = new GreenfootImage("images\\Weapon\\Bow01.png");
    GreenfootSound shotsfx = new GreenfootSound("sfx\\bow\\arrowsfx.mp3");
    boolean spreadMode = false;
    int cooldown = 0;
    int straightShotsFired = 0;
    static int cooldownTime = 50;
    public Weapon(Player player){
        this.player = player;
        setImage(Bow);
    }
    public void act()
    {
        followPlayer();
        followMouse();
        handleModeSwitch();
        if (cooldown > 0) {
            cooldown--;
        } else {
            shoot();
        }
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
            straightShotsFired = 0;
        }
    }
    private void shoot(){
        if(Greenfoot.mousePressed(null)){
            if(spreadMode == false){
                shootStraight();
            } else {
                shootSpread();
                cooldown = cooldownTime;
            }
        }
    }
    private void shootStraight(){
        Projectile p = new Projectile(10);
        getWorld().addObject(p, getX(), getY());
        p.setRotation(getRotation());
        straightShotsFired++;
        shotsfx.play();
        cooldown = cooldownTime;
        //if(straightShotsFired >= 3){
            //cooldown = cooldownTime;
            //straightShotsFired = 0;
    }
    private void shootSpread(){
        for (int angle : new int[] {-10, 0, 10}) {
            Projectile p = new Projectile(5);
            getWorld().addObject(p, getX(), getY());
            p.setRotation(getRotation() + angle);
        }
    }
}
