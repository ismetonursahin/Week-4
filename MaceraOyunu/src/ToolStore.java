public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "ToolStore");
    }

    @Override
    public boolean onLocation() {
        System.out.println("\n  ==>  Dükkana Girdin  <==");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("\n1 - Silahlar" +
                    "\n2 - Zırhlar" +
                    "\n3 - Menüye Dön.");
            System.out.print("\n Seçiminiz : ");
            int selectCase = input.nextInt();
            while (selectCase > 3 || selectCase < 1) {
                System.out.println("Geçersiz Bir Değer Girdiniz, Tekrar Giriniz : ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Yine bekleriz");
                    showMenu = false;
                    break;
            }
        }
          return true;
    }

    public void printWeapon() {
        System.out.println("    ==> Silahlar <==     ");

        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getID() + " - "
                    + w.getName() +  "  => Para:"
                    + w.getPrice() + ", => Hasar:"
                    + w.getDamage() + " >");
        }
        System.out.println("0 - Dükkana Geri Dön");
    }

    public void buyWeapon() {

        System.out.print("Bir Silah Seç : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Geçersiz Değer, Tekrar Gir.");
            selectWeaponID = input.nextInt();
        }

        if(selectWeaponID !=0 ){

        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("\n !! Yeterli Paran Yok !!");
            } else {
                //Satın alım gerçekleştiği alan
                System.out.println(" * " + selectedWeapon.getName() + " Silahını aldın.");
                int balance = this.getPlayer().getMoney() - (selectedWeapon.getPrice());
                this.getPlayer().setMoney(balance);
                System.out.println(" * Kalan Paran : " + this.getPlayer().getMoney());
                System.out.println(" * Önceki Silahın : ==> " + this.getPlayer().getInventory().getWeapon().getName());

                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println(" * Yeni Silahın :   ==> " + this.getPlayer().getInventory().getWeapon().getName());

            }
        }
    }
}


    public void printArmor() {
        System.out.println("    ==>  Zırhlar  <==    ");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getID() + " - " + a.getName() + " =>Para: " + a.getPrice() + ", =>Block: " + a.getBlock() + " >");
        }
        System.out.println("0 - Mağazaya Dön");
    }

    public void buyArmor() {
        System.out.print("Bir Silah Seç : ");

        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Geçersiz Değer, Tekrar Gir.");
            selectArmorID = input.nextInt();
        }

        if (selectArmorID != 0) {
        Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("\n !! Yeterli Paran Yok !!");
            } else {
                //Satın alım gerçekleştiği alan
                System.out.println(" * " + selectedArmor.getName() + " Silahını aldın.");
                int balance = this.getPlayer().getMoney() - (selectedArmor.getPrice());
                this.getPlayer().setMoney(balance);
                System.out.println(" * Kalan Paran : " + this.getPlayer().getMoney());
                System.out.println(" * Önceki Silahın : ==> " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println(" * Yeni Silahın :   ==> " + this.getPlayer().getInventory().getWeapon().getName());

            }
        }
    }
}
