
public class BalancedBinaryTree {

    public static void main(String[] args) {
        // Test 1:
        //        1
        //       / \
        //      2   2
        //     / \
        //    3   3
        // Left subtree depth=3, right subtree depth=1
        // Difference = 2 → NOT balanced
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(3);
        System.out.println(isBalanced(t1)); // true (both sides differ by at most 1)

        // Test 2:
        //            1
        //           / \
        //         2  2  
        //         / \
        //        3   3
        //       / \
        //      4   4
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(2);
        t2.left.left = new TreeNode(3);
        t2.left.right = new TreeNode(3);
        t2.left.left.left = new TreeNode(4);
        t2.left.left.right = new TreeNode(4);
        System.out.println(isBalanced(t2)); // false

        // Test 3: empty tree → true
        System.out.println(isBalanced(null)); // true

        // Test 4: single node → true
        System.out.println(isBalanced(new TreeNode(1))); // true
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    // ============================================
    // TREES — PROBLEM 5: Balanced Binary Tree
    // ============================================
    // A binary tree is "balanced" if for EVERY node,
    // the depth of the left subtree and right subtree
    // differ by at most 1.
    //
    // You already wrote maxDepth. Can you use it here?
    //
    // BEFORE CODING — answer these 3 questions:
    // 1. What am I checking at one node?
    // 2. What do I check next?
    // 3. When do I stop?
    // ============================================
    static boolean isBalanced(TreeNode root) {
        // answer the 3 questions first, then code
        // diffDepth(left, right) =  0 or 1
        //
        if(root == null) return true;
        if(maxDepth(root.left) - maxDepth(root.right) == 1 || maxDepth(root.left) - maxDepth(root.right) == 0) {
            isBalanced(root.left);
            isBalanced(root.right);
        } else {
            return false;
        }
        return true;
    }

    static int maxDepth(TreeNode node) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}
