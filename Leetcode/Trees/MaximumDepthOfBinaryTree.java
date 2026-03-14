
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        // Test 1: [3,9,20,null,null,15,7] → 3
        //        3
        //       / \
        //      9   20
        //         /  \
        //        15   7
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);
        System.out.println(maxDepth(t1)); // 3

        // Test 2: [1,null,2] → 2
        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);
        System.out.println(maxDepth(t2)); // 2

        // Test 3: [] → 0
        System.out.println(maxDepth(null)); // 0

        // Test 4: [0] → 1
        System.out.println(maxDepth(new TreeNode(0))); // 1
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    // ============================================
    // TREES — PROBLEM 1: Maximum Depth of Binary Tree
    // ============================================
    // Given the root of a binary tree, return its
    // maximum depth.
    //
    // Depth = number of nodes along the longest path
    // from root to the farthest leaf.
    //
    //        3          depth 1
    //       / \
    //      9   20       depth 2
    //         /  \
    //        15   7     depth 3
    //
    // Answer: 3
    //
    // Rules:
    //   - Think recursively: the depth of a tree is
    //     1 + max(depth of left, depth of right)
    //   - Base case: null node has depth 0
    // ============================================
    static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return  1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
