import java.util.*;

public class SimpleHuffmanCode {

    // Node class now inside SimpleHuffmanCode class
    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    // Build Huffman Tree - Assuming nodes are inserted in sorted order
    public static Node buildHuffmanTree(char[] charArray, int[] charfreq) {
        List<Node> nodes = new ArrayList<>();
        
        // Add all characters and frequencies to a list in sorted order
        for (int i = 0; i < charArray.length; i++) {
            Node newNode = new Node(charArray[i], charfreq[i]);
            insertSorted(nodes, newNode);
        }

        // Build the tree by combining the nodes
        while (nodes.size() > 1) {
            // Take the two nodes with the smallest frequency
            Node left = nodes.remove(0); // Remove the first (smallest frequency)
            Node right = nodes.remove(0); // Remove the second (smallest frequency)
            
            // Create a new node with combined frequency
            Node newNode = new Node(left.freq + right.freq, left, right);
            
            // Insert the new node back into the list in sorted order
            insertSorted(nodes, newNode);
        }

        return nodes.get(0); // The root of the tree
    }

    // Helper function to insert nodes into the list while keeping it sorted
    public static void insertSorted(List<Node> nodes, Node newNode) {
        int i = 0;
        // Find the position where the new node should be inserted to keep the list sorted
        while (i < nodes.size() && nodes.get(i).freq < newNode.freq) {
            i++;
        }
        // Insert the new node at the correct position
        nodes.add(i, newNode);
    }

    // Generate codes for each character
    public static void generateCodes(Node root, String code) {
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + ": " + code);
            return;
        }
        generateCodes(root.left, code + "0");
        generateCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        // Build the Huffman Tree
        Node root = buildHuffmanTree(charArray, charfreq);

        // Generate and print the codes for each character
        System.out.println("Character codes:");
        generateCodes(root, "");
    }
}
