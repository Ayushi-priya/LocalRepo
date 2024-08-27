package LocalRepo.BinaryTree;
import java.util.*;
public class BasicOperationOnTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preOrder(Node root) {
            if(root == null) {
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void postOrder(Node root) {
            if(root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+ " ");
        }

        public static void inOrder(Node root) {
            if(root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public static void levelOrderTraversal(Node root) {
            if(root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if(currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static int height(Node root) {
            if(root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh) + 1;
        }

        public static int noOfNodes(Node root) {
            if(root == null) {
                return 0;
            }
            int leftNode = noOfNodes(root.left);
            int rightNode = noOfNodes(root.right);
            return leftNode+rightNode+1;
        }

        public static int sumOfNodes(Node root) {
            if(root == null) {
                return 0;
            }
            int sumOfLeft = sumOfNodes(root.left);
            int sumOfRight = sumOfNodes(root.right);
            return sumOfLeft + sumOfRight + root.data;
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = tree.buildTree(nodes);
        System.out.println("Preorder traversal:");
        tree.preOrder(root);
        System.out.println("\nPostOrder traversal: ");
        tree.postOrder(root);
        System.out.println("\nInorder traversal: ");
        tree.inOrder(root);
        System.out.println("\nLevel order traversal: ");
        tree.levelOrderTraversal(root);
        System.out.println("\nHeight: "+tree.height(root));
        System.out.println("No. of Nodes: "+tree.noOfNodes(root));
        System.out.println("Sum of nodes: "+tree.sumOfNodes(root));
    }
}
