
public class InvertBinaryTree {

    public static void main(String[] args) {
        // Test 1:
        //        4
        //       / \
        //      2   7
        //     / \ / \
        //    1  3 6  9
        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(7);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(3);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(9);
        TreeNode result1 = invertTree(t1);
        printTree(result1); // [4, 7, 2, 9, 6, 3, 1]

        // Test 2:
        //    2         →      2
        //   / \              / \
        //  1   3            3   1
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        TreeNode result2 = invertTree(t2);
        printTree(result2); // [2, 3, 1]

        // Test 3: null
        System.out.println(invertTree(null)); // null

        // Test 4: single node
        TreeNode result4 = invertTree(new TreeNode(1));
        printTree(result4); // [1]
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    // ============================================
    // TREES — PROBLEM 6: Invert Binary Tree
    // ============================================
    // Invert (mirror) a binary tree — swap every node's
    // left and right children.
    //
    //        4              4
    //       / \    →       / \
    //      2   7          7   2
    //     / \ / \        / \ / \
    //    1  3 6  9      9  6 3  1
    //
    // BEFORE CODING — answer:
    // 1. What am I doing at one node?
    // 2. What do I do next?
    // 3. When do I stop?
    // ============================================
    static TreeNode invertTree(TreeNode root) {
        // your code here

        // 1. check if its null if not swap right left
        // 2. recurse for left and right nodes
        // 3. when back at root
        if(root == null) return null;
        TreeNode leftNode = root.right;
        TreeNode rightNode = root.left;
        root.right = rightNode;
        root.left = leftNode;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

    // Helper to print tree level-order
    static void printTree(TreeNode root) {
        if (root == null) { System.out.println("null"); return; }
        java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder("[");
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            sb.append(n.val).append(", ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        System.out.println(sb);
    }
}
