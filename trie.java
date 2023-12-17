public class trie {
    public static void main(String[] args) {
        TrieNode t = new TrieNode(' ');
        add("news", t);
        add("neon", t);
        display(t);
        search("news", t);
        remove("neon", t);
        display(t);
        // t.remove("news");
        // System.out.println(t.search("news"));
    }

    public static void add(String word, TrieNode root) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (temp.children[ch - 'a'] == null) {
                TrieNode n = new TrieNode(ch);
                temp.children[ch - 'a'] = n;
            }
            temp = temp.children[ch - 'a'];
        }
        temp.isTerminating = true;
    }

    public static void search(String word, TrieNode root) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (temp.children[ch - 'a'] == null) {
                System.out.println("Not Found");
                return;
            }
            temp = temp.children[ch - 'a'];
        }
        if (temp.isTerminating)
            System.out.println("Found");
        else
            System.out.println("Not Found");
    }

    public static void remove(String word, TrieNode root) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            temp = temp.children[ch - 'a'];
        }
        temp.isTerminating = false;
    }

    public static void display(TrieNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " -> ");
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null)
                System.out.print(root.children[i].data + " ");
        }
        System.out.println();
        for (int i = 0; i < 26; i++) {
            display(root.children[i]);
        }
    }
}

class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode children[];

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
    }
}