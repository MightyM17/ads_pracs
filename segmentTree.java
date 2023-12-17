public class segmentTree {
    static int[] arr = {1,3,5,7};
    public static void main(String a[]) {
        Tree t[] = new Tree[4*arr.length];
        for(int i = 0; i < t.length; i++) {
            t[i] = new Tree();
        }
        buildTree(t, 0, arr.length-1, 0);
        query(t, 0, arr.length-1, 0, 0, 3);
    }

    public static void buildTree(Tree[] t, int start, int end, int index)  {
        if(start == end) {
            t[index].sum = arr[start];
            t[index].min = arr[start];
            t[index].max = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        buildTree(t, start, mid, left);
        buildTree(t, mid + 1, end, right);
        t[index].sum = t[left].sum + t[right].sum;
        t[index].min = Math.min(t[left].min, t[right].min);
        t[index].max = Math.max(t[left].max, t[right].max);
    }

    public static void query(Tree t[], int start, int end, int index, int l, int r) {
        if(l > end || r < start) {
            return;
        }
        if(l <= start && r >= end) {
            System.out.println(t[index].sum);
            System.out.println(t[index].min);   
            System.out.println(t[index].max);   
            return;
        }
        int mid = (start + end) / 2;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if(r <= mid) {
            query(t, start, mid, left, l, r);
        } else if(l > mid) {
            query(t, mid + 1, end, right, l, r);
        } else {
            query(t, start, mid, left, l, mid);
            query(t, mid + 1, end, right, mid + 1, r);
        }
    }
}

class Tree {
    int sum, min, max;

    Tree() {
        sum = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
}