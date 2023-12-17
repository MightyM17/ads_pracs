public class binomialHeap {
    public static void main(String[] args) {
        Node n = new Node(12, 0);
        Node n1 = new Node(7, 2);
        Node n1c1 = new Node(40, 1);
        n1.children[0] = n1c1;
        n.sibling = n1;
        Node n2 = new Node(15, 3);
        Node n2c1 = new Node(60, 2);
        Node n2c2 = new Node(50, 1);
        n2.children[0] = n2c1;
        n2.children[1] = n2c2;
        n1.sibling = n2;


        Node t = new Node(10, 0);
        Node t1 = new Node(13, 2);
        Node t1c1 = new Node(39, 1);
        t1.children[0] = t1c1;
        t.sibling = t1;
        Node t2 = new Node(8, 3);
        Node t2c1 = new Node(59, 2);
        Node t2c2 = new Node(49, 1);
        t2.children[0] = t2c1;
        t2.children[1] = t2c2;
        t1.sibling = t2;


        // Merge
        Node heap1 = n;
        Node heap2 = t;
        while(heap1 != null && heap2 != null) {
            Node next1 = heap1.sibling;
            Node next2 = heap2.sibling;
            if(heap2.degree <= heap1.degree) {
                //System.out.println(heap1.data + " c1 " + heap2.data);
                Node tempp = heap1.sibling;
                heap1.sibling = heap2;
                heap2.sibling = tempp;
                // Node temp = n;
                // while (temp != null) {
                //     display(temp);
                //     temp = temp.sibling;
                // }
            }
            else {
                Node tempp = heap2.sibling;
                heap2.sibling = heap1;
                heap1.sibling = tempp;
            }
            heap1 = next1;
            heap2 = next2;
        }

        show(n);
        Node x = n;
        Node nextx = x.sibling;
        Node nextnextx = nextx.sibling;
        while (nextnextx != null) {
            if(x.degree != nextx.degree) {
                System.out.println("Wrong deg move ahead");
                x = nextx;
                nextx = nextnextx;
                nextnextx = nextnextx.sibling;
            }
            // x == nextx.deg
            else {
                if(x.degree == nextnextx.degree) {
                    System.out.println("All three same deg move ahead");
                    x = nextx;
                    nextx = nextnextx;
                    nextnextx = nextnextx.sibling;   
                }
                else {
                    System.out.println("nextnext has diff deg");
                    if(x.data <= nextx.data) {
                        Node newx = new Node(x.data, x.degree + 1);
                        newx.children[0] = nextx;
                        for (int i = 0;i < x.children.length; i++){
                            newx.children[i+1] = x.children[i];
                        }
                        newx.sibling = nextnextx;
                        x = newx;
                    }
                    else {
                        Node newx = new Node(nextx.data, nextx.degree + 1);
                        newx.children[0] = x;
                        for (int i = 0;i < nextx.children.length; i++){
                            newx.children[i+1] = nextx.children[i];
                        }
                        newx.sibling = nextnextx;
                        nextx = newx;
                    }
                }
            }
        }
        show(n);
    }

    public static void show(Node n) {
        //Display
        Node temp = n;
        while (temp != null) {
            display(temp);
            temp = temp.sibling;
        }
    }

    public static void display(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " -> ");
        for (int i = 0; i < root.degree; i++) {
            if (root.children[i] != null)
                System.out.print(root.children[i].data + " ");
        }
        System.out.println();
        // for (int i = 0; i < root.degree; i++) {
        //     display(root.children[i]);
        // }
    }
}

class Node {
    int data;
    int degree;
    Node children[];
    Node sibling;

    public Node(int data, int degree) {
        this.data = data;
        this.degree = degree;
        children = new Node[degree];
        sibling = null;
    }
}