public class BloomFilter {
    // hash 1
    static int h1(String s, int arrSize) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash + ((int) s.charAt(i))) % arrSize;
        }
        return (int) hash;
    }

    // hash 2
    static int h2(String s, int arrSize) {
        long hash = 1;
        for (int i = 0; i < s.length(); i++) {
            hash = (long)((hash + Math.pow(19, i) * s.charAt(i)) % arrSize);
        }
        return (int) (hash % arrSize);
    }

    // hash 2
    static int h3(String s, int arrSize) {
        long hash = 1;
        for (int i = 0; i < s.length(); i++) {
            hash = (long)((hash + Math.pow(26, i) + s.charAt(i)) % arrSize);
        }
        return (int) (hash % arrSize);
    }

    // lookup operation
    static boolean lookup(boolean[] bitArray, int arrSize, String s) {
        int a = h1(s, arrSize);
        int b = h2(s, arrSize);
        int c = h3(s, arrSize);
        System.out.println("Checking " + a + ", " + b + ", " + c);

        return bitArray[a] && bitArray[b] && bitArray[c];
    }

    // insert operation
    static void insert(boolean[] bitArray, int arrSize, String s) {
        // check if the element is already present or not
        if (lookup(bitArray, arrSize, s)) {
            System.out.println(s + " is probably already present");
        } else {
            int a = h1(s, arrSize);
            int b = h2(s, arrSize);
            int c = h3(s, arrSize);
            bitArray[a] = true;
            bitArray[b] = true;
            bitArray[c] = true;

            System.out.println(s + " inserted" + " at " + a + ", " + b + ", " + c);
        }
    }

    // Driver Code
    public static void main(String[] args) {
        boolean[] bitArray = new boolean[100];
        int arrSize = 100;
        String[] sArray = {
            "abound", "abounds", "abundance",
            "abundant", "accessible", "bloom",
            "blossom", "bolster", "bonny",
            "bonus", "bonuses", "coherent",
            "cohesive", "colorful", "comely",
            "comfort", "gems", "generosity",
            "generous", "generously", "genial",
            "bluff", "cheater", "hate",
            "war", "humanity", "racism",
            "hurt", "nuke", "gloomy",
            "facebook", "geeksforgeeks", "twitter"
        };

        for (String s : sArray) {
            insert(bitArray, arrSize, s);
        }
    }
}
