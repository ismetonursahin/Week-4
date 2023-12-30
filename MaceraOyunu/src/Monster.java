public class Monster {
    private int ID;
    private String name;
    private int damage;
    private int health;
    private int award;
    private int orjinaHealth;



    public Monster(int ID, String name, int damage, int health ,int award) {
        this.ID = ID;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.orjinaHealth=health;
        this.award =award;

    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }
    public int getOrjinaHealth() {
        return orjinaHealth;
    }

    public void setOrjinaHealth(int orjinaHealth) {
        this.orjinaHealth = orjinaHealth;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health<0){
            health=0;
        }
        this.health = health;
    }
}
