import java.awt.*;
import java.util.Scanner;

public class Game {
    private Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.println("      * MACERA OYUNU *     ");
        System.out.println("Oyunda Kullanacağınız İsim : ");
        //  String playerName = scan.nextLine();
        Player player = new Player("İsmet");
        System.out.println("Karanlığa Hoşgeldin " + player.getPlayerName());
        System.out.println("Artık Tek Başınasın...");
        System.out.println("-----------------------------------------------------");
        System.out.println("  - OYUNDAKİ KARAKTERLER  -");
        player.selectChar();
        Location location = null;

        while (true) {
            player.printInfo();
            System.out.println("\n   ==> Bölgeler <== \n     ");
            System.out.println("1 - Güvenli Ev --> Güvenli Bölge, Düşman Yok, Can Yenilenir. ");
            System.out.println("2 - Envanter Dükkanı  -->  Silah veya Zırh Alabilirsin");
            System.out.println("3 - Mağara  --> <- Ödül: YEMEK  ->  Mağaraya Gir. Zombilere Dikkat Et!");
            System.out.println("4 - Orman   --> <- Ödül: ODUN   ->  Ormana Git. Vampirler Çok Tehlikeli");
            System.out.println("5 - Nehir   --> <- Ödül: SU     ->  Nehire Git. Ayılar Seni Bekliyor.");
            System.out.println("6 - Maden   --> <- Ödül: ŞANS?  ->  Burada Yılanlarla Savaşacksın.");
            System.out.println("0 - Çıkış Yap ==> Oyunu Sonlandır.");

            System.out.print("\nGitmek İstediğin Yer : ");
            int selectLoc = scan.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5 :
                    location = new River(player);
                    break;
                case 6 :
                    location = new Mine(player);
                default:
                    System.out.println("Geçerli Bir Bölge Gir ! ");;
            }
            if (location == null) {
                System.out.println("Oyun Bitti...");
                break;
            }

            if (!location.onLocation()) {
                System.out.println(" -- GAME OVER --");
                break;
            }
        }
    }
}
