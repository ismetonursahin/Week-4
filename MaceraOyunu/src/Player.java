import javax.swing.text.Style;
import java.lang.ref.PhantomReference;
import java.util.Scanner;

public class Player {

    private int health;
    private int orjinalHealth;
    private int damage;
    private int money;
    private String playerName;
    private String charName;
    Scanner input = new Scanner(System.in);
    private Inventory inventory;


    public Player(String playerName) {
        this.playerName = playerName;
        this.inventory = new Inventory();
    }

    public void printInfo() {
        System.out.println("Silahın: " + this.getInventory().getWeapon().getName() +
                ", Zırhın: " + this.getInventory().getArmor().getName() +
                ", Bloklama: " + this.getInventory().getArmor().getBlock() +
                ", Hasar: " + this.getTotalDamage() +
                ", Sağlık: " + this.getHealth() +
                ", Para: " + this.getMoney());
    }

    public void selectChar() {
        Samurai samurai = new Samurai();
        Archer archer = new Archer();
        Knight knight = new Knight();

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("-----------------------------------------------------------");
        for (GameChar gameChar : charList) {
            System.out.println("Id: " + gameChar.getID() +
                    "\t Karakter: " + gameChar.getName() +
                    "\t Hasar: " + gameChar.getDamage() +
                    "\t Sağlık: " + gameChar.getHealth() +
                    "\t Para: " + gameChar.getMoney());
        }
        System.out.println("-----------------------------------------------------------");

        System.out.print("Lütfen Bir Karakter Seç (1-2-3) : ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("  * " + this.getCharName() + " Oldun!");
    }

    public void selectLoc() {

    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
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

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}