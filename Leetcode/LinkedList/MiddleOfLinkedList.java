
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        // Test 1: [1,2,3,4,5] → [3,4,5]
        printList(middleNode(buildList(new int[]{1,2,3,4,5})));

        // Test 2: [1,2,3,4,5,6] → [4,5,6]
        printList(middleNode(buildList(new int[]{1,2,3,4,5,6})));

        // Test 3: [1] → [1]
        printList(middleNode(buildList(new int[]{1})));

        // Test 4: [1,2] → [2]
        printList(middleNode(buildList(new int[]{1,2})));
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // ============================================
    // LINKED LIST — PROBLEM 4: Middle of the Linked List
    // ============================================
    // Given the head of a linked list, return the
    // middle node. If there are two middle nodes,
    // return the SECOND one.
    //
    // Example:
    //   [1,2,3,4,5] → return node 3
    //   [1,2,3,4,5,6] → return node 4 (second middle)
    //
    // Rules:
    //   - O(n) time, O(1) space
    //   - Think about what you just learned from
    //     the cycle detection problem
    // ============================================
    static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static ListNode buildList(int[] vals) {
        if (vals.length == 0) return null;
        ListNode head = new ListNode(vals[0]);
        ListNode curr = head;
        for (int i = 1; i < vals.length; i++) {
            curr.next = new ListNode(vals[i]);
            curr = curr.next;
        }
        return head;
    }

    static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(" -> ");
            head = head.next;
        }
        System.out.println(sb.toString());
    }
}
