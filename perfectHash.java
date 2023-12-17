public class perfectHash {
    public static void main(String[] args) {
        int[] keys = {10, 22, 31, 4, 15, 28, 17, 88, 59};
        int size = keys.length;
        PrimTable[] hashTable = new PrimTable[size];

        for (int i = 0; i < size; i++) {
            int index = hash1(keys[i], size);
            if (hashTable[index] == null) {
                hashTable[index] = new PrimTable(size);
            }
            int index2 = hash2(keys[i], hashTable[index].n);
            hashTable[index].arr[index2] = keys[i];
        }

        // Display the hash table
        for (int i = 0; i < size; i++) {
            if (hashTable[i] != null) {
                for (int j = 0; j < hashTable[i].n; j++) {
                    System.out.print(hashTable[i].arr[j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static int hash1(int key, int size) {
        return key % size;
    }

    public static int hash2(int key, int size) {
        return ((3 * key) % 42) % size;
    }
}

class PrimTable {
    int n;
    int[] arr;

    PrimTable(int size) {
        this.n = size;
        this.arr = new int[n];
    }
}