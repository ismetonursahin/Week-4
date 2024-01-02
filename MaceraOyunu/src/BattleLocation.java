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
        int obsNumber = this.randomMonsterNumber();
        System.out.println("Şu an buradasınız : " + this.getName());
        System.out.println("Dikkatli ol! Burada " + obsNumber + " tane " + this.getMonster().getName() + " yaşıyor");
        System.out.print("<S>avaş veya <K>aç: ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")) {
            if (combat(obsNumber)) {
                System.out.println(this.getName() + " tüm düşmanları yendiniz");
                if (this.award.equals("Food") && this.getPlayer().getInventory().isFood() == false) {
                    System.out.println(this.award + " Kazandınız! ");
                    this.getPlayer().getInventory().setFood(true);
                } else if (this.award.equals("Water") && this.getPlayer().getInventory().isWater() == false) {
                    System.out.println(this.award + " Kazandınız! ");
                    this.getPlayer().getInventory().setWater(true);
                } else if (this.award.equals("Firewood") && this.getPlayer().getInventory().isFirewood() == false) {
                    System.out.println(this.award + " Kazandınız! ");
                    this.getPlayer().getInventory().setFirewood(true);
                }
                return true;
            }
            if (this.getPlayer().getHealth() <= 0) {
                System.out.println("Öldünüz.");
                return false;
            }

        }

        return true;
    }


    public boolean combat(int obsNumber) {
        if (this.getMonster().getName().equals("Snake")) {
            this.getMonster().setDamage(this.getMonster().getDamage());
        }
        int hitChance = 0;

        for (int i = 1; i <= obsNumber; i++) {
            this.getMonster().setHealth(this.monster.getOrjinaHealth());
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                hitChance = (int) (Math.random() * 9 + 1);
                System.out.print("<V>ur veya <K>aç: ");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {
                    if (hitChance < 5) {
                        System.out.println("Siz vurdunuz");
                        this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();

                    } else {
                        if (this.getMonster().getHealth() > 0) {

                            System.out.println("Canavar size vurdu");
                            int obstacleDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    }

                } else {
                    return false;
                }

            }
            if (this.getMonster().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı Yendiniz ");
                if (getMonster().getName().equals("Yılan")) {
                    drop();
                }else{
                System.out.println(this.getMonster().getAward() + " para kazandınız");

                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Güncel paranız: " + this.getPlayer().getMoney());

                }
            } else {
                return false;
            }
        }
        return true;
    }
    public void drop() {
        Random r = new Random();
        int chance = r.nextInt() * 100;

        if (chance < 55) {
            Random r1 = new Random();
            int itemchance = r1.nextInt() * 100;
            if (itemchance <= 30) {
                int weaponChance = r1.nextInt() * 100;
                if (weaponChance <= 20) {
                    getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
                    System.out.println(getPlayer().getInventory().getWeapon().getName() + " kazandiniz.");
                }
                if (20 < weaponChance && weaponChance <= 50) {
                    getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
                    System.out.println(getPlayer().getInventory().getWeapon().getName() + " kazandiniz.");
                }
                if (50 < weaponChance) {
                    getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
                    System.out.println(getPlayer().getInventory().getWeapon().getName() + " kazandiniz.");
                }

            }
            if (30 < itemchance && itemchance <= 60) {
                Random r2 = new Random();
                int armorChance = r2.nextInt() * 100;
                if (armorChance <= 20) {
                    getPlayer().getInventory().setArmor(Armor.getArmorObjByID(3));
                    System.out.println(getPlayer().getInventory().getArmor().getName() + " ele gecirildi.");
                }
                if (20 < armorChance && armorChance <= 50) {
                    getPlayer().getInventory().setArmor(Armor.getArmorObjByID(2));
                    System.out.println(getPlayer().getInventory().getArmor().getName() + " ele gecirildi.");
                }
                if (50 < armorChance) {
                    getPlayer().getInventory().setArmor(Armor.getArmorObjByID(1));
                    System.out.println(getPlayer().getInventory().getArmor().getName() + " ele gecirildi.");
                }
            }
            if (60 < itemchance) {
                Random r3 = new Random();
                int goldChance = r3.nextInt() * 100;
                if (goldChance <= 20) {
                    getPlayer().setMoney(getPlayer().getMoney() + 10);
                    System.out.println("10 Altın ele gecirildi.");
                }
                if (20 < goldChance && goldChance <= 50) {
                    getPlayer().setMoney(getPlayer().getMoney() + 5);
                    System.out.println("5 Altın ele gecirildi.");
                }
                if (50 < goldChance) {
                    getPlayer().setMoney(getPlayer().getMoney() + 1);
                    System.out.println("1 Altın ele gecirildi.");
                }
            }
        } else {
            System.out.println("Hiç bir sey kazanamadınız.");
        }
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