public class bTree {
    static int K = 3;
    static class BNode {
        int leaf;
        int n;
        int keys[] = new int[K-1];
        BNode children[] = new BNode[K];

        public BNode() {
            leaf = 1;
            n = 0;
        }
    }

    static BNode root = new BNode();

    public static void main(String[] args) {
        insert(1);
        insert(4);
        display(root);
        System.out.println();
        insert(5);
        display(root);
    }

    public static void display(BNode x) {
        for(int i=0;i<x.n;i++)
            System.out.print(x.keys[i] + " ");
        if(x.leaf == 0) {
            for(int i=0;i<x.n+1;i++)
                display(x.children[i]);
        }
    }

    public static BNode split(BNode x, int i, int data) {
        BNode z = new BNode();
        BNode y = x.children[i];
        z.leaf = y.leaf;
        z.n = (K - 1) / 2;
        for(int j=0;j<z.n;j++)
            z.keys[j] = y.keys[j + z.n + 1];
        if(y.leaf == 0) {
            for(int j=0;j<z.n+1;j++)
                z.children[j] = y.children[j + z.n + 1];
        }
        y.n = (K - 1) / 2;
        for(int j=x.n;j>=i+1;j--)
            x.children[j+1] = x.children[j];
        x.children[i+1] = z;
        for(int j=x.n-1;j>=i;j--)
            x.keys[j+1] = x.keys[j];
        x.keys[i] = y.keys[y.n];
        x.n++;
        return x;
    }

    public static void insert(int data) {
        BNode r = root;
        if(r.n == K - 1) {
            BNode s = new BNode();
            root = s;
            s.leaf = 0;
            s.n = 0;
            s.children[0] = r;
            split(s, 0, data);
        }
        else
            insertNonFull(r, data);
    }

    public static void insertNonFull(BNode x, int data) {
        int i = x.n - 1;
        if(x.leaf == 1) {
            while(i>=0 && data<x.keys[i]) {
                x.keys[i+1] = x.keys[i];
                i--;
            }
            x.keys[i+1] = data;
            x.n++;
        }
        else {
            while(i>=0 && data<x.keys[i])
                i--;
            i++;
            if(x.children[i].n == K - 1) {
                split(x, i, data);
                if(data > x.keys[i])
                    i++;
            }
            insertNonFull(x.children[i], data);
        }
    }
}