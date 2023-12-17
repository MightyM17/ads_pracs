public class multiPopStack {
    static int size = 10;
    static int stack[] = new int[size];
    static int top = -1;
    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        multiPop(3);
        System.out.println(stack[top]);
    }

    public static void push(int data) {
        if(top == size - 1) {
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = data;
    }

    public static void multiPop(int n) {
        if(top == -1) {
            System.out.println("Stack is empty");
        }
        if(n > top + 1) {
            System.out.println("Not enough elements in stack");
        }
        top -= n;
    }
}
