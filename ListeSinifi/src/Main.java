public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();

        System.out.println("Dizideki Eleman Sayısı : " + list.size());
        System.out.println("Dizinin Kapasitesi : " + list.getCapacity());

        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Liste Durumu: " + (list.isEmpty() ? "Boş" : "Dolu"));
        System.out.println("2. indisteki değer : " + list.get(2));
        list.remove(2);
        list.add(40);
        list.set(0, 100);
        System.out.println("2. indisteki değer : " + list.get(2));
        System.out.println(list.toString());

        System.out.println("Dizideki Eleman Sayısı : " + list.size());
        System.out.println("Dizinin Kapasitesi : " + list.getCapacity());

        list.add(50);
        list.add(60);
        list.add(70);
        list.add(50);

        System.out.println("Indeks : " + list.indexOf(20));
        System.out.println("Indeks : " + list.indexOf(110));
        System.out.println("Indeks : " + list.lastIndexOf(50));
        Object[] dizi = list.toArray();
        System.out.println("Object dizisinin ilk elemanı :" + dizi[0]);
        MyList<Integer> altListem = list.subList(0, 3);
        System.out.println(altListem.toString());
        list.add(80);
        list.add(90);
        list.add(100);
        System.out.println("Listemde 20 değeri : " + list.contains(20));
        System.out.println("Listemde 120 değeri : " + list.contains(120));

        list.add(110);
        list.add(120);

        System.out.println("Dizideki Eleman Sayısı : " + list.size());
        System.out.println("Dizinin Kapasitesi : " + list.getCapacity());
        list.clear();
        System.out.println(list.toString());

    }
}