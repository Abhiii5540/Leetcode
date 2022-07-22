Given below is a binary tree. The task is to print the top view of binary tree. 
Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6      7

Top view will be: 4 2 1 3 7
Note: Return nodes from leftmost node to rightmost node.


GFG link :- https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1


import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int data) {
        this.data = data;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
class Pair {
    int num; // horizontal distance
   TreeNode root;

    public Pair(int num, TreeNode root) {
        this.num = num;
        this.root = root;
    }
}

public class topView {
    static ArrayList<Integer> topOrderIterative(TreeNode root) {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> m = new TreeMap<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (m.get(curr.num) == null) {
                m.put(curr.num, curr.root.data);
            }
            if (curr.root.left != null) {
                q.add(new Pair(curr.num - 1, curr.root.left));
            }
            if (curr.root.right != null) {
                q.add(new Pair(curr.num + 1, curr.root.right));
            }
        }

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("prinitng the top order traversal  of the tree");
        ArrayList<Integer> res2 = topOrderIterative(root);
        System.out.println(res2);
    }
}
