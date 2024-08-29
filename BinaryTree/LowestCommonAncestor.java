package LocalRepo.BinaryTree;

import java.util.ArrayList;

public class LowestCommonAncestor {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        }
    }
    public static boolean getPath(Node root, ArrayList<Node> path, int n) {
        if(root == null) {
            return false;
        }
        path.add(root);
        if(root.data == n) {
            return true;
        }
        boolean leftPath = getPath(root.left, path, n);
        boolean rightPath = getPath(root.right, path, n);

        if(leftPath || rightPath) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        if(root == null) {
            return null;
        }
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root, path1, n1);
        getPath(root, path2, n2);

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }

        return path1.get(i-1);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        Node ans = lca(root, 6, 5);
        System.out.println(ans.data);
    }
}




// package LocalRepo.BinaryTree;

// import java.util.ArrayList;

// public class LowestCommonAncestor {
//     static class Node {
//         int data;
//         Node left, right;

//         public Node(int data) {
//         this.data = data;
//         this.left = null;
//         this.right = null;
//         }
//     }

//     public static boolean getPath(Node root, ArrayList<Node> path, int n) {
//         if(root == null) {
//             return false;
//         }
//         path.add(root);
//         if(root.data == n) {
//             return true;
//         }
//         boolean foundLeft = getPath(root.left, path, n);
//         boolean foundRight = getPath(root.right, path, n);
//         if(foundLeft || foundRight) {
//             return true;
//         }
//         path.remove(path.size()-1);
//         return false;
//     }

//     public static Node lca(Node root, int n1, int n2) {
//         if(root == null) {
//             return null;
//         }
//         ArrayList<Node> path1 = new ArrayList<>();
//         ArrayList<Node> path2 = new ArrayList<>();
//         getPath(root, path1, n1);
//         getPath(root, path2, n2);
        
//         int i = 0;
//         for (i = 0; i < path1.size() && i < path2.size(); i++) {
//             if(path1.get(i) != path2.get(i)) {
//                 break;
//             }
//         }

//         Node lcaAns = path1.get(i-1);
//         return lcaAns;
//     }

//     public static void main(String[] args) {
//         Node root = new Node(1);
//         root.left = new Node(2);
//         root.right = new Node(3);
//         root.left.left = new Node(4);
//         root.left.right = new Node(5);
//         root.right.left = new Node(4);
//         root.right.right = new Node(6);
//         Node ans = lca(root, 6, 5);
//         System.out.println(ans.data);
//     }
// }
