public class cuckooHash {
    public static void main(String[] args) {
        int arr[] = {20, 50, 53, 75, 100, 67, 105, 3, 36, 39};
        int hash1[] = new int[11];
        int hash2[] = new int[11];
        for (int i = 0; i < hash1.length; i++) {
            hash1[i] = -1;
            hash2[i] = -1;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < hash1.length; j++) {
                System.out.print(hash1[j] + " ");
            }
            System.out.println();
            for (int j = 0; j < hash2.length; j++) {
                System.out.print(hash2[j] + " ");
            }
            System.out.println();
            int index1 = arr[i] % 11;            
            if(hash1[index1] == -1){
                hash1[index1] = arr[i];
                continue;
            }
            else {
                int temp = hash1[index1];
                int index2 = (temp / 11)%11;                
                if(hash2[index2] != -1) {
                    System.err.println("Rehash");
                    int temp2 = hash2[index2];
                    int index22 = (temp2 / 11)%11;  
                    System.out.println("Swapping " + temp2 + " with " + arr[i]);
                    hash2[index2] = hash2[index22];
                    hash2[index22] = temp2;
                }
                else {
                    hash1[index1] = arr[i];
                    hash2[index2] = temp;
                    continue;
                }
            }
        }
        for (int i = 0; i < hash1.length; i++) {
            System.out.print(hash1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < hash2.length; i++) {
            System.out.print(hash2[i] + " ");
        }
    }
}