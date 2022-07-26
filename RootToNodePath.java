/*

Question Link :- https://www.interviewbit.com/problems/path-to-given-node/

Problem Description

Given a Binary Tree A containing N nodes.
You need to find the path from Root to a given node B.
NOTE:
No two nodes in the tree have same data values.
You can assume that B is present in the tree A and a path always exists.

Problem Constraints
 1 <= N <= 105 

 1 <= Data Values of Each Node <= N

 1 <= B <= N



Input Format
First Argument represents pointer to the root of binary tree A.

Second Argument is an integer B denoting the node number.



Output Format
Return an one-dimensional array denoting the path from Root to the node B in order.



Example Input
Input 1:

 A =

           1
         /   \
        2     3
       / \   / \
      4   5 6   7 


B = 5

Input 2:

 A = 
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6


B = 1




Example Output
Output 1:

 [1, 2, 5]
Output 2:

 [1]


Example Explanation
Explanation 1:

 We need to find the path from root node to node with data value 5.
 So the path is 1 -> 2 -> 5 so we will return [1, 2, 5]
Explanation 2:

 We need to find the path from root node to node with data value 1.
 As node with data value 1 is the root so there is only one node in the path.
 So we will return [1]

*/



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
