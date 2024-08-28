package LocalRepo.BinaryTree;

public class IsSubtree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if(root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if(isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isIdentical(Node root, Node subRoot) {
        if(root == null && subRoot == null) {
            return true;
        } else if(root == null || subRoot == null || root.data != subRoot.data) {
            return false;
        }
        if(!isIdentical(root.left, subRoot.left)) {
            return false;
        }
        if(!isIdentical(root.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println("Tree: ");
        preOrder(root);
        System.out.println("\nSubtree: ");
        preOrder(subRoot);
        System.out.println("\nIs the subtree present: " + isSubtree(root, subRoot));
        
    }
}





// package LocalRepo.BinaryTree;

// public class IsSubtree {
//     static class Node {
//         int data;
//         Node left, right;

//         public Node(int data) {
//             this.data = data;
//             this.left = null;
//             this.right = null;
//         }
//     }

//     public static void preOrder(Node root) {
//         if(root == null) {
//             return;
//         }
//         System.out.print(root.data + " ");
//         preOrder(root.left);
//         preOrder(root.right);
//     }

//     public static boolean isIdentical(Node root, Node subRoot) {
//         if(root == null && subRoot == null) {
//             return true;
//         } else if(root == null || subRoot == null || root.data != subRoot.data) {
//             return false;
//         }
//         if(!isIdentical(root.left, subRoot.left)) {
//             return false;
//         }
//         if (!isIdentical(root.right, subRoot.right)) {
//             return false;
//         }
//         return true;
//     }

//     public static boolean isSubtree(Node root, Node subRoot) {
//         if (root == null) {
//             return false;
//         }
//         if(root.data == subRoot.data) {
//             if(isIdentical(root, subRoot)) {
//                 return true;
//             }
//         }
//         return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
//     }

//     public static void main(String[] args) {
//         Node root = new Node(1);
//         root.left = new Node(2);
//         root.right = new Node(3);
//         root.left.left = new Node(4);
//         root.left.right = new Node(5);
//         root.right.left = new Node(6);
//         root.right.right = new Node(7);

//         Node subRoot = new Node(2);
//         subRoot.left = new Node(4);
//         subRoot.right = new Node(7);

//         preOrder(root);
//         System.out.println();
//         preOrder(subRoot);
//         System.out.println(isSubtree(root, subRoot));
        
//     }
// }
