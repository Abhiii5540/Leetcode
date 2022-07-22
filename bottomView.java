Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.
  20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.

GFG link :- https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

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

public class bottomView {
    static ArrayList<Integer> bottomViewIterative(TreeNode root) {
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
                m.put(curr.num, curr.root.data);
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
        System.out.println("prinitng the bottom view  of the tree");
        ArrayList<Integer> res = bottomViewIterative(root);
        System.out.println(res);
    }
}
