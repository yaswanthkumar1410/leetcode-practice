
public class LinkedListCycle {

    public static void main(String[] args) {
        // Test 1: [1,2,3,4,5] → has cycle? false
        ListNode list1 = buildList(new int[]{1,2,3,4,5});
        System.out.println(hasCycle(list1)); // false

        // Test 2: [3,2,0,-4] with tail connecting to index 1 → true
        ListNode list2 = buildList(new int[]{3,2,0,-4});
        ListNode tail2 = list2.next.next.next; // node -4
        tail2.next = list2.next;               // -4 points back to 2
        System.out.println(hasCycle(list2)); // true

        // Test 3: [1,2] with tail connecting to index 0 → true
        ListNode list3 = buildList(new int[]{1,2});
        list3.next.next = list3; // 2 points back to 1
        System.out.println(hasCycle(list3)); // true

        // Test 4: [1] → false
        ListNode list4 = buildList(new int[]{1});
        System.out.println(hasCycle(list4)); // false
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
    // LINKED LIST — PROBLEM 3: Linked List Cycle
    // ============================================
    // Given the head of a linked list, determine if
    // the list has a cycle (a node's next points back
    // to an earlier node).
    //
    // Example:
    //   3 → 2 → 0 → -4
    //       ↑           |
    //       └───────────┘
    //   -4 points back to 2 → cycle exists → true
    //
    // Rules:
    //   - O(n) time, O(1) space
    //   - You cannot use a HashSet (that's O(n) space)
    // ============================================
    static boolean hasCycle(ListNode head) {
        // your code here
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
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
}
