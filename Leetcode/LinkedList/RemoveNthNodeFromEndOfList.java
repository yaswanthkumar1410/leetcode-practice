
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        // Test 1: [1,2,3,4,5], n=2 → [1,2,3,5]
        ListNode t1 = buildList(new int[]{1,2,3,4,5});
        printList(removeNthFromEnd(t1, 2)); // 1 2 3 5

        // Test 2: [1], n=1 → []
        ListNode t2 = buildList(new int[]{1});
        printList(removeNthFromEnd(t2, 1)); // (empty)

        // Test 3: [1,2], n=1 → [1]
        ListNode t3 = buildList(new int[]{1,2});
        printList(removeNthFromEnd(t3, 1)); // 1
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // ============================================
    // LC 19 — Remove Nth Node From End of List
    // ============================================
    // Given the head of a linked list, remove the nth
    // node from the end of the list and return its head.
    //
    // Do it in one pass.
    // ============================================
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyListNode = new ListNode(0);
        dummyListNode.next = head;
        ListNode left = dummyListNode;
        ListNode right = head;
        while(n > 0 && right != null) {
            right = right.next;
            n--;
        }
        while(right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummyListNode.next;
    }

    static ListNode buildList(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : vals) { curr.next = new ListNode(v); curr = curr.next; }
        return dummy.next;
    }

    static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) { sb.append(head.val).append(" "); head = head.next; }
        System.out.println(sb.toString().trim());
    }
}
