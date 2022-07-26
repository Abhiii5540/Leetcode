import java.util.*;

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

public class RootToNodePath {

    public static ArrayList<Integer> PrintRootToNodePath(TreeNode A, int B) {
        ArrayList<Integer> l = new ArrayList<>();
        if (A == null)
            return l;
        PrintRootToNodePathHelper(A, l, B);
        return l;
    }

    static boolean  PrintRootToNodePathHelper(TreeNode root, ArrayList<Integer> l, int x) {
        // if root is NULL
        // there is no path
        if (root == null)
            return false;

        // push the node's value in 'l'
        l.add(root.val);

        // if it is the required node
        // return true
        if (root.val == x)
            return true;

        // else check whether the required node lies in the left subtree or right
        // subtree of the current node
        if (PrintRootToNodePathHelper(root.left, l, x) ||
                PrintRootToNodePathHelper(root.right, l, x))
            return true;

        // required node does not lie either in the left or right subtree of the current
        // node
        // Thus, remove current node's value from 'l'and then return false
        l.remove(l.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(PrintRootToNodePath(root, 7));
    }
}