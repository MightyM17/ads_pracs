public class binaryCounter {
    static int arr[] = new int[10];
    static int cost = 0;
    static int credit = 0;
    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            increment();
            for(int j=0;j<10;j++)
                System.out.print(arr[j]+" ");
            System.out.println(cost+" "+credit);
        }
    }

    public static void increment() {
        int i=9;
        // Set 1 to 0
        while(i>=0 && arr[i]==1) {
            arr[i]=0;
            credit--;
            i--;
        }
        // Set 0 to 1
        if(i>=0) {
            arr[i]=1;
            cost++;
            credit++;
        }
    }
}