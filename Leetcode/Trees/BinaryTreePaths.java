
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        // Test 1:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        // Paths: "1->2->4", "1->2->5", "1->3"
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(t1)); // [1->2->4, 1->2->5, 1->3]

        // Test 2: single node
        System.out.println(binaryTreePaths(new TreeNode(1))); // [1]

        // Test 3:
        //     1
        //      \
        //       2
        //        \
        //         3
        TreeNode t3 = new TreeNode(1);
        t3.right = new TreeNode(2);
        t3.right.right = new TreeNode(3);
        System.out.println(binaryTreePaths(t3)); // [1->2->3]
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    // ============================================
    // TREES — PROBLEM 8: Binary Tree Paths
    // ============================================
    // Return all root-to-leaf paths as strings.
    // A leaf is a node with no children.
    //
    //       1
    //      / \
    //     2   3
    //    / \
    //   4   5
    //
    // Output: ["1->2->4", "1->2->5", "1->3"]
    //
    // BEFORE CODING — answer:
    // 1. What am I doing at one node?
    // 2. What do I do next?
    // 3. When do I stop?
    // ============================================
    static List<String> binaryTreePaths(TreeNode root) {
        // your code here
        // Add to stringbuidler check if nodes have childeren -> go there, if not add to list
        // go to child nodes
        // when all are done
        List<String> result = new ArrayList<>();
        buildString(root, "", result);
        return result;
    }

    static void buildString(TreeNode node, String s, List<String> result) {
         s = (s.equals("")) ? String.valueOf(node.val) : s + "->" + String.valueOf(node.val);
        if(node.right == null && node.left == null) {
                result.add(s);
                s = "";
            }
        if(node.left != null) {
            buildString(node.left, s, result);
        }
        if(node.right != null) {
            buildString(node.right, s, result);
        }
        
    }
}
