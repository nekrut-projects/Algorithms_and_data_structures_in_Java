package lesson_8;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<Cat>[] array;
    private int size;
    private float loadBalance;
    private int capacity;

    public HashTable(int capacity) {
        this.array = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = new LinkedList<>();
        }
        this.capacity = capacity;
        this.size = 0;
        this.loadBalance = 0.7F;
    }

    private int getIndex(Cat cat) {
        return Math.abs(cat.hashCode() % array.length);
    }

    public void insert(Cat cat) {
        if (size / (capacity * 1.0F) >= loadBalance) {
            increaseArray();
        }
        int idx = getIndex(cat);
        array[idx].addFirst(cat);
        ++size;
    }

    private void increaseArray() {
        LinkedList<Cat>[] oldArray = array;
        capacity *=2;
        size = 0;
        array = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = new LinkedList<>();
        }

        for (int i = 0; i < oldArray.length; i++) {
            for (int j = 0; j < oldArray[i].size(); j++) {
                insert(oldArray[i].get(j));
            }
        }
    }

    public boolean contains(Cat cat) {
        int idx = getIndex(cat);
        return array[idx].contains(cat);
    }

    public boolean delete(Cat cat) {
        int idx = getIndex(cat);
        if (array[idx].remove(cat)){
            --size;
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HT{\n");
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < array[i].size(); j++) {
                sb.append(j == 0 ? "\t" : ", ");
                sb.append(array[i].get(j));
            }
            if (array[i].size() != 0) {
                sb.append('\n');
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public int getCapacity() {
        return capacity;
    }
}
