import java.util.ArrayList;
import java.util.Scanner;


class Node {
    int data;
    Node left;
    Node right;
    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

public class MainCode {

    // DFS approach
    void leafNodesByLevelRec(Node root, int level,ArrayList<ArrayList<Integer>> res) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            while (res.size() <= level) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.data);
        }

        leafNodesByLevelRec(root.left, level + 1, res);
        leafNodesByLevelRec(root.right, level + 1, res);
    }
    ArrayList<ArrayList<Integer>> leafNodesByLevel(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        leafNodesByLevelRec(root, 0, res);
        return res;
    }

    void nodesAtDepthRec(Node root, int currentDepth, int targetDepth, ArrayList<Integer> res) {
        if (root == null) return;
        if (currentDepth == targetDepth) {
            res.add(root.data);
            return; 
        }

        nodesAtDepthRec(root.left, currentDepth + 1, targetDepth, res);
        nodesAtDepthRec(root.right, currentDepth + 1, targetDepth, res);
    }

    public static void main(String[] args) {
        //         5
        //        / \
        //      12   13
        //      /  \    \
        //      7    14   2
        //     / \  /  \  / \
        //    17 23 27 3  8  11

        Node root = new Node(5);
        
        root.left = new Node(12);
        root.right = new Node(13);

        root.left.left = new Node(7);
        root.left.right = new Node(14);
        root.right.right = new Node(2);

        root.left.left.left = new Node(17);
        root.left.left.right = new Node(23);

        root.left.right.left = new Node(27);
        root.left.right.right = new Node(3);

        root.right.right.left = new Node(8);
        root.right.right.right = new Node(11);
        MainCode tree = new MainCode();
        ArrayList<ArrayList<Integer>> res = tree.leafNodesByLevel(root);

        // Leaf node Printing
        for (ArrayList<Integer> level : res) {
            if (!level.isEmpty()) {
                for (int val : level) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }

        // Nodes at Depth
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the depth to find nodes at: ");
        int n = scanner.nextInt() - 1;

        ArrayList<Integer> depthRes = new ArrayList<>();
        tree.nodesAtDepthRec(root, 0, n, depthRes);
        System.out.println("Nodes at Depth " + (n + 1) + ":");
        System.out.println(depthRes);
    }
}