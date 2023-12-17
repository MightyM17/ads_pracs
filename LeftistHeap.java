public class LeftistHeap {
    // Structure to represent a node in a Leftist Heap
    static class LeftistNode {
        int key;                   // Key of the node
        int rank;                  // Rank of the node
        LeftistNode left;  // Pointer to the left child node
        LeftistNode right; // Pointer to the right child node

        // Constructor to create a new Leftist node
        LeftistNode(int key) {
            this.key = key;
            this.rank = 0;
            this.left = null;
            this.right = null;
        }
    }

    // Function to merge two Leftist Heaps
    static LeftistNode mergeLeftistHeaps(LeftistNode heap1, LeftistNode heap2) {
        // If one of the heaps is empty, return the other heap
        if (heap1 == null) {
            return heap2;
        }
        if (heap2 == null) {
            return heap1;
        }

        // heap1's root has a higher key
        if (heap1.key > heap2.key) {
            // Swap heap1 and heap2
            LeftistNode temp = heap1;
            heap1 = heap2;
            heap2 = temp;
        }

        // Recursively merge the right subtree of heap1 with heap2
        heap1.right = mergeLeftistHeaps(heap1.right, heap2);

        // Update ranks to maintain leftist property
        if (heap1.left == null || (heap1.right != null && heap1.left.rank < heap1.right.rank)) {
            // Swap the left and right children of heap1
            LeftistNode temp = heap1.left;
            heap1.left = heap1.right;
            heap1.right = temp;
        }

        // Update the rank of heap1
        if (heap1.right == null) {
            heap1.rank = 0;
        } else {
            heap1.rank = heap1.right.rank + 1;
        }

        // Return the merged heap
        return heap1;
    }

    // Function to display the Leftist Heap
    static void displayLeftistHeap(LeftistNode root) {
        // If the heap is empty, return
        if (root == null) {
            return;
        }

        // Print the key of the root node
        System.out.print(root.key + " ");
        // Recursively display the left and right subtrees
        displayLeftistHeap(root.left);
        displayLeftistHeap(root.right);
    }

    // Example usage
    public static void main(String[] args) {
        // Create two heaps
        LeftistNode heap1 = new LeftistNode(3);
        heap1.left = new LeftistNode(10);
        heap1.right = new LeftistNode(8);

        LeftistNode heap2 = new LeftistNode(6);
        heap2.left = new LeftistNode(7);
        heap2.right = new LeftistNode(5);

        // Display the heaps
        System.out.print("Heap 1: ");
        displayLeftistHeap(heap1);
        System.out.println();

        System.out.print("Heap 2: ");
        displayLeftistHeap(heap2);
        System.out.println();

        // Merge the heaps
        LeftistNode mergedHeap = mergeLeftistHeaps(heap1, heap2);

        // Display the merged heap
        System.out.print("Merged Heap: ");
        displayLeftistHeap(mergedHeap);
        System.out.println();
    }
}
