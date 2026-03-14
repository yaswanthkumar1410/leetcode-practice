
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        // Test 1: [3,9,20,null,null,15,7]
        //        3
        //       / \
        //      9   20
        //         /  \
        //        15   7
        // Output: [[3],[9,20],[15,7]]
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);
        System.out.println(levelOrder(t1)); // [[3], [9, 20], [15, 7]]

        // Test 2: [1] → [[1]]
        System.out.println(levelOrder(new TreeNode(1))); // [[1]]

        // Test 3: [] → []
        System.out.println(levelOrder(null)); // []
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    // ============================================
    // TREES — PROBLEM 4: Binary Tree Level Order Traversal
    // ============================================
    // Given a binary tree, return its values level by level
    // (top to bottom, left to right at each level).
    //
    //        3           Level 0: [3]
    //       / \          Level 1: [9, 20]
    //      9   20        Level 2: [15, 7]
    //         /  \
    //        15   7
    //
    // This is BFS — use a Queue.
    //
    // Pattern:
    //   1. Add root to queue
    //   2. While queue is not empty:
    //      - Get the current queue size (= nodes at this level)
    //      - Process that many nodes:
    //        - Poll a node, add its value to the level list
    //        - Add its children to the queue
    //      - Add the level list to the result
    // ============================================
    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root  == null) return result;
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 1; i <= size; i++) {
                TreeNode tempNode = queue.poll();
                temp.add(tempNode.val);
                if(tempNode.left != null) queue.add(tempNode.left);
                if(tempNode.right != null) queue.add(tempNode.right);
            }
            result.add(temp);
        }
        return result;
    }
}
