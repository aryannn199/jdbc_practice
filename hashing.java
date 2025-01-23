
import java.util.*;

// Linear Probing Hash Table
class LinearProbingHashTable {
    private int[] hashTable;
    private int tableSize;
    private int elementCount;

    public LinearProbingHashTable(int size) {
        tableSize = size;
        hashTable = new int[tableSize];
        elementCount = 0;
        Arrays.fill(hashTable, -1);
    }

    private int hashFunction(int key) {
        return key % tableSize;
    }

    public void insert(int key) {
        if (elementCount == tableSize) {
            System.out.println("Hash Table is full. Cannot insert " + key);
            return;
        }
        int index = hashFunction(key);
        while (hashTable[index] != -1) {
            index = (index + 1) % tableSize;
        }
        hashTable[index] = key;
        elementCount++;
        System.out.println("Inserted " + key + " at index " + index);
    }

    public int search(int key) {
        int index = hashFunction(key);
        int startIndex = index;
        while (hashTable[index] != -1) {
            if (hashTable[index] == key) {
                return index;
            }
            index = (index + 1) % tableSize;
            if (index == startIndex) break;
        }
        return -1;
    }

    public void display() {
        System.out.println("Hash Table:");
        for (int i = 0; i < tableSize; i++) {
            System.out.println("Index " + i + ": " + (hashTable[i] == -1 ? "Empty" : hashTable[i]));
        }
    }
}

// Quadratic Probing Hash Table
class QuadraticProbingHashTable {
    private int N;
    private Entry[] hashTable;

    static class Entry {
        int key;
        String value;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public QuadraticProbingHashTable(int size) {
        N = size;
        hashTable = new Entry[N];
    }

    private int hashFunction(int key) {
        return key % N;
    }

    private int quadraticProbe(int key) {
        int index = hashFunction(key);
        int i = 0;
        while (hashTable[(index + i * i) % N] != null && hashTable[(index + i * i) % N].key != key) {
            i++;
            if (i == N) return -1;
        }
        return (index + i * i) % N;
    }

    public void insert(int key, String value) {
        int index = quadraticProbe(key);
        if (index == -1) {
            System.out.println("Hash table is full");
        } else {
            hashTable[index] = new Entry(key, value);
            System.out.println("Inserted (" + key + ", " + value + ") at index " + index);
        }
    }

    public String search(int key) {
        int index = hashFunction(key);
        int i = 0;
        while (hashTable[(index + i * i) % N] != null) {
            if (hashTable[(index + i * i) % N].key == key) {
                return hashTable[(index + i * i) % N].value;
            }
            i++;
            if (i == N) return null;
        }
        return null;
    }

    public void displayHashTable() {
        for (int i = 0; i < N; i++) {
            if (hashTable[i] != null) {
                System.out.println("Index " + i + ": (" + hashTable[i].key + ", " + hashTable[i].value + ")");
            } else {
                System.out.println("Index " + i + ": null");
            }
        }
    }
}

// Modulo Hashing
class ModuloHashing {
    public static void main(String[] args) {
        int a = 15;
        int b = 8;
        int k = a % b;
        System.out.println("Modulo result: " + k);
    }
}

// Fold Shift Hashing
class FoldShiftHashing {
    public static int foldShiftHash(int key, int tableSize) {
        int sum = 0;
        while (key > 0) {
            sum += key % 100; // Take two digits at a time
            key /= 100;
        }
        return sum % tableSize;
    }

    public static void main(String[] args) {
        int key = 123456;
        int tableSize = 10;
        int hashValue = foldShiftHash(key, tableSize);
        System.out.println("Fold Shift Hash of " + key + " is " + hashValue);
    }
}
