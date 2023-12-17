public class dynamicArray {
    int arr[] = new int[0];
    int size = 0;
    int top = 0;
    public static void main(String[] args) {
        
    }

    public void add(int data) {
        if(size == arr.length) {
            int temp[] = new int[size * 2];
            for(int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        size = size * 2;
        arr[top++] = data;
    }
}
