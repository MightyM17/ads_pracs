public class fiboHeap {
    public static void main(String[] args) {
        fiboNode rootNode = new fiboNode(10);
        fiboNode n2 = new fiboNode(20);
        n2.degree = 1;
        fiboNode n2c1 = new fiboNode(30);
        n2c1.parent = n2;
        n2.child = n2c1;
        rootNode.rightNode = n2;
        rootNode.leftNode = n2;
        n2.leftNode = rootNode;
        n2.rightNode = rootNode;

        show(rootNode);
        fiboNode rootNode2 = new fiboNode(11);
        fiboNode n22 = new fiboNode(21);
        n22.degree = 1;
        fiboNode n22c1 = new fiboNode(31);
        n22c1.parent = n22;
        n22.child = n22c1;
        rootNode2.rightNode = n22;
        rootNode2.leftNode = n22;
        n22.leftNode = rootNode2;
        n22.rightNode = rootNode2;
        show(rootNode2);

        fiboNode merged = merge(rootNode, rootNode2);
        show(merged);
    }

    public static void show(fiboNode n) {
        fiboNode temp = n;
        while(temp!=null) {
            System.out.print(temp.data+" -> ");
            show(temp.child);
            System.out.println();
            temp = temp.rightNode;
        }
    }

    public static fiboNode merge(fiboNode n1, fiboNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
    
        fiboNode temp = n1.rightNode;
        n1.rightNode = n2.rightNode;
        n2.rightNode.leftNode = n1;
        n2.rightNode = temp;
        temp.leftNode = n2;
    
        if (n1.data < n2.data) {
            return n1;
        } else {
            return n2;
        }
    }
}

class fiboNode {
    int data;
    int degree;
    fiboNode child;
    fiboNode leftNode;
    fiboNode rightNode;
    fiboNode parent;

    fiboNode(int data) {
        this.data = data;
        degree = 0;
        child = null;
        leftNode = null;
        rightNode = null;
        parent = null;
    }
}
