public class Weapon  {
    private String name;
    private int ID ;
    private int damage;
    private  int price ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon(String name , int ID, int damage, int price) {
        this.name = name;
        this.ID = ID;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon getWeaponObjById(int id){

        for (Weapon w : Weapon.weapons()){
            if(w.getID() == id){
                return  w;
            }
        }
        return null;
    }

    public static Weapon[] weapons(){
        Weapon[] weaponList = new Weapon[3] ;
        weaponList[0] = new Weapon("Tabanca",1,2,25);
        weaponList[1] = new Weapon("Kılıç",2,3,35);
        weaponList[2] = new Weapon("Tüfek",3,7,45);

        return weaponList;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
