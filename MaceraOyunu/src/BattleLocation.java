import java.util.Random;

public abstract class BattleLocation extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLocation(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsterNum = randomMonsterNumber();
        System.out.println("Tehlike : " + this.getName());
        System.out.println("Dikkatli Ol! Burada " + monsterNum + " tane " + this.getMonster().getName() + " ile karşılaşacaksın!");
        System.out.println("Savaşmak için -S- , Kaçmak için -K-  : ");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("S")&&combat(monsterNum)) {
                System.out.println(this.getName() + " Tüm " + this.getMonster().getName() + " Yendin");
                return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("\n Öldün...");
            return false;
        }
        return true;
    }

    public boolean combat(int monsterNum) {
        for (int i = 1; i <= monsterNum; i++) {
            this.getMonster().setHealth(this.getMonster().getOrjinaHealth());
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("Saldır -S- ,  Kaç -K- : ");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("S")) {
                    System.out.println("------------------");
                    System.out.println("Kafasını patlattın.");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println("--------------");
                        System.out.println(this.getMonster().getName() + " Sana vurdu!!!");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - this.getMonster().getDamage());
                        afterHit();
                        System.out.println("-----------------");
                    }
                }else {
                    return false;
                }
            }

            if (this.getMonster().getHealth()< this.getPlayer().getHealth()){
                System.out.println(" ==> " +this.getMonster().getName()+" Yendin");
                System.out.println(" ==> "+this.getMonster().getAward()+" Para Kazandın !");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getMonster().getAward());
                System.out.println("Güncel Paran ==> " + this.getPlayer().getMoney());
            }else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Senin Canın : " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + " Canı : " + this.getMonster().getHealth());

    }

    public void playerStats() {
        System.out.println(" ==> " + this.getPlayer().getPlayerName() + " Bilgileri ");
        System.out.println("Sağlık: " + this.getPlayer().getHealth() +
                "\nHasar: " + getPlayer().getTotalDamage() +
                "\nSilah: " + this.getPlayer().getInventory().getWeapon().getName() +
                "\nZırh : " + this.getPlayer().getInventory().getArmor().getName() +
                "\nBlok : " + this.getPlayer().getInventory().getArmor().getBlock() +
                "\nPara : " + getPlayer().getMoney());

    }

    public void monsterStats(int i) {
        System.out.println(" ==> "+ i+". "+ this.getMonster().getName() + " Değerleri ");
        System.out.println("Sağlık : " + this.getMonster().getHealth() +
                "\nHasar : " + getMonster().getDamage() +
                "\nPara  : " + getMonster().getAward() +
                "\nÖdül : " + getMonster().getAward());
    }


    public int randomMonsterNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
