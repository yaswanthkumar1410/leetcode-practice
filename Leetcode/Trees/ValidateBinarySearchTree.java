
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        // Test 1: Valid BST
        //        2
        //       / \
        //      1   3
        TreeNode t1 = new TreeNode(2);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(3);
        System.out.println(isValidBST(t1)); // true

        // Test 2: Invalid BST
        //        5
        //       / \
        //      1   4
        //         / \
        //        3   6
        // 3 is less than 5 but in its right subtree → invalid
        TreeNode t2 = new TreeNode(5);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(4);
        t2.right.left = new TreeNode(3);
        t2.right.right = new TreeNode(6);
        System.out.println(isValidBST(t2)); // false

        // Test 3: tricky case
        //        5
        //       / \
        //      4   6
        //         / \
        //        3   7
        // 3 is in right subtree of 5, but 3 < 5 → invalid
        TreeNode t3 = new TreeNode(5);
        t3.left = new TreeNode(4);
        t3.right = new TreeNode(6);
        t3.right.left = new TreeNode(3);
        t3.right.right = new TreeNode(7);
        System.out.println(isValidBST(t3)); // false

        // Test 4: single node → true
        System.out.println(isValidBST(new TreeNode(1))); // true
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    // ============================================
    // TREES — PROBLEM 7: Validate Binary Search Tree
    // ============================================
    // A BST has this rule:
    //   - Left child < parent
    //   - Right child > parent
    //   - This must hold for ALL nodes, not just immediate children
    //
    // Example (INVALID):
    //        5
    //       / \
    //      4   6
    //         / \
    //        3   7
    //   Node 3 is a valid right→left child of 6,
    //   but 3 < 5, so it violates the BST property.
    //
    // Hint: each node has a valid RANGE.
    //   - Root: (-infinity, +infinity)
    //   - Root's left child: (-infinity, root.val)
    //   - Root's right child: (root.val, +infinity)
    //   - And so on down the tree...
    //
    // BEFORE CODING — answer:
    // 1. What am I checking at one node?
    // 2. What do I check next?
    // 3. When do I stop?
    // ============================================
    static boolean isValidBST(TreeNode root) {
        // your code here
        return isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean isValidNode(TreeNode node, long min, long max)  {
        if(node == null) return true;
        if(node.val > min && node.val < max) {
           return isValidNode(node.left, min, (long) node.val) && isValidNode(node.right, (long) node.val, max);
        }
        return false;
    }
}