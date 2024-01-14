public class MyList<T> {
    private Object[] array;
    private int size;
    private int capacity;

    // Boş constructor, kapasite varsayılan olarak 10 olarak ayarlanır
    public MyList() {
        this.capacity = 10;
        this.array = new Object[capacity];
        this.size = 0;
    }

    // Kapasite parametresi alarak constructor
    public MyList(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.size = 0;
    }

    // Listenin boyutunu döndüren metod
    public int size() {
        return size; // Listenin boyutunu döndürür
    }

    // Listenin kapasitesini döndüren metod
    public int getCapacity() {
        return capacity; // Dizinin kapasitesini döndürür
    }

    // Yeni eleman ekleyen metod
    public void add(T data) {
        if (size == capacity) {
            // Eğer dizi dolarsa, kapasiteyi iki katına çıkart
            capacity *= 2;
            Object[] newArray = new Object[capacity];
            // Yeni diziye eski verileri kopyala
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = data;
        size++;
    }

    // Belirtilen indisteki elemanı getiren metod
    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Dizin sınırların dışında: " + index);
        }
        return (T) array[index];
    }

    // Belirtilen indise eleman atayan metod
    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            System.out.println("Dizin sınırların dışında: " + index);
        }
        array[index] = data;
    }

    // Listenin elemanlarını gösteren metot
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i != size - 1) {
                result.append(", ");
            }
        }
        result.append(" ]");
        return result.toString();
    }

    // Belirtilen indisteki elemanı silen metod
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Dizin sınırların dışında: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }



    // Listenin içinde belirli bir elemanın indeksini döndüren metod
    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1; // Öğe bulunamadı
    }

    // Listenin içinde belirli bir elemanın son indeksini döndüren metod
    public int lastIndexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    // Listeyi dizi olarak döndüren metod
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }

    // Belirtilen aralıktaki elemanları içeren alt liste oluşturan metod
    public MyList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Geçersiz aralık: fromIndex = " + fromIndex + ", toIndex = " + toIndex);
        }

        MyList<T> subList = new MyList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(this.get(i));
        }
        return subList;
    }

    // Belirli bir elemanın listede olup olmadığını kontrol eden metod
    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    // Listenin tamamını temizleyen metod
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }
}