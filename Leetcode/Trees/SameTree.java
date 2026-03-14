
public class SameTree {

    public static void main(String[] args) {
        // Test 1: [1] and [1] → true
        System.out.println(isSameTree(new TreeNode(1), new TreeNode(1))); // true

        // Test 2: [1,2] and [1,null,2] → false
        //    1        1
        //   /          \
        //  2            2
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);
        System.out.println(isSameTree(t1, t2)); // false

        // Test 3: [1,2,3] and [1,2,3] → true
        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(2);
        t3.right = new TreeNode(3);
        TreeNode t4 = new TreeNode(1);
        t4.left = new TreeNode(2);
        t4.right = new TreeNode(3);
        System.out.println(isSameTree(t3, t4)); // true

        // Test 4: both null → true
        System.out.println(isSameTree(null, null)); // true
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    // ============================================
    // TREES — PROBLEM 3: Same Tree
    // ============================================
    // Given the roots of two binary trees, check if
    // they are the same (same structure, same values).
    //
    // BEFORE CODING — answer these 3 questions:
    // 1. What am I checking at one node?
    // 2. What do I check next?
    // 3. When do I stop?
    // ============================================
    static boolean isSameTree(TreeNode p, TreeNode q) {
        // answer the 3 questions first, then code
        // 1. is current nodes equal
        // 2. both left and right
        // 3. when i find null
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
