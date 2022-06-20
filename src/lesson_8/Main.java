package lesson_8;


public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Mursik", 3);
        Cat cat2 = new Cat("Barsik", 8);

        HashTable hashTable = new HashTable(12);
        hashTable.insert(new Cat());
        hashTable.insert(new Cat());
        hashTable.insert(cat1);
        hashTable.insert(new Cat());
        hashTable.insert(new Cat());
        hashTable.insert(cat2);
        hashTable.insert(new Cat());
        hashTable.insert(new Cat());
        hashTable.insert(new Cat());
        hashTable.insert(new Cat());

        System.out.println(hashTable.getCapacity());

        System.out.println(hashTable.contains(cat1));
        System.out.println(hashTable);

        System.out.println();

        System.out.println(hashTable.delete(cat2));
        System.out.println(hashTable);

    }

}
