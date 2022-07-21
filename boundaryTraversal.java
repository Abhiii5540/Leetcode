import java.util.ArrayList;
import java.util.*;

// Boundary traversal in an anti-clockwise direction can be described as a traversal consisting of three parts:

// Part 1: Left Boundary of the tree (excluding the leaf nodes).
// Part 2: All the leaf nodes travelled in the left to right direction.
// Part 3: Right Boundary of the tree (excluding the leaf nodes), traversed in the reverse direction

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class boundaryTraversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("prinitng the boundary traversal of the tree");
        ArrayList<Integer> ans = boundaryTraverse(root);
        System.out.println(ans);

        // System.out.println("prinitng the diameter of the tree");
        // int ans7 = diameter(root);
        // System.out.println(ans7);

    }

    static Boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }

    static void leftBoundary(TreeNode root, ArrayList<Integer> ans) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (isLeaf(curr) == false) {
                ans.add(curr.val);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    static void rightBoundary(TreeNode root, ArrayList<Integer> ans) {
        TreeNode curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (isLeaf(curr) == false) {
                temp.add(curr.val);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; --i) {
            ans.add(temp.get(i));
        }
    }

    static void leaves(TreeNode root, ArrayList<Integer> ans) {
        if (isLeaf(root)) {
            ans.add(root.val);
            return;
        }
        if (root.left != null) {
            leaves(root.left, ans);
        }
        if (root.right != null) {
            leaves(root.right, ans);
        }
    }

    static ArrayList<Integer> boundaryTraverse(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (isLeaf(root) == false) {
            res.add(root.val);
        }
        leftBoundary(root, res);
        leaves(root, res);
        rightBoundary(root, res);
        return res;
    }
}
