package LocalRepo.BinaryTree;
import java.util.*;
public class KthLevel {
    static class Node {
        int data;
        Node left = null;
        Node right = null;

        public Node(int data) {
            this.data = data;
        }
    }
    public static void kthLevelNodes(int level, int k, Node root) {
        if(root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kthLevelNodes(level+1, k, root.left);
        kthLevelNodes(level+1, k, root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        kthLevelNodes(1, 3, root);
    }
}
